package com.codingsnail.myappbardemo;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * Created by Snail on 17/12/17 下午56:37
 * Contact with slowsnail0223@gmail.com
 * 通过Material Design中的AppBarLayout实现功能
 */
public class AppBarLayoutActivity extends AppCompatActivity {

    private ArrayList<Integer> images = new ArrayList<>();
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        banner = findViewById(R.id.banner_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setBannerData();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setBannerData() {

        images.add(R.mipmap.img_test);
        images.add(R.mipmap.img_test2);
        images.add(R.mipmap.img_test);
        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }
}
