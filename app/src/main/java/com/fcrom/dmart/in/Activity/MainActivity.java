package com.fcrom.dmart.in.Activity;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fcrom.dmart.in.BaseActivity.FCROMApplication;
import com.fcrom.dmart.in.R;
import com.fcrom.library.Model.CustomerPickUp.PickUpShipment;
import com.fcrom.library.Model.LoginBody;
import com.fcrom.library.Utils.Logger;

import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Dialog progressDialog;
    List<PickUpShipment> pickuplist;
    LoginBody loginBody = new LoginBody();
    private static Application instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginBody.setUserId("pupexAABQ");
        loginBody.setPassword("pupexAABQ");
        //getLogin(loginBody, false);
        getContext();
        FCROMApplication.getInstance();

    }

      //uat SERVER
    public static Context getContext() {
        return instance.getApplicationContext();
    }

 //   public void getLogin(LoginBody loginBody, boolean cleartokenflag) {
//        getDataClass.getAccessToken(loginBody, cleartokenflag, new Callback<LoginResponse>() {
//            @Override
//            public void success(LoginResponse loginResponse, Response response) {
//                hideProgressDialog();
//                Logger.log(TAG, "LOGIN SUCESS*********" + loginResponse.toString());
//
//                storeloginValues(loginResponse);
//                if (SharedPreferenceUtil.getpin().length() == 0) {
//                    SharedPreferenceUtil.saveUserName(et_username.getText().toString());
//                    SharedPreferenceUtil.savepwd(et_pwd.getText().toString());
//                    linear_pin.setVisibility(View.VISIBLE);
//                    linear_usernamepwd.setVisibility(View.GONE);
//                    tv_username.setText("" + SharedPreferenceUtil.getUserName());
//                    tv_lableuser.setText("Set PIN for  ");
//                    et_pin.setText("");
//                    btn_submit.setText("SET PIN");
//                } else {
//
//                    Intent i = new Intent(Login.this, DashBoard.class);
//                    startActivity(i);
//                }
//                //init();
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                hideProgressDialog();
//                Logger.log(TAG, "LOGIN FAIL *********" + error.toString());
//
//                failresponsecheck_internal(error.getResponse());
//
//
//            }
//        });

//        getWebServiceClass.getAccessToken(this,loginBody,cleartokenflag, new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//
//                if(response.isSuccessful()) {
//                   // hideProgressDialog();
//                   Logger.log("TAG", "LOGIN SUCESS*********" + response.body());

//                    storeloginValues(response.body());
//                    if (SharedPreferenceUtil.getpin().length() == 0) {
//                        SharedPreferenceUtil.saveUserName(et_username.getText().toString());
//                        SharedPreferenceUtil.savepwd(et_pwd.getText().toString());
//                        linear_pin.setVisibility(View.VISIBLE);
//                        linear_usernamepwd.setVisibility(View.GONE);
//                        tv_username.setText("" + SharedPreferenceUtil.getUserName());
//                        tv_lableuser.setText("Set PIN for  ");
//                        et_pin.setText("");
//                        btn_submit.setText("SET PIN");
//                    } else {
//
//                        //Intent i = new Intent(Login.this, DashBoard.class);
//                        startActivity(i);
//                    }

//                }
//                else
//                {
//                   // hideProgressDialog();
//                    failresponsecheck_internal(response);
//                }
//
//
//                //init();
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                //hideProgressDialog();
//                Logger.log("LOGIN", "LOGIN FAIL *********" + t.getMessage());
//
//                //failresponsecheck_internal(t.getMessage());
//
//            }
//        } );
//    }
    public void failresponsecheck_internal(Response response) {
        Logger.log("--Response======",""+response.errorBody());
        if (response != null) {
            if (response.code() == 500) {
                Toast.makeText(this, "Server Error . Please Retry.", Toast.LENGTH_SHORT).show();
            } else if (response.code() == 401) {
                Toast.makeText(this, "Invalid Login ... ", Toast.LENGTH_SHORT).show();
                /*Toast.makeText(this, " Pleaes Enter Login / PIN.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, EnterPIN.class);
                //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();*/
            } else {
                Toast.makeText(this, "Server Error :- " + response, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No Network ", Toast.LENGTH_SHORT).show();
        }
    }
}
