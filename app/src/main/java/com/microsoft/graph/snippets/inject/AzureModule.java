/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.inject;

import com.microsoft.graph.auth.AzureADModule;
import com.microsoft.graph.snippets.SignInActivity;
import com.microsoft.graph.snippets.SnippetDetailActivity;
import com.microsoft.graph.snippets.SnippetDetailFragment;
import com.microsoft.graph.snippets.SnippetListActivity;

import dagger.Module;

@Module(includes = AzureADModule.class,
        complete = false,
        injects = {
                SignInActivity.class,
                SnippetDetailActivity.class,
                SnippetListActivity.class,
                SnippetDetailFragment.class
        }
)
public class AzureModule {}