package com.silence.feelcycle.selfsetting;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silence.feelcycle.R;
import com.silence.feelcycle.charge.RechargeActivity;

public class MyWalletActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.bt_recharge).setOnClickListener(v->startActivity(new Intent(MyWalletActivity.this,RechargeActivity.class)));
    }
}
