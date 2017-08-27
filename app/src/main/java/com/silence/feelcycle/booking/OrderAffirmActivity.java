package com.silence.feelcycle.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silence.feelcycle.R;
import com.silence.feelcycle.main.MainActivity;

/**
 * Created by SILENCE on 2017/08/24.
 */

public class OrderAffirmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_affirm);
        findViewById(R.id.bt_submitorder).setOnClickListener(
                v->submit());
    }
    public void submit(){
        startActivity(new Intent(OrderAffirmActivity.this,MainActivity.class));
        finish();
    }
}

