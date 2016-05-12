/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.extensions.IGraphServiceClient;

import static com.microsoft.graph.snippets.R.array.get_all_contacts;

public abstract class ContactsSnippets<Result> extends AbstractSnippet<IGraphServiceClient, Result> {

    public ContactsSnippets(Integer descriptionArray) {
        super(SnippetCategory.contactSnippetCategory, descriptionArray);
    }


    static ContactsSnippets[] getContactsSnippets() {
        return new ContactsSnippets[]{
                // Marker element
                new ContactsSnippets(null) {
                    @Override
                    public void request(IGraphServiceClient service, ICallback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                 /* Get all of the user's contacts
                 * HTTP GET https://graph.microsoft.com/{version}/myOrganization/contacts
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_list_contacts
                 */
                new ContactsSnippets(get_all_contacts) {
                    @Override
                    public void request(IGraphServiceClient service, ICallback callback) {
                        service.getMe().getContacts().buildRequest().get(callback);
                    }
                }
        };
    }

    @Override
    public abstract void request(IGraphServiceClient service, ICallback<Result> callback);

}