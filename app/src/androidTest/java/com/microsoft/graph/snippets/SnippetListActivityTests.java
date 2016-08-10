/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.microsoft.graph.snippets.snippet.AbstractSnippet;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class SnippetListActivityTests {
    public static int CURRENT_NUMBER_OF_CATEGORIES = 6;
    @Rule
    public ActivityTestRule<SnippetListActivity> mSnippetListActivityRule = new ActivityTestRule<>(SnippetListActivity.class, false, false);

    @Test
    public void checkRightNumberOfCategories() {
        int adapterSize = getItemsCount(mSnippetListActivityRule);
        int actualSnippets = getActualSnippetsCount(mSnippetListActivityRule);

        Assert.assertEquals(
                "The number of categories is incorrect",
                CURRENT_NUMBER_OF_CATEGORIES,
                adapterSize - actualSnippets
        );
    }

    private int getItemsCount(ActivityTestRule<SnippetListActivity> snippetListActivityRule){
        SnippetListActivity snippetListActivity = snippetListActivityRule.launchActivity(null);

        ListAdapter listAdapter = getListAdapter(snippetListActivity);
        int numItems = listAdapter.getCount();

        snippetListActivity.finish();

        return numItems;
    }

    private int getActualSnippetsCount(ActivityTestRule<SnippetListActivity> snippetListActivityRule) {
        List<Integer> actualSnippetsIndexes = getSnippetsIndexes(snippetListActivityRule);
        return actualSnippetsIndexes.size();
    }

    private List<Integer> getSnippetsIndexes(ActivityTestRule<SnippetListActivity> snippetListActivityRule) {
        SnippetListActivity snippetListActivity = snippetListActivityRule.launchActivity(null);

        ListAdapter listAdapter = getListAdapter(snippetListActivity);
        int numItems = listAdapter.getCount();

        List<Integer> snippetIndexes = new ArrayList<>();

        // Get the index of items in the adapter that
        // are actual snippets and not categories, which don't have a Url
        for (int i = 0; i < numItems; i++) {
            if(((AbstractSnippet)listAdapter.getItem(i)).getUrl() != null) {
                snippetIndexes.add(i);
            }
        }

        snippetListActivity.finish();

        return snippetIndexes;
    }

    private ListAdapter getListAdapter (SnippetListActivity snippetListActivity) {
        return ((ListView) snippetListActivity
                .getSupportFragmentManager()
                .findFragmentById(R.id.snippet_list)
                .getView()
                .findViewById(android.R.id.list))
                .getAdapter();
    }
}
