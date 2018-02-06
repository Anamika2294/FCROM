package com.fcrom.dmart.in.Activity.Trip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fcrom.dmart.in.Adapter.ReceiveCrateAdapter;
import com.fcrom.dmart.in.Constant.Constant;
import com.fcrom.dmart.in.R;
import com.fcrom.dmart.in.Utils.Logger;
import com.fcrom.library.Model.Trip.CrateList;
import com.fcrom.library.Model.Trip.TripList;

import java.util.ArrayList;
import java.util.List;

public class TripReceiveListActivity extends AppCompatActivity {
    TextView tv_cratecount, tv_vehicleno, tv_ordercount, tv_tripno, tv_totalscancount;
    ImageView iv_call;
    TripList tripdata;
    RecyclerView gridview;
    RecyclerView listview;
    ArrayList<String> listtimeslot = new ArrayList<>();
    private ReceiveCrateAdapter adapter;
    Button btn_scan;
    EditText et_BTEInput;
    Boolean isServicecalled = false;
    List<CrateList> listlines = new ArrayList<>();
    boolean flag_isServiceCalled = true;
    int position;
    boolean flag_isscan=false;
    int count;

    String TAG = "TripReceiveListActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_receive_list);
        tv_cratecount = (TextView) findViewById(R.id.tv_cratecount);
        tv_vehicleno = (TextView) findViewById(R.id.tv_vehicleno);

        tv_tripno = (TextView) findViewById(R.id.tv_tripno);
        tv_totalscancount = (TextView) findViewById(R.id.tv_totalscancount);
        listview = (RecyclerView) findViewById(R.id.listview);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        et_BTEInput = (EditText) findViewById(R.id.et_BTEInput);
        iv_call = (ImageView) findViewById(R.id.iv_call);
        getIntentData();
        scannerinput();
    }

    public void getIntentData(){
        Intent intent = getIntent();
       // Bundle bundle = intent.getExtras();
        //tripdata = (TripList) bundle.getSerializable("value");
        position=intent.getExtras().getInt("position");
        Logger.log(TAG ,"--pos----"+position);
        Logger.log("TAG","---siz---"+Constant.tripList.size());
       // Logger.log("TripData", "-------------------------------" + tripdata.toString());

                Logger.log(TAG,"- LIST---"+Constant.tripList.get(position).getCrateList());
                setAdapterwithData(Constant.tripList.get(position).getCrateList());

        init();

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
                    flag_isscan=true;
                    Constant.tripList.get(i).getCrateList().get(j).setIsscanned(true);
                    tv_cratecount.setText(""+getScannedCrateCount()+"/"+Constant.tripList.get(position).getCrateList().size());
                    Logger.log(TAG,"-------Crate Scanned-----");
                    setAdapterwithData(Constant.tripList.get(position).getCrateList());
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void init(){
        tv_tripno.setText(Constant.tripList.get(position).getTripId());
        tv_vehicleno.setText(Constant.tripList.get(position).getVehicleNumber());
        tv_cratecount.setText(""+getScannedCrateCount()+"/"+Constant.tripList.get(position).getCrateList().size());

    }

    public int getScannedCrateCount(){

        int count=0;
        for(int i=0;i<Constant.tripList.get(position).getCrateList().size();i++){
            if(Constant.tripList.get(position).getCrateList().get(i).getIsscanned()){
                count++;
            }
        }
        return  count;
    }


    @Override
    public void onBackPressed() {
        //  super.onBackPressed();
                Intent intent = getIntent();
                setResult(1111, intent);
                finish();

    }


    private void setAdapterwithData(List<CrateList> crateList) {
        //listview.setAdapter(new ReceiveOrderAdapter(this, receiveOrder));
        adapter = new ReceiveCrateAdapter(this, crateList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        listview.setLayoutManager(linearLayoutManager);
        listview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));

        listview.setItemAnimator(new DefaultItemAnimator());
        listview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
