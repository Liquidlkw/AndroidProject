package com.example.liquid.busstationoutdoorfacilitiesms.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItem;
import com.example.liquid.busstationoutdoorfacilitiesms.db.MessageDB;
import com.example.liquid.busstationoutdoorfacilitiesms.R;
import com.example.liquid.busstationoutdoorfacilitiesms.adapter.MessageItemAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    public static ArrayList<MessageItem> MessageItemArrayList ;
    public  List<MessageDB> MessageDBlist;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)  {
        return inflater.inflate(R.layout.fragment_message,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MessageDBlist = DataSupport.findAll(MessageDB.class);
        MessageItemArrayList = new ArrayList<>();

        initMessageItem();
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        MessageItemAdapter MessageItemAdapter = new MessageItemAdapter(MessageItemArrayList);

        recyclerView.setAdapter(MessageItemAdapter);
    }


    private void initMessageItem() {
//        for (int i =0 ;i<1;i++) {
//            MessageItemArrayList
//                    .add(new MessageItem("清洗", "", "茶汤桥", "南向北",
//                            "已完成", R.mipmap.ongoing, R.mipmap.two));
//
//        }
        int i =1;
        for (MessageDB messageDB : MessageDBlist)
        {   if(messageDB.getProcess().equals("已完成")) {
            MessageItemArrayList.add(new MessageItem(i, messageDB.getMission(), messageDB.getBrand(),
                    messageDB.getStation(), messageDB.getDirection(), messageDB.getProcess(), R.mipmap.finish, R.mipmap.one));
        }
            if(messageDB.getProcess().equals("进行中")) {
                MessageItemArrayList.add(new MessageItem(i, messageDB.getMission(), messageDB.getBrand(),
                        messageDB.getStation(), messageDB.getDirection(), messageDB.getProcess(), R.mipmap.ongoing, R.mipmap.one));
            }
            if(messageDB.getProcess().equals("未接收")) {
                MessageItemArrayList.add(new MessageItem(i, messageDB.getMission(), messageDB.getBrand(),
                        messageDB.getStation(), messageDB.getDirection(), messageDB.getProcess(), R.mipmap.unreceived, R.mipmap.one));
            }
            i++;
        }

    }







}
