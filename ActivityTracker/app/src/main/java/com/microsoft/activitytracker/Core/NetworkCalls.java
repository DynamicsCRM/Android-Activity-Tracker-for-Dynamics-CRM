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

package com.microsoft.activitytracker.Core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.microsoft.activitytracker.Classes.ActivityTracker;
import com.microsoft.activitytracker.Classes.Constants;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.Map;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.QueryMap;
import retrofit.mime.TypedString;

public class NetworkCalls
{
    private interface CrmService
    {
        @Headers({"Content-Type: text/xml; charset=utf-8"})
        @POST("/XRMServices/2011/Organization.svc/web/")
        void makeSoapPost(@Header("SOAPAction") String soapAction, @Body TypedString body, Callback<Object> callback);

        @Headers({"Accept: application/json"})
        @GET("/XRMServices/2011/OrganizationData.svc/{id}")
        void makeoDataGet(@Path("id") String path, @QueryMap Map<String, String> queries, Callback<LinkedTreeMap<String, Object>> callback);

        @Headers({"Content-Type: application/json", "Accept: application/json"})
        @POST("/XRMServices/2011/OrganizationData.svc/{id}")
        void makeoDataPost(@Path("id") String path, @Body TypedString body, Callback<LinkedTreeMap<String, Object>> callback);
    }

    private static class getAuthorityTask extends AsyncTask<Void, Void, HttpResponse>
    {
        String mEndpoint;

        public getAuthorityTask(String endpoint) {
            mEndpoint = endpoint;
        }

        @Override
        protected HttpResponse doInBackground(Void... params)
        {
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(mEndpoint + "/XRMServices/2011/OrganizationData.svc/web?SdkClientVersion=6.1.0.533");
                httpGet.setHeader("Accept", "application/x-www-form-urlencoded");
                httpGet.setHeader("Authorization", "Brearer");

                return httpClient.execute(httpGet);
            }

            catch(Exception ex) {
                ex.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(HttpResponse response)
        {
        }
    }

    public static Object getAuthority(String endpoint) {
        try {
            AsyncTask authTask = new getAuthorityTask(endpoint).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            return authTask.get();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /***
     * this is used to make a post to the SOAP endpoint and parses out the SOAP Xml that is returned.
     * @param thisContext the context that you are making this call from
     * @param soapAction the action you want this call to fire (which is passed in the header of the request)
     * @param body the body of the network call you want to send to the SOAP endpoint (make sure you use the soap wrapper and encode the content xml)
     * @param callback callback to invoke when the network call has finished
     */
    public static void soapPostRequest(Context thisContext, String soapAction, String body, Callback<Object> callback)
    {
        SharedPreferences appPrefs = PreferenceManager.getDefaultSharedPreferences(thisContext);

        RestAdapter restAdapter = buildSoapRestAdapter(soapAction, appPrefs);

        if (restAdapter != null)
        {
            CrmService crmService = restAdapter.create(CrmService.class);
            crmService.makeSoapPost(soapAction, new TypedString(body), callback);
        }
    }

    /***
     * Based on the soap action build the restadapter. Since both have differently structured xml responses we need
     * choose which parser to use.
     * @param soapAction pass the soap action so we can determine which parser to use with the xml that is returned
     * @param appPrefs app prefs so we can pull the endpoint for the restadapter
     * @return returns the restadapter that we are going to use for this SOAP request
     */
    private static RestAdapter buildSoapRestAdapter(String soapAction, SharedPreferences appPrefs)
    {
        if (soapAction.equals(Constants.SOAP_ACTION_RETRIEVE_MULTIPLE))
        {
            return new RestAdapter.Builder()
//                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(appPrefs.getString(Constants.ENDPOINT, ""))
                    .setConverter(new SoapRetrieveMultipleParser())
                    .setRequestInterceptor(ActivityTracker.getRequestInterceptor())
                    .build();
        }
        else if (soapAction.equals(Constants.SOAP_ACTION_EXECUTE))
        {
            return new RestAdapter.Builder()
//                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(appPrefs.getString(Constants.ENDPOINT, ""))
                    .setConverter(new SoapExecuteParser())
                    .setRequestInterceptor(ActivityTracker.getRequestInterceptor())
                    .build();
        }
        else
        {
            return null;
        }
    }

    /***
     * Use this method when you want to make a get call to the oData endpoint NOTE: if you are trying to hit the get endpoint, unlike usual
     * this endpoint does restrict you to ONLY get calls
     * @param thisContext the context that you are making this call from
     * @param path the path to add to your current endpoint
     * @param queries map of the parameters to use in the query string
     * @param callback the callback that will be invoked when the network call is finished
     */
    public static void oDataGetRequest(Context thisContext, String path, Map<String, String> queries, Callback<LinkedTreeMap<String, Object>> callback)
    {
        SharedPreferences appPrefs = PreferenceManager.getDefaultSharedPreferences(thisContext);

        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new Gson()))
                .setEndpoint(appPrefs.getString(Constants.ENDPOINT, ""))
                .setRequestInterceptor(ActivityTracker.getRequestInterceptor())
                .build();

        CrmService crmService = restAdapter.create(CrmService.class);
        crmService.makeoDataGet(path, queries, callback);
    }

    /***
     * Use this method when you want to post to the odata endpoint (Means you have a body to your request)
     * @param thisContext the context that you are making this call from
     * @param body the body of the network call you want to send to the oData endpoint
     * @param path the path to add to your current endpoint
     * @param callback the callback that will be invoked when the network call is finished
     */
    public static void oDataPostRequest(Context thisContext, String body, String path, Callback<LinkedTreeMap<String, Object>> callback)
    {
        SharedPreferences appPrefs = PreferenceManager.getDefaultSharedPreferences(thisContext);

        RestAdapter restAdapter = new RestAdapter.Builder()
//                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new Gson()))
                .setEndpoint(appPrefs.getString(Constants.ENDPOINT, ""))
                .setRequestInterceptor(ActivityTracker.getRequestInterceptor())
                .build();

        CrmService crmService = restAdapter.create(CrmService.class);
        crmService.makeoDataPost(path, new TypedString(body), callback);
    }
}
