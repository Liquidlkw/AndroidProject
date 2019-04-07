package com.example.liquid.busstationoutdoorfacilitiesms.adapter;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liquid.busstationoutdoorfacilitiesms.Home.Relase.dection.LightDetailActivity;
import com.example.liquid.busstationoutdoorfacilitiesms.Item.LightItem;
import com.example.liquid.busstationoutdoorfacilitiesms.Item.MessageItemDetail;
import com.example.liquid.busstationoutdoorfacilitiesms.R;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.VH>{


    private ArrayList<LightItem> mitemlist;
    public ArrayList<LightItem> getMitemlist() {
        return mitemlist;
    }

    static class VH extends RecyclerView.ViewHolder {

        private final TextView zhandian;
        private final TextView zhuangtai;
        private final TextView bianhao;

        public VH(@NonNull View itemView) {
            super(itemView);
            bianhao = itemView.findViewById(R.id.bianhao);
            zhandian = itemView.findViewById(R.id.didian);
            zhuangtai = itemView.findViewById(R.id.zhuangtai);
        }
    }
    public ItemAdapter(ArrayList<LightItem> itemlist) {
        mitemlist=itemlist;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        return new  VH(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        LightItem lightItem = mitemlist.get(i);//获取子项
        final String id = mitemlist.get(i).getBianhao();
        vh.bianhao.setText(lightItem.getBianhao());
        vh.zhuangtai.setText(lightItem.getZhuangtai());
        vh.zhandian.setText(lightItem.getZhandian());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vh.itemView.getContext(), LightDetailActivity.class);
                intent.putExtra("id",id);
                Log.i("id", "onClick: "+id);
                vh.itemView.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        if(mitemlist!=null)
        return mitemlist.size();
        return 0;
    }


}
