package com.microsoft.activitytracker.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
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
import com.microsoft.xrm.sdk.Client.OrganizationServiceProxy;

import org.apache.http.message.BasicHttpResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

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
        ((EditText)findViewById(R.id.endpoint_text)).setText(mAppPrefs.getString(Constants.ENDPOINT, ""));
    }

    @Override
    public void onClick(View v)
    {
        mEndpoint = ((TextView)findViewById(R.id.endpoint_text)).getText().toString();
        mUsername = ((TextView)findViewById(R.id.username_text)).getText().toString();

        NetworkCalls.getAuthority(mEndpoint, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                // will never get hit
            }

            @Override
            public void failure(RetrofitError error) {
                boolean foundHeader = false;

                for (Header header : error.getResponse().getHeaders()) {
                    if (header.getName() != null && header.getName().equals("WWW-Authenticate")) {
                        foundHeader = true;
                        mAppPrefs.edit().putString(
                                Constants.AUTHORITY,
                                header.getValue().substring(header.getValue().indexOf("https://"))
                        ).apply();
                        login();
                        break;
                    }
                }

                if (!foundHeader) {
                    Toast.makeText(getApplicationContext(), "Unable to Challenge", Toast.LENGTH_LONG).show();
                }
            }
        });
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
        ActivityTracker.setCurrentSessionToken(this, result.getAccessToken());
        mAppPrefs.edit().putString(Constants.REFRESH_TOKEN, result.getRefreshToken()).apply();
        mAppPrefs.edit().putString(Constants.TOKEN, result.getAccessToken());
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
//        ex.getCause().printStackTrace();
    }

    @Override
    public void onBackPressed()
    {
        // since we require them to be logged in for everything,
        // user can't leave this page unless they successfully log in.
    }
}
