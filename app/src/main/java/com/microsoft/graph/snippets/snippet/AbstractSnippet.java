/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.snippet;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.snippets.application.SnippetApp;

public abstract class AbstractSnippet<Result> {

    private static final int mNameIndex = 0;
    private static final int mDescIndex = 1;
    private static final int mUrlIndex = 2;
    private static final int mIsAdminRequiredIndex = 3;
    private static final int mCodeSnippetIndex = 4;
    protected final IGraphServiceClient mGraphServiceClient;

    boolean mIsAdminRequired;
    private String mName, mDesc, mUrl, mCodeSnippet;

    /**
     * Snippet constructor
     *
     * @param category         Snippet category as corresponds to UI displayed sections (organization, me, groups, etc...)
     * @param descriptionArray The String array for the specified snippet
     */
    public AbstractSnippet(
            SnippetCategory category,
            Integer descriptionArray) {
        //Get snippet configuration information from the
        //XML configuration for the snippet
        getSnippetArrayContent(category, descriptionArray);
        mGraphServiceClient = SnippetApp.getApp().getGraphServiceClient();
    }


    /**
     * Gets the items from the specified snippet XML string array and stores the values
     * in private class fields
     *
     * @param category         Snippet category as corresponds to UI displayed sections (organization, me, groups, etc...)
     * @param descriptionArray The String array for the specified snippet
     */
    private void getSnippetArrayContent(SnippetCategory category, Integer descriptionArray) {
        if (null != descriptionArray) {
            String[] params = SnippetApp.getApp().getResources().getStringArray(descriptionArray);

            try {
                mName = params[mNameIndex];
                mDesc = params[mDescIndex];
                mUrl = params[mUrlIndex];
                mCodeSnippet = params[mCodeSnippetIndex];
                String isAdminRequired = params[mIsAdminRequiredIndex];
                mIsAdminRequired = isAdminRequired.equalsIgnoreCase("true");
            } catch (IndexOutOfBoundsException ex) {
                throw new RuntimeException(
                        "Invalid array in "
                                + category.mSection
                                + " snippet XML file"
                        , ex);
            }
        } else {
            mName = category.mSection;
            mDesc = mUrl = null;
        }
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDesc;
    }

    public String getCodeSnippet() { return mCodeSnippet; }

    public String getUrl() {
        return mUrl;
    }

    public boolean getIsAdminRequired() {
        return mIsAdminRequired;
    }

    public abstract void request(ICallback<Result> callback);
}
