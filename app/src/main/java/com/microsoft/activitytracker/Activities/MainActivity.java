package com.microsoft.activitytracker.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.microsoft.activitytracker.Adapters.HistoryAdapter;
import com.microsoft.activitytracker.Classes.DatabaseContracts.*;
import com.microsoft.activitytracker.Adapters.SearchResultsAdapter;
import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Classes.Utils;
import com.microsoft.activitytracker.R;

import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;

import com.microsoft.xrm.sdk.Callback;
import com.microsoft.xrm.sdk.Client.OrganizationServiceProxy;
import com.microsoft.xrm.sdk.Entity;
import com.microsoft.xrm.sdk.EntityCollection;
import com.microsoft.xrm.sdk.Query.FetchExpression;
import com.nispok.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AuthenticationCallback<AuthenticationResult>,
        LoaderManager.LoaderCallbacks<Cursor>, MenuItemCompat.OnActionExpandListener, SearchView.OnQueryTextListener,
        SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {
    private static final int SETUP_ID = 0;

    private static final String[] MAIL_COLUMNS = {
            HistoryEntry._ID,
            HistoryEntry.COLUMN_ACCOUNT_NAME,
            HistoryEntry.COLUMN_DATE_LAST_OPEN,
            HistoryEntry.COLUMN_FULL_NAME,
            HistoryEntry.COLUMN_JOB_TITLE,
            HistoryEntry.COLUMN_LOGICAL_NAME
    };

    public static final int COL_ID_INDEX = 0;
    public static final int COL_NAME_INDEX = 1;
    public static final int COL_DATE_INDEX = 2;
    public static final int COL_FULL_NAME_INDEX = 3;
    public static final int COL_JOB_TITLE_INDEX = 4;
    public static final int COL_LOGICAL_NAME_INDEX = 5;

    private OrganizationServiceProxy mOrgService;
    private SharedPreferences mAppPreferences;
    private HistoryAdapter mHistoryAdapter;
    private ListView mMainList;
    private SwipeRefreshLayout mSwipeRefresh;
    private AuthenticationContext mAuthContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        // Sets up the progress bar and the pull to refresh gesture
        mSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.pullRefresh);
        mSwipeRefresh.setOnRefreshListener(this);

        mMainList = (ListView) findViewById(R.id.itemsList);
        mHistoryAdapter = new HistoryAdapter(this, HistoryEntry.getRecentHistory(this), 0);
        mMainList.setAdapter(mHistoryAdapter);
        mMainList.setOnItemClickListener(this);

        mAppPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mSwipeRefresh.setRefreshing(true);
        Authentication();
    }

    @Override
    public void onRefresh() {
        getRecentActivity();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Object thisItem = mMainList.getAdapter().getItem(position);
        if (thisItem.getClass() != String.class) {
            // Completely bundle up the selected entity and pass it as an extra
            // to the next activity
            Intent iItem = new Intent(MainActivity.this, ItemActivity.class);
            iItem.putExtra(Constants.CURRENT_ENTITY, ((Entity)thisItem).toEntityReference().toBundle());
            startActivity(iItem);
        }
    }

    /***
     *  runs authentication to get a token. If a refresh token is stored in the application storage it will
     *  try to refresh the old token, or it will navigate to the signin activity for you to log in using the
     *  Azure Active Directory Library's (aadl) custom webview.
     */
    private void Authentication() {
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
                            this);
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

    private void populateAuthContext() {
        try {
            mAuthContext = new AuthenticationContext(
                    MainActivity.this,
                    mAppPreferences.getString(Constants.AUTHORITY, ""),
                    false);
        }
        catch (Exception ex) {
            ex.getCause().printStackTrace();
        }
    }

    @Override
    public void onSuccess(AuthenticationResult result) {
        ActivityTracker.setCurrentSessionToken(this, result.getAccessToken());
        mOrgService = new OrganizationServiceProxy(mAppPreferences.getString(Constants.ENDPOINT, ""),
                ActivityTracker.getCurrentSessionToken());

        getRecentActivity();
    }

    @Override
    public void onError(Exception exc) {
        Toast.makeText(this, "Unable to log back in", Toast.LENGTH_SHORT).show();
        Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
        startActivityForResult(iSetup, SETUP_ID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SETUP_ID:
                mOrgService = new OrganizationServiceProxy(mAppPreferences.getString(Constants.ENDPOINT, ""),
                    ActivityTracker.getCurrentSessionToken());

                getRecentActivity();
                break;
            default:
                if (mAuthContext != null) {
                    mAuthContext.onActivityResult(requestCode, resultCode, data);
                }
                break;
        }
    }

    private void getRecentActivity() {
        mMainList.setAdapter(mHistoryAdapter);
        mSwipeRefresh.setRefreshing(false);
    }

    private void runSearchQuery(@Nullable String query) {
        if (query != null) {
            mSwipeRefresh.setRefreshing(true);

            FetchExpression fetchExpression = new FetchExpression(
                    Utils.getEscapedContactSearchTermFetch(query));
            mOrgService.RetrieveMultiple(fetchExpression, new Callback<EntityCollection>() {
                @Override
                public void success(EntityCollection entityCollection) {
                    mMainList.setAdapter(new SearchResultsAdapter(getApplicationContext(), entityCollection));
                    mSwipeRefresh.setRefreshing(false);
                }

                @Override
                public void failure(Throwable error) {
                    displayError(error.getMessage());
                }
            });
        }
    }

    private void displayError(String error) {
        Snackbar.with(this)
                .text(error)
                .textColor(this.getResources().getColor(R.color.white))
                .duration(Snackbar.SnackbarDuration.LENGTH_LONG)
                .show(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        MenuItemCompat.setOnActionExpandListener(searchItem, this);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.logout:
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
                HistoryEntry.clearRecentRecords(this);

                editPrefs.apply();

                Intent iSetup = new Intent(MainActivity.this, SetupActivity.class);
                startActivityForResult(iSetup, SETUP_ID);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        getRecentActivity();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        runSearchQuery(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mHistoryAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mHistoryAdapter.swapCursor(null);
    }
}