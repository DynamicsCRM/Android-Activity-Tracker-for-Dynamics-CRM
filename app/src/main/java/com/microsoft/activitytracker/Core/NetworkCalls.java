package com.microsoft.activitytracker.Core;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;

/**
 * Created by Jeremy Shore on 8/1/14.
 */
public class NetworkCalls
{
    public static void getAuthority(String endpoint, Callback<Response> callback) {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .build();

        IServices services = restAdapter.create(IServices.class);
        services.getAuthority(callback);
    }
}
