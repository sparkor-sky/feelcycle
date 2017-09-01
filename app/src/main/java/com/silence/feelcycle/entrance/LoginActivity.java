package com.silence.feelcycle.entrance;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.silence.feelcycle.R;
import com.silence.feelcycle.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText phone;//用户手机号
    private EditText psw;//用户密码
    private Button forget_pas;//忘记密码
    private Button login;
    private ImageView phone_clear;
    private ImageView pwd_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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


        //忘记密码按钮
        forget_pas = (Button)findViewById(R.id.bt_forget_psw);
        forget_pas.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        //清空手机号和密码
        phone_clear = (ImageView)findViewById(R.id.phone_clear);
        phone_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone.setText("");
            }
        });
        pwd_clear = (ImageView)findViewById(R.id.pwd_clear);
        pwd_clear.setOnClickListener(new View.OnClickListener() {
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
                    pwd_clear.setVisibility(View.VISIBLE);
                }
                else {
                    pwd_clear.setVisibility(View.INVISIBLE);
                }
            }
        });

        //登录按钮
        login = (Button) findViewById(R.id.bt_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        login.setOnTouchListener((v, event) -> {
            if(event.getAction()== MotionEvent.ACTION_DOWN){
                v.setBackgroundResource(R.drawable.button_onclick_login);
            }else if(event.getAction()==MotionEvent.ACTION_UP){
                v.setBackgroundResource(R.drawable.button_login);
            }
            return false;
        });

    }
}
