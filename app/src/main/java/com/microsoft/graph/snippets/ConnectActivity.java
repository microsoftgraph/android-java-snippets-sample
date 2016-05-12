/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.graph.snippets.util.SharedPrefsUtil;

import java.net.URI;
import java.util.UUID;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static com.microsoft.graph.snippets.R.layout.activity_signin;
import static com.microsoft.graph.snippets.R.string.signin_err;
import static com.microsoft.graph.snippets.R.string.warning_clientid_redirecturi_incorrect;

public class ConnectActivity extends AppCompatActivity {

    private static final String TAG = "ConnectActivity";
    protected View mDiagnosticsLayout;
    protected TextView mDiagnosticsTxt;
    protected Button mConnectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_signin);

        mDiagnosticsLayout = (View)findViewById(R.id.layout_diagnostics);
        mConnectButton = (Button)findViewById(R.id.o365_signin);
        mDiagnosticsTxt = (TextView)findViewById(R.id.view_diagnostics_data);

        // add click listener
        mConnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInO365Clicked();
            }
        });

    }

    public void onSignInO365Clicked() {
        try {
            // define the post-auth callback
            AuthenticationCallback<AuthenticationResult> callback =
                    new AuthenticationCallback<AuthenticationResult>() {

                        @Override
                        public void onSuccess(AuthenticationResult authenticationResult) {
                            // reset anything that may have gone wrong...
                            mDiagnosticsLayout.setVisibility(INVISIBLE);
                            mDiagnosticsTxt.setText("");

                            // get rid of this Activity so that users can't 'back' into it
                            finish();

                            // save our auth token to use later
                            SharedPrefsUtil.persistAuthToken(authenticationResult);

                            // get the user display name
                            final String userDisplayableId =
                                    authenticationResult
                                            .getUserInfo()
                                            .getDisplayableId();

                            // get the index of their '@' in the name (to determine domain)
                            final int at = userDisplayableId.indexOf("@");

                            // parse-out the tenant
                            final String tenant = userDisplayableId.substring(at + 1);

                            SharedPrefsUtil.persistUserTenant(tenant);
                            SharedPrefsUtil.persistUserID(authenticationResult);

                            // go to our main activity
                            start();
                        }

                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();

                            //Show the localized message supplied with the exception or
                            //or a default message from the string resources if a
                            //localized message cannot be obtained
                            String msg;
                            if (null == (msg = e.getLocalizedMessage())) {
                                msg = getString(signin_err);
                                Toast.makeText(ConnectActivity.this, msg, Toast.LENGTH_SHORT).show();
                            } else {
                                mDiagnosticsTxt.setText(msg);
                                mDiagnosticsLayout.setVisibility(VISIBLE);
                            }
                        }
                    };

            AuthenticationManager mgr = AuthenticationManager.getInstance();
            mgr.setContextActivity(this);
            mgr.connect(callback);
        } catch (IllegalArgumentException e) {
            warnBadClient();
        }
    }

    private void warnBadClient() {
        Toast.makeText(this,
                warning_clientid_redirecturi_incorrect,
                Toast.LENGTH_LONG)
                .show();
    }

//    private void authenticate() throws IllegalArgumentException {
//        validateOrganizationArgs();
//        mAuthenticationManager.connect(this);
//    }

    /**
     * This activity gets notified about the completion of the ADAL activity through this method.
     *
     * @param requestCode The integer request code originally supplied to startActivityForResult(),
     *                    allowing you to identify who this result came from.
     * @param resultCode  The integer result code returned by the child activity through its
     *                    setResult().
     * @param data        An Intent, which can return result data to the caller (various data
     *                    can be attached to Intent "extras").
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "onActivityResult - AuthenticationActivity has come back with results");
        super.onActivityResult(requestCode, resultCode, data);
        AuthenticationManager
                .getInstance()
                .getAuthenticationContext()
                .onActivityResult(requestCode, resultCode, data);
    }

    private void validateOrganizationArgs() throws IllegalArgumentException {
        UUID.fromString(Constants.CLIENT_ID);
        URI.create(Constants.REDIRECT_URI);
    }

    private void start() {
        Intent appLaunch = new Intent(this, SnippetListActivity.class);
        startActivity(appLaunch);
    }

}
