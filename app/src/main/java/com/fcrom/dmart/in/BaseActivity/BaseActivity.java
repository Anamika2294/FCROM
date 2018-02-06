package com.fcrom.dmart.in.BaseActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.fcrom.dmart.in.R;
import com.fcrom.dmart.in.Utils.Logger;
import com.fcrom.dmart.in.Activity.EnterPin;
import com.fcrom.library.Content.WebServiceClass;


public class BaseActivity extends AppCompatActivity {
    public WebServiceClass getWebServiceClass= new WebServiceClass();
    private static final String LOG_TAG = "BaseActivity";
    private boolean mHandlerFlag = true;
    private Handler handler = new Handler();
    private Dialog progressDialog;
    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void showProgressDialog() {



//        if ((progressDialog == null || !progressDialog.isShowing())
//                && (getActivity() != null && !getActivity().isFinishing())) {
            Logger.log("Show"," Progress Dialog");
            progressDialog = new CustomDialog(this);
            progressDialog.show();
     //  }
    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {

        this.activity = activity;
    }

    public void hideProgressDialog() {
        try {
            mHandlerFlag = false;
            if ((this.progressDialog != null) && this.progressDialog.isShowing()) {
                this.progressDialog.dismiss();
            }
        } catch (final IllegalArgumentException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }

    public void failresponsecheck_in(retrofit2.Response response) {

        if (response != null) {
            Logger.log("AEL", "--------ERROR CODE ----EXCEPTION----------"+response.code());
            if (response.code() == 500) {
                Toast.makeText(this, "Server Error . Please Retry.", Toast.LENGTH_SHORT).show();
            } else if (response.code() == 401) {
                Toast.makeText(this, " Pleaes Enter Login / PIN.", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, EnterPin.class);

                //  i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Server Error :- " + response, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No Network ", Toast.LENGTH_SHORT).show();
        }
    }
}
