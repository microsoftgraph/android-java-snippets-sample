/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.application;

import android.app.Application;

public class SnippetApp extends Application {
    private static SnippetApp sSnippetApp;

    public static SnippetApp getApp() {
        return sSnippetApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sSnippetApp = this;
    }
}
