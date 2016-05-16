/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.office365.msgraphsnippetapp.snippet;

import android.os.Handler;

import com.google.gson.JsonObject;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.office365.msgraphapiservices.MSGraphMeService;
import com.microsoft.office365.msgraphsnippetapp.R;
import com.microsoft.office365.msgraphsnippetapp.application.SnippetApp;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_direct_reports;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_group_membership;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_manager;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_photo;
import static com.microsoft.office365.msgraphsnippetapp.R.array.get_me_responsibilities;

public abstract class MeSDKSnippets<Result> extends AbstractSnippet<MSGraphMeService, Result> {
    /**
     * Snippet constructor
     *
     * @param descriptionArray The String array for the specified snippet
     */
    public MeSDKSnippets(Integer descriptionArray) {
        super(SnippetCategory.meSnippetCategory, descriptionArray);
    }

    static MeSDKSnippets[] getMeSDKSnippets() {
        return new MeSDKSnippets[]{
                // Marker element
                new MeSDKSnippets(null) {
                    @Override
                    public void request(MSGraphMeService service, Callback callback) {
                        // Not implemented
                    }
                },
                // Snippets

                /* Get information about signed in user
                 * HTTP GET https://graph.microsoft.com/{version}/me
                 * @see https://graph.microsoft.io/docs/api-reference/v1.0/api/user_get
                 */
                new MeSDKSnippets<Response>(get_me) {
                    @Override
                    public void request(MSGraphMeService service, final Callback<Response> callback) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                JsonObject result = null;

                                try {
                                    result = SnippetApp.getApp().getGraphServiceClient().getMe().buildRequest().get().getRawObject();
                                    Response response = new Response("the test", 200, "The stuff worked!", new ArrayList<Header>(), null);

                                    callback.success(null, response);
                                } catch (ClientException clientException) {
                                    //callback.failure();
                                }
                            }
                        }).start();
                    }
                }
        };
    }

    @Override
    public abstract void request(MSGraphMeService service, Callback<Result> callback);

}
