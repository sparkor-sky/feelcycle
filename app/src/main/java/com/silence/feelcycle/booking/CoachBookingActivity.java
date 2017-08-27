package com.silence.feelcycle.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silence.feelcycle.R;

/**
 * Created by SILENCE on 2017/08/24.
 */

public class CoachBookingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coachbooking);
        findViewById(R.id.coach_first).setOnClickListener(
                v -> startActivity(new Intent(CoachBookingActivity.this,AffirmSetsActivity.class)));
    }
}
