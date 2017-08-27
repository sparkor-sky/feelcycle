package com.silence.feelcycle.booking


import android.app.Fragment
import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.silence.feelcycle.R
import com.silence.feelcycle.main.MainActivity

/**
 * Created by SILENCE on 2017/08/24.
 */

class BookingListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val booking_view= inflater!!.inflate(R.layout.activity_booking_list, null)
        val intent= Intent(activity, FitnessActivity::class.java)
        booking_view.findViewById<Button>(R.id.first).setOnClickListener{v->startActivity(intent)}
        return booking_view
    }

}
