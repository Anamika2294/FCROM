package com.fcrom.dmart.in.Activity.Trip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.fcrom.dmart.in.Adapter.TripsAdapter;
import com.fcrom.dmart.in.BaseActivity.BaseActivity;
import com.fcrom.dmart.in.Constant.Constant;
import com.fcrom.dmart.in.R;
import com.fcrom.dmart.in.Utils.Logger;
import com.fcrom.library.Model.Trip.TripList;
import com.fcrom.library.Model.Trip.Trips;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripsActivity extends BaseActivity {

    RecyclerView listView;
    private TripsAdapter adapter;
    EditText et_BTEInput;
    String TAG = "TripActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        listView = (RecyclerView) findViewById(R.id.listview);
        et_BTEInput = (EditText) findViewById(R.id.et_BTEInput);

        getTripsData();
        scannerinput();
    }

    private void scannerinput() {
        et_BTEInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    if (et_BTEInput.getText().toString() != null) {

                        checkValidCrateID(et_BTEInput.getText().toString());
                        et_BTEInput.setText("");
                        Logger.log(TAG, "---------------------AFTER CHECK ValidCrate--------");
                        //et_BTEInput.requestFocus();
                        //requestFocus(et_BTEInput);
                    }
                    return true;
                }
                return false;
            }
        });

    }

    public void checkValidCrateID(String id){
        for(int i=0;i<Constant.tripList.size();i++){
            int count=0;
            for(int j=0;j<Constant.tripList.get(i).getCrateList().size();j++){
                if(id.equals(Constant.tripList.get(i).getCrateList().get(j).getCrateId()) && (!Constant.tripList.get(i).getCrateList().get(j).getIsscanned())){
                    //flag_isscan=true;
                    Constant.tripList.get(i).getCrateList().get(j).setIsscanned(true);
                    //tv_cratecount.setText(""+getScannedCrateCount()+"/"+Constant.tripList.get(position).getCrateList().size());
                    Logger.log(TAG,"-------Crate Scanned-----");
                    setAdapter(Constant.tripList);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void getTripsData() {
        showProgressDialog();
        getWebServiceClass.getTrips(new Callback<Trips>() {
            @Override
            public void onResponse(Call<Trips> trips, Response<Trips> response) {

                if(response.isSuccessful()) {
                    hideProgressDialog();
                    Logger.log("TAG", "LOGIN SUCESS*********" + response.body());


                    Constant.tripList=response.body().getTripList();
                    setAdapter(Constant.tripList);


                    Toast.makeText(TripsActivity.this,"TripId"+response.body().getTripList().get(0).getTripId(), Toast.LENGTH_SHORT).show();


                }
                else
                {
                    hideProgressDialog();
                    failresponsecheck_in(response);
                }


                //init();

            }



            @Override
            public void onFailure(Call<Trips> call, Throwable t) {
                hideProgressDialog();
                Logger.log("TAG", "LOGIN FAIL *********" + t.getMessage());

                //failresponsecheck_internal(t.getMessage());

            }
        } );
    }

    public void setAdapter(List<TripList> dataList){

        adapter = new TripsAdapter(this, dataList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(linearLayoutManager);
        listView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));

        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adapter.notifyDataSetChanged();
    }


}
