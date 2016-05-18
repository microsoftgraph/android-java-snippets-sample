/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import com.microsoft.office365.msgraphsnippetapp.application.SnippetApp;

import static com.microsoft.office365.msgraphsnippetapp.R.string.section_contacts;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_drives;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_events;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_groups;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_me;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_messages;
import static com.microsoft.office365.msgraphsnippetapp.R.string.section_user;

public class SnippetCategory {
    static final SnippetCategory contactSnippetCategory
            = new SnippetCategory(section_contacts);

    static final SnippetCategory eventsSnippetCategory
            = new SnippetCategory(section_events);

    static final SnippetCategory groupSnippetCategory
            = new SnippetCategory(section_groups);

    static final SnippetCategory userSnippetCategory
            = new SnippetCategory(section_user);

    static final SnippetCategory mailSnippetCategory
            = new SnippetCategory(section_messages);

    static final SnippetCategory meSnippetCategory
            = new SnippetCategory(section_me);

    static final SnippetCategory drivesSnippetCategory
            = new SnippetCategory(section_drives);

    final String mSection;

    SnippetCategory(int sectionId) {
        mSection = SnippetApp.getApp().getString(sectionId);
    }
}
