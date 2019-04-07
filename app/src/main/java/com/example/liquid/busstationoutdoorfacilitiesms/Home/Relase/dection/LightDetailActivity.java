package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.add.AddEquipmentActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.db.AdDB;
import com.example.liquid.busstationoutdoorfacilitiesms.db.LightTestDB;
import com.example.liquid.busstationoutdoorfacilitiesms.db.StationDB;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LightDetailActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView id, time;
    private TextView bus;
    private TextView remarks;
    private TextView status;
    /**
     * 确认
     */
    private Button mButton9;
    /**
     * 灯具详情
     */
    private TextView mTextView30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_detail);
        initView();
        Intent intent = getIntent();
        String equipid = intent.getStringExtra("id");
        Toast.makeText(this, "" + equipid, Toast.LENGTH_SHORT).show();
        List<AdDB> AdDB = DataSupport.where("testid=?", equipid).find(AdDB.class);
        List<StationDB> StationDB = DataSupport.where("testid=?", equipid).find(StationDB.class);
        List<LightTestDB> lightTestDB = DataSupport.where("testid=?", equipid).find(LightTestDB.class);

        if (equipid.indexOf("L") != -1) {
            initlightdata(lightTestDB);
            mTextView30.setText("灯具监测");
        }
        if (equipid.indexOf("S") != -1) {
            initstationdata(StationDB);
            mTextView30.setText("站台监测");
        }
        if (equipid.indexOf("A") != -1) {
            initadata(AdDB);
            mTextView30.setText("广告监测");
        }
    }

    private void initadata(List<AdDB> adDB) {
        id.setText(adDB.get(0).getTestid());
        time.setText(adDB.get(0).getTime() + "");
        bus.setText(adDB.get(0).getStation());
        remarks.setText(adDB.get(0).getRemark());
        status.setText(adDB.get(0).getState());
    }

    private void initstationdata(List<StationDB> stationDB) {
        id.setText(stationDB.get(0).getTestid());
        time.setText(stationDB.get(0).getTime() + "");
        bus.setText(stationDB.get(0).getStation());
        remarks.setText(stationDB.get(0).getRemark());
        status.setText(stationDB.get(0).getState());
    }

    private void initlightdata(List<LightTestDB> lightTestDB) {
        id.setText(lightTestDB.get(0).getTestid());
        time.setText(lightTestDB.get(0).getTime() + "");
        bus.setText(lightTestDB.get(0).getStation());
        remarks.setText(lightTestDB.get(0).getRemark());
        status.setText(lightTestDB.get(0).getState());
    }

    private void initView() {
        mButton9 = (Button) findViewById(R.id.button9);
        mButton9.setOnClickListener(this);

        id = findViewById(R.id.id_equipment1);
        id.setTextColor(Color.BLACK);
        id.setText(AddEquipmentActivity.id);

        time = findViewById(R.id.use_time_detail);
        time.setText(AddEquipmentActivity.time);
        time.setTextColor(Color.BLACK);

        bus = findViewById(R.id.station_bus_detail);
        bus.setText(AddEquipmentActivity.bus);
        bus.setTextColor(Color.BLACK);


        remarks = findViewById(R.id.remarks_detail);
        remarks.setText(AddEquipmentActivity.remark);
        remarks.setTextColor(Color.BLACK);

        status = findViewById(R.id.status_equipment_detail);
        status.setText(AddEquipmentActivity.statustring);
        status.setTextColor(Color.BLACK);

        mTextView30 = (TextView) findViewById(R.id.textView30);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button9:
                finish();
                break;
        }
    }
}
