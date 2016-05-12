/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.snippets.GraphServiceClientManager;
import com.microsoft.graph.snippets.application.SnippetApp;

import static com.microsoft.graph.snippets.R.string.section_contacts;
import static com.microsoft.graph.snippets.R.string.section_drives;
import static com.microsoft.graph.snippets.R.string.section_events;
import static com.microsoft.graph.snippets.R.string.section_groups;
import static com.microsoft.graph.snippets.R.string.section_me;
import static com.microsoft.graph.snippets.R.string.section_messages;
import static com.microsoft.graph.snippets.R.string.section_user;

public class SnippetCategory<T> {
    static final SnippetCategory<IGraphServiceClient> contactSnippetCategory
            = new SnippetCategory<>(section_contacts);

//    static final SnippetCategory<MSGraphEventsService> eventsSnippetCategory
//            = new SnippetCategory<>(section_events, create(MSGraphEventsService.class));
//
//    static final SnippetCategory<MSGraphGroupsService> groupSnippetCategory
//            = new SnippetCategory<>(section_groups, create(MSGraphGroupsService.class));
//
//    static final SnippetCategory<MSGraphUserService> userSnippetCategory
//            = new SnippetCategory<>(section_user, create(MSGraphUserService.class));
//
//    static final SnippetCategory<MSGraphMailService> mailSnippetCategory
//            = new SnippetCategory<>(section_messages, create(MSGraphMailService.class));
//
//    static final SnippetCategory<MSGraphMeService> meSnippetCategory
//            = new SnippetCategory<>(section_me, create(MSGraphMeService.class));
//
//    static final SnippetCategory<MSGraphDrivesService> drivesSnippetCategory
//            = new SnippetCategory<>(section_drives, create(MSGraphDrivesService.class));

    final String mSection;
    final IGraphServiceClient mService;

    SnippetCategory(int sectionId) {
        mSection = SnippetApp.getApp().getString(sectionId);
        mService = GraphServiceClientManager.getInstance().getGraphServiceClient();
    }
}