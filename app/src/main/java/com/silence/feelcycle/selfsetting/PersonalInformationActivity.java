package com.silence.feelcycle.selfsetting;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.silence.feelcycle.R;

import java.util.ArrayList;
import java.util.List;

public class PersonalInformationActivity extends AppCompatActivity {
    //性别的spinner
    private Spinner sex_spinner;
    private List<String> sex_data_list;
    private ArrayAdapter<String> sex_arr_adapter;

    //HomeAsUp按钮
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        //HomeAsUp 按钮
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //性别spinner
        sex_spinner = (Spinner) findViewById(R.id.sex_spinner);
        //数据
        sex_data_list = new ArrayList<String>();
        sex_data_list.add("男");
        sex_data_list.add("女");
        sex_data_list.add("保密");
        //适配器
        sex_arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data_list);
        //设置样式
        sex_arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        sex_spinner.setAdapter(sex_arr_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_information_actionbar_list,menu);

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            //保存按钮的监听
            case R.id.action_save:
                Toast.makeText(getApplicationContext(),"已保存",Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
        return true;
    }
    //设置生日的效果
    public void setBirthday(View v){
        //弹出一个TimePicker pass
    }

}
