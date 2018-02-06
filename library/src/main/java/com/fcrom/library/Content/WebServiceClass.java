package com.fcrom.library.Content;

import android.app.Activity;

import com.fcrom.library.Constant.API_urls;
import com.fcrom.library.Model.CustomerPickUp.CustomerPickup;
import com.fcrom.library.Model.LoginBody;
import com.fcrom.library.Model.LoginResponse;
import com.fcrom.library.Model.Trip.Trips;
import com.fcrom.library.Network.NetworkingService;
import com.fcrom.library.Utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//import som.dmart.in.library.Constant.API_urls;
//import som.dmart.in.library.Model.CashSummery.CashSummary;
//import som.dmart.in.library.Model.CustomerPickUp.CustomerPickup;
//import som.dmart.in.library.Model.Login.LoginBody;
//import som.dmart.in.library.Model.Login.LoginResponse;
//import som.dmart.in.library.Model.OTP.Otp;
//import som.dmart.in.library.Model.OTP.OtpResponse;
//import som.dmart.in.library.Model.PhReturns.CustPhReturnOrder.PhReturnServerResponse;
//import som.dmart.in.library.Model.PhReturns.PhReturnMain;
//import som.dmart.in.library.Model.Putaway.PutAway;
//import som.dmart.in.library.Model.Reports.Reports;
//import som.dmart.in.library.Model.RetunOrder.ReturnShipment;
//import som.dmart.in.library.Model.Search.Search;
//import som.dmart.in.library.Network.NetworkingService;
//import som.dmart.in.library.Utils.Logger;

/**
 * Created by anamika.chavan on 10-11-2017.
 */

public class WebServiceClass extends NetworkingAbstract {

    String TAG = "ContentClass";
    String HEADER_TAG = "Headers";

    public NetworkingService ns = adapter.create(NetworkingService.class);
    public NetworkingService ns_custome = adapter_custome.create(NetworkingService.class);

    public void getAccessToken(final Activity activity, LoginBody loginBody, boolean cleartokenflag, final Callback<LoginResponse> accessTokenCallback) {

        Call<LoginResponse> call=ns_custome.LoginService_in("application/json", loginBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {
                    headerToken(response);
                    accessTokenCallback.onResponse(call, response);
                    Logger.log(TAG, "------------------ Sucess Receive Search - " + response.body());
                }
                else
                {

                        headerToken(response);
                        accessTokenCallback.onResponse(call,response);
                        Logger.log(TAG, "------------------ FAIL Receive Search - " + response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                accessTokenCallback.onFailure(call,t);
            }
        });


        if (cleartokenflag) {
            API_urls.headerNodeID = "";
            API_urls.headerTokenn = "";
        }

        Logger.log(TAG, "---@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@---" + loginBody.toString());

        ns_custome.LoginService_in("application/json", loginBody);
    }

    public void getTrips(final Callback<Trips> trips){
        Call<Trips> call=ns_custome.getTrips();
        call.enqueue(new Callback<Trips>() {
            @Override
            public void onResponse(Call<Trips> call, Response<Trips> response) {
                if(response.isSuccessful()) {
                    headerToken(response);
                    trips.onResponse(call, response);
                    Logger.log(TAG, "------------------ Sucess Receive Search - " + response.body());
                }
                else
                {

                    headerToken(response);
                    trips.onResponse(call,response);
                    Logger.log(TAG, "------------------ FAIL Receive Search - " + response.body());
                }
            }

            @Override
            public void onFailure(Call<Trips> call, Throwable t) {
                trips.onFailure(call,t);
            }
        });

        ns_custome.getTrips();


    }


    public void getCustPickupList(final Callback<CustomerPickup> CustomerPickup, String shipNode, String status) {
        Call<CustomerPickup> call=ns_custome.getCustPickup(shipNode);
        call.enqueue(new Callback<CustomerPickup>() {
            @Override
            public void onResponse(Call<CustomerPickup> call, Response<CustomerPickup> response) {
                if(response.isSuccessful()){
                    headerToken(response);
                    CustomerPickup.onResponse(call,response);
                    Logger.log(TAG, "------------------ Sucess Crate Search - " + response.body());
                }
                else {
                    headerToken(response);
                    CustomerPickup.onResponse(call,response);
                    Logger.log(TAG, "------------------ FAIL Crate Search - " + response.body());

                }

            }

            @Override
            public void onFailure(Call<CustomerPickup> call, Throwable t) {
                CustomerPickup.onFailure(call,t);
            }
        });

        ns_custome.getCustPickup(shipNode);
    }








    //--------------Headers -----------------------//

    public void headerToken(Response response) {
        Logger.log(HEADER_TAG, "=================================");
        Logger.log("Anamika=======","Response"+response.body());
        if (response.headers() != null) {
            if(response.headers().get("X-OAPI-Auth-Header")!=null){
                API_urls.headerTokenn  =response.headers().get("X-OAPI-Auth-Header");
                Logger.log("HeaderUrl--------","--"+ API_urls.headerTokenn);
            }
            if(response.headers().get("X-OAPI-Node-Id")!=null){
                API_urls.headerNodeID = response.headers().get("X-OAPI-Node-Id");
                Logger.log("HeaderNode--------","--"+ API_urls.headerNodeID);
            }


//            for (Header header : headerList) {
//                // Logger.log(HEADER_TAG, header.getName() + " ******** " + header.getValue());
//                if (header.getName() != null) {
//                    if (header.getName().toString().equals("X-OAPI-Auth-Header")) {//X-OAPI-Auth-Header
//                        API_urls.headerTokenn = header.getValue();
//                    }
//                    if (header.getName().toString().equals("X-OAPI-Node-Id")) {
//                        API_urls.headerNodeID = header.getValue();
//                    }
//                }
//            }

        }
    }





}
