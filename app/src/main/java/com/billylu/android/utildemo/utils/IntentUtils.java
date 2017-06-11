package com.billylu.android.utildemo.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.billylu.android.utildemo.MoreActivity;
import com.billylu.android.utildemo.mob.WebActivity;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by maning on 16/3/3.
 * <p/>
 * 页面跳转
 */
public class IntentUtils {

    public static final String ImagePositionForImageShow = "PositionForImageShow";
    public static final String ImageArrayList = "BigImageArrayList";
    public static final String WebTitleFlag = "WebTitleFlag";
    public static final String WebTitle = "WebTitle";
    public static final String WebUrl = "WebUrl";
    public static final String DayDate = "DayDate";

    public static final String PushMessage = "PushMessage";

    public static void startToImageShow(Context context, ArrayList<String> mDatas, int position, View view) {
//        Intent intent = new Intent(context.getApplicationContext(), ImagesActivity.class);
//        intent.putStringArrayListExtra(ImageArrayList, mDatas);
//        intent.putExtra(ImagePositionForImageShow, position);
//        context.startActivity(intent);
        KLog.i("startToImageShow:" + view.getWidth() / 2 + "," + view.getHeight());
//        MNImageBrowser.showImageBrowser(context, view, position, mDatas);
    }

    public static void startToWebActivity(Context context, String titleFlag, String title, String url) {
        Intent intent = new Intent(context.getApplicationContext(), WebActivity.class);
        intent.putExtra(WebTitleFlag, titleFlag);
        intent.putExtra(WebTitle, title);
        intent.putExtra(WebUrl, url);
        context.startActivity(intent);
    }
//
//    public static void startAboutActivity(Context context) {
//        Intent intent = new Intent(context.getApplicationContext(), AboutActivity.class);
//        context.startActivity(intent);
//    }
//
//    public static void startSettingActivity(Context context) {
//        Intent intent = new Intent(context.getApplicationContext(), SettingActivity.class);
//        context.startActivity(intent);
//    }
//
//    public static void startDayShowActivity(Context context, String date) {
//        Intent intent = new Intent(context.getApplicationContext(), GankActivity.class);
//        intent.putExtra(DayDate, date);
//        context.startActivity(intent);
//    }

    public static void startAppShareText(Context context, String shareTitle, String shareText) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain"); // 纯文本
        shareIntent.putExtra(Intent.EXTRA_TITLE, shareTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    public static void startAppShareImage(Context context, String shareTitle, String shareText, Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_TITLE, shareTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    public static void startToFeedBackPage(Context context) {
        //阿里百川意见反馈
        //可以设置UI自定义参数，如主题色等,map的key值具体为：
        //enableAudio(是否开启语音 1：开启 0：关闭)
        //bgColor(消息气泡背景色 "#ffffff")，
        //color(消息内容文字颜色 "#ffffff")，
        //avatar(当前登录账号的头像)，string，为http url
        //toAvatar(客服账号的头像),string，为http url
        //themeColor(标题栏自定义颜色 "#ffffff")
        //profilePlaceholder: (顶部联系方式)，string
        //profileTitle: （顶部联系方式左侧提示内容）, String
        //chatInputPlaceholder: (输入框里面的内容),string
        //profileUpdateTitle:(更新联系方式标题), string
        //profileUpdateDesc:(更新联系方式文字描述), string
        //profileUpdatePlaceholder:(更新联系方式), string
        //profileUpdateCancelBtnText: (取消更新), string
        //profileUpdateConfirmBtnText: (确定更新),string
        //sendBtnText: (发消息),string
        //sendBtnTextColor: ("white"),string
        //sendBtnBgColor: ('red'),string
        //hideLoginSuccess: true  隐藏登录成功的toast
        //pageTitle: （Web容器标题）, string
        //photoFromCamera: (拍摄一张照片),String
        //photoFromAlbum: (从相册选取), String
        //voiceContent:(点击这里录制语音), String
        //voiceCancelContent: (滑到这里取消录音), String
        //voiceReleaseContent: (松开取消录音), String
        Map<String, String> customInfoMap = new HashMap<>();
        customInfoMap.put("themeColor", "#54aee6");
        customInfoMap.put("pageTitle", "意见反馈");
        customInfoMap.put("hideLoginSuccess", "true");
//        FeedbackAPI.setUICustomInfo(customInfoMap);
//        FeedbackAPI.openFeedbackActivity(context);
    }

//    public static void startQRCodeActivity(Context context) {
//        Intent intent = new Intent(context.getApplicationContext(), QRCodeActivity.class);
//        context.startActivity(intent);
//    }
//
//    public static void startSupportPayActivity(Context context) {
//        Intent intent = new Intent(context.getApplicationContext(), SupportPayActivity.class);
//        context.startActivity(intent);
//    }

    public static void startMoreActivity(Context context) {
        Intent intent = new Intent(context.getApplicationContext(), MoreActivity.class);
        context.startActivity(intent);
    }

    public static void goToMarket(Context context, String packageName) {
        //判断是否安装应用宝
        if (!GankUtils.isAppInstalled(context, "com.tencent.android.qqdownloader")) {
            MyToast.showShortToast("请先安装应用宝市场");
            return;
        }
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            goToMarket.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            context.startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

}
