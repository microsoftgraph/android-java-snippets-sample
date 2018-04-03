/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.snippets.snippet.AbstractSnippet;
import com.microsoft.graph.snippets.snippet.SnippetContent;

import java.io.PrintWriter;
import java.io.StringWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static com.microsoft.graph.snippets.R.color.code_1xx;
import static com.microsoft.graph.snippets.R.color.code_3xx;
import static com.microsoft.graph.snippets.R.color.code_4xx;
import static com.microsoft.graph.snippets.R.id.btn_run;
import static com.microsoft.graph.snippets.R.id.progressbar;
import static com.microsoft.graph.snippets.R.id.txt_desc;
import static com.microsoft.graph.snippets.R.id.txt_hyperlink;
import static com.microsoft.graph.snippets.R.id.txt_request_url;
import static com.microsoft.graph.snippets.R.id.txt_response_body;
import static com.microsoft.graph.snippets.R.id.txt_status_color;
import static com.microsoft.graph.snippets.R.string.clippy;
import static com.microsoft.graph.snippets.R.string.code_snippet;
import static com.microsoft.graph.snippets.R.string.raw_object;

public class SnippetDetailFragment<T, Result>
        extends BaseFragment implements ICallback<Result> {

    public static final String ARG_ITEM_ID = "item_id";

    private static final int UNSET = -1;
    private static final String STATUS_COLOR = "STATUS_COLOR";
    private static final String CONTENT_DESCRIPTION = "CONTENT_DESCRIPTION";

    private boolean mIsExecutingRequest = false;

    private AbstractSnippet<Result> mItem;

    //
    // UI component bindings
    //

    /**
     * Displays the status code as color 'stoplight'
     */
    @BindView(txt_status_color)
    protected ImageView mStatusColor;

    /**
     * On-screen description of the current snippet
     */
    @BindView(txt_desc)
    protected TextView mSnippetDescription;

    /**
     * The request url of the current snippet
     */
    @BindView(txt_request_url)
    protected TextView mRequestUrl;

    /**
     * The response body of the snippet's request
     */
    @BindView(txt_response_body)
    protected TextView mResponseBody;

    /**
     * Barber's pole progress bar (indeterminate)
     */
    @BindView(progressbar)
    protected ProgressBar mProgressbar;

    /**
     * The 'run-snippet' button
     */
    @BindView(btn_run)
    protected Button mRunButton;

    /**
     * Fragment default constructor
     */
    public SnippetDetailFragment() {
        // unimplemented
    }

    //
    // UI event bindings
    //
    @OnClick(txt_request_url)
    public void onRequestUrlClicked(TextView tv) {
        // copy to clip
        clipboard(tv);
    }

    @OnClick(txt_response_body)
    public void onResponseBodyClicked(TextView tv) {
        // copy to clip
        clipboard(tv);
    }

    @OnClick(btn_run)
    public void onRunClicked(Button btn) {
        mIsExecutingRequest = true;

        // disable the button while the snippet is running
        mRunButton.setEnabled(false);

        // clear any old response body
        mResponseBody.setText("");

        // reset the status 'stoplight'
        displayStatus(ContextCompat.getColor(getActivity(), code_3xx), getString(R.string.stoplight_in_progress));

        // show the indeterminate spinner
        mProgressbar.setVisibility(VISIBLE);

        // actually make the request
        mItem.request(this);
    }

    @OnClick(txt_hyperlink)
    public void onDocsLinkClicked(TextView textView) {
        launchUrl(Uri.parse(mItem.getUrl()));
    }

    //
    // Lifecycle hooks
    //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = (AbstractSnippet<Result>)
                    SnippetContent.ITEMS.get(getArguments().getInt(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_snippet_detail, container, false);
        ButterKnife.bind(this, rootView);
        mSnippetDescription.setText(mItem.getDescription());
        mRequestUrl.setText(mItem.getCodeSnippet());
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != mStatusColor.getTag()) {
            outState.putInt(STATUS_COLOR, (Integer) mStatusColor.getTag());
        }
        if (null != mStatusColor.getContentDescription()) {
            outState.putString(CONTENT_DESCRIPTION, (String)mStatusColor.getContentDescription());
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null != getActivity() && getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (null != activity.getSupportActionBar()) {
                activity.getSupportActionBar().setTitle(mItem.getName());
            }
        }
        if (null != savedInstanceState && savedInstanceState.containsKey(STATUS_COLOR) && savedInstanceState.containsKey(CONTENT_DESCRIPTION)) {
            int statusColor = savedInstanceState.getInt(STATUS_COLOR, UNSET);
            String contentDescription = savedInstanceState.getString(CONTENT_DESCRIPTION, "");
            if (UNSET != statusColor) {
                displayStatus(statusColor, contentDescription);
            }
        }
    }

    //
    // Custom event bindings
    //
    @Override
    public void success(final Result result) {
        if (!isAdded()) {
            // the user has left...
            return;
        }

        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        mRunButton.setEnabled(true);
                        mProgressbar.setVisibility(GONE);
                        displayStatus(ContextCompat.getColor(getActivity(), code_1xx), getString(R.string.stoplight_success));
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        mResponseBody.setText(gson.toJson(result));
                        mIsExecutingRequest = false;
                    }
                }
        );
    }

    @Override
    public void failure(final ClientException error) {
        getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        mRunButton.setEnabled(true);
                        mProgressbar.setVisibility(GONE);
                        displayStatus(ContextCompat.getColor(getActivity(), code_4xx), getString(R.string.stoplight_failure));
                        mResponseBody.setText(error.getLocalizedMessage());
                        mIsExecutingRequest = false;
                    }
                }
        );
    }

    public boolean isExecutingRequest() {
        return mIsExecutingRequest;
    }

    //
    // Private methods
    //
    private void clipboard(TextView tv) {
        // which view are we copying to the clipboard?
        int which;

        switch (tv.getId()) {
            case txt_request_url: // the url field
                which = code_snippet;
                break;

            case txt_response_body: // the response body
                which = raw_object;
                break;

            default:
                which = UNSET; // don't assign a prefix
        }

        // if we know which view we're copying, prefix it with useful info
        String what = which == UNSET ? "" : getString(which) + " ";

        // concat the clipboard data to this String
        what += getString(clippy);

        // inform the user that data was added to the clipboard
        Toast.makeText(
                getActivity(),
                what,
                Toast.LENGTH_SHORT
        ).show();

        // depending on our API, do it one way or another...
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // old way
            ClipboardManager clipboardManager = (ClipboardManager)
                    getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
            clipboardManager.setText(tv.getText());
        } else {
            clipboard11(tv);
        }
    }

    @TargetApi(11)
    private void clipboard11(TextView tv) {
        android.content.ClipboardManager clipboardManager =
                (android.content.ClipboardManager) getActivity()
                        .getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("RESTSnippets", tv.getText());
        clipboardManager.setPrimaryClip(clipData);
    }

    private void launchUrl(Uri uri) {
        Intent viewDocs = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(viewDocs);
    }

    private void displayStatus(int color, String contentDescription) {
        mStatusColor.setBackgroundColor(color);
        mStatusColor.setTag(color);
        mStatusColor.setContentDescription(contentDescription);
    }

    private void displayThrowable(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String trace = sw.toString();
        mResponseBody.setText(trace);
    }
}
