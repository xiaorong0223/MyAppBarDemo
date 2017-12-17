package com.codingsnail.myappbardemo;


import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by Snail on 17/12/17 下午6:37
 * Contact with slowsnail0223@gmail.com
 * 自定义ScrollView 监听ScrollView的滑动
 */
public class MonitorScrollView extends ScrollView {

    private ScrollChangedListener listener;

    public MonitorScrollView(Context context) {
        super(context);
    }

    public MonitorScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MonitorScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            listener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(ScrollChangedListener listener) {
        this.listener = listener;
    }

    public interface ScrollChangedListener {
        void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt);
    }
}
