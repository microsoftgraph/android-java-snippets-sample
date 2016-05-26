/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SignInActivityTests {
    @Rule
    public IntentsTestRule<SignInActivity> mActivityRule = new IntentsTestRule<>(SignInActivity.class);

    @Test
    public void displayAzureADSignIn() {
        ServiceConstants.CLIENT_ID = "12345678-1234-1234-1234-1234567890ab";
        onView(withId(R.id.o365_signin)).perform(click());
    }
}
