package com.billylu.android.utildemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.billylu.android.utildemo.R;
import com.billylu.android.utildemo.skin.SkinManager;
import com.billylu.android.utildemo.utils.StatusBarUtil;
import com.bumptech.glide.Glide;

/**
 * Created by maning on 16/3/2.
 * <p/>
 * 父类
 */
public class BaseActivity extends AppCompatActivity {

    private SVProgressHUD mSVProgressHUD;
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置主题
        SkinManager.onActivityCreateSetSkin(this);
        super.onCreate(savedInstanceState);

        mContext = this;

        initStatus();

        initDialog();

    }

    private void initStatus() {
        //设置状态栏的颜色
        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (SkinManager.THEME_DAY == currentSkinType) {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.main_color), 60);
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.main_color_night), 60);
        }
    }

    private void initDialog() {
        mSVProgressHUD = new SVProgressHUD(this);
    }

    public void showProgressDialog() {
        dissmissProgressDialog();
        mSVProgressHUD.showWithStatus("加载中...", SVProgressHUD.SVProgressHUDMaskType.Black);
    }

    public void showProgressDialog(String message) {
        if (TextUtils.isEmpty(message)) {
            showProgressDialog();
        } else {
            dissmissProgressDialog();
            mSVProgressHUD.showWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.Black);
        }
    }

    public void showProgressSuccess(String message) {
        dissmissProgressDialog();
        mSVProgressHUD.showSuccessWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.Black);
    }

    public void showProgressError(String message) {
        dissmissProgressDialog();
        mSVProgressHUD.showErrorWithStatus(message, SVProgressHUD.SVProgressHUDMaskType.Black);
    }

    public void dissmissProgressDialog() {
        if (mSVProgressHUD.isShowing()) {
            mSVProgressHUD.dismiss();
        }
    }

    public void initToolBar(Toolbar toolbar, String title, int icon) {
        toolbar.setTitle(title);// 标题的文字需在setSupportActionBar之前，不然会无效
        toolbar.setNavigationIcon(icon);
        setSupportActionBar(toolbar);
        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (SkinManager.THEME_DAY == currentSkinType) {
            toolbar.setTitleTextColor(getResources().getColor(R.color.gank_text1_color));
            toolbar.setPopupTheme(R.style.ToolBarPopupThemeDay);
        } else {
            toolbar.setTitleTextColor(getResources().getColor(R.color.gank_text1_color_night));
            toolbar.setPopupTheme(R.style.ToolBarPopupThemeNight);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            if (mSVProgressHUD.isShowing()) {
                mSVProgressHUD.dismiss();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onDestroy() {
        dissmissProgressDialog();
        Glide.with(this.getApplicationContext()).pauseRequests();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(this.getClass().getSimpleName());
//        MobclickAgent.onResume(this);       //统计时长
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPageStart(this.getClass().getSimpleName());
//        MobclickAgent.onPause(this);
    }


}
