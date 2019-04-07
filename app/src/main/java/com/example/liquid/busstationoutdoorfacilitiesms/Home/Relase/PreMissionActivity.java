package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItem;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.db.MessageDB;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.MessageFragment;

import java.util.Calendar;

public class PreMissionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner mSpinnerStation;
    private Spinner mSpinnerDirection;
    private Spinner mSpinnerBrand;
    private String[] ctype;
    private String station;
    private String direction;
    private String brand;
    /**
     * 发布任务
     */
    private Button mBtFinish;
    private Spinner mSpinnerStaff;
    private String staff;
    private ImageView mPreReturn;
    private EditText remark;
    private LinearLayout mTimeStart;
    private LinearLayout mTimeEnd;
    /**
     * -----------选择起始日期~-----------
     */
    private TextView mDateStart;
    /**
     * -----------选择终止日期~-----------
     */
    private TextView mDateEnd;
    private String end;
    private String start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premission);
        initView();


    }

    private void initView() {
        ctype = new String[]{"茶汤桥", "七古登", "湖州街上塘路口"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
        mSpinnerStation = super.findViewById(R.id.spinner_station);
        mSpinnerStation.setAdapter(adapter);
        mSpinnerStation.setOnItemSelectedListener(this);

        mSpinnerDirection = (Spinner) findViewById(R.id.spinner_direction);
        mSpinnerDirection.setOnItemSelectedListener(this);

        mSpinnerBrand = (Spinner) findViewById(R.id.spinner_brand);
        mSpinnerBrand.setOnItemSelectedListener(this);
        mBtFinish = (Button) findViewById(R.id.bt_finish);
        mBtFinish.setOnClickListener(this);
        mSpinnerStaff = (Spinner) findViewById(R.id.spinner_staff);
        mPreReturn = (ImageView) findViewById(R.id.pre_return);
        remark = findViewById(R.id.editText_remark);
        mPreReturn.setOnClickListener(this);
        mTimeStart = (LinearLayout) findViewById(R.id.time_start);
        mTimeStart.setOnClickListener(this);
        mTimeEnd = (LinearLayout) findViewById(R.id.time_end);
        mTimeEnd.setOnClickListener(this);
        mDateStart = (TextView) findViewById(R.id.date_start);
        mDateEnd = (TextView) findViewById(R.id.date_end);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /*
        parent 当前spinner
        view 选中的条目
        position 选中条目的下标
         */
        switch (parent.getId()) {
            case R.id.spinner_station:
                station = (String) mSpinnerStation.getSelectedItem();
                break;


            case R.id.spinner_direction:
                direction = (String) mSpinnerDirection.getSelectedItem();
                break;

            case R.id.spinner_brand:
                brand = (String) mSpinnerBrand.getSelectedItem();

                break;

            case R.id.spinner_staff:
                staff = (String) mSpinnerStaff.getSelectedItem();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_finish:
                MessageDB messageDB = new MessageDB("上刊", mSpinnerStation.getSelectedItem().toString(),
                        mSpinnerDirection.getSelectedItem().toString(), mSpinnerBrand.getSelectedItem().toString(), "未接收",
                        (MessageFragment.MessageItemArrayList.size() + 1), 0, start+"\n"+end+"\n"+remark.getText().toString(), "正常");

                messageDB.save();

                Toast.makeText(this, "" + (MessageFragment.MessageItemArrayList.size() + 1), Toast.LENGTH_SHORT).show();

                MessageFragment.MessageItemArrayList.add(new MessageItem(MessageFragment.MessageItemArrayList.size() + 1,
                        "上刊", brand, station, direction, "未接收", R.mipmap.unreceived, R.mipmap.one));

                Toast.makeText(this, "上刊任务发布完成！", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.pre_return:
                finish();
                break;
            case R.id.time_start:
                startTimePicker();
                break;
            case R.id.time_end:
                endTimePicker();
                break;
        }
    }

    private void endTimePicker() {

        Calendar calendar = Calendar.getInstance();
        final int[] Year = {calendar.get(Calendar.YEAR)};//获取当前年
        final int[] month = {calendar.get(Calendar.MONTH) + 1};//获取月份，加1是因为月份是从0开始计算的
        final int[] day = {calendar.get(Calendar.DATE)};//获取日
        final int hour = calendar.get(Calendar.HOUR);//获取小时
        final int minute = calendar.get(Calendar.MINUTE);//获取分钟
        final int seconds = calendar.get(Calendar.SECOND);//获取秒钟

        //实例化日期选择器悬浮窗
        //参数1：上下文对象
        //参数2：监听事件
        //参数3：初始化年份
        //参数4：初始化月份
        //参数5：初始化日期
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //实现监听方法
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //设置文本显示内容，i为年，i1为月，i2为日
                mDateEnd.setText("任务结束时间：" + i + "年" + (i1 + 1) + "月" + i2 + "日" + hour + ":" + minute + ":" + seconds);
                end = mDateEnd.getText().toString();
                //以下赋值给全局变量，是为了后面的时间选择器，选择时间的时候不会获取不到日期！
                Year[0] = i;
                month[0] = i1 + 1;
                day[0] = i2;
            }
        }, Year[0], month[0], day[0]).show();//记得使用show才能显示悬浮窗
        //实例化时间选择器
        //参数1：上下文对象
        //参数2：监听事件
        //参数3：初始化小时
        //参数4：初始化分钟
        //参数5：是否24小时制
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            //实现监听方法
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                //设置文本显示内容
//                mDateEnd.setText("当前时间："+ Year[0] +"年"+ month[0] +"月"+ day[0] +"日   "+i+":"+i1);
            }
        },hour,minute,true).show();//记得使用show才能显示！



    }

    private void startTimePicker() {
        Calendar calendar = Calendar.getInstance();
         final int[] Year = {calendar.get(Calendar.YEAR)};//获取当前年
        final int[] month = {calendar.get(Calendar.MONTH) + 1};//获取月份，加1是因为月份是从0开始计算的
         final int[] day = {calendar.get(Calendar.DATE)};//获取日
         final int hour = calendar.get(Calendar.HOUR);//获取小时
         final int minute = calendar.get(Calendar.MINUTE);//获取分钟
         final int seconds = calendar.get(Calendar.SECOND);//获取秒钟
        //设置标题栏显示当前事件


        //实例化日期选择器悬浮窗
        //参数1：上下文对象
        //参数2：监听事件
        //参数3：初始化年份
        //参数4：初始化月份
        //参数5：初始化日期
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            //实现监听方法
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                //设置文本显示内容，i为年，i1为月，i2为日
                mDateStart.setText("任务启动时间：" + i + "年" + (i1 + 1) + "月" + i2 + "日" + hour + ":" + minute + ":" + seconds);
                start = mDateStart.getText().toString();
                //以下赋值给全局变量，是为了后面的时间选择器，选择时间的时候不会获取不到日期！
                Year[0] = i;
                month[0] = i1 + 1;
                day[0] = i2;
            }
        }, Year[0], month[0], day[0]).show();//记得使用show才能显示悬浮窗
        //实例化时间选择器
        //参数1：上下文对象
        //参数2：监听事件
        //参数3：初始化小时
        //参数4：初始化分钟
        //参数5：是否24小时制
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            //实现监听方法
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                //设置文本显示内容
                mDateStart.setText("当前时间："+ Year[0] +"年"+ month[0] +"月"+ day[0] +"日   "+i+":"+i1);
            }
        },hour,minute,true).show();//记得使用show才能显示！




    }


}
