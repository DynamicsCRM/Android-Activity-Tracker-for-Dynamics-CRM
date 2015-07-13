package com.microsoft.activitytracker.Core;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by JeremyShore on 3/12/15.
 */
interface IServices {

    @Headers({
        "Accept: application/x-www-form-urlencoded",
        "Authorization: Bearer"
    })
    @GET("/XRMServices/2011/OrganizationData.svc/web?SdkClientVersion=6.1.0.533")
    void getAuthority(Callback<Response> callback);

}
