package com.example.asus.ChannelPlayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Asus on 2019/5/7.
 */

public class top extends AppCompatActivity {

    private TextView mTV1;
    private String channelName;
    private String getChannelID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top);

        Intent intent = getIntent();

        mTV1 = (TextView) findViewById(R.id.top);
        mTV1.setText(intent.getStringExtra("传递了"+"name"));

    }






}
