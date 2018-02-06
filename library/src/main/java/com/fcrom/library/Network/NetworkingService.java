package com.fcrom.library.Network;

import com.fcrom.library.Constant.API_urls;
import com.fcrom.library.Model.CustomerPickUp.CustomerPickup;
import com.fcrom.library.Model.LoginBody;
import com.fcrom.library.Model.LoginResponse;
import com.fcrom.library.Model.Trip.Trips;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by anamika.chavan on 10-11-2017.
 */

public interface NetworkingService {

    @POST(API_urls.API_POST_LOGIN)
    Call<LoginResponse> LoginService_in(@Header("Content-Type") String content_type, @Body LoginBody userbody);

    @GET(API_urls.API_GET_CUST_PICKUP_API)
//Status="ReadyforPickUp"/"PickedUp"
    Call<CustomerPickup> getCustPickup(@Query("nodeId") String shipNode);

    @GET(API_urls.API_GET_TRIPS)
    Call<Trips> getTrips();

}
