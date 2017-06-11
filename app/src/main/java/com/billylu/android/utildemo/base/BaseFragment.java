package com.billylu.android.utildemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.bigkoo.svprogresshud.SVProgressHUD;

public class BaseFragment extends Fragment {

    private SVProgressHUD mSVProgressHUD;


    public Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        initDialog();

    }


    private void initDialog() {
        mSVProgressHUD = new SVProgressHUD(getActivity());
    }

    public void showProgressDialog() {
        dissmissProgressDialog();
        mSVProgressHUD.showWithStatus("加载中...", SVProgressHUD.SVProgressHUDMaskType.BlackCancel);
    }

    public void dissmissProgressDialog() {
        if (mSVProgressHUD.isShowing()) {
            mSVProgressHUD.dismiss();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart(this.getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
    }

}
