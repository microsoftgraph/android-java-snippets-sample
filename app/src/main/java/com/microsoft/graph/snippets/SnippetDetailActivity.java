/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class SnippetDetailActivity extends BaseActivity {
    private SnippetDetailFragment mSnippetDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snippet_detail);
        if (null != getActionBar()) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putInt(SnippetDetailFragment.ARG_ITEM_ID,
                    getIntent().getIntExtra(SnippetDetailFragment.ARG_ITEM_ID, 0));
            mSnippetDetailFragment = new SnippetDetailFragment();
            mSnippetDetailFragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .add(R.id.snippet_detail_container, mSnippetDetailFragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, SnippetListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isExecutingRequest(){
        return mSnippetDetailFragment.isExecutingRequest();
    }
}