package com.billylu.android.utildemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.bean.mob.MobHealthEntity;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 健康知识
 */
public class RecycleHealthAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MobHealthEntity.ListBean> mDatas;
    private LayoutInflater layoutInflater;

    public RecycleHealthAdapter(Context context, ArrayList<MobHealthEntity.ListBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public void upddateDatas(ArrayList<MobHealthEntity.ListBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.item_health, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

            MobHealthEntity.ListBean mobHealth = mDatas.get(position);

            myViewHolder.tv_title.setText(mobHealth.getTitle());

            SparseBooleanArray mTogglePositions = new SparseBooleanArray();
            myViewHolder.expand_text_view.setText(mobHealth.getContent(), mTogglePositions, position);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title)
        TextView tv_title;
        @Bind(R.id.expand_text_view)
        ExpandableTextView expand_text_view;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
