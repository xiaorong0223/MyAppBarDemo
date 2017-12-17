package com.codingsnail.myappbardemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ScrollView;

/**
 * Created by Snail on 17/12/17 下午9:10
 * Contact with slowsnail0223@gmail.com
 * 自定义ScrollView 监听ScrollView的滑动
 */
public class NormalActivity extends AppCompatActivity implements MonitorScrollView.ScrollChangedListener {

    private Toolbar toolbar;

    private float headerHeight;//顶部高度
    private float minHeaderHeight;//顶部最低高度，即Bar的高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MonitorScrollView scrollView = findViewById(R.id.scrollview);
        scrollView.setOnScrollChangedListener(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.argb(0, 48, 63, 159));
        initMeasure();
    }

    private void initMeasure() {
        headerHeight = getResources().getDimension(R.dimen.app_bar_height);
        minHeaderHeight = getResources().getDimension(R.dimen.abc_action_bar_default_height_material);
    }

    @Override
    public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
        float scrollY = who.getScrollY();
        float headerBarOffsetY = headerHeight - minHeaderHeight;
        float offset = 1 - Math.max((headerBarOffsetY - scrollY) / headerBarOffsetY, 0f);
        toolbar.setBackgroundColor(Color.argb((int) (offset * 255), 48, 63, 159));
    }
}
