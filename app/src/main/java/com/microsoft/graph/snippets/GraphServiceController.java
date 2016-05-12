/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.support.annotation.VisibleForTesting;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.extensions.BodyType;
import com.microsoft.graph.extensions.EmailAddress;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.extensions.ItemBody;
import com.microsoft.graph.extensions.Message;
import com.microsoft.graph.extensions.Recipient;

import java.security.InvalidParameterException;
import java.util.Collections;

/**
 * Handles the creation of the message and using the GraphServiceClient to
 * send the message. The app must have connected to Office 365 before using the
 * {@link #sendMail(String, String, String, ICallback)}method.
 */
class GraphServiceController {

    private final IGraphServiceClient mGraphServiceClient;

    public GraphServiceController() {
        mGraphServiceClient = GraphServiceClientManager.getInstance().getGraphServiceClient();
    }

    /**
     * Sends an email message using the Microsoft Graph API on Office 365. The mail is sent
     * from the address of the signed in user.
     *
     * @param emailAddress The recipient email address.
     * @param subject      The subject to use in the mail message.
     * @param body         The body of the message.
     */
    public void sendMail(
            final String emailAddress,
            final String subject,
            final String body,
            ICallback<Void> callback
    ) {

        // create the email message
        Message message = createMessage(subject, body, emailAddress);

        mGraphServiceClient.getMe().getSendMail(message, true).buildRequest().post(callback);
    }

    @VisibleForTesting
    Message createMessage(
            String subject,
            String body,
            String address) {

        if(address == null || address.isEmpty()) {
            throw new IllegalArgumentException("The address parameter can't be null or empty.");
        } else {
            // perform a simple validation of the email address
            String addressParts[] = address.split("@");
            if(addressParts.length != 2 || addressParts[0].length() == 0 || addressParts[1].indexOf('.') == -1) {
                throw new IllegalArgumentException(
                        String.format("The address parameter must be a valid email address {0}", address)
                );
            }
        }

        Message message = new Message();

        EmailAddress emailAddress = new EmailAddress();
        emailAddress.address = address;

        Recipient recipient = new Recipient();
        recipient.emailAddress = emailAddress;

        message.toRecipients = Collections.singletonList(recipient);

        ItemBody itemBody = new ItemBody();
        itemBody.content = body;
        itemBody.contentType = BodyType.html;

        message.body = itemBody;

        message.subject = subject;

        return message;
    }

}