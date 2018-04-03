/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.application;

import android.app.Application;
import android.content.Context;

import com.microsoft.graph.core.DefaultClientConfig;
import com.microsoft.graph.core.IClientConfig;
import com.microsoft.graph.extensions.GraphServiceClient;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.snippets.AuthenticationManager;


public class SnippetApp extends Application {
    private static SnippetApp sSnippetApp;
    private AuthenticationManager mAuthenticationManager;

    public static SnippetApp getApp() {
        return sSnippetApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sSnippetApp = this;
        mAuthenticationManager = AuthenticationManager.getInstance();
    }

    public IGraphServiceClient getGraphServiceClient() {
        IClientConfig clientConfig = DefaultClientConfig.createWithAuthenticationProvider(
                mAuthenticationManager
        );
        return new GraphServiceClient.Builder().fromConfig(clientConfig).buildClient();
    }

    public static Context getContext() {
        return sSnippetApp;
    }

    public void disconnect() {
        mAuthenticationManager.disconnect();
    }


}
