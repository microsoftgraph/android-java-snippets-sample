package com.microsoft.graph.snippets.util;

import java.util.HashMap;

public interface IManifestReader {
    String getApplicationMetadataValueString(String key);
    int getApplicationMetadataValueInt(String key);
    boolean getApplicationMetadataValueBoolean(String key);
    int getApplicationMetadataValueColor(String key);
    float getApplicationMetadataValueFloat(String key);
    String getIntentFilterAction(String activityName);
    String[] getIntentFilterCategories(String activityName);
    HashMap<String, String> getIntentFilterData(String activityName);

}
