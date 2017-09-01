package com.silence.feelcycle.entrance;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import com.silence.feelcycle.R;

import java.util.Timer;
import java.util.TimerTask;

public class PhoneRegistActivity extends AppCompatActivity {
    Button bt_submit;
    Button bt_resent;
    Toolbar toolbar;
    private CountDownTimer downTimer;//用来控制重新发送验证码的时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_regist);
        init();

    }
    private void init(){
        //Toolbar
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //重新发送验证码按钮
        bt_resent = (Button)findViewById(R.id.bt_resent);
        bt_resent.setEnabled(false);//开始时设置不可点击
        bt_resent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downTimer.start();
            }
        });
        bt_resent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    bt_resent.setBackgroundResource(R.drawable.button_onclick_login);
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    bt_resent.setBackgroundResource(R.drawable.button_login);
                }
                return false;
            }
        });
        //注册按钮
        bt_submit = (Button) findViewById(R.id.bt_submit_regist);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PhoneRegistActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        bt_submit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    bt_submit.setBackgroundResource(R.drawable.button_onclick_login);
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    bt_submit.setBackgroundResource(R.drawable.button_login);
                }
                return false;
            }
        });
        //显示倒计时
        downTimer = new CountDownTimer(60*1000,1000) {
            @Override
            public void onTick(long l) {
                bt_resent.setEnabled(false);//开始时设置不可点击
                bt_resent.setText((l / 1000)+"秒");
            }

            @Override
            public void onFinish() {
                bt_resent.setEnabled(true);
                bt_resent.setText("重新发送");
            }
        };
        downTimer.start();
    }
}
