package com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.information;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItem;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.adapter.MessageItemAdapter;
import com.example.liquid.busstationoutdoorfacilitiesms.db.MessageDB;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.HomeFragment;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.MessageFragment;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MissionInforActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 方位信息
     */
    private TextView mMissionSpinnertext;
    private Spinner mMissionSpinner;
    private RecyclerView mMissionInfo;
    /**
     * xxXX中任务
     */
    private TextView mMissionAttribute;
    private ArrayList<MessageItem> allList = MessageFragment.MessageItemArrayList;

    private ImageButton mImageButtonReturn;
    private MessageItemAdapter messageItemAdapter;
    private TextView spinnertext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    private String[] ctype;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_infor);
        recyclerView = findViewById(R.id.mission_info);
        layoutManager = new LinearLayoutManager(this);
        initView();

        if (HomeFragment.flag.equals("方位已完成任务：")) {
            List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "已完成").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
            }

            mMissionAttribute.setText("方位已完成任务：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);

        }

        if (HomeFragment.flag.equals("方位进行中任务：")) {

            List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "进行中").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.two));
            }
            mMissionAttribute.setText("方位进行中任务：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);
        }


        if (HomeFragment.flag.equals("方位未接收任务：")) {
            mMissionAttribute.setText("方位未接收任务：");
            List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "未接收").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
            }
            mMissionAttribute.setText("方位未接收任务：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);
        }


        if (HomeFragment.flag.equals("品牌进行中任务：")) {
            ctype = new String[]{"哇哈哈", "农夫山泉"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
            mMissionSpinner = super.findViewById(R.id.mission_spinner);
            mMissionSpinner.setAdapter(adapter);

            mMissionAttribute.setText("品牌进行中任务：");
            List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "进行中").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.two));
            }
            mMissionAttribute.setText("品牌进行中任务：");
            spinnertext.setText("品牌信息：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);
        }


        if (HomeFragment.flag.equals("品牌未接收任务：")) {
            ctype = new String[]{"哇哈哈", "农夫山泉"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
            mMissionSpinner = super.findViewById(R.id.mission_spinner);
            mMissionSpinner.setAdapter(adapter);

            spinnertext.setText("品牌信息：");
            mMissionAttribute.setText("品牌未接收任务：");
            List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "未接收").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
            }
            mMissionAttribute.setText("品牌未接收任务：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);
        }

        if (HomeFragment.flag.equals("品牌已完成任务：")) {
            ctype = new String[]{"哇哈哈", "农夫山泉"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
            mMissionSpinner = super.findViewById(R.id.mission_spinner);
            mMissionSpinner.setAdapter(adapter);


            spinnertext.setText("品牌信息：");
            mMissionAttribute.setText("品牌已完成任务：");
            List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "已完成").find(MessageDB.class);
            ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

            for (MessageDB messageDB : ArrayList) {
                MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                        messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
            }
            mMissionAttribute.setText("品牌已完成任务：");
            recyclerView.setLayoutManager(layoutManager);
            messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
            recyclerView.setAdapter(messageItemAdapter);

        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        messageItemAdapter.notifyDataSetChanged();
    }

    private void initView() {

        spinnertext = findViewById(R.id.mission_spinnertext);

        mMissionSpinnertext = (TextView) findViewById(R.id.mission_spinnertext);

        mMissionSpinner = (Spinner) findViewById(R.id.mission_spinner);
        mMissionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("南向北")&&
                        HomeFragment.flag.equals("方位进行中任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "进行中").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("南向北")&&
                        HomeFragment.flag.equals("方位已完成任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "已完成").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("南向北")&&
                        HomeFragment.flag.equals("方位未接收任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "南向北", "未接收").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }



                if(parent.getItemAtPosition(position).toString().equals("北向南")&&
                        HomeFragment.flag.equals("方位未接收任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "北向南", "未接收").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("北向南")&&
                        HomeFragment.flag.equals("方位进行中任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "北向南", "进行中").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("北向南")&&
                        HomeFragment.flag.equals("方位已完成任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("direction=? and process=?", "北向南", "已完成").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("哇哈哈")&&
                        HomeFragment.flag.equals("品牌未接收任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "未接收").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("哇哈哈")&&
                        HomeFragment.flag.equals("品牌已完成任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "已完成").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("哇哈哈")&&
                        HomeFragment.flag.equals("品牌进行中任务："))
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "哇哈哈", "进行中").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.two));
                    }

                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }


                if(parent.getItemAtPosition(position).toString().equals("农夫山泉")&&
                        HomeFragment.flag.equals("品牌进行中任务：")
                )
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "农夫山泉", "进行中").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
                    }
                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("农夫山泉")&&
                        HomeFragment.flag.equals("品牌已完成任务：")
                )
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "农夫山泉", "已完成").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.two));
                    }
                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

                if(parent.getItemAtPosition(position).toString().equals("农夫山泉")&&
                        HomeFragment.flag.equals("品牌未接收任务：")
                )
                {
                    List<MessageDB> ArrayList = DataSupport.where("brand=? and process=?", "农夫山泉", "未接收").find(MessageDB.class);
                    ArrayList<MessageItem> MessageItemArrayList = new ArrayList<>();

                    for (MessageDB messageDB : ArrayList) {
                        MessageItemArrayList.add(new MessageItem(messageDB.getEquipmentId(),messageDB.getMission(), messageDB.getBrand(), messageDB.getStation(),
                                messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.two));
                    }
                    recyclerView.setLayoutManager(layoutManager);
                    messageItemAdapter = new MessageItemAdapter(MessageItemArrayList);
                    recyclerView.setAdapter(messageItemAdapter);
                    messageItemAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mMissionInfo = (RecyclerView) findViewById(R.id.mission_info);
        mMissionAttribute = (TextView) findViewById(R.id.mission_attribute);
        mImageButtonReturn = (ImageButton) findViewById(R.id.imageButton_return);
        mImageButtonReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imageButton_return:
                finish();
                break;
        }
    }
}
