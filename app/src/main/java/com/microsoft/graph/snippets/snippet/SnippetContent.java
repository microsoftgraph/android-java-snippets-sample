/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.microsoft.graph.snippets.snippet.DrivesSnippets.getDrivesSnippets;
import static com.microsoft.graph.snippets.snippet.EventsSnippets.getEventsSnippets;
import static com.microsoft.graph.snippets.snippet.GroupsSnippets.getGroupsSnippets;
import static com.microsoft.graph.snippets.snippet.MeSnippets.getMeSnippets;
import static com.microsoft.graph.snippets.snippet.MessageSnippets.getMessageSnippets;
import static com.microsoft.graph.snippets.snippet.UsersSnippets.getUsersSnippets;

public class SnippetContent {


    public static final List<AbstractSnippet<?>> ITEMS = new ArrayList<>();

    static {
        AbstractSnippet<?>[][] baseSnippets = new AbstractSnippet<?>[][]{
                getGroupsSnippets(),
                getEventsSnippets(),
                getMeSnippets(),
                getMessageSnippets(),
                getUsersSnippets(),
                getDrivesSnippets()
        };

        for (AbstractSnippet<?>[] snippetArray : baseSnippets) {
            Collections.addAll(ITEMS, snippetArray);
        }
    }

}
