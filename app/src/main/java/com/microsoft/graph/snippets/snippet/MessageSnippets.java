/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import android.content.SharedPreferences;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
//import com.microsoft.graph.extensions.BodyType;
//import com.microsoft.graph.extensions.EmailAddress;
//import com.microsoft.graph.extensions.IMessageCollectionPage;
//import com.microsoft.graph.extensions.ItemBody;
//import com.microsoft.graph.extensions.Message;
//import com.microsoft.graph.extensions.Recipient;
import com.microsoft.graph.models.extensions.EmailAddress;
import com.microsoft.graph.models.extensions.ItemBody;
import com.microsoft.graph.models.extensions.Message;
import com.microsoft.graph.models.extensions.Recipient;
import com.microsoft.graph.models.generated.BodyType;
import com.microsoft.graph.requests.extensions.IMessageCollectionPage;
import com.microsoft.graph.snippets.R;
import com.microsoft.graph.snippets.application.SnippetApp;
import com.microsoft.graph.snippets.util.SharedPrefsUtil;

import java.util.Collections;

import static com.microsoft.graph.snippets.R.array.get_user_messages;
import static com.microsoft.graph.snippets.R.array.send_an_email_message;

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
                        mGraphServiceClient
                                .me()
                                .messages()
                                .buildRequest()
                                .get(new ICallback<IMessageCollectionPage>() {
                                    @Override
                                    public void success(IMessageCollectionPage iMessageCollectionPage) {
                                        callback.success(iMessageCollectionPage.getRawObject());
                                    }

                                    @Override
                                    public void failure(ClientException ex) {
                                        callback.failure(ex);
                                    }
                                });
                    }
                },

                /* Sends an email message on behalf of the signed in user
                 * HTTP POST https://graph.microsoft.com/{version}/me/messages/sendMail
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_post_messages
                 */
                new MessageSnippets<JsonObject>(send_an_email_message) {
                    @Override
                    public void request(final ICallback<JsonObject> callback) {
                        Message message = createMessageObject();

                        mGraphServiceClient
                                .me()
                                .sendMail(message, true)
                                .buildRequest()
                                .post(new ICallback<Void>() {
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
        itemBody.contentType = BodyType.TEXT;
        itemBody.content = app.getString(R.string.mail_body);
        message.body = itemBody;

        return message;
    }
}
