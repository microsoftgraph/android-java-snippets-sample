/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import com.google.common.io.CharStreams;
import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.DriveItem;
import com.microsoft.graph.extensions.Folder;
import com.microsoft.office365.msgraphsnippetapp.application.SnippetApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static com.microsoft.office365.msgraphsnippetapp.R.array.create_me_file;
import static com.microsoft.office365.msgraphsnippetapp.R.array.create_me_folder;
import static com.microsoft.office365.msgraphsnippetapp.R.array.delete_me_file;
import static com.microsoft.office365.msgraphsnippetapp.R.array.download_me_file;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_drive;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_files;
import static com.microsoft.office365.msgraphsnippetapp.R.array.rename_me_file;
import static com.microsoft.office365.msgraphsnippetapp.R.array.update_me_file;

abstract class DrivesSnippets<Result> extends AbstractSnippet<Result> {

    public DrivesSnippets(Integer descriptionArray) {
        super(SnippetCategory.drivesSnippetCategory, descriptionArray);
    }

    static DrivesSnippets[] getDrivesSnippets() {
        return new DrivesSnippets[]{
                // Marker element
                new DrivesSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        //No implementation
                    }
                },
                //Snippets

                /* Get the user's drive
                 * GET https://graph.microsoft.com/{version}/me/drive
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/drive_get
                 */
                new DrivesSnippets<JsonObject>(get_me_drive) {
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
                                                    .getMe()
                                                    .getDrive()
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
                 * Get files in the root folder
                 * GET https://graph.microsoft.com/{version}/me/drive/root/children
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_list_children
                 */
                new DrivesSnippets<JsonObject>(get_me_files) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        //Get files in root folder
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getRoot()
                                                    .getChildren()
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
                 * Create a file
                 * PUT https://graph.microsoft.com/{version}/me/drive/root/children/{filename}/content
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_post_children
                 */
                new DrivesSnippets<JsonObject>(create_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // create a new file
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    String guid = UUID.randomUUID().toString();
                                    byte[] byteArray = guid.getBytes("UTF-8");

                                    result =
                                            SnippetApp
                                                .getApp()
                                                .getGraphServiceClient()
                                                .getMe()
                                                .getDrive()
                                                .getRoot()
                                                .getChildren(guid)
                                                .getContent()
                                                .buildRequest()
                                                .put(byteArray)
                                                .getRawObject();

                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                } catch (UnsupportedEncodingException uee) {
                                    uee.printStackTrace();
                                }
                            }
                        }).start();
                    }
                },

                /*
                 * Download the content of a file
                 * GET https://graph.microsoft.com/{version}/me/drive/items/{filename}/content
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_downloadcontent
                 */
                new DrivesSnippets<JsonObject>(download_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    //create a new file to download
                                    String guid = UUID.randomUUID().toString();
                                    byte[] byteArray = guid.getBytes("UTF-8");

                                    result =
                                            SnippetApp
                                                .getApp()
                                                .getGraphServiceClient()
                                                .getMe()
                                                .getDrive()
                                                .getRoot()
                                                .getChildren(guid)
                                                .getContent()
                                                .buildRequest()
                                                .put(byteArray)
                                                .getRawObject();

                                    // Get the guid that the service assigned to my file
                                    guid = result.get("id").getAsString();

                                    InputStream inputStream =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getItems()
                                                    .byId(guid)
                                                    .getContent()
                                                    .buildRequest()
                                                    .get();

                                    final InputStreamReader inr = new InputStreamReader(inputStream);
                                    String text = CharStreams.toString(inr);

                                    result = new JsonObject();
                                    result.addProperty("value", text);

                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                } catch (IOException exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }).start();
                    }
                },

                /*
                 * Update the content of a file
                 * PUT https://graph.microsoft.com/{version}/me/drive/items/{filename}/content
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_update
                 */
                new DrivesSnippets<JsonObject>(update_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    //create a new file to download
                                    String guid = UUID.randomUUID().toString();
                                    // This is the original content
                                    byte[] byteArray = guid.getBytes("UTF-8");

                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getRoot()
                                                    .getChildren(guid)
                                                    .getContent()
                                                    .buildRequest()
                                                    .put(byteArray)
                                                    .getRawObject();

                                    // Get the guid that the service assigned to my file
                                    guid = result.get("id").getAsString();

                                    // This is the new content that we use to update the file
                                    byteArray = "A plain text file".getBytes("UTF-8");
                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getItems()
                                                    .byId(guid)
                                                    .getContent()
                                                    .buildRequest()
                                                    .put(byteArray)
                                                    .getRawObject();

                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                } catch (UnsupportedEncodingException uee) {
                                    uee.printStackTrace();
                                }
                            }
                        }).start();
                    }
                },

                /*
                 * Delete the content of a file
                 * DELETE https://graph.microsoft.com/{version}/me/drive/items/{fileId}/
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_delete
                 */
                new DrivesSnippets<JsonObject>(delete_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //create a new file to download
                                    String guid = UUID.randomUUID().toString();
                                    // This is the original content
                                    byte[] byteArray = guid.getBytes("UTF-8");

                                    JsonObject result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getRoot()
                                                    .getChildren(guid)
                                                    .getContent()
                                                    .buildRequest()
                                                    .put(byteArray)
                                                    .getRawObject();

                                    // Get the guid that the service assigned to my file
                                    guid = result.get("id").getAsString();
                                    SnippetApp
                                            .getApp()
                                            .getGraphServiceClient()
                                            .getMe()
                                            .getDrive()
                                            .getItems()
                                            .byId(guid)
                                            .buildRequest()
                                            .delete();

                                    callback.success(null);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                } catch (UnsupportedEncodingException uee) {
                                    uee.printStackTrace();
                                }
                            }
                        }).start();
                    }
                },
                
                /*
                 * Renames a file
                 * PATCH https://graph.microsoft.com/{version}/me/drive/items/{fileId}/
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_update
                 */
                new DrivesSnippets<JsonObject>(rename_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //create a new file to download
                                    String guid = UUID.randomUUID().toString();
                                    // This is the original content
                                    byte[] byteArray = guid.getBytes("UTF-8");

                                    JsonObject result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getRoot()
                                                    .getChildren(guid)
                                                    .getContent()
                                                    .buildRequest()
                                                    .put(byteArray)
                                                    .getRawObject();

                                    // Get the guid that the service assigned to my file
                                    guid = result.get("id").getAsString();
                                    DriveItem driveItem = new DriveItem();
                                    driveItem.name = "Updated name";

                                    result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getItems()
                                                    .byId(guid)
                                                    .buildRequest()
                                                    .patch(driveItem)
                                                    .getRawObject();

                                    callback.success(result);
                                } catch (ClientException clientException) {
                                    callback.failure(clientException);
                                } catch (UnsupportedEncodingException uee) {
                                    uee.printStackTrace();
                                }
                            }
                        }).start();
                    }
                },

                /*
                 * Creates a folder
                 * POST https://graph.microsoft.com/me/drive/root/children
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_post_children
                 */
                new DrivesSnippets<JsonObject>(create_me_folder) {

                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    //create a new file to download
                                    String guid = UUID.randomUUID().toString();

                                    DriveItem driveItem = new DriveItem();
                                    driveItem.name = guid;
                                    driveItem.folder = new Folder();

                                    JsonObject result =
                                            SnippetApp
                                                    .getApp()
                                                    .getGraphServiceClient()
                                                    .getMe()
                                                    .getDrive()
                                                    .getRoot()
                                                    .getChildren()
                                                    .buildRequest()
                                                    .post(driveItem)
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
