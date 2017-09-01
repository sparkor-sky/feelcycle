package com.silence.feelcycle.entrance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.baidu.mapapi.SDKInitializer;
import com.silence.feelcycle.R;
import com.silence.feelcycle.main.MainActivity;

public class RegistActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button bt_next;//下一步的按钮
    EditText phone;
    EditText psw;
    ImageView phone_clear;
    ImageView psw_clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();
    }
    private void init(){

        //Toolbar
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //清空手机号和密码
        phone_clear = (ImageView)findViewById(R.id.phone_clear);
        phone_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.setText("");
            }
        });
        psw_clear = (ImageView)findViewById(R.id.psw_clear);
        psw_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                psw.setText("");
            }
        });
        //用户手机号
        phone = (EditText)findViewById(R.id.user_phone_edit_text);
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){//得到焦点
                    phone_clear.setVisibility(View.VISIBLE);
                }
                else{//失去焦点
                    phone_clear.setVisibility(View.INVISIBLE);
                }
            }
        });
        //用户密码
        psw = (EditText)findViewById(R.id.user_psw);
        psw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b){//得到焦点
                    psw_clear.setVisibility(View.VISIBLE);
                }
                else {
                    psw_clear.setVisibility(View.INVISIBLE);
                }
            }
        });
        //下一步按钮
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistActivity.this, PhoneRegistActivity.class);
                startActivity(intent);
            }
        });
        bt_next.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN){
                v.setBackgroundResource(R.drawable.button_onclick_login);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                v.setBackgroundResource(R.drawable.button_login);
            }
            return false;
        });
    }

}
