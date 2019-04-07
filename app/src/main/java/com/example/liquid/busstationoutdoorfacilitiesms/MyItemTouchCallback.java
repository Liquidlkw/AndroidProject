package com.example.liquid.busstationoutdoorfacilitiesms;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.example.liquid.busstationoutdoorfacilitiesms.adapter.ItemAdapter;

import java.util.Collections;

public class MyItemTouchCallback extends ItemTouchHelper.Callback {

    private final ItemAdapter adapter;
    private  final Context context;

    public MyItemTouchCallback(ItemAdapter adapter,Context context) {
        this.adapter = adapter;
        this.context = context;
    }
    /**
     * 当某个item由静止状态变为滑动或拖动状态时调用此方法
     * 可以改变当前拖拽 item 的透明度，这样就可以和其他 item 区分开来了。
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            viewHolder.itemView.setBackgroundColor(Color.GRAY);
        }
    }
    /*
    相对应地，当用户手指从拖拽 item 中抬起的时候，我们需要把 item 的透明度复原。
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(0);
    }

/*
这个方法返回RecyclerView的Item可以滑动、拖拽的方向，
dragFlags是拖拽的方向，swipeFlags是滑动。
可以根据不同的需求定义滑动、拖拽的方向。
 */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHol  ) {
        int dragFlag;
        int swipeFlag;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP
                    | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
            swipeFlag = 0;
        } else {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
            swipeFlag = ItemTouchHelper.END;
        }
        return makeMovementFlags(dragFlag, swipeFlag);


    }
/*
拖拽到新位置时候的回调方法,这里通过接口回调将开始position和结束position通知给到使用的地方，让其进行数据处理。
 */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(adapter.getMitemlist(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(adapter.getMitemlist(), i, i - 1);
            }
        }
        recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
        return true;


    }
/*
当用户左右滑动项目达到删除条件时，会调用该方法，一般手指触摸滑动的距离达到RecyclerView宽度的一半时，
再松开手指，此时该项目会继续向原先滑动方向滑过去并且调用onSwiped方法进行删除，
否则会反向滑回原来的位置在该方法内部我们可以这样写：
 */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        if (direction == ItemTouchHelper.END) {
            adapter.getMitemlist().remove(position);
            adapter.notifyItemRemoved(position);
            Toast.makeText(context,"删除成功！",Toast.LENGTH_SHORT).show();
        }
    }


}