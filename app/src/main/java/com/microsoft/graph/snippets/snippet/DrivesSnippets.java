/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.google.common.io.CharStreams;
import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.models.extensions.Drive;
import com.microsoft.graph.models.extensions.DriveItem;
import com.microsoft.graph.models.extensions.Folder;
import com.microsoft.graph.requests.extensions.IDriveItemCollectionPage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import static com.microsoft.graph.snippets.R.array.create_me_file;
import static com.microsoft.graph.snippets.R.array.create_me_folder;
import static com.microsoft.graph.snippets.R.array.delete_me_file;
import static com.microsoft.graph.snippets.R.array.download_me_file;
import static com.microsoft.graph.snippets.R.array.get_me_drive;
import static com.microsoft.graph.snippets.R.array.get_me_files;
import static com.microsoft.graph.snippets.R.array.rename_me_file;
import static com.microsoft.graph.snippets.R.array.update_me_file;

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
                        mGraphServiceClient
                                .me()
                                .drive()
                                .buildRequest()
                                .get(new ICallback<Drive>() {
                                    @Override
                                    public void success(Drive drive) {
                                        callback.success(drive.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                        });

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
                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children()
                                .buildRequest()
                                .get(new ICallback<IDriveItemCollectionPage>() {
                                    @Override
                                    public void success(IDriveItemCollectionPage iDriveItemCollectionPage) {
                                        callback.success(iDriveItemCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
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
                        try {
                            String guid = UUID.randomUUID().toString();
                            byte[] byteArray = guid.getBytes("UTF-8");

                            mGraphServiceClient
                                    .me()
                                    .drive()
                                    .root()
                                    .children(guid)
                                    .content()
                                    .buildRequest()
                                    .put(byteArray, new ICallback<DriveItem>() {
                                        @Override
                                        public void success(DriveItem driveItem) {
                                            callback.success(driveItem.getRawObject());
                                        }

                                        @Override
                                        public void failure(ClientException ex) {
                                            callback.failure(ex);
                                        }
                                    });
                        } catch (UnsupportedEncodingException uee) {
                            uee.printStackTrace();
                        }
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
                        //create a new file to download
                        String guid = UUID.randomUUID().toString();
                        byte[] byteArray = null;

                        try {
                            byteArray = guid.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }

                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children(guid)
                                .content()
                                .buildRequest()
                                .put(byteArray, new ICallback<DriveItem>() {
                                    @Override
                                    public void success(DriveItem driveItem) {
                                        // Get the guid that the service assigned to my file
                                        String guid = driveItem.id;
                                        mGraphServiceClient
                                                .me()
                                                .drive()
                                                .items()
                                                .byId(guid)
                                                .content()
                                                .buildRequest()
                                                .get(new ICallback<InputStream>() {
                                                    @Override
                                                    public void success(InputStream inputStream) {
                                                        final InputStreamReader inr = new InputStreamReader(inputStream);
                                                        String text;
                                                        try {
                                                            text = CharStreams.toString(inr);
                                                            JsonObject result = new JsonObject();
                                                            result.addProperty("value", text);

                                                            callback.success(result);
                                                        } catch (IOException ex) {
                                                            ex.printStackTrace();
                                                        }
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

                /*
                 * Update the content of a file
                 * PUT https://graph.microsoft.com/{version}/me/drive/items/{filename}/content
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_update
                 */
                new DrivesSnippets<JsonObject>(update_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        //create a new file to update
                        String guid = UUID.randomUUID().toString();
                        byte[] byteArray = null;

                        try {
                            byteArray = guid.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }

                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children(guid)
                                .content()
                                .buildRequest()
                                .put(byteArray, new ICallback<DriveItem>() {
                                    @Override
                                    public void success(DriveItem driveItem) {
                                        // This is the new content that we use to update the file
                                        byte[] byteArray = null;

                                        try {
                                            byteArray = "A plain text file".getBytes("UTF-8");

                                            mGraphServiceClient
                                                    .me()
                                                    .drive()
                                                    .items()
                                                    .byId(driveItem.id)
                                                    .content()
                                                    .buildRequest()
                                                    .put(byteArray, new ICallback<DriveItem>() {
                                                        @Override
                                                        public void success(DriveItem driveItem) {
                                                            callback.success(driveItem.getRawObject());
                                                        }

                                                        @Override
                                                        public void failure(ClientException ex) {
                                                            callback.failure(ex);
                                                        }
                                                    });
                                        } catch (IOException ex) {
                                            ex.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
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
                        //create a new file to delete
                        String guid = UUID.randomUUID().toString();
                        byte[] byteArray = null;

                        try {
                            byteArray = guid.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }

                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children(guid)
                                .content()
                                .buildRequest()
                                .put(byteArray, new ICallback<DriveItem>() {
                                    @Override
                                    public void success(DriveItem driveItem) {
                                        mGraphServiceClient
                                                .me()
                                                .drive()
                                                .items()
                                                .byId(driveItem.id)
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
                },
                
                /*
                 * Renames a file
                 * PATCH https://graph.microsoft.com/{version}/me/drive/items/{fileId}/
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_update
                 */
                new DrivesSnippets<JsonObject>(rename_me_file) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        //create a new file to rename
                        String guid = UUID.randomUUID().toString();
                        byte[] byteArray = null;

                        try {
                            byteArray = guid.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }

                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children(guid)
                                .content()
                                .buildRequest()
                                .put(byteArray, new ICallback<DriveItem>() {
                                    @Override
                                    public void success(DriveItem driveItem) {
                                        DriveItem renamedDriveItem = new DriveItem();
                                        renamedDriveItem.name = "Updated name";
                                        mGraphServiceClient
                                                .me()
                                                .drive()
                                                .items()
                                                .byId(driveItem.id)
                                                .buildRequest()
                                                .patch(renamedDriveItem, new ICallback<DriveItem>() {
                                                    @Override
                                                    public void success(DriveItem driveItem) {
                                                        callback.success(driveItem.getRawObject());
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

                /*
                 * Creates a folder
                 * POST https://graph.microsoft.com/me/drive/root/children
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/item_post_children
                 */
                new DrivesSnippets<JsonObject>(create_me_folder) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        String guid = UUID.randomUUID().toString();

                        DriveItem driveItem = new DriveItem();
                        driveItem.name = guid;
                        driveItem.folder = new Folder();

                        mGraphServiceClient
                                .me()
                                .drive()
                                .root()
                                .children(guid)
                                .buildRequest()
                                .post(driveItem, new ICallback<DriveItem>() {
                                    @Override
                                    public void success(DriveItem driveItem) {
                                        callback.success(driveItem.getRawObject());
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
