package com.fcrom.dmart.in.Activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fcrom.dmart.in.BaseActivity.FCROMApplication;
import com.fcrom.dmart.in.Permission.RuntimePermissionsActivity;
import com.fcrom.dmart.in.R;
import com.fcrom.library.Model.LoginBody;
import com.fcrom.library.Model.LoginResponse;
import com.fcrom.library.Utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends RuntimePermissionsActivity {
    LoginBody loginBody = new LoginBody();
    private static final int REQUEST_PERMISSIONS = 20;
    Boolean flag_Check_Permission = false;
    Button btn_submit;
    EditText et_username, et_pwd, et_pin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username = (EditText) findViewById(R.id.et_username);
        et_pwd = (EditText) findViewById(R.id.et_pwd);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        checkforPermission();
        FCROMApplication.getInstance();
        init();
    }

    private void init(){
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag_Check_Permission) {
                    if ((et_username.getText().toString().length() >= 8 && et_pwd.getText().toString().length() >= 8) &&
                            (et_username.getText().toString().length() <= 20 && et_pwd.getText().toString().length() <= 20)) {
                        loginBody.setUserId(et_username.getText().toString());
                        loginBody.setPassword(et_pwd.getText().toString());
                        showProgressDialog();
                        getLogin(loginBody, true);
                        Intent i=new Intent(Login.this,EnterPin.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(Login.this, "Please Enter User Name & Password between 8-20 characters.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, "Please Provide Permission...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void checkforPermission() {

        Login.super.requestAppPermissions(new
                        String[]{Manifest.permission.CALL_PHONE,
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CALL_LOG}, R.string
                        .runtime_permissions_txt
                , REQUEST_PERMISSIONS);
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        flag_Check_Permission = true;

    }

    public void getLogin(LoginBody loginBody, boolean cleartokenflag) {


        getWebServiceClass.getAccessToken(this,loginBody,cleartokenflag, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()) {
//                    hideProgressDialog();
                  Logger.log("TAG", "LOGIN SUCESS*********" + response.body());
//
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

                }
                else
                {
                    hideProgressDialog();
                    failresponsecheck_internal(response);
                }


                //init();

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                hideProgressDialog();
                Logger.log("TAG", "LOGIN FAIL *********" + t.getMessage());

                //failresponsecheck_internal(t.getMessage());

            }
        } );
    }



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
