package com.silence.feelcycle.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.silence.feelcycle.R;

/**
 * Created by SILENCE on 2017/08/24.
 */

public class FitnessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        findViewById(R.id.bt_booking_coach).setOnClickListener(
                v -> startActivity(new Intent(FitnessActivity.this,CoachBookingActivity.class)));
        findViewById(R.id.bt_booking_nocoach).setOnClickListener(
                v -> startActivity(new Intent(FitnessActivity.this,NoCoachBookingActivity.class)));
    }
}
