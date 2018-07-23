/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.models.extensions.DirectoryObject;
import com.microsoft.graph.requests.extensions.IDirectoryObjectCollectionWithReferencesPage;
import com.microsoft.graph.models.extensions.ProfilePhoto;
import com.microsoft.graph.models.extensions.User;
import com.microsoft.graph.options.Option;
import com.microsoft.graph.options.QueryOption;

import java.util.LinkedList;
import java.util.List;

import static com.microsoft.graph.snippets.R.array.get_me;
import static com.microsoft.graph.snippets.R.array.get_me_direct_reports;
import static com.microsoft.graph.snippets.R.array.get_me_group_membership;
import static com.microsoft.graph.snippets.R.array.get_me_manager;
import static com.microsoft.graph.snippets.R.array.get_me_photo;
import static com.microsoft.graph.snippets.R.array.get_me_responsibilities;

public abstract class MeSnippets<Result> extends AbstractSnippet<Result> {
    /**
     * Snippet constructor
     *
     * @param descriptionArray The String array for the specified snippet
     */
    public MeSnippets(Integer descriptionArray) {
        super(SnippetCategory.meSnippetCategory, descriptionArray);
    }

    static MeSnippets[] getMeSnippets() {
        return new MeSnippets[]{
                // Marker element
                new MeSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                /* Get information about signed in user
                 * HTTP GET https://graph.microsoft.com/{version}/me
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_get
                 */
                new MeSnippets<JsonObject>(get_me) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .buildRequest()
                                .get(new ICallback<User>() {
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
                },

                /* Get responsibilities of signed in user
                 * HTTP GET https://graph.microsoft.com/{version}/me?$select=AboutMe,Responsibilities,Tags
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/user
                 */
                new MeSnippets<JsonObject>(get_me_responsibilities) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        final List<Option> options = new LinkedList<>();
                        options.add(new QueryOption("$select", "AboutMe,Responsibilities,Tags"));
                        mGraphServiceClient
                                .me()
                                .buildRequest(options)
                                .get(new ICallback<User>() {
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
                },

                /* Get the user's manager
                 * HTTP GET https://graph.microsoft.com/{version}/me/manager
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/user
                 */
                new MeSnippets<JsonObject>(get_me_manager) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .manager()
                                .buildRequest()
                                .get(new ICallback<DirectoryObject>() {
                                    @Override
                                    public void success(DirectoryObject directoryObject) {
                                        callback.success(directoryObject.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Get the user's direct reports
                 * HTTP GET https://graph.microsoft.com/{version}/me/directReports
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/user
                 */
                new MeSnippets<JsonObject>(get_me_direct_reports) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .directReports()
                                .buildRequest()
                                .get(new ICallback<IDirectoryObjectCollectionWithReferencesPage>() {
                                    @Override
                                    public void success(IDirectoryObjectCollectionWithReferencesPage iDirectoryObjectCollectionWithReferencesPage) {
                                        callback.success(iDirectoryObjectCollectionWithReferencesPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Get the group membership of the user
                 * HTTP GET https://graph.microsoft.com/{version}/me/memberOf
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/user
                 */
                new MeSnippets<JsonObject>(get_me_group_membership) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .memberOf()
                                .buildRequest()
                                .get(new ICallback<IDirectoryObjectCollectionWithReferencesPage>() {
                                    @Override
                                    public void success(IDirectoryObjectCollectionWithReferencesPage iDirectoryObjectCollectionWithReferencesPage) {
                                        callback.success(iDirectoryObjectCollectionWithReferencesPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Get the photo of the user
                 * HTTP GET https://graph.microsoft.com/{version}/me/userPhoto
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/user
                 */
                new MeSnippets<JsonObject>(get_me_photo) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .me()
                                .photo()
                                .buildRequest()
                                .get(new ICallback<ProfilePhoto>() {
                                    @Override
                                    public void success(ProfilePhoto profilePhoto) {
                                        callback.success(profilePhoto.getRawObject());
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

    @Override
    public abstract void request(ICallback<Result> callback);

}
