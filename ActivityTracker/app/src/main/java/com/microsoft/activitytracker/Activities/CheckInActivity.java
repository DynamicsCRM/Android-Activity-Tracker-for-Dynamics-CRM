package com.microsoft.activitytracker.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Models.Contact;
import com.microsoft.activitytracker.R;
import com.microsoft.xrm.sdk.AliasedValue;
import com.microsoft.xrm.sdk.Client.OrganizationServiceProxy;
import com.microsoft.xrm.sdk.Client.RestOrganizationServiceProxy;
import com.microsoft.xrm.sdk.ColumnSet;
import com.microsoft.xrm.sdk.Entity;
import com.microsoft.xrm.sdk.EntityReference;
import com.microsoft.xrm.sdk.Messages.SetStateRequest;
import com.microsoft.xrm.sdk.OptionSetValue;
import com.microsoft.xrm.sdk.OrganizationResponse;
import com.nispok.snackbar.Snackbar;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CheckInActivity extends AppCompatActivity implements View.OnClickListener {

    private OrganizationServiceProxy mOrgService;
    private Calendar mDate = Calendar.getInstance();
    private Contact mContact;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mOrgService = new OrganizationServiceProxy(sharedPreferences.getString(Constants.ENDPOINT, ""),
                ActivityTracker.getRequestInterceptor());
        mProgressDialog = new ProgressDialog(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.checkin_toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.dateSection).setOnClickListener(this);
        LoadPage();
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            // when the date section is tapped (area around the date and the title)
            case R.id.dateSection:
                new DatePickerDialog(CheckInActivity.this, mDateSetListener,
                        mDate.get(Calendar.YEAR),
                        mDate.get(Calendar.MONTH),
                        mDate.get(Calendar.DAY_OF_MONTH)).show();
                break;

        }
    }

    private void validateForm() {
        EditText subject = (EditText)findViewById(R.id.etSubject);

        if (subject.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.subject_required);

            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    findViewById(R.id.submit_activity).setEnabled(true);
                }
            });

            dialog.show();
        } else {
            CreateActivity();
        }
    }

    private void LoadPage() {

        final TextView title = (TextView)findViewById(R.id.checkinTitle);

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
                            getSupportActionBar().setTitle(R.string.title_activity_check_in);
                            title.setText(mContact.getFullName());

                            ArrayList<String> jobAccount = new ArrayList<String>();

                            if (mContact.contains("jobtitle") && !mContact.getJobTitle().equals("")) {
                                jobAccount.add(mContact.getJobTitle());
                            }
                            if (mContact.contains("accountname") && !mContact.get("accountname").equals("")) {
                                jobAccount.add(((AliasedValue)mContact.get("accountname")).getValue().toString());
                            }

                            ((TextView) findViewById(R.id.checkinSubject))
                                    .setText(StringUtils.join(jobAccount.toArray(), ", "));

                            switch (mContact.getLogicalName()) {
                                case "contact":
                                    title.setTextColor(getResources().getColor(R.color.contact_color));
                                    break;
                                case "opportunity":
                                    title.setTextColor(getResources().getColor(R.color.opportunity_color));
                                    break;
                                case "account":
                                    title.setTextColor(getResources().getColor(R.color.account_color));
                                    break;
                            }


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

    private void CreateActivity() {
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getResources().getString(R.string.creating_activity));
        mProgressDialog.show();

        EditText subject = (EditText)findViewById(R.id.etSubject);
        EditText notes = (EditText)findViewById(R.id.etNotes);

        Entity entity = new Entity();

        entity.getAttributes().put("Subject", subject.getText().toString());
        entity.getAttributes().put("ActualEnd", mDate.getTime());
        entity.getAttributes().put("Description", notes.getText().toString());

        try {
            RestOrganizationServiceProxy restService = new RestOrganizationServiceProxy(mOrgService);
            restService.Create(mContact, entity, "Contact_Tasks", new Callback<UUID>() {
                @Override
                public void success(UUID uuid, Response response) {
                    CompleteActivity(uuid);
                }

                @Override
                public void failure(RetrofitError error) {
                    displayErrorSnackbar("Unable to create new check in");
                }
            });
        }
        catch(Exception ex) {

        }
    }

    private void CompleteActivity(UUID activityId) {
        SetStateRequest setStateRequest = SetStateRequest.build()
                .setEntityMoniker(new EntityReference("task", activityId))
                .setState(new OptionSetValue(1))
                .setStatus(new OptionSetValue(5));

        mOrgService.Execute(setStateRequest, new Callback<OrganizationResponse>() {
            @Override
            public void success(OrganizationResponse organizationResponse, Response response) {
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                displayErrorSnackbar("Error completing activity");
                Log.d("Execute SetStateRequest", error.getMessage());
            }
        });

    }

    private void SetDate()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        EditText etSubject = (EditText)findViewById(R.id.etSubject);

        if (etSubject.getText().toString().contains(String.format(
                getString(R.string.check_in_with),
                mContact.getFullName(),
                ""))) {
            etSubject.setText(String.format(
                    getString(R.string.check_in_with),
                    mContact.getFullName(),
                    simpleDateFormat.format(mDate.getTime())
            ));
        }

        TextView date = (TextView)findViewById(R.id.tvDate);
        date.setText(simpleDateFormat.format(mDate.getTime()));

    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mDate.set(Calendar.YEAR, year);
            mDate.set(Calendar.MONTH, monthOfYear);
            mDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SetDate();
        }
    };

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.warning_error);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                //Don't do anything, ignore the back press
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_check_in, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.submit_activity:
                findViewById(R.id.submit_activity).setEnabled(false);
                validateForm();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
