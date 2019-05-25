package com.example.asus.ChannelPlayer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

/**
 * Created by Asus on 2019/5/10.
 */

public class LiveActivity extends AppCompatActivity {

    private PlayerView bofang;
    private Button quanping,fanghui;
    private RelativeLayout jiemian;
    private TextView biaoti;
    SimpleExoPlayer player;
    static Boolean  aBoolean = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//状态栏隐藏


        setContentView(R.layout.activity_live);

        jiemian = findViewById(R.id.channeljiemian);

        fanghui = findViewById(R.id.fanghuipindao);
        fanghui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        quanping = findViewById(R.id.quanping);

        quanping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (aBoolean == false) {
                    player.stop();
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//全屏
                    requestWindowFeature(Window.FEATURE_NO_TITLE);
                    aBoolean=true;
                }
            }


        });



        Intent intent = getIntent();
        Uri uri = Uri.parse(intent.getStringExtra("uri"));
        String moviename = intent.getStringExtra("name");
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        biaoti = findViewById(R.id.channelmovieName);
        biaoti.setText(moviename);



        bofang = (PlayerView) findViewById(R.id.palyerview);

        player = ExoPlayerFactory.newSimpleInstance(this);
        //创建播放器
//        ExoPlayer player = ExoPlayerFactory.newSimpleInstance(this);
        player.setPlayWhenReady(true);
        bofang.setPlayer(player);
        //
        DataSource.Factory factory = new DefaultDataSourceFactory(this, "asd");
//        new HlsMediaSource.Factory(factory).createMediaSource(this,);

        HlsMediaSource source = new HlsMediaSource.Factory(factory).createMediaSource(uri);
        player.prepare(source);

//        Toast.makeText(LiveActivity.this,intent.getStringExtra("uri"),Toast.LENGTH_LONG).show();

    }

    protected void onDestroy() {
        super.onDestroy();
        //销毁

        Log.d("LifeCycle", "--onDestroy--");
        if (player != null) {
            player.stop();
        }
        //因为有缓存，所以会继续播放，但已经没有加载资源
    }

    protected void onPause() {
        super.onPause();
//        暂停
        Log.d("LifeCycle", "--onPause--");

        if (player != null) {
            player.setPlayWhenReady(false);
            player.stop();
        }
    }

    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "--onStart--");

        if (player == null) {
            player.setPlayWhenReady(true);
        }

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (aBoolean == false) super.onBackPressed();
        else {
            aBoolean = false;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
            Log.d("LifeCycle", aBoolean.toString());
        }
        Log.d("LifeCycle", "--onBackPressed--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        player.setPlayWhenReady(true);
        Log.d("LifeCycle", "--onRestart--");
    }
    }









