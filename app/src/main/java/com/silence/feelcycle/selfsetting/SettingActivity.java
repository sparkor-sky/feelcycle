package com.silence.feelcycle.selfsetting;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silence.feelcycle.R;

public class SettingActivity extends AppCompatActivity {

    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //HomeAsUp
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.self_info).setOnClickListener(v->startActivity(new Intent(SettingActivity.this,PersonalInformationActivity.class)));
        findViewById(R.id.account_manage).setOnClickListener(v->startActivity(new Intent(SettingActivity.this,AccountManagementActivity.class)));
    }
}
