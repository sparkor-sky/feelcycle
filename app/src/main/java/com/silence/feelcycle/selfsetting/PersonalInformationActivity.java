package com.silence.feelcycle.selfsetting;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.silence.feelcycle.R;
import com.silence.feelcycle.utils.JsonBean;
import com.silence.feelcycle.utils.JsonFileReader;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PersonalInformationActivity extends AppCompatActivity {
    //性别的spinner
    private Spinner sex_spinner;
    private List<String> sex_data_list;
    private ArrayAdapter<String> sex_arr_adapter;

    //HomeAsUp按钮
    ActionBar actionBar;
    //显示生日的TextView
    TextView brithText;
    //显示城市的TextView
    private TextView mTvAddress;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        init();//初始化的方法
    }

    private void init() {
        //HomeAsUp 按钮
        actionBar = getSupportActionBar();
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
        sex_arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data_list);

        sex_arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sex_data_list);

        //设置样式
        sex_arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        sex_spinner.setAdapter(sex_arr_adapter);


        //生日文本和监听器
        brithText = (TextView) findViewById(R.id.birthday_text);
        brithText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog();
            }
        });
        //城市文本
        mTvAddress = (TextView) findViewById(R.id.city_text);
        mTvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerView();
            }
        });

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        //  获取json数据
        String JsonData = JsonFileReader.getJson(this, "province_data.json");
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }

    }
    //显示选择城市的对话框
    private void showPickerView() {
        OptionsPickerView pvOptions=new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是两个级别的选中位置
                String text = options1Items.get(options1).getPickerViewText() +"-"+
                        options2Items.get(options1).get(options2);
                mTvAddress.setText(text);
            }
        }).setTitleText("")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(15)
                .setOutSideCancelable(false)
                .build();
        /*pvOptions.setPicker(options1Items);//一级选择器
          pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
          */
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        pvOptions.show();
    }


    //显示选择生日的对话框
    private void showDataDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(PersonalInformationActivity.this, AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                // TODO Auto-generated method stub
                int mYear = year;
                int mMonth = month;
                int mDay = day;
                //更新EditText控件日期 小于10加0
                brithText.setText(new StringBuilder()
                        .append(mYear)
                        .append("-")
                        .append((mMonth + 1) < 10 ? 0 + (mMonth + 1) : (mMonth + 1))
                        .append("-")
                        .append((mDay < 10) ? 0 + mDay : mDay));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //设置时间范围 截止到目前
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        datePickerDialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.personal_information_actionbar_list, menu);
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
    //Gson 的解析
    public ArrayList<JsonBean> parseData(String result) {
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

}
