package com.billylu.android.utildemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Bind(R.id.tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this ;
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        Intent intent = new Intent(context.getApplicationContext(), MoreActivity.class);
        context.startActivity(intent);
    }
}
