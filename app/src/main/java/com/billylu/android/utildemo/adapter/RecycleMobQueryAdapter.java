package com.billylu.android.utildemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.bean.mob.MobItemEntity;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 更多功能的Adapter
 */
public class RecycleMobQueryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private HashMap<String, Object> mDatas;

    public RecycleMobQueryAdapter(Context context, HashMap<String, Object> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public void updateDatas(HashMap<String, Object> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.item_mob_query, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof MyViewHolder) {
            final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            MobItemEntity mobItemEntity = (MobItemEntity) mDatas.get(String.valueOf(position));
            if (mobItemEntity != null) {
                myViewHolder.tvTitle.setText(mobItemEntity.getTitle());
                myViewHolder.tvDesc.setText(mobItemEntity.getDesc());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_desc)
        TextView tvDesc;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
