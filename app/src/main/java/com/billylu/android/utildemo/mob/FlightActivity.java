package com.billylu.android.utildemo.mob;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.base.BaseActivity;
import com.billylu.android.utildemo.bean.mob.MobFlightEntity;
import com.billylu.android.utildemo.http.MobApi;
import com.billylu.android.utildemo.http.MyCallBack;
import com.billylu.android.utildemo.utils.KeyboardUtils;
import com.billylu.android.utildemo.utils.MySnackbar;
import com.billylu.android.utildemo.utils.StatusBarUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 航班
 */
public class FlightActivity extends BaseActivity {

    @Bind(R.id.ll_query)
    LinearLayout llQuery;
    @Bind(R.id.tv_start_name)
    TextView tvStartName;
    @Bind(R.id.tv_end_name)
    TextView tvEndName;
    @Bind(R.id.tv_time_query)
    TextView tvTimeQuery;
    @Bind(R.id.et_start_name)
    EditText etStartName;
    @Bind(R.id.iv_swap)
    ImageView ivSwap;
    @Bind(R.id.et_end_name)
    EditText etEndName;

    private SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
    private Animation animation180;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        ButterKnife.bind(this);
        StatusBarUtil.setTranslucentForImageView(this, 20, llQuery);

        initAnimation();

        //初始化数据
        initData();

    }

    private void initAnimation() {

        animation180 = AnimationUtils.loadAnimation(this, R.anim.rotate_180);

    }

    private void initData() {
        Date date = new Date();
        tvTimeQuery.setText(sdf.format(date));
    }

    @OnClick(R.id.btn_back)
    public void btn_back() {
        this.finish();
    }

    @OnClick(R.id.rl_root)
    public void rl_root() {
        KeyboardUtils.hideSoftInput(this);
    }

    @OnClick(R.id.iv_swap)
    public void ivSwap() {
        LinearInterpolator lin = new LinearInterpolator();
        animation180.setInterpolator(lin);
        ivSwap.setAnimation(animation180);
        ivSwap.startAnimation(animation180);
        animation180.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                etStartName.setVisibility(View.GONE);
                etEndName.setVisibility(View.GONE);

                tvStartName.setVisibility(View.VISIBLE);
                tvEndName.setVisibility(View.VISIBLE);

                //交换
                String startName = etStartName.getText().toString();
                String endName = etEndName.getText().toString();

                tvStartName.setText(startName);
                tvEndName.setText(endName);

                etStartName.setText(endName);
                etEndName.setText(startName);


                //开始动画
                int[] location = new int[2];
                etEndName.getLocationInWindow(location);
                int translateX = location[0] + etEndName.getWidth() / 2;

                TranslateAnimation translateAnimation = new TranslateAnimation(0, translateX, 0, 0);
                translateAnimation.setDuration(600);
                tvStartName.setAnimation(translateAnimation);
                tvStartName.startAnimation(translateAnimation);

                TranslateAnimation translateAnimation2 = new TranslateAnimation(0, -translateX, 0, 0);
                translateAnimation2.setDuration(600);
                tvEndName.setAnimation(translateAnimation2);
                tvEndName.startAnimation(translateAnimation2);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                etStartName.setVisibility(View.VISIBLE);
                etEndName.setVisibility(View.VISIBLE);

                tvStartName.setVisibility(View.GONE);
                tvEndName.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @OnClick(R.id.btn_query)
    public void btnQuery() {

        KeyboardUtils.hideSoftInput(this);

        //获取出发城市
        final String startName = etStartName.getText().toString();

        //获取到达城市
        final String endName = etEndName.getText().toString();

        //判断
        if (TextUtils.isEmpty(startName)) {
            MySnackbar.makeSnackBarBlack(tvEndName, "出发城市不能为空");
            return;
        }

        if (TextUtils.isEmpty(endName)) {
            MySnackbar.makeSnackBarBlack(tvEndName, "到达城市不能为空");
            return;
        }

        showProgressDialog("正在查询...");

        MobApi.queryFlightLineList(startName, endName, 0x001, new MyCallBack() {
            @Override
            public void onSuccess(int what, Object result) {

            }

            @Override
            public void onSuccessList(int what, List results) {
                dissmissProgressDialog();
                ArrayList<MobFlightEntity> mDatas = (ArrayList<MobFlightEntity>) results;
                if (mDatas != null && mDatas.size() > 0) {
                    //跳转页面
                    Intent intent = new Intent(mContext, FlightListActivity.class);
                    intent.putExtra("IntentTitle", startName + "-" + endName);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("IntentDatas", mDatas);
                    intent.putExtras(bundle);
                    mContext.startActivity(intent);
                }
            }

            @Override
            public void onFail(int what, String result) {
                dissmissProgressDialog();
                MySnackbar.makeSnackBarRed(tvEndName, result);
            }
        });

    }

}
