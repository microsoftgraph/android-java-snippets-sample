/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ListView;

import junit.framework.AssertionFailedError;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsAnything.anything;

@RunWith(AndroidJUnit4.class)
public class SnippetTests {
    @Rule
    public IntentsTestRule<SnippetListActivity> mSnippetListActivityRule = new IntentsTestRule<>(SnippetListActivity.class);

    @Test
    public void RunSnippets() throws InterruptedException{
        SnippetListActivity snippetListActivityActivity = mSnippetListActivityRule.getActivity();
        int numItems = ((ListView) snippetListActivityActivity
                .getSupportFragmentManager()
                .findFragmentById(R.id.snippet_list)
                .getView()
                .findViewById(android.R.id.list))
                .getAdapter()
                .getCount();

        for (int i = 0; i < numItems; i++){
            onData(anything())
                    .inAdapterView(withId(android.R.id.list))
                    .atPosition(i)
                    .perform(click());

            try {
                intended(allOf(
                        hasComponent(hasShortClassName(".SnippetDetailActivity")),
                        hasExtra("item_id", i),
                        toPackage("com.microsoft.graph.snippets")
                ));
            } catch (AssertionFailedError e) {
                continue;
            }

            onView(withId(R.id.btn_run)).perform(click());

            Thread.sleep(3000, 0);

            onView(withId(R.id.txt_status_color)).check(matches(withContentDescription(R.string.stoplight_success)));

            onView(withContentDescription("Navigate up")).perform(click());
        }
    }
}
