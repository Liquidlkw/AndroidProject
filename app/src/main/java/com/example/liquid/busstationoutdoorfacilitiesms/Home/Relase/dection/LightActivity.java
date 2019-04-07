package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.add.AddEquipmentActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Item.LightItem;
import com.example.liquid.busstationoutdoorfacilitiesms.MyItemTouchCallback;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.adapter.ItemAdapter;
import com.example.liquid.busstationoutdoorfacilitiesms.db.LightTestDB;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class LightActivity extends AppCompatActivity implements View.OnClickListener {
    public static ArrayList<LightItem> stationlist;
    private RecyclerView stationRV;
    private TextView trash;
    private ItemAdapter lightitemAdapter;

    List<LightTestDB> TestDBList;
    private ImageButton mLightReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestDBList = DataSupport.findAll(LightTestDB.class);

        setContentView(R.layout.activity_light);
        initView();
        Toast.makeText(this, "长按拖拽，滑动删除", Toast.LENGTH_SHORT).show();
        initstationlist();
        stationRV = findViewById(R.id.rv_light);
        stationRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lightitemAdapter = new ItemAdapter(stationlist);
        stationRV.setAdapter(lightitemAdapter);

        ItemTouchHelper helper = new ItemTouchHelper(new MyItemTouchCallback(lightitemAdapter, this));
        helper.attachToRecyclerView(stationRV);
        /*
        滑动清除
         */
        trash = findViewById(R.id.trashall);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });

        /*
        添加设备
         */
        LinearLayout add = findViewById(R.id.lightadd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LightActivity.this, AddEquipmentActivity.class));

            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lightitemAdapter.notifyDataSetChanged();//在ListView发生变化之后，调用通知列表进行改变。

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lightitemAdapter.notifyDataSetChanged();
    }

    private void initstationlist() {
        stationlist = new ArrayList<>();
        for (LightTestDB testDB : TestDBList) {
            stationlist.add(new LightItem(testDB.getTestid(), testDB.getStation(), testDB.getState()));
        }
    }

    private void showNormalDialog() {
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(LightActivity.this);
        normalDialog.setTitle("清空");
        normalDialog.setMessage("确定清空当前列表吗？");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        stationRV.removeAllViews();
                        stationlist.clear();
                        lightitemAdapter.notifyDataSetChanged();
                        Toast.makeText(LightActivity.this, "清空！", Toast.LENGTH_SHORT).show();
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();
    }

    private void initView() {
        mLightReturn = (ImageButton) findViewById(R.id.light_return);
        mLightReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.light_return:
                finish();
                break;
        }
    }
}
