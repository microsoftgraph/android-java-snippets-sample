/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.Recipient;
import com.microsoft.office365.msgraphsnippetapp.R;
import com.microsoft.office365.msgraphsnippetapp.application.SnippetApp;
import com.microsoft.office365.msgraphsnippetapp.util.SharedPrefsUtil;

import java.util.Collections;

import static com.microsoft.office365.msgraphsnippetapp.R.array.get_user_messages;
import static com.microsoft.office365.msgraphsnippetapp.R.array.send_an_email_message;

public abstract class MessageSnippets<Result> extends AbstractSnippet<Result> {
    /**
     * Snippet constructor
     *
     * @param descriptionArray The String array for the specified snippet
     */
    public MessageSnippets(Integer descriptionArray) {
        super(SnippetCategory.mailSnippetCategory, descriptionArray);
    }

    static MessageSnippets[] getMessageSnippets() {
        return new MessageSnippets[]{
                // Marker element
                new MessageSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                /* Get messages from mailbox for signed in user
                 * HTTP GET https://graph.microsoft.com/{version}/me/messages
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_list_messages
                 */
                new MessageSnippets<JsonObject>(get_user_messages) {
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
                                                    .getMessages()
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

                /* Sends an email message on behalf of the signed in user
                 * HTTP POST https://graph.microsoft.com/{version}/me/messages/sendMail
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_post_messages
                 */
                new MessageSnippets<JsonObject>(send_an_email_message) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        // Get a context so we can interrogate Resources & SharedPreferences
                      new Thread(new Runnable() {
                        @Override
                        public void run() {
                            JsonObject result = null;

                            try {
                                // create a new event to delete
                                Message message = createMessageObject();

                                SnippetApp
                                        .getApp()
                                        .getGraphServiceClient()
                                        .getMe()
                                        .getSendMail(message, true)
                                        .buildRequest()
                                        .post();

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

    @Override
    public abstract void request(ICallback<Result> callback);

    private static Message createMessageObject() {
        // Get a context so we can interrogate Resources & SharedPreferences
        SnippetApp app = SnippetApp.getApp();
        SharedPreferences prefs = SharedPrefsUtil.getSharedPreferences();

        Message message = new Message();
        Recipient recipient = new Recipient();
        recipient.emailAddress = new EmailAddress();
        recipient.emailAddress.address = prefs.getString(SharedPrefsUtil.PREF_USER_ID, "");
        message.toRecipients = Collections.singletonList(recipient);

        message.subject = app.getString(R.string.mail_subject);

        ItemBody itemBody = new ItemBody();
        itemBody.contentType = BodyType.text;
        itemBody.content = app.getString(R.string.mail_body);
        message.body = itemBody;

        return message;
    }
}
