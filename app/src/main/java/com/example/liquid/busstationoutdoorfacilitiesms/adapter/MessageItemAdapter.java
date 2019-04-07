package com.example.liquid.busstationoutdoorfacilitiesms.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItem;
import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItemDetail;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

import java.util.ArrayList;

public class MessageItemAdapter extends RecyclerView.Adapter<MessageItemAdapter.VH> {
    private ArrayList<MessageItem> mitemlist;
    private int id;

    /*
    创建内部类VH extends RecyclerView.ViewHolder（视图容器）
    承载的是条目中的控件
     */
     class VH extends RecyclerView.ViewHolder {
        private final TextView zhandian;
        private final ImageView image;
        private final TextView fangxiang;
        private final TextView renwujindu;
        private final ImageView renwujindu_pic;
        private final TextView pingpai;
        private final TextView mission1;

        public VH(@NonNull final View itemView) {
            super(itemView);
            mission1 = itemView.findViewById(R.id.mission1);
            pingpai = itemView.findViewById(R.id.pingpai);
            zhandian = itemView.findViewById(R.id.zhantai);
            image = itemView.findViewById(R.id.image);
            fangxiang = itemView.findViewById(R.id.fangxiang);
            renwujindu = itemView.findViewById(R.id.renwujindu);
            renwujindu_pic = itemView.findViewById(R.id.renwujindu_pic);

        }
    }

    /*
    创建构造函数
    构造函数参数是list的集合，他是rv直接的数据来源
    在做Adapter实例化的时候必须传入list的集合数据
     */

    public MessageItemAdapter(ArrayList<MessageItem> mitemlist) {
        this.mitemlist = mitemlist;
    }

    /*
    创建ViewHolder对象
     */
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_test,viewGroup,false);

        return new VH(view) ;
    }
    /*
    给ViewHolder中的控件设置数据
    监听器也写在这里
    i 代表 列表中的位置 从 0 开始
     */
    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {

        MessageItem MessageItem = mitemlist.get(i);

        //获取它实际的id id是数据库链接的唯一标识 ,id对应数据的实际位置
        // 通过在列表中的位置i获得到数据在数据库中的位置id
       final int id = MessageItem.getId();

        Log.i("id", "onBindViewHolder: "+i);

        vh.renwujindu.setText(MessageItem.getRenwujindu());
        vh.renwujindu_pic.setImageResource(MessageItem.getRenwujingdu_pic());
        vh.zhandian.setText(MessageItem.getZhandian());
        vh.fangxiang.setText(MessageItem.getFangxiang());
        vh.image.setImageResource(MessageItem.getImage());
        vh.mission1.setText(MessageItem.getRenwu());
        vh.pingpai.setText(MessageItem.getPingpai());

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vh.itemView.getContext(), MessageItemDetail.class);
                intent.putExtra("itemid",id-1);//关键在这里

                vh.itemView.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return mitemlist!=null?mitemlist.size():0;
    }
}
