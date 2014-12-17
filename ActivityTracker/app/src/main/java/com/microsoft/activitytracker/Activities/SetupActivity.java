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
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.microsoft.activitytracker.Core.NetworkCalls;
import com.microsoft.activitytracker.R;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationResult;

import org.apache.http.message.BasicHttpResponse;

public class SetupActivity extends Activity implements View.OnClickListener,
        AuthenticationCallback<AuthenticationResult>
{
    private static final String TAG = "ActivityLogger.SetupActivity";
    private AuthenticationContext mAuthContext;
    private SharedPreferences mAppPrefs;
    private String mEndpoint;
    private String mUsername;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        mAppPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        findViewById(R.id.login_button).setOnClickListener(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(R.style.DialogProgressTheme);

        setEndpoint();
    }

    /**
     * set the text that populates the edittext. If the user already has an endpoint
     * saved then use that, otherwise we are going to use the default sample endpoint
     */
    private void setEndpoint() {
        String endpoint = mAppPrefs.getString(Constants.ENDPOINT, "");

        if (endpoint.equals("")) {
            endpoint = Constants.DEFAULT_ENDPOINT;
        }

        ((EditText)findViewById(R.id.endpoint_text)).setText(endpoint);
    }

    @Override
    public void onClick(View v)
    {
        mEndpoint = ((TextView)findViewById(R.id.endpoint_text)).getText().toString();
        mUsername = ((TextView)findViewById(R.id.username_text)).getText().toString();

        Object response = NetworkCalls.getAuthority(mEndpoint);
        if (response != null) {
            String authHeader = ((BasicHttpResponse) response).getHeaders("WWW-Authenticate")[0].toString();
            mAppPrefs.edit().putString(
                    Constants.AUTHORITY,
                    authHeader.substring(authHeader.indexOf("https://"))).apply();

            login();
        }
        else {
            Toast.makeText(this, "Unable to challenge service", Toast.LENGTH_SHORT).show();
        }
    }

    private void login() {
        String authority = mAppPrefs.getString(Constants.AUTHORITY,"");
        if (!authority.equals("")) {
            try {

                mAuthContext = new AuthenticationContext(SetupActivity.this, authority, false);
                mProgressDialog.show();

                // use the endpoint that the user entered in and use the username,
                // as the hint that is automatically populated into the azure library's webview
                mAuthContext.acquireToken(
                        SetupActivity.this,
                        mEndpoint,
                        Constants.CLIENT_ID,
                        Constants.REDIRECT_URI,
                        mUsername,
                        this
                );
            } catch (Exception ex) {
                ex.getCause().printStackTrace();
            }
        }
        else {
            Toast.makeText(this, getString(R.string.authority_error), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (mAuthContext != null) {
            if (resultCode != 2001) {
                mAuthContext.onActivityResult(requestCode, resultCode, data);
            }
            else {
                mProgressDialog.hide();
                CookieSyncManager.createInstance(SetupActivity.this);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.removeAllCookie();
                CookieSyncManager.getInstance().sync();
                mAuthContext.getCache().removeAll();
                Toast.makeText(this, getString(R.string.login_error), Toast.LENGTH_LONG).show();
            }
        }
    }

    /**
     * if the login is successful, save the current token into the property created for the application,
     * store the username and endpoint into application shared storage, and return to the main activity
     * @param result returns <T> the result of the authentication
     */
    @Override
    public void onSuccess(AuthenticationResult result)
    {
        ActivityTracker.setCurrentSessionToken(getApplicationContext(), result.getAccessToken());

        mAppPrefs.edit().putString(Constants.REFRESH_TOKEN, result.getRefreshToken()).apply();
        mAppPrefs.edit().putString(Constants.ENDPOINT, mEndpoint).apply();
        mAppPrefs.edit().putString(Constants.USERNAME, mUsername).apply();

        finish();
    }

    /**
     * (currently just crash the app so we can see the full stacktrace in the logcat)
     * @param ex the exception that was thrown during login
     */
    @Override
    public void onError(Exception ex)
    {
        Log.d(TAG, ex.getCause().getStackTrace().toString());
//        ex.getCause().printStackTrace();
    }

    @Override
    public void onBackPressed()
    {
        // since we require them to be logged in for everything,
        // user can't leave this page unless they successfully log in.
    }
}
