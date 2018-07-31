/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.content.Intent;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.Espresso.unregisterIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SnippetDetailActivityTests {
    private static TestCredentials testCredentials;

    @Rule
    public ActivityTestRule<SignInActivity> mSignInActivityRule = new ActivityTestRule<>(SignInActivity.class, false, false);
    @Rule
    public ActivityTestRule<SnippetListActivity> mSnippetListActivityRule = new ActivityTestRule<>(SnippetListActivity.class, false, false);
    @Rule
    public ActivityTestRule<SnippetDetailActivity> mSnippetDetailActivityRule = new ActivityTestRule<>(SnippetDetailActivity.class, false, false);

    @BeforeClass
    public static void setupEnvironment() throws FileNotFoundException {
        testCredentials = TestCredentials.getTestCredentials();
       // ServiceConstants.CLIENT_ID = testCredentials.clientId;
    }

    @Before
    public void initIntents(){
        Intents.init();
    }

    @After
    public void releaseIntents() {
        Intents.release();
    }

    @Test
    public void RunSnippets_Success() throws InterruptedException{
        SignInActivityTests.AzureADSignIn(testCredentials.username, testCredentials.password, mSignInActivityRule);

        List<Integer> snippetIndexes = SnippetListActivityTests.getSnippetsIndexes(mSnippetListActivityRule);

        for(int index : snippetIndexes) {
            runSnippet(index, R.string.stoplight_success);
        }
    }

    @Test
    public void RunSnippets_NoToken() throws InterruptedException{
        SnippetListActivityTests.Disconnect(mSnippetListActivityRule);

        List<Integer> snippetIndexes = SnippetListActivityTests.getSnippetsIndexes(mSnippetListActivityRule);

        for(int index : snippetIndexes) {
            runSnippet(index, R.string.stoplight_failure);
        }
    }

    private void runSnippet(int index, int expectedStatusColor) {
        Intent itemIdIntent = new Intent();
        itemIdIntent.putExtra("item_id", index);
        SnippetDetailActivity snippetDetailActivity = mSnippetDetailActivityRule.launchActivity(itemIdIntent);

        SnippetDetailActivityIdlingResource idlingResource = new SnippetDetailActivityIdlingResource(snippetDetailActivity);
        registerIdlingResources(idlingResource);

        onView(withId(R.id.btn_run)).perform(click());

        onView(withId(R.id.txt_status_color)).check(matches(withContentDescription(expectedStatusColor)));
        unregisterIdlingResources(idlingResource);
        snippetDetailActivity.finish();
    }

    private class SnippetDetailActivityIdlingResource implements IdlingResource {
        private SnippetDetailActivity activity;
        private ResourceCallback callback;

        public SnippetDetailActivityIdlingResource(SnippetDetailActivity activity) {
            this.activity = activity;
        }

        @Override
        public String getName() {
            return this.getClass().getName();
        }

        @Override
        public boolean isIdleNow() {
            Boolean idle = activity != null &&
                    callback != null &&
                    !activity.isExecutingRequest();
            if (idle) callback.onTransitionToIdle();
            return idle;
        }

        @Override
        public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
            this.callback = resourceCallback;
        }
    }
}
