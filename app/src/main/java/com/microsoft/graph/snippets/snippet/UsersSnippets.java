/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.IUserCollectionPage;
import com.microsoft.graph.extensions.PasswordProfile;
import com.microsoft.graph.extensions.User;
import com.microsoft.graph.options.Option;
import com.microsoft.graph.options.QueryOption;
import com.microsoft.graph.snippets.util.SharedPrefsUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.microsoft.graph.snippets.R.array.get_organization_filtered_users;
import static com.microsoft.graph.snippets.R.array.get_organization_users;
import static com.microsoft.graph.snippets.R.array.insert_organization_user;
import static com.microsoft.graph.snippets.util.SharedPrefsUtil.PREF_USER_TENANT;

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
                        // Not implemented
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
                        mGraphServiceClient
                                .getUsers()
                                .buildRequest()
                                .get(new ICallback<IUserCollectionPage>() {
                                    @Override
                                    public void success(IUserCollectionPage iUserCollectionPage) {
                                        callback.success(iUserCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
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
                        final List<Option> options = new LinkedList<>();
                        options.add(new QueryOption("$filter", "country eq 'United States'"));

                        mGraphServiceClient
                                .getUsers()
                                .buildRequest(options)
                                .get(new ICallback<IUserCollectionPage>() {
                                    @Override
                                    public void success(IUserCollectionPage iUserCollectionPage) {
                                        callback.success(iUserCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
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

                        mGraphServiceClient
                                .getUsers()
                                .buildRequest()
                                .post(user, new ICallback<User>() {
                                    @Override
                                    public void success(User user) {
                                        callback.success(user.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                }
        };
    }

    public abstract void request(ICallback<Result> callback);
}