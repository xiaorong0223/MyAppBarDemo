package com.codingsnail.myappbardemo;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Snail on 17/12/17 下午6:49
 * Contact with slowsnail0223@gmail.com
 * 自定义ScrollView 监听ScrollView的滑动
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext())
                .load(path)
                .crossFade()
                .into(imageView);
    }
}
