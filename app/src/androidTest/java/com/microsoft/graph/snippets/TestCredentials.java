/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.os.Environment;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestCredentials {
    private static final String TEST_ARTIFACT_LOCATION = "local/testConfig.json";
    private static final String CLIENT_ID_TEST_ARTIFACT = "test_client_id";
    private static final String USERNAME_TEST_ARTIFACT = "test_username";
    private static final String PASSWORD_TEST_ARTIFACT = "test_password";

    public String clientId;
    public String username;
    public String password;

    public static TestCredentials getTestCredentials() throws FileNotFoundException {
        TestCredentials testCredentials = new TestCredentials();
//        File testConfigFile = new File(Environment.getDataDirectory(), TEST_ARTIFACT_LOCATION);
//        JsonObject testConfig = new JsonParser().parse(new FileReader(testConfigFile)).getAsJsonObject();

//        testCredentials.clientId = testConfig.get(CLIENT_ID_TEST_ARTIFACT).getAsString();
//        testCredentials.username = testConfig.get(USERNAME_TEST_ARTIFACT).getAsString();
//        testCredentials.password = testConfig.get(PASSWORD_TEST_ARTIFACT).getAsString();
          testCredentials.clientId = "94da997e-c3f4-40b4-9901-ab5b75c0d1a5";
          testCredentials.username = "ding.men@husky.neu.edu";
          testCredentials.password = "Dingmc610@ms";

        return testCredentials;
    }
}
