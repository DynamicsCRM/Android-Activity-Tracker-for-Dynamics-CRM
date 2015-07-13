package com.microsoft.activitytracker.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.activitytracker.Adapters.ActivitiesAdapter;
import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Models.Contact;
import com.microsoft.activitytracker.R;

import com.microsoft.xrm.sdk.AliasedValue;
import com.microsoft.xrm.sdk.Client.OrganizationServiceProxy;
import com.microsoft.xrm.sdk.Client.QueryOptions;
import com.microsoft.xrm.sdk.Client.RestOrganizationServiceProxy;
import com.microsoft.xrm.sdk.Entity;
import com.microsoft.xrm.sdk.EntityCollection;
import com.microsoft.xrm.sdk.EntityReference;
import com.microsoft.xrm.sdk.ColumnSet;
import com.microsoft.xrm.sdk.Messages.CreateRequest;
import com.microsoft.xrm.sdk.OrganizationResponse;
import com.nispok.snackbar.Snackbar;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ItemActivity extends AppCompatActivity implements View.OnClickListener
{
    private final int CHECK_IN_ACTIVITY = 1;

    private SwipeRefreshLayout mSwipeRefresh;
    private OrganizationServiceProxy mOrgService;
    private Contact mContact;
    private ListView mActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mOrgService = new OrganizationServiceProxy(sharedPreferences.getString(Constants.ENDPOINT, ""),
                ActivityTracker.getRequestInterceptor());
        mActivityList = (ListView)findViewById(R.id.activity_list);

        View view  = getLayoutInflater().inflate(R.layout.twoline_item_layout, null);
        view.setEnabled(false);
        mActivityList.addHeaderView(view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.item_toolbar);
        setSupportActionBar(toolbar);
        //allow the user to use the app icon to go back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set the listener for each button
        findViewById(R.id.action_checkin).setOnClickListener(this);
        findViewById(R.id.mail_wrapper).setOnClickListener(this);
        findViewById(R.id.address_wrapper).setOnClickListener(this);
        findViewById(R.id.phone_wrapper).setOnClickListener(this);

        Contact contact = Contact.build()
                .setFirstName("wiggle")
                .setLastName("tuffles");

        CreateRequest createRequest = new CreateRequest();
        createRequest.setTarget(contact);

        mOrgService.Execute(createRequest, new Callback<OrganizationResponse>() {
            @Override
            public void success(OrganizationResponse organizationResponse, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        // grab and setup the pull to refresh layout
        mSwipeRefresh = (SwipeRefreshLayout)findViewById(R.id.recent_swipe_activity);

        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh() {
                getRecentActivities();
            }
        });

        loadEntity();
    }

    @Override
    public void onClick(View v)
    {
        int intentId = 0;
        Intent iOption = null;

        try {
            switch (v.getId()) {
                // moves the user to the checkin activity to create and complete a new activity
                case R.id.action_checkin:
                    iOption = new Intent(ItemActivity.this, CheckInActivity.class);
                    intentId = CHECK_IN_ACTIVITY;
                    break;
                // uses the sent to intent to send and open an email client
                case R.id.mail_wrapper:
                    Intent iMail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto",
                            mContact.getEMailAddress1(),
                            null
                    ));
                    startActivity(Intent.createChooser(iMail, "Send Email Using"));
                    break;
                // uses the Action View intent to open up Google Maps to the geo information
                // passed in from the contacts address
                case R.id.address_wrapper:
                    if (mContact.getAddress1_Line1() != null) {
                        Intent iAddress = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                String.format("geo:0,0?q=%s",
                                        String.format(
                                                "%s, %s",
                                                mContact.getAddress1_Line1(),
                                                mContact.getAddress1_City()))
                        ));
                        startActivity(iAddress);
                    }
                    break;
                // uses the Action Dial intent to start the dialer and automatically fill in this
                // contacts phone number
                case R.id.phone_wrapper:
                    Intent iPhone = new Intent(Intent.ACTION_DIAL);
                    iPhone.setData(Uri.parse(String.format("tel:%s", mContact.getTelephone1())));
                    startActivity(iPhone);
                    break;
            }

            if (iOption != null) {
                iOption.putExtra(Constants.CURRENT_ENTITY, getIntent().getExtras()
                        .getBundle(Constants.CURRENT_ENTITY));
                startActivityForResult(iOption, intentId);
            }
        }
        catch (ActivityNotFoundException ex) {
            Snackbar.with(this)
                    .text("No Available Apps")
                    .textColor(this.getResources().getColor(R.color.white))
                    .duration(Snackbar.SnackbarDuration.LENGTH_LONG)
                    .show(this);
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

    private void loadEntity() {
        final TextView title = (TextView)findViewById(R.id.item_title);

        EntityReference entityReference = EntityReference.fromBundle(
                getIntent().getExtras().getBundle(Constants.CURRENT_ENTITY));

        mOrgService.Retrieve(entityReference.getLogicalName(), entityReference.getId(),
                new ColumnSet("contactid", "fullname", "address1_line1", "address1_city",
                        "address1_stateorprovince", "address1_postalcode", "emailaddress1",
                        "jobtitle", "telephone1"),
                new Callback<Entity>() {
                    @Override
                    public void success(Entity entity, Response response) {
                        try {
                            mContact = entity.toEntity(Contact.class);
                            getSupportActionBar().setTitle(R.string.contact_title);

                            ArrayList<String> jobAccount = new ArrayList<>();

                            if (mContact.contains("jobtitle") && !mContact.getJobTitle().equals("")) {
                                jobAccount.add(mContact.getJobTitle());
                            }
                            if (mContact.contains("accountname") && !mContact.get("accountname").equals("")) {
                                jobAccount.add(((AliasedValue)mContact.get("accountname")).getValue().toString());
                            }

                            ((TextView) findViewById(R.id.item_subject))
                                    .setText(StringUtils.join(jobAccount.toArray(), ", "));


                            title.setText(mContact.getFullName());

                            if (mContact.getTelephone1() != null && !mContact.getTelephone1().equals("")) {
//                                findViewById(R.id.phone_wrapper).setVisibility(View.VISIBLE);
                                ((TextView) findViewById(R.id.phone)).setText(mContact.getTelephone1());
                            }
                            if (mContact.getEMailAddress1() != null && !mContact.getEMailAddress1().equals("")) {
//                                findViewById(R.id.mail_wrapper).setVisibility(View.VISIBLE);
                                ((TextView) findViewById(R.id.email)).setText(mContact.getEMailAddress1());
                            }
                            if (mContact.getAddress1_Composite() != null && !mContact.getAddress1_Composite().equals("")) {
//                                findViewById(R.id.address_wrapper).setVisibility(View.VISIBLE);
                                ((TextView) findViewById(R.id.address)).setText(mContact.getAddress1_Composite());
                            }

                            getRecentActivities();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        displayErrorSnackbar("Unable to retrieve Contact");
                    }
                });
    }

    private void displayErrorSnackbar(String error) {
        Snackbar.with(this)
                .text(error)
                .textColor(getResources().getColor(R.color.white))
                .duration(Snackbar.SnackbarDuration.LENGTH_LONG)
                .show(this);
    }

    private void getRecentActivities() {
        mSwipeRefresh.setRefreshing(true);

        QueryOptions queryOptions = QueryOptions.build()
                .putTop("10")
                .putSelect(Constants.ACTIVITY_SELECT)
                .putFilter("ActualEnd ne null")
                .putOrderBy("ActualEnd desc");

        RestOrganizationServiceProxy restService = new RestOrganizationServiceProxy(mOrgService);

        restService.RetrieveMultiple(Contact.class.getSimpleName(), mContact.getId(), "Contact_ActivityPointers",
                queryOptions, new Callback<EntityCollection>() {
                    @Override
                    public void success(EntityCollection entityCollection, Response response) {
//                        mActivityList.removeAllViews();
//
//                        if (entityCollection.getEntities().size() == 0) {
//                            View header = getLayoutInflater().inflate(R.layout.header_item_layout, mActivityList);
//                            ((TextView)header.findViewById(R.id.header_text)).setText("No Activities Found");
//                            mActivityList.addHeaderView(header);
//                        }

                        mActivityList.setAdapter(new ActivitiesAdapter(getApplicationContext(),
                                entityCollection));
                        mSwipeRefresh.setRefreshing(false);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        displayErrorSnackbar("Unable to retrieve contact's activities");
                    }
                });
    }


}
