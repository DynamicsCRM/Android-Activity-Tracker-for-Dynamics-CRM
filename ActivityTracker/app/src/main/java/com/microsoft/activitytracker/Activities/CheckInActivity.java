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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Classes.Entity;
import com.microsoft.activitytracker.Classes.Utils;
import com.microsoft.activitytracker.Core.NetworkCalls;
import com.microsoft.activitytracker.R;
import com.google.gson.internal.LinkedTreeMap;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CheckInActivity extends Activity implements View.OnClickListener
{

    private Entity mThisEntity;
    private Calendar mDate = Calendar.getInstance();
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(R.style.DialogProgressTheme);

        mThisEntity = Entity.fromBundle((Bundle)getIntent().getParcelableExtra(Constants.SELECTED_ENTITY));
        ((EditText)findViewById(R.id.etSubject)).setText(String.format(
                getString(R.string.check_in_with),
                mThisEntity.getAttributeValue("fullname"),
                new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime())
        ));

        findViewById(R.id.dateSection).setOnClickListener(this);
//        findViewById(R.id.btnSubmit).setOnClickListener(this);

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

            // when the submit button is pressed
//            case R.id.btnSubmit:
//                findViewById(R.id.btnSubmit).setEnabled(false);
//                validateForm();
//                break;
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

    private void LoadPage()
    {
        TextView title = (TextView)findViewById(R.id.checkinTitle);
        title.setText(mThisEntity.getAttributeValue("fullname"));

        String jobTitle = mThisEntity.getAttributeValue("jobtitle");
        String accountName = mThisEntity.getAttributeValue("accountname");
        String stringFormat;

        if (!jobTitle.equals("") && !accountName.equals("")) {
            stringFormat = "%s, %s";
        }
        else {
            stringFormat = "%s%s";
        }

        ((TextView)findViewById(R.id.checkinSubject)).setText(
                String.format(stringFormat,
                        accountName,
                        jobTitle)
        );

        switch(mThisEntity.getLogicalname()){
            case CONTACT:
                title.setTextColor(getResources().getColor(R.color.contact_color));
                break;
            case OPPORTUNITY:
                title.setTextColor(getResources().getColor(R.color.opportunity_color));
                break;
            case ACCOUNT:
                title.setTextColor(getResources().getColor(R.color.account_color));
                break;
        }

        SetDate();
    }

    private void CreateActivity()
    {
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getResources().getString(R.string.creating_activity));
        mProgressDialog.show();

        EditText subject = (EditText)findViewById(R.id.etSubject);
        EditText notes = (EditText)findViewById(R.id.etNotes);

        String body = Utils.getSerializedCheckIn (
                subject.getText().toString(),
                mDate.getTime(),
                notes.getText().toString()
        );

        NetworkCalls.oDataPostRequest(
            this,
            body,
            String.format("ContactSet(guid'%s')/Contact_Tasks", mThisEntity.getId()),
            new Callback<LinkedTreeMap<String, Object>>() {
                @Override
                public void success(LinkedTreeMap<String, Object> stringObjectLinkedTreeMap, Response response)
                {
                    LinkedTreeMap<String, Object> newActivity = (LinkedTreeMap<String, Object>)stringObjectLinkedTreeMap.get("d");
                    CompleteActivity(newActivity.get("ActivityId").toString());
                }

                @Override
                public void failure(RetrofitError error)
                {
                    error.printStackTrace();
                }
            }
        );
    }

    private void CompleteActivity(String activityId)
    {
        mProgressDialog.setMessage(getResources().getString(R.string.completing_activity));
        String body = Utils.getRequestBodyforExecuteXML(Utils.getMarkActivityCompleteFetch(activityId));

        NetworkCalls.soapPostRequest(
                this,
                Constants.SOAP_ACTION_EXECUTE,
                body,
                new Callback<Object>()
                {
                    @Override
                    public void success(Object entities, Response response)
                    {
                        setResult(RESULT_OK);
                        finish();
                    }

                    @Override
                    public void failure(RetrofitError error)
                    {
                        error.getCause().printStackTrace();
                    }
                }
        );
    }

    private void SetDate()
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        EditText etSubject = (EditText)findViewById(R.id.etSubject);

        if (etSubject.getText().toString().contains(String.format(
                getString(R.string.check_in_with),
                mThisEntity.getAttributeValue("fullname"),
                ""))) {
            etSubject.setText(String.format(
                    getString(R.string.check_in_with),
                    mThisEntity.getAttributeValue("fullname"),
                    simpleDateFormat.format(mDate.getTime())
            ));
        }

        TextView date = (TextView)findViewById(R.id.tvDate);
        date.setText(simpleDateFormat.format(mDate.getTime()));


    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            mDate.set(Calendar.YEAR, year);
            mDate.set(Calendar.MONTH, monthOfYear);
            mDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SetDate();
        }
    };

    @Override
    public void onBackPressed()
    {

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
