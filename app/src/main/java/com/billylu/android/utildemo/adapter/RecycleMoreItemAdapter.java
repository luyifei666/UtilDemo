package com.billylu.android.utildemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.listeners.OnItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 更多功能的Adapter
 */
public class RecycleMoreItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> mDatas;
    private LayoutInflater layoutInflater;

    public RecycleMoreItemAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.item_more_tools_item, parent, false);
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

            String title = mDatas.get(position);
            myViewHolder.tv_title_more_item.setText(title);

            if (title.equals("手机号码归属地")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_phone_address);
            } else if (title.equals("邮编查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_postcode);
            } else if (title.equals("菜谱查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_cookbook);
            } else if (title.equals("身份证查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_idcard_query);
            } else if (title.equals("IP地址")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_ip);
            } else if (title.equals("中国彩票开奖结果")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_lottery);
            } else if (title.equals("微信精选")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_weixin);
            }

            if (title.equals("银行卡信息")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_bank);
            } else if (title.equals("白银数据")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_baiyin);
            } else if (title.equals("黄金数据")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_gold);
            } else if (title.equals("货币汇率")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_money);
            } else if (title.equals("国内现货交易所贵金属")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_guijinshu);
            } else if (title.equals("全球股指查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_guzhi);
            }

            if (title.equals("周公解梦")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_zhougong);
            } else if (title.equals("婚姻匹配")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_hunyin);
            } else if (title.equals("手机号码查吉凶")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_jixiong);
            } else if (title.equals("八字算命")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_suanming);
            } else if (title.equals("老黄历")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_huangli);
            } else if (title.equals("电影票房")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_movie);
            } else if (title.equals("火车票查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_train);
            } else if (title.equals("航班信息查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_plane);
            } else if (title.equals("足球五大联赛")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_football);
            }

            if (title.equals("健康知识")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_jiankang);
            } else if (title.equals("历史上的今天")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_history);
            } else if (title.equals("成语大全")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_chengyu);
            } else if (title.equals("新华字典")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_zidian);
            } else if (title.equals("全国省市今日油价")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_youjia);
            } else if (title.equals("汽车信息查询")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_car);
            } else if (title.equals("驾考题库")) {
                myViewHolder.iv_more_item.setImageResource(R.drawable.gank_icon_tools_tiku_car);
            }

        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_more_item)
        ImageView iv_more_item;
        @Bind(R.id.tv_title_more_item)
        TextView tv_title_more_item;

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
