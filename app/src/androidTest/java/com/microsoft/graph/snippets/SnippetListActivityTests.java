/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.microsoft.graph.snippets.snippet.AbstractSnippet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class SnippetListActivityTests {
    public static int CURRENT_NUMBER_OF_CATEGORIES = 6;
    @Rule
    public ActivityTestRule<SnippetListActivity> mSnippetListActivityRule = new ActivityTestRule<>(SnippetListActivity.class, false, false);

    @Before
    public void initIntents(){
        Intents.init();
    }

    @After
    public void releaseIntents() {
        Intents.release();
    }

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

    @Test
    public void Disconnect() {
        Disconnect(mSnippetListActivityRule);
    }

    private void Disconnect(ActivityTestRule<SnippetListActivity> snippetListActivityTestRule) {
        SnippetListActivity snippetListActivity = snippetListActivityTestRule.launchActivity(null);

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());

        // Espresso can't find menu items by id. We'll use the text property.
        onView(withText(R.string.disconnect_menu_item))
                .perform(click());

        intended(allOf(
                hasComponent(hasShortClassName(".SignInActivity")),
                toPackage("com.microsoft.graph.snippets")
        ));

        snippetListActivity.finish();
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

    public static List<Integer> getSnippetsIndexes(ActivityTestRule<SnippetListActivity> snippetListActivityRule) {
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

    private static ListAdapter getListAdapter (SnippetListActivity snippetListActivity) {
        return ((ListView) snippetListActivity
                .getSupportFragmentManager()
                .findFragmentById(R.id.snippet_list)
                .getView()
                .findViewById(android.R.id.list))
                .getAdapter();
    }
}
