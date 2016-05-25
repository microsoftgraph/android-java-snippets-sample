/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.Group;
import com.microsoft.graph.extensions.IDirectoryObjectCollectionWithReferencesPage;
import com.microsoft.graph.extensions.IGroupCollectionPage;

import java.util.Collections;
import java.util.UUID;

import static com.microsoft.graph.snippets.R.array.delete_a_group;
import static com.microsoft.graph.snippets.R.array.get_a_group;
import static com.microsoft.graph.snippets.R.array.get_all_groups;
import static com.microsoft.graph.snippets.R.array.get_group_members;
import static com.microsoft.graph.snippets.R.array.get_group_owners;
import static com.microsoft.graph.snippets.R.array.insert_a_group;

public abstract class GroupsSnippets<Result> extends AbstractSnippet<Result> {

    public GroupsSnippets(Integer descriptionArray) {
        super(SnippetCategory.groupSnippetCategory, descriptionArray);
    }

    static GroupsSnippets[] getGroupsSnippets() {
        return new GroupsSnippets[]{
                // Marker element
                new GroupsSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                /*
                 * Get a group by id
                 * GET https://graph.microsoft.com/{version}/myOrganization/groups/{Group.objectId}
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/group_get
                 */
                new GroupsSnippets<JsonObject>(get_a_group) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // create a group then query it
                        Group group = createGroupObject();

                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .post(group, new ICallback<Group>() {
                                    @Override
                                    public void success(Group group) {
                                        mGraphServiceClient
                                                .getGroups()
                                                .byId(group.id)
                                                .buildRequest()
                                                .get(new ICallback<Group>() {
                                                    @Override
                                                    public void success(Group group) {
                                                        callback.success(group.getRawObject());
                                                    }

                                                    @Override
                                                    public void failure(ClientException ex) {
                                                        callback.failure(ex);
                                                    }
                                                });

                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },
                /* Get all of the members of a newly created organization group
                 * GET https://graph.microsoft.com/{version}/myOrganization/groups/{Group.objectId}/members
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/group_list_members
                 */
                new GroupsSnippets<JsonObject>(get_group_members) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // create a group then ask for its members
                        Group group = createGroupObject();

                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .post(group, new ICallback<Group>() {
                                    @Override
                                    public void success(Group group) {
                                        mGraphServiceClient
                                                .getGroups()
                                                .byId(group.id)
                                                .getMembers()
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

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Get all of a group's owners
                 * GET https://graph.microsoft.com/{version}/myOrganization/groups/{Group.objectId}/owners
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/group_list_owners
                 */
                new GroupsSnippets<JsonObject>(get_group_owners) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // create a group and then request its owner
                        Group group = createGroupObject();

                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .post(group, new ICallback<Group>() {
                                    @Override
                                    public void success(Group group) {
                                        mGraphServiceClient
                                                .getGroups()
                                                .byId(group.id)
                                                .getOwners()
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

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* List all organization groups
                 * GET https://graph.microsoft.com/v1.0/groups
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/group_list
                 */
                new GroupsSnippets<JsonObject>(get_all_groups) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .get(new ICallback<IGroupCollectionPage>() {
                                    @Override
                                    public void success(IGroupCollectionPage iGroupCollectionPage) {
                                        callback.success(iGroupCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Create a new group with a random name
                 * POST https://graph.microsoft.com/{version}/myOrganization/groups
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/resources/group
                 */
                new GroupsSnippets<JsonObject>(insert_a_group) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // create a new group
                        Group group = createGroupObject();

                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .post(group, new ICallback<Group>() {
                                    @Override
                                    public void success(Group group) {
                                        callback.success(group.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Delete a group
                 * DELETE https://graph.microsoft.com/{version}/myOrganization/groups/{Group.objectId}
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/group_delete
                 */
                new GroupsSnippets<JsonObject>(delete_a_group) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        //Create a group that we will delete
                        // create a group and then request its owner
                        Group group = createGroupObject();

                        mGraphServiceClient
                                .getGroups()
                                .buildRequest()
                                .post(group, new ICallback<Group>() {
                                    @Override
                                    public void success(Group group) {
                                        mGraphServiceClient
                                                .getGroups()
                                                .byId(group.id)
                                                .buildRequest()
                                                .delete(new ICallback<Void>() {
                                                    @Override
                                                    public void success(Void aVoid) {
                                                        callback.success(null);
                                                    }

                                                    @Override
                                                    public void failure(ClientException ex) {
                                                        callback.failure(ex);
                                                    }
                                                });
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

    private static  Group createGroupObject() {
        String guid = UUID.randomUUID().toString();

        Group group = new Group();
        group.displayName = guid;
        group.mailNickname = guid;
        group.mailEnabled = false;
        group.securityEnabled = false;
        group.groupTypes = Collections.singletonList("Unified");

        return group;
    }

}