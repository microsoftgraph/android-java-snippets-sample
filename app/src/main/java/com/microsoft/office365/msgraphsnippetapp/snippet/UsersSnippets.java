/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.PasswordProfile;
import com.microsoft.graph.extensions.User;
import com.microsoft.graph.options.Option;
import com.microsoft.graph.options.QueryOption;
import com.microsoft.office365.msgraphsnippetapp.application.SnippetApp;
import com.microsoft.office365.msgraphsnippetapp.util.SharedPrefsUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.microsoft.office365.msgraphsnippetapp.R.array.get_organization_filtered_users;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_organization_users;
import static com.microsoft.office365.msgraphsnippetapp.R.array.insert_organization_user;
import static com.microsoft.office365.msgraphsnippetapp.util.SharedPrefsUtil.PREF_USER_TENANT;

public abstract class UsersSnippets<Result> extends AbstractSnippet<Result> {

    public UsersSnippets(Integer descriptionArray) {
        super(SnippetCategory.userSnippetCategory, descriptionArray);
    }

    static UsersSnippets[] getUsersSnippets() {
        return new UsersSnippets[]{
                // Marker element
                new UsersSnippets(null) {

                    @Override
                    public void request(ICallback callback) {
                    }
                },

                /*
                 * Gets all of the users in your tenant\'s directory.
                 * HTTP GET https://graph.microsoft.com/{version}/myOrganization/users
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_list
                 */
                new UsersSnippets<JsonObject>(get_organization_users) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getUsers()
                                                    .buildRequest()
                                                    .get()
                                                    .getRawObject();
                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                }
                            }
                        }).start();
                    }
                },

                /*
                 * Gets all of the users in your tenant's directory who are from the United States, using $filter.
                 * HTTP GET https://graph.microsoft.com/{version}/myOrganization/users?$filter=country eq \'United States\'
                 * @see http://graph.microsoft.io/docs/overview/query_parameters
                 */
                new UsersSnippets<JsonObject>(get_organization_filtered_users) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;
                                final List<Option> options = new LinkedList<>();
                                options.add(new QueryOption("$filter", "country eq 'United States'"));

                                try {
                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getUsers()
                                                    .buildRequest(options)
                                                    .get()
                                                    .getRawObject();
                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                }
                            }
                        }).start();
                    }
                },

                 /*
                 * Adds a new user to the tenant's directory
                 * HTTP POST https://graph.microsoft.com/{version}/myOrganization/users
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_post_users
                 */
                new UsersSnippets<JsonObject>(insert_organization_user) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                //Use a random UUID for the user name
                                String randomUserName = UUID.randomUUID().toString();

                                // create the user
                                User user = new User();
                                user.accountEnabled = true;
                                user.displayName = "SAMPLE " + randomUserName;
                                user.mailNickname = randomUserName;

                                // get the tenant from preferences
                                SharedPreferences prefs = SharedPrefsUtil.getSharedPreferences();
                                String tenant = prefs.getString(PREF_USER_TENANT, "");
                                user.userPrincipalName = randomUserName + "@" + tenant;

                                // initialize a password & say whether or not the user must change it
                                PasswordProfile password = new PasswordProfile();
                                password.password = UUID.randomUUID().toString().substring(0, 16);
                                password.forceChangePasswordNextSignIn = false;

                                user.passwordProfile = password;

                                try {
                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getUsers()
                                                    .buildRequest()
                                                    .post(user)
                                                    .getRawObject();
                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                }
                            }
                        }).start();
                    }
                }
        };
    }

    public abstract void request(ICallback<Result> callback);
}