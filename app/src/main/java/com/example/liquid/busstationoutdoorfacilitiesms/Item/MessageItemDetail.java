package com.example.liquid.busstationoutdoorfacilitiesms.Item;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.MainActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.db.MessageDB;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MessageItemDetail extends AppCompatActivity implements View.OnClickListener {

    /**
     * 确认
     */
    private Button mDetailFinish;
    private int id;//数据库的第几条
    private TextView mIdEquipment;
    private TextView mUseTime;
    private TextView mStation;
    private TextView mSpinnerStatus;
    private TextView mRemarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_item_detail);
        Intent intent = getIntent();
        id = intent.getIntExtra("itemid", 0);
        Toast.makeText(this, "detail" + id, Toast.LENGTH_SHORT).show();
        initView();
    }

    private void initView() {
        mDetailFinish = (Button) findViewById(R.id.detail_finish);
        mDetailFinish.setOnClickListener(this);

        mIdEquipment = (TextView) findViewById(R.id.id_equipment_detail);
        mUseTime = (TextView) findViewById(R.id.use_time);
        mStation = (TextView) findViewById(R.id.station);
        mSpinnerStatus = (TextView) findViewById(R.id.spinner_status_detail);
        mRemarks = (TextView) findViewById(R.id.remarks);
        initDB();
    }

    private void initDB() {
        List<MessageDB> messageDBList = DataSupport.findAll(MessageDB.class);
//        MainActivity. MessageList.get(id).getEquipmentId();
        MessageDB item = messageDBList.get(id);
        Toast.makeText(this, "DB" + id, Toast.LENGTH_SHORT).show();

        mIdEquipment.setText(item.getEquipmentId()+"");
//        Toast.makeText(this, ""+item.getEquipmentId(), Toast.LENGTH_SHORT).show();
        mUseTime.setText(item.getUsetime()+"");
        mStation.setText(item.getStation());
        mSpinnerStatus.setText(item.getState());
        mRemarks.setText(item.getMark());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.detail_finish:
                finish();
                break;
        }
    }
}
