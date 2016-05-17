/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import com.microsoft.graph.concurrency.ICallback;

import retrofit.Callback;
import retrofit.client.Response;

import static com.microsoft.office365.msgraphsnippetapp.R.array.get_all_contacts;

public abstract class ContactsSnippets<Result> extends AbstractSnippet<Result> {

    public ContactsSnippets(Integer descriptionArray) {
        super(SnippetCategory.contactSnippetCategory, descriptionArray);
    }


    static ContactsSnippets[] getContactsSnippets() {
        return new ContactsSnippets[]{
                // Marker element
                new ContactsSnippets(null) {
                    @Override
                    public void request(ICallback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                 /* Get all of the user's contacts
                 * HTTP GET https://graph.microsoft.com/{version}/myOrganization/contacts
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_list_contacts
                 */
                new ContactsSnippets<Response>(get_all_contacts) {
                    @Override
                    public void request(ICallback<Response> callback) {
                        //service.getContacts(getVersion(), callback);
                    }
                }
        };
    }

    @Override
    public abstract void request(ICallback<Result> callback);

}