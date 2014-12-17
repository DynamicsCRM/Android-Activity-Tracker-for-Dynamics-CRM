// Android Activity Tracker Sample app for Microsoft Dynamics CRM
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
// MIT License
//
// Permission is hereby granted, free of charge, to any person obtaining a copy of this software
// and associated documentation files (the ""Software""), to deal in the Software without
// restriction, including without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
//    The above copyright notice and this permission notice shall be included in all copies
//    or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
// BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
// DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package com.microsoft.activitytracker.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;

import com.microsoft.activitytracker.Adapters.ActivitiesItemAdapter;
import com.microsoft.activitytracker.Adapters.ActivitiesItemAdapter;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Classes.Entity;
import com.microsoft.activitytracker.Classes.RecentHistorydbHandler;
import com.microsoft.activitytracker.Core.NetworkCalls;
import com.microsoft.activitytracker.R;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


public class ItemActivity extends Activity implements View.OnClickListener
{
    private final int CHECK_IN_ACTIVITY = 1;

    private ActionBar mActionBar;
    private SwipeRefreshLayout mSwipeRefresh;
    private Entity mThisEntity;
    private StickyListHeadersListView mActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        mThisEntity = Entity.fromBundle(getIntent().getExtras().getBundle(Constants.SELECTED_ENTITY));
        mActivityList = (StickyListHeadersListView)findViewById(R.id.activity_list);

        // add this record to the recent records database now that we have visited the record
        RecentHistorydbHandler historydbHandler = new RecentHistorydbHandler(this);
        historydbHandler.addEntity(mThisEntity);

        //allow the user to use the app icon to go back
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // set the listener for each button
        findViewById(R.id.action_checkin).setOnClickListener(this);
        findViewById(R.id.mail_wrapper).setOnClickListener(this);
        findViewById(R.id.address_wrapper).setOnClickListener(this);
        findViewById(R.id.phone_wrapper).setOnClickListener(this);

        // grab and setup the pull to refresh layout
        mSwipeRefresh = (SwipeRefreshLayout)findViewById(R.id.recent_swipe_activity);
        mSwipeRefresh.setColorScheme(R.color.progress_1, R.color.progress_2, R.color.progress_3, R.color.progress_4);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                getRecentActivities();
            }
        });

        mActionBar = getActionBar();

        getDetailInfo();
        getRecentActivities();
    }

    @Override
    public void onClick(View v)
    {
        int intentId = 0;
        Intent iOption = null;

        switch(v.getId())
        {
            // moves the user to the checkin activity to create and complete a new activity
            case R.id.action_checkin:
                iOption = new Intent(ItemActivity.this, CheckInActivity.class);
                intentId = CHECK_IN_ACTIVITY;
                break;
            // uses the sent to intent to send and open an email client
            case R.id.mail_wrapper:
                Intent iMail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",
                        mThisEntity.getAttributeValue("emailaddress1"),
                        null
                ));
                startActivity(Intent.createChooser(iMail, "Send Email Using"));
                break;
            // uses the Action View intent to open up Google Maps to the geo information
            // passed in from the contacts address
            case R.id.address_wrapper:
                if (!mThisEntity.getAttributeValue("address1_line1").equals("")) {
                    Intent iAddress = new Intent(Intent.ACTION_VIEW, Uri.parse(
                            String.format("geo:0,0?q=%s",
                                    String.format(
                                            "%s, %s",
                                            mThisEntity.getAttributeValue("address1_line1"),
                                            mThisEntity.getAttributeValue("address1_city")))
                    ));
                    startActivity(iAddress);
                }
                break;
            // uses the Action Dial intent to start the dialer and automatically fill in this
            // contacts phone number
            case R.id.phone_wrapper:
                Intent iPhone = new Intent(Intent.ACTION_DIAL);
                iPhone.setData(Uri.parse(String.format("tel:%s", mThisEntity.getAttributeValue("telephone1"))));
                startActivity(iPhone);
                break;
        }

        if (iOption != null)
        {
            iOption.putExtra(Constants.SELECTED_ENTITY, mThisEntity.toBundle());
            startActivityForResult(iOption, intentId);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case CHECK_IN_ACTIVITY:
                getRecentActivities();
                break;
        }
    }

    private void loadItemDetails()
    {
        Resources resources = getResources();
        TextView title = (TextView)findViewById(R.id.item_title);

        switch (mThisEntity.getLogicalname())
        {
            case ACCOUNT:
                mActionBar.setTitle(R.string.account_title);
                title.setTextColor(resources.getColor(R.color.account_color));
                break;
            case CONTACT:
                mActionBar.setTitle(R.string.contact_title);
                title.setTextColor(resources.getColor(R.color.contact_color));
                break;
            case OPPORTUNITY:
                mActionBar.setTitle(R.string.opportunity_title);
                title.setTextColor(resources.getColor(R.color.opportunity_color));
                break;
        }

        String jobTitle = mThisEntity.getAttributeValue("jobtitle").trim();
        String accountName = mThisEntity.getAttributeValue("accountname").trim();
        String stringFormat;

        if (!jobTitle.equals("") && !accountName.equals("")) {
            stringFormat = "%s, %s";
        }
        else {
            stringFormat = "%s%s";
        }

        title.setText(mThisEntity.getAttributeValue("fullname"));
        ((TextView)findViewById(R.id.item_subject)).setText(String.format(
                stringFormat,
                accountName,
                jobTitle)
        );

        String telephone = mThisEntity.getAttributeValue("telephone1").trim();
        if (!telephone.equals("")) {
//            findViewById(R.id.phone_wrapper).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.phone)).setText(telephone);
        }
        else {
            ((TextView)findViewById(R.id.phone)).setText("--");
        }

        String email = mThisEntity.getAttributeValue("emailaddress1").trim();
        if (!email.equals("")) {
//            findViewById(R.id.mail_wrapper).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.email)).setText(email);
        }
        else {
            ((TextView)findViewById(R.id.email)).setText("--");
        }

        String addressLine1 = mThisEntity.getAttributeValue("address1_line1").trim();
        String city = mThisEntity.getAttributeValue("address1_city").trim();
        String state = mThisEntity.getAttributeValue("address1_stateorprovince").trim();
        String postalCode = mThisEntity.getAttributeValue("address1_postalcode").trim();
        if (!addressLine1.equals("") || !city.equals("") || !state.equals("") || !postalCode.equals("")) {
//            findViewById(R.id.address_wrapper).setVisibility(View.VISIBLE);
            ((TextView)findViewById(R.id.address)).setText(
                    String.format("%s\n%s, %s %s",addressLine1, city, state, postalCode)
            );
        }
        else {
            ((TextView)findViewById(R.id.address)).setText("--");
        }
    }

    private void getDetailInfo()
    {
        HashMap<String, String> queries = new HashMap<String, String>();
        queries.put("$select", Constants.CONTACT_SELECT);

        NetworkCalls.oDataGetRequest(
            this,
            String.format("ContactSet(guid'%s')", mThisEntity.getId()),
            queries,
            new Callback<LinkedTreeMap<String, Object>>()
            {

                @Override
                public void success(LinkedTreeMap<String, Object> stringObjectLinkedTreeMap, Response response) {
                    // drill into the response to get to the properties which is in the 'd' namespace
                    LinkedTreeMap<String, Object> propResponse = (LinkedTreeMap<String, Object>)stringObjectLinkedTreeMap.get("d");

                    // pull the keys of the properties and check if we have it yet
                    // if not add them to the entity attributes hashmap
                    Set<String> keys = propResponse.keySet();
                    for (String key : keys)
                    {
                        if (!mThisEntity.attributes.containsKey(key.toLowerCase()))
                        {
                            mThisEntity.attributes.put(key.toLowerCase(), propResponse.get(key));
                        }
                    }

                    loadItemDetails();
                }

                @Override
                public void failure(RetrofitError error) {
                    error.getCause().printStackTrace();
                }
            }
        );
    }

    private void getRecentActivities()
    {
        mSwipeRefresh.setRefreshing(true);

        HashMap<String, String> queries = new HashMap<String, String>();
        queries.put("$select", Constants.ACTIVITY_SELECT);
        queries.put("$filter", "ActualEnd ne null");
        queries.put("$orderby", "ActualEnd desc");
        queries.put("$top", "10");

        NetworkCalls.oDataGetRequest(
            this,
            String.format("ContactSet(guid'%s')/Contact_ActivityPointers", mThisEntity.getId()),
            queries,
            new Callback<LinkedTreeMap<String, Object>>()
            {
                @Override
                public void success(LinkedTreeMap<String, Object> stringObjectLinkedTreeMap, Response response)
                {
                    ArrayList results = (ArrayList)((LinkedTreeMap)stringObjectLinkedTreeMap.get("d")).get("results");

                    if (results != null && results.size() > 0) {
                        mActivityList.setAdapter(new ActivitiesItemAdapter(
                                getApplicationContext(),
                                results
                        ));
                    }
                    else {
                        ArrayList<String> noResult = new ArrayList<String>();
                        noResult.add(getString(R.string.no_complete_activites));

                        mActivityList.setAdapter(new ActivitiesItemAdapter(
                                getApplicationContext(),
                                noResult
                        ));
                    }

                    mSwipeRefresh.setRefreshing(false);
                }

                @Override
                public void failure(RetrofitError error)
                {
                    error.getCause().printStackTrace();
                }
            });
    }


}
