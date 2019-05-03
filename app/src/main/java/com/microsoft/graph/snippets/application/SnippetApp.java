/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.application;

import android.app.Application;
import android.content.Context;
import com.microsoft.graph.authentication.MSALAuthenticationProvider;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.snippets.AuthenticationManager;
import com.microsoft.graph.snippets.ServiceConstants;
import com.microsoft.graph.snippets.SignInActivity;

public class SnippetApp extends Application {
    private static SnippetApp sSnippetApp;
    private static SignInActivity signInActivity;
    private AuthenticationManager mAuthenticationManager;
    private MSALAuthenticationProvider msalAuthenticationProvider;
    private IGraphServiceClient graphClient;

    public static SnippetApp getApp() {
        return sSnippetApp;
    }
    public static SignInActivity getAppActivity() {return signInActivity;}

    @Override
    public void onCreate() {
        super.onCreate();
        sSnippetApp = this;
        signInActivity = new SignInActivity();
        mAuthenticationManager = AuthenticationManager.getInstance();
    }

    public IGraphServiceClient getGraphServiceClient() {

        if(msalAuthenticationProvider == null) {
            msalAuthenticationProvider = new MSALAuthenticationProvider(
                    getAppActivity(),
                    SnippetApp.getApp(),
                    mAuthenticationManager.getPublicClient(),
                    ServiceConstants.SCOPES);
        }

        if(graphClient == null) {
            graphClient =
                    GraphServiceClient
                            .builder()
                            .authenticationProvider(msalAuthenticationProvider)
                            .buildClient();
        }

         return graphClient;
    }

    public static Context getContext() {
        return sSnippetApp;
    }

    public void disconnect() {
        mAuthenticationManager.disconnect();
    }
}
