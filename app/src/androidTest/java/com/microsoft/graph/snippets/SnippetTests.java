/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.runner.AndroidJUnit4;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.graph.auth.AuthenticationManager;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.inject.Inject;

import dagger.ObjectGraph;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
public class SnippetTests {
    private static String testClientId;
    private static String testUsername;
    private static String testPassword;

    protected ObjectGraph mObjectGraph;

    @Inject
    protected AuthenticationManager mAuthenticationManager;

    @Rule
    public IntentsTestRule<SignInActivity> mSignInActivityRule = new IntentsTestRule<>(SignInActivity.class);

    @BeforeClass
    public static void getTestParameters() throws FileNotFoundException {
        File testConfigFile = new File(Environment.getDataDirectory(), "local/testConfig.json");
        JsonObject testConfig = new JsonParser().parse(new FileReader(testConfigFile)).getAsJsonObject();
        testClientId = testConfig.get("test_client_id").getAsString();
        testUsername = testConfig.get("test_username").getAsString();
        testPassword = testConfig.get("test_password").getAsString();
        ServiceConstants.CLIENT_ID = testClientId;
    }

    @Test
    public void AzureADSignIn() throws InterruptedException{
        Thread.sleep(2000,0);
        onView(withId(R.id.o365_signin)).perform(click());

        try {
            onWebView()
                    .withElement(findElement(Locator.ID, "cred_userid_inputtext"))
                    .perform(clearElement())
                    // Enter text into the input element
                    .perform(DriverAtoms.webKeys(testUsername))
                    // Set focus on the username input text
                    // The form validates the username when this field loses focus
                    .perform(webClick())
                    .withElement(findElement(Locator.ID, "cred_password_inputtext"))
                    .perform(clearElement())
                    // Enter text into the input element
                    .perform(DriverAtoms.webKeys(testPassword))
                    // Now we force focus on this element to make
                    // the username element to lose focus and validate
                    .perform(webClick());

            Thread.sleep(2000, 0);

            onWebView()
                    .withElement(findElement(Locator.ID, "cred_sign_in_button"))
                    .perform(webClick());
        } catch (NoMatchingViewException ex) {
            // If user is already logged in, the flow will go directly to SnippetListActivity
        }

        Thread.sleep(2000, 0);
        intended(allOf(
                hasComponent(hasShortClassName(".SnippetListActivity")),
                toPackage("com.microsoft.graph.snippets")
        ));
    }
}
