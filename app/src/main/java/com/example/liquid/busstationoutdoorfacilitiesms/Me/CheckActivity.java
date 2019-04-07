package com.example.liquid.busstationoutdoorfacilitiesms.Me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItem;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.adapter.MessageItemAdapter;
import com.example.liquid.busstationoutdoorfacilitiesms.fragment.MessageFragment;

import java.util.ArrayList;

public class CheckActivity extends AppCompatActivity {

    /**
     * xxx任务：
     */
    private TextView mCheckmission;
    /*
    ongoingArrayList
     */
    private ArrayList<MessageItem> ongoinglist;

    /*
  ungoingArrayList
   */
    private ArrayList<MessageItem> ungoinglist;

    /*
  finsihArrayList
   */
    private ArrayList<MessageItem> finishlist;
    /*
    allArrayList
     */
    private ArrayList<MessageItem> alllist = MessageFragment.MessageItemArrayList;
    private Intent intent;
    private RecyclerView recyclerView;
    private ImageView checkreturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        initView();
        recyclerView = findViewById(R.id.mission_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        intent = getIntent();

        if (intent.getStringExtra("title").equals("进行中任务：")) {
            mCheckmission.setText("进行中任务：");

            for (MessageItem item : alllist)
            {
                if(item.getRenwujindu().equals("进行中"))
                {
                    ongoinglist.add(item);
                }
            }

            MessageItemAdapter MessageItemAdapter = new MessageItemAdapter(ongoinglist);
            recyclerView.setAdapter(MessageItemAdapter);

        }



        if (intent.getStringExtra("title").equals("未接收任务：")) {
            mCheckmission.setText("未接收任务：");
            for (MessageItem item : alllist)
            {
                if(item.getRenwujindu().equals("未接收"))
                {
                    ungoinglist.add(item);
                }
            }
            MessageItemAdapter MessageItemAdapter = new MessageItemAdapter(ungoinglist);
            recyclerView.setAdapter(MessageItemAdapter);
        }

        if (intent.getStringExtra("title").equals("已完成任务：")) {
            mCheckmission.setText("已完成任务：");
            for (MessageItem item : alllist)
            {
                if(item.getRenwujindu().equals("已完成"))
                {
                    finishlist.add(item);
                }
            }
            MessageItemAdapter MessageItemAdapter = new MessageItemAdapter(finishlist);
            recyclerView.setAdapter(MessageItemAdapter);
        }
        /*
        适配器和数据的写入（使用从旧的ArrayList中找出对应新的Arraylist进行判断）
         */
        checkreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void setRecyclerView() {
    }

    private void initView() {
        checkreturn = findViewById(R.id.imageView11);
        mCheckmission = (TextView) findViewById(R.id.checkmission);
        ongoinglist = new ArrayList<>();
        ungoinglist = new ArrayList<>();
        finishlist = new ArrayList<>();
    }
}
