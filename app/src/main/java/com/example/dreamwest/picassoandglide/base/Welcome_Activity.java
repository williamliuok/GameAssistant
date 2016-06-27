package com.example.dreamwest.picassoandglide.base;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dreamwest.picassoandglide.R;

import java.util.ArrayList;
import java.util.List;

public class Welcome_Activity extends BaseActivity {

    private ViewPager vp_welcome;
    protected List<ImageView> mlistPics ;

    @Override
    protected int setViewID() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void findView() {
        vp_welcome = (ViewPager) findViewById(R.id.vp_welcome);
    }

    protected void addImageView(int srcID) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(srcID);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mlistPics.add(imageView);
    //
    }

    @Override
    protected void init() {
        mlistPics = new ArrayList<>();
        addImageView(R.mipmap.bg_guide_01);
        addImageView(R.mipmap.bg_guide_02);
        addImageView(R.mipmap.bg_guide_03);
        addImageView(R.mipmap.bg_guide_04);

    }



    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
