package com.fcrom.dmart.in.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.fcrom.dmart.in.Activity.Trip.TripsActivity;
import com.fcrom.dmart.in.R;

public class Dashboard extends AppCompatActivity {
    LinearLayout layout_trips,layout_crates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        layout_trips = (LinearLayout) findViewById(R.id.layout_trip);
        layout_crates = (LinearLayout) findViewById(R.id.layout_crates);

        layout_trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this, TripsActivity.class);
                startActivity(i);
            }
        });

    }
}
