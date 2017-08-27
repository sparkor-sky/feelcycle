package com.silence.feelcycle.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silence.feelcycle.R;

/**
 * Created by SILENCE on 2017/08/24.
 */

public class NoCoachBookingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_none_coach_booking);
        findViewById(R.id.nocoach_first).setOnClickListener(
                v -> startActivity(new Intent(NoCoachBookingActivity.this,AffirmSetsActivity.class)));
    }
}
