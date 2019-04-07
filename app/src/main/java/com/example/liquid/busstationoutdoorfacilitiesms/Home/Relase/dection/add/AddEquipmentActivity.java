package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.LightActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.LightDetailActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Item.LightItem;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

public class AddEquipmentActivity extends AppCompatActivity  {

    private ImageView add_return;
    private Intent intent;
    private EditText id_equipment,user_time,remarks;
    public static String id,time,bus,remark,statustring;
    private Spinner bus_station;
    private String []array_equipment_status;
    private String []array_bus_station;
    private Spinner status;
    private Button add_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipment);
        intent = new Intent(AddEquipmentActivity.this,FinishActivity.class);
        //EditText需要添加监听器监听文字变化
        id_equipment = findViewById(R.id.id_equipment);
        id_equipment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                id = id_equipment.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                id = id_equipment.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                id = id_equipment.getText().toString();
            }
        });

        user_time = findViewById(R.id.use_time);
        user_time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                time = user_time.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                time = user_time.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                time = user_time.getText().toString();
            }
        });

        array_bus_station=getResources().getStringArray(R.array.bus_station);
        bus_station = findViewById(R.id.station);
        bus_station.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    bus = array_bus_station[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        array_equipment_status=getResources().getStringArray(R.array.equipment_status);
        status = findViewById(R.id.spinner_status);
        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                statustring = array_equipment_status[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        EditText remaks = findViewById(R.id.remarks);
        remaks.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                remark = user_time.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                remark = user_time.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
                remark = user_time.getText().toString();
            }
        });



        add_return = findViewById(R.id.add_return);
        add_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        add_finish = findViewById(R.id.add_finish);
        add_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LightActivity.stationlist.add(new LightItem(id,bus,statustring));
                Toast.makeText(AddEquipmentActivity.this, ""+id+bus+statustring, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
