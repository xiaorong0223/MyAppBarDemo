package com.codingsnail.myappbardemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Snail on 17/12/17 下午9:37
 * Contact with slowsnail0223@gmail.com
 * 根据滑动的距离改变Toolbar的UI显示
 */
public class ToolbarStatusActivity extends AppCompatActivity implements MonitorScrollView.ScrollChangedListener {

    private int initHeight = 0;
    private SearchView barSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        initView();
    }

    private void initView() {
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MonitorScrollView scrollView = findViewById(R.id.scrollview);
        scrollView.setOnScrollChangedListener(this);
        barSearchView = myToolbar.findViewById(R.id.iv_right);
        initHeight = DensityUtil.dip2px(this, 45);
    }


    @Override
    public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
        float scrollY = who.getScrollY();
        // TODO: 2017/12/17 需要继续优化
        if (scrollY > initHeight)
            barSearchView.setVisibility(View.VISIBLE);
        else {
            barSearchView.setVisibility(View.GONE);
        }
    }
}