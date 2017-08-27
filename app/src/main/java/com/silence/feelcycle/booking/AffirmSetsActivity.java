package com.silence.feelcycle.booking;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silence.feelcycle.R;

/**
 * Created by SILENCE on 2017/08/24.
 */

public class AffirmSetsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affirm_sets);
        findViewById(R.id.bt_confirm_number).setOnClickListener(
                v->startActivity(new Intent(AffirmSetsActivity.this,OrderAffirmActivity.class)));
    }
}
