/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.AssertionFailedError;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class SignInActivityTests {
    private static final String USER_ID_TEXT_ELEMENT = "cred_userid_inputtext";
    private static final String PASSWORD_TEXT_ELEMENT = "cred_password_inputtext";
    private static final String SIGN_IN_BUTTON_ELEMENT = "cred_sign_in_button";
    private static TestCredentials testCredentials;

    @Rule
    public ActivityTestRule<SignInActivity> mSignInActivityRule = new ActivityTestRule<>(SignInActivity.class, false, false);
    @Rule
    public ActivityTestRule<SnippetListActivity> mSnippetListActivityRule = new ActivityTestRule<>(SnippetListActivity.class, false, false);

    @BeforeClass
    public static void setupEnvironment() throws FileNotFoundException {


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
    public void AzureADSignIn_Success() throws InterruptedException{
        AzureADSignIn(TestCredentials.USERNAME_TEST_ARTIFACT, TestCredentials.PASSWORD_TEST_ARTIFACT, mSignInActivityRule);
    }

    @Test(expected = AssertionFailedError.class)
    public void AzureADSignIn_Fail() throws InterruptedException{
        AzureADSignIn("fake@fake.onmicrosoft.com", "fake_password", mSignInActivityRule);
    }

    public static void AzureADSignIn(String username, String password, ActivityTestRule<SignInActivity> signInActivityTestRule) throws InterruptedException {
        SignInActivity signInActivity = signInActivityTestRule.launchActivity(null);

        onView(withId(R.id.o365_signin)).perform(click());

        try {
            onWebView()
                    .withElement(findElement(Locator.ID, USER_ID_TEXT_ELEMENT))
                    .perform(clearElement())
                    // Enter text into the input element
                    .perform(DriverAtoms.webKeys(username))
                    // Set focus on the username input text
                    // The form validates the username when this field loses focus
                    .perform(webClick())
                    .withElement(findElement(Locator.ID, PASSWORD_TEXT_ELEMENT))
                    // Now we force focus on this element to make
                    // the username element to lose focus and validate
                    .perform(webClick())
                    .perform(clearElement())
                    // Enter text into the input element
                    .perform(DriverAtoms.webKeys(password));

            Thread.sleep(2000, 0);

            onWebView()
                    .withElement(findElement(Locator.ID, SIGN_IN_BUTTON_ELEMENT))
                    .perform(webClick());
        } catch (NoMatchingViewException ex) {
            // If user is already logged in, the flow will go directly to SnippetListActivity
        } finally {
            Thread.sleep(2000, 0);
        }

        // Finally, verify that SnippetListActivity is on top
        intended(allOf(
                hasComponent(hasShortClassName(".SnippetListActivity")),
                toPackage("com.microsoft.graph.snippets")
        ));

        signInActivity.finish();
    }
}
