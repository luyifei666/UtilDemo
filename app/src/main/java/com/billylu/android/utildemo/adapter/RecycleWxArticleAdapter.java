package com.billylu.android.utildemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.bean.mob.MobWxArticleListEntity;
import com.billylu.android.utildemo.listeners.OnItemClickListener;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 微信分类
 */
public class RecycleWxArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MobWxArticleListEntity.ListBean> mDatas;
    private LayoutInflater layoutInflater;

    public RecycleWxArticleAdapter(Context context, ArrayList<MobWxArticleListEntity.ListBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(this.context);
    }

    public void updateDatas(ArrayList<MobWxArticleListEntity.ListBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.item_wx_article, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof MyViewHolder) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

            if (mOnItemClickLitener != null) {
                myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnItemClickLitener.onItemClick(view, position);
                    }
                });
            }

            MobWxArticleListEntity.ListBean listBean = mDatas.get(position);

            myViewHolder.tv_title_wx.setText(listBean.getTitle());
            myViewHolder.tv_time_wx.setText(listBean.getPubTime());

            //图片处理
            myViewHolder.iv_show_wx.setVisibility(View.VISIBLE);
            myViewHolder.iv_show_wx.setImageResource(R.drawable.pic_gray_bg);
            String thumbnails = listBean.getThumbnails();
            if (!TextUtils.isEmpty(thumbnails)) {
                String[] images = thumbnails.split("$");
                if (images.length > 0) {
                    Glide.with(context)
                            .load(images[0])
                            .placeholder(R.drawable.pic_gray_bg)
                            .centerCrop()
                            .into(myViewHolder.iv_show_wx);
                } else {
                    myViewHolder.iv_show_wx.setVisibility(View.GONE);
                }
            } else {
                myViewHolder.iv_show_wx.setVisibility(View.GONE);
            }

        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title_wx)
        TextView tv_title_wx;
        @Bind(R.id.tv_time_wx)
        TextView tv_time_wx;
        @Bind(R.id.iv_show_wx)
        ImageView iv_show_wx;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    private OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

}
