package com.billylu.android.utildemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.listeners.OnItemClickListener;
import com.billylu.android.utildemo.mob.BankCardActivity;
import com.billylu.android.utildemo.mob.ChineseCalendarActivity;
import com.billylu.android.utildemo.mob.DictionaryActivity;
import com.billylu.android.utildemo.mob.FlightActivity;
import com.billylu.android.utildemo.mob.HealthActivity;
import com.billylu.android.utildemo.mob.HistoryTodayActivity;
import com.billylu.android.utildemo.mob.IDCardQueryActivity;
import com.billylu.android.utildemo.mob.IPQueryActivity;
import com.billylu.android.utildemo.mob.IdiomActivity;
import com.billylu.android.utildemo.mob.OilPriceActivity;
import com.billylu.android.utildemo.mob.PhoneAddressActivity;
import com.billylu.android.utildemo.mob.PostCodeActivity;
import com.billylu.android.utildemo.mob.TrainActivity;
import com.billylu.android.utildemo.mob.WXArticleActivity;
import com.billylu.android.utildemo.utils.IntentUtils;
import com.billylu.android.utildemo.utils.MySnackbar;
import com.billylu.android.utildemo.utils.MyToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 更多功能的Adapter
 */
public class RecycleMoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> mDatas;
    private LayoutInflater layoutInflater;

    public RecycleMoreAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = layoutInflater.inflate(R.layout.item_more_tools, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        if (viewHolder instanceof MyViewHolder) {
            final MyViewHolder myViewHolder = (MyViewHolder) viewHolder;

            myViewHolder.tvTitleMore.setText(mDatas.get(position));

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            myViewHolder.recyclerViewItem.setLayoutManager(gridLayoutManager);
            myViewHolder.recyclerViewItem.setItemAnimator(new DefaultItemAnimator());

            ArrayList<String> mDatasItem = new ArrayList<>();
            if (position == 0) {
                mDatasItem.add("手机号码归属地");
                mDatasItem.add("邮编查询");
                mDatasItem.add("菜谱查询");
                mDatasItem.add("身份证查询");
                mDatasItem.add("IP地址");
                mDatasItem.add("中国彩票开奖结果");
                mDatasItem.add("微信精选");
            } else if (position == 1) {
                mDatasItem.add("银行卡信息");
                mDatasItem.add("货币汇率");
//                mDatasItem.add("黄金数据");
//                mDatasItem.add("白银数据");
//                mDatasItem.add("国内现货交易所贵金属");
//                mDatasItem.add("全球股指查询");
            } else if (position == 2) {
                mDatasItem.add("周公解梦");
                mDatasItem.add("婚姻匹配");
                mDatasItem.add("八字算命");
                mDatasItem.add("老黄历");
                mDatasItem.add("电影票房");
                mDatasItem.add("足球五大联赛");
                mDatasItem.add("火车票查询");
                mDatasItem.add("航班信息查询");
            } else if (position == 3) {
                mDatasItem.add("健康知识");
                mDatasItem.add("历史上的今天");
                mDatasItem.add("成语大全");
                mDatasItem.add("新华字典");
                mDatasItem.add("全国省市今日油价");
                mDatasItem.add("汽车信息查询");
                mDatasItem.add("驾考题库");
            }

            final ArrayList<String> mDatasTitle = mDatasItem;
            RecycleMoreItemAdapter recycleMoreItemAdapter = new RecycleMoreItemAdapter(context, mDatasItem);
            myViewHolder.recyclerViewItem.setAdapter(recycleMoreItemAdapter);
            recycleMoreItemAdapter.setOnItemClickLitener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    String title = mDatasTitle.get(position);
                    if (title.equals("手机号码归属地")) {
                        context.startActivity(new Intent(context, PhoneAddressActivity.class));
                    } else if (title.equals("邮编查询")) {
                        context.startActivity(new Intent(context, PostCodeActivity.class));
                    } else if (title.equals("菜谱查询")) {
                        MyToast.showShortToast("功能暂未开通,敬请期待");
                    } else if (title.equals("身份证查询")) {
                        context.startActivity(new Intent(context, IDCardQueryActivity.class));
                    } else if (title.equals("IP地址")) {
                        context.startActivity(new Intent(context, IPQueryActivity.class));
                    } else if (title.equals("中国彩票开奖结果")) {
                        MyToast.showShortToast("功能暂未开通,敬请期待");
                    } else if (title.equals("微信精选")) {
                        context.startActivity(new Intent(context, WXArticleActivity.class));
                    }

                    if (title.equals("银行卡信息")) {
                        context.startActivity(new Intent(context, BankCardActivity.class));
                    } else if (title.equals("货币汇率")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("货币汇率")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("白银数据")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("国内现货交易所贵金属")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("全球股指查询")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    }

                    if (title.equals("周公解梦")) {
                        IntentUtils.startToWebActivity(context, "工具", "周公解梦", "http://tools.2345.com/zhgjm.htm");
                    } else if (title.equals("婚姻匹配")) {
                        IntentUtils.startToWebActivity(context, "工具", "婚姻匹配", "http://www.jjdzc.com/peidui/hehun.html");
                    } else if (title.equals("八字算命")) {
                        IntentUtils.startToWebActivity(context, "工具", "八字算命", "http://www.jjdzc.com/sm/bz.html");
                    } else if (title.equals("老黄历")) {
                        context.startActivity(new Intent(context, ChineseCalendarActivity.class));
                    } else if (title.equals("电影票房")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("火车票查询")) {
                        context.startActivity(new Intent(context, TrainActivity.class));
                    } else if (title.equals("航班信息查询")) {
                        context.startActivity(new Intent(context, FlightActivity.class));
                    } else if (title.equals("足球五大联赛")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    }

                    if (title.equals("健康知识")) {
                        context.startActivity(new Intent(context, HealthActivity.class));
                    } else if (title.equals("历史上的今天")) {
                        context.startActivity(new Intent(context, HistoryTodayActivity.class));
                    } else if (title.equals("成语大全")) {
                        context.startActivity(new Intent(context, IdiomActivity.class));
                    } else if (title.equals("新华字典")) {
                        context.startActivity(new Intent(context, DictionaryActivity.class));
                    } else if (title.equals("全国省市今日油价")) {
                        context.startActivity(new Intent(context, OilPriceActivity.class));
                    } else if (title.equals("汽车信息查询")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    } else if (title.equals("驾考题库")) {
                        MySnackbar.makeSnackBarGreen(myViewHolder.recyclerViewItem,"功能暂未开通,敬请期待");
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title_more)
        TextView tvTitleMore;
        @Bind(R.id.recyclerViewItem)
        RecyclerView recyclerViewItem;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
