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
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Toast;

import com.microsoft.activitytracker.Adapters.MainItemAdapter;
import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Classes.Entity;
import com.microsoft.activitytracker.Classes.RecentHistorydbHandler;
import com.microsoft.activitytracker.Classes.Utils;
import com.microsoft.activitytracker.Core.NetworkCalls;
import com.microsoft.activitytracker.Adapters.MainItemAdapter;
import com.microsoft.activitytracker.R;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class MainActivity extends Activity implements AuthenticationCallback<AuthenticationResult>
{
    private static final String TAG = "ActivityLogger.MainActivity";
    private static final int SETUP_ID = 0;

    private SharedPreferences mAppPreferences;
    private String mLastQuery;
    private StickyListHeadersListView mMainList;
    private SwipeRefreshLayout mSwipeRefresh;
    private AuthenticationContext mAuthContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets up the progress bar and the pull to refresh gesture
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.pullRefresh);
        // Colors are for the indeterminate progressbar at the top of the screen (right under the
        // Action bar
        mSwipeRefresh.setColorScheme(R.color.progress_1, R.color.progress_2, R.color.progress_3, R.color.progress_4);
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                if (mLastQuery != null) {
                    runSearchQuery();
                }
                else {
                    getRecentActivity();
                }
            }
        });

        mMainList = (StickyListHeadersListView) findViewById(R.id.itemsList);
        mMainList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Object thisItem = mMainList.getAdapter().getItem(position);
                if (thisItem.getClass() != String.class) {
                    Entity thisEntity = (Entity) thisItem;

                    // Completely bundle up the selected entity and pass it as an extra
                    // to the next activity
                    Intent iItem = new Intent(MainActivity.this, ItemActivity.class);
                    iItem.putExtra(Constants.SELECTED_ENTITY, thisEntity.toBundle());
                    startActivity(iItem);
                }
            }
        });


        mAppPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mSwipeRefresh.setRefreshing(true);
        Authentication();
    }

    /***
     *  runs authentication to get a token. If a refresh token is stored in the application storage it will
     *  try to refresh the old token, or it will navigate to the signin activity for you to log in using the
     *  Azure Active Directory Library's (aadl) custom webview.
     */
    private void Authentication()
    {

        // Get the connectivity manager so we can check if the device has an internet connection or not
        ConnectivityManager connectivityManager =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        // If we do have an internet connection, run refresh of the auth token
        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {
            try {
                if (mAppPreferences.contains(Constants.REFRESH_TOKEN) || !mAppPreferences.getString(Constants.REFRESH_TOKEN, "").equals("")) {
                    mAuthContext = new AuthenticationContext(
                            MainActivity.this,
                            mAppPreferences.getString(Constants.AUTHORITY,""),
                            false);

                    mAuthContext.acquireTokenByRefreshToken(
                            mAppPreferences.getString(Constants.REFRESH_TOKEN, ""),
                            Constants.CLIENT_ID,
                            this
                    );
                }
                else {
                    Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
                    startActivityForResult(iSetup, SETUP_ID);
                }

            } catch (Exception e) {
                Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
                startActivityForResult(iSetup, SETUP_ID);
            }
        }
        // If we don't create a popup to tell the user
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.network_error);

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
                    finish();
                }
            });

            dialog.show();
        }
    }

    private void populateAuthContext()
    {
        try {
            mAuthContext = new AuthenticationContext(
                    MainActivity.this,
                    mAppPreferences.getString(Constants.AUTHORITY,""),
                    false);
        }
        catch (Exception ex) {
            ex.getCause().printStackTrace();
        }
    }

    @Override
    public void onSuccess(AuthenticationResult result)
    {
        ActivityTracker.setCurrentSessionToken(getApplicationContext(), result.getAccessToken());
        Log.d(TAG, "Status:" + result.getStatus() + " Expired:" + result.getExpiresOn().toString());
        getRecentActivity();
    }

    @Override
    public void onError(Exception exc)
    {
        Toast.makeText(this, "Unable to log back in", Toast.LENGTH_SHORT).show();
        Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
        startActivityForResult(iSetup, SETUP_ID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case SETUP_ID:
                getRecentActivity();
                break;

            default:
                if (mAuthContext != null)
                {
                    mAuthContext.onActivityResult(requestCode, resultCode, data);
                }
                break;
        }
    }

    private void getRecentActivity()
    {
        RecentHistorydbHandler historydbHandler = new RecentHistorydbHandler(this);

        List<Entity> recordHistory = historydbHandler.getRecentHistory();

        // if the database has actual recent records build the list this way
        if (recordHistory.size() > 0) {
            mMainList.setAdapter(new MainItemAdapter(
                    this,
                    recordHistory,
                    getString(R.string.recent_records)
            ));
        }
        // if the database is empty then we just pass in a string item to build the list
        else {
            ArrayList<String> noResult = new ArrayList<String>();
            noResult.add(getString(R.string.no_recent_records));

            mMainList.setAdapter(new MainItemAdapter(
                    this,
                    noResult,
                    getString(R.string.recent_records)
            ));
        }

        mSwipeRefresh.setRefreshing(false);
    }

    private void runSearchQuery()
    {
        mSwipeRefresh.setRefreshing(true);

        NetworkCalls.soapPostRequest(
            this,
            Constants.SOAP_ACTION_RETRIEVE_MULTIPLE,
            Utils.getRequestBodyforFetchXML(Utils.getEscapedContactSearchTermFetch(mLastQuery)),
            new Callback<Object>() {
                @Override
                public void success(Object entities, retrofit.client.Response response) {
                    mMainList.setAdapter(new MainItemAdapter(
                                            getApplicationContext(),
                                            entities,
                                            "")
                    );

                    mSwipeRefresh.setRefreshing(false);
                }

                @Override
                public void failure(RetrofitError error) {
                    error.printStackTrace();
                    mSwipeRefresh.setRefreshing(false);
                }
            }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                mLastQuery = null;
                getRecentActivity();
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                mLastQuery = query;
                runSearchQuery();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

        searchView.setIconifiedByDefault(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.logout:
                RecentHistorydbHandler dbHandler = new RecentHistorydbHandler(this);

                SharedPreferences.Editor editPrefs = mAppPreferences.edit();
                editPrefs.remove(Constants.ENDPOINT);
                editPrefs.remove(Constants.REFRESH_TOKEN);
                editPrefs.remove(Constants.USERNAME);
                editPrefs.remove(Constants.AUTHORITY);

                populateAuthContext();
                CookieSyncManager.createInstance(MainActivity.this);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.removeAllCookie();
                CookieSyncManager.getInstance().sync();
                mAuthContext.getCache().removeAll();
                dbHandler.clearRecentRecords();

                editPrefs.apply();

                Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
                startActivityForResult(iSetup, SETUP_ID);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}