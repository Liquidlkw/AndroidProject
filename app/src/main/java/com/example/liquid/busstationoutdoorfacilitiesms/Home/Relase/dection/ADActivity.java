package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.Item.LightItem;
import com.example.liquid.busstationoutdoorfacilitiesms.MyItemTouchCallback;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.adapter.ItemAdapter;
import com.example.liquid.busstationoutdoorfacilitiesms.db.AdDB;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ADActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<LightItem> stationlist = new ArrayList();
    private RecyclerView adRV;
    private TextView trash;
    private ItemAdapter lightitemAdapter;
    List<AdDB> TestDBList;
    private ImageButton mAdReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestDBList = DataSupport.findAll(AdDB.class);
        setContentView(R.layout.activity_ad);
        initView();
        Toast.makeText(this, "长按拖拽，滑动删除", Toast.LENGTH_SHORT).show();
        initadlist();
        adRV = findViewById(R.id.rv_light);
        adRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        lightitemAdapter = new ItemAdapter(stationlist);
        adRV.setAdapter(lightitemAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(new MyItemTouchCallback(lightitemAdapter, this));
        helper.attachToRecyclerView(adRV);
        trash = findViewById(R.id.trashall);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initadlist() {
        stationlist = new ArrayList<>();
//
//        for (int i = 0; i <6 ; i++) {
//            adlist.add(new LightItem("s001","茶汤桥","正常"));
//            adlist.add(new LightItem("s002","茶汤桥","异常"));
//            adlist.add(new LightItem("s003","茶汤桥","正常"));
//            adlist.add(new LightItem("s004","湖州街沈半路口","正常"));
//        }
        for (AdDB testDB : TestDBList) {
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
                new AlertDialog.Builder(ADActivity.this);
        normalDialog.setTitle("清空");
        normalDialog.setMessage("确定清空当前列表吗？");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                        adRV.removeAllViews();
                        stationlist.clear();
                        lightitemAdapter.notifyDataSetChanged();
                        Toast.makeText(ADActivity.this, "清空！", Toast.LENGTH_SHORT).show();
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
        mAdReturn = (ImageButton) findViewById(R.id.ad_return);
        mAdReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ad_return:
                finish();
                break;
        }
    }
}
