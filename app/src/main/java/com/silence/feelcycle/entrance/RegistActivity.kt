package com.silence.feelcycle.entrance

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.baidu.mapapi.SDKInitializer
import com.silence.feelcycle.R

class RegistActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        val bt_regist=findViewById<Button>(R.id.bt_phone_regist)
        val intent=Intent();
        intent.setClass(this,CodeGetActivity::class.java)
        bt_regist.setOnClickListener { v ->startActivity(intent)  }
        // Example of a call to a native method
//        sample_text.text = stringFromJNI()
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
