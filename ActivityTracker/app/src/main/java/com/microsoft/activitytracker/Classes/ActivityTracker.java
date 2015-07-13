package com.microsoft.activitytracker.Classes;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import retrofit.RequestInterceptor;

public class ActivityTracker extends Application
{
    private static String currentSessionToken;
    private static RequestInterceptor requestInterceptor;

    public static RequestInterceptor getRequestInterceptor()
    {
        return requestInterceptor;
    }

    public static void setCurrentSessionToken(Context thisContext, String sessionToken)
    {
        SharedPreferences mAppPreferences = PreferenceManager.getDefaultSharedPreferences(thisContext);
        mAppPreferences.edit().putString(Constants.TOKEN, sessionToken).apply();

        currentSessionToken = sessionToken;

        requestInterceptor = new RequestInterceptor()
        {
            @Override
            public void intercept(RequestFacade request)
            {
                request.addHeader("Authorization", "Bearer " + currentSessionToken);
            }
        };
    }
}