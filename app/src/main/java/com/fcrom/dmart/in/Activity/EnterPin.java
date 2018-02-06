package com.fcrom.dmart.in.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fcrom.dmart.in.BaseActivity.BaseActivity;
import com.fcrom.dmart.in.R;
import com.fcrom.library.Model.LoginBody;

public class EnterPin extends BaseActivity {
    Button btn_submit;
    TextView tv_username, tv_changepin;
    EditText et_pin;
    LoginBody loginBody = new LoginBody();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_pin);

        btn_submit = (Button) findViewById(R.id.btn_submit);
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_changepin = (TextView) findViewById(R.id.tv_changepin);
        et_pin = (EditText) findViewById(R.id.et_pin);

        init();
    }

    private void init(){
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(EnterPin.this,Dashboard.class);
                startActivity(i);

            }
        });
    }
}
