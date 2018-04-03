package com.microsoft.graph.snippets.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.microsoft.graph.snippets.application.SnippetApp;

import java.util.HashMap;

/*
Contains methods that access the application manifest
 */
public class ManifestReader implements IManifestReader{

    /**
     * Gets the value of an AndroidManifest meta-data node. If the node value cannot be cast to String,
     * null is returned.
     * @param key String. The meta-data key value
     * @return String.  The value associated with the key
     */
    @Override
    public String getApplicationMetadataValueString(String key) {
        String returnValue = "";
        try {
            PackageInfo info = SnippetApp.getContext().getPackageManager().getPackageInfo(
                    SnippetApp.getContext().getPackageName(),
                    PackageManager.GET_META_DATA);
            if (info.applicationInfo.metaData != null) {
                Bundle bundle = info.applicationInfo.metaData;
                returnValue = bundle.getString(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    @Override
    public int getApplicationMetadataValueInt(String key) {
        return 0;
    }

    @Override
    public boolean getApplicationMetadataValueBoolean(String key) {
        return false;
    }

    @Override
    public int getApplicationMetadataValueColor(String key) {
        return 0;
    }

    @Override
    public float getApplicationMetadataValueFloat(String key) {
        return 0;
    }

    @Override
    public String getIntentFilterAction(String activityName) {
        return null;
    }

    @Override
    public String[] getIntentFilterCategories(String activityName) {
        return new String[0];
    }

    @Override
    public HashMap<String, String> getIntentFilterData(String activityName) {
        return null;
    }


}
