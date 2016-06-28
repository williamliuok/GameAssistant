package com.example.dreamwest.picassoandglide.base;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dreamwest.picassoandglide.R;
import com.example.dreamwest.picassoandglide.common.constant.Constant;
import com.example.dreamwest.picassoandglide.module.main.UI.MainActivity;
import com.se7en.utils.SystemUtil;

import java.util.ArrayList;
import java.util.List;

public class Welcome_Activity extends BaseActivity {

    private ViewPager vp_welcome;
    protected List<ImageView> mlistPics ;
    private ImageView logotext;
    private ImageView logowelcome;
    private int mCurrentVersion;
    private int mLastVersion ;
    private Button btn_welcome;
    private Intent intent;

    @Override
    protected int setViewID() {
        return R.layout.activity_welcome;
    }
    protected void showLogoTextAnim(){
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,-1.0f,
                Animation.RELATIVE_TO_PARENT,0,
                Animation.RELATIVE_TO_PARENT,0,
                Animation.RELATIVE_TO_PARENT,0);
        translateAnimation.setDuration(2000);
        translateAnimation.setInterpolator(new OvershootInterpolator());
        logotext.setVisibility(View.VISIBLE);
        logotext.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                showLogoAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showLogoAnim() {
        logowelcome.setVisibility(View.VISIBLE);
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0,
                Animation.RELATIVE_TO_PARENT,0,Animation.RELATIVE_TO_PARENT,-1.0f,Animation.RELATIVE_TO_PARENT,0);
        translateAnimation.setDuration(2000);
        translateAnimation.setInterpolator(new BounceInterpolator());
        logowelcome.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                intent = new Intent(Welcome_Activity.this,MyActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    protected void findView() {
        vp_welcome = (ViewPager) findViewById(R.id.vp_welcome);
        btn_welcome = (Button) findViewById(R.id.btn_welcome);
        logotext = (ImageView) findViewById(R.id.iv_logotext_welcome);
        logowelcome = (ImageView) findViewById(R.id.iv_logo_welcome);
    }

    protected void addImageView(int srcID) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(srcID);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        mlistPics.add(imageView);
    }

    @Override
    protected void init() {
        intent = new Intent(this, MyActivity.class);
        mCurrentVersion= SystemUtil.getSystemVersionCode();
        mLastVersion=SystemUtil.getSharedInt(Constant.VERSION_STRING,-1);
        if((mLastVersion==-1)||mCurrentVersion>mLastVersion){
            mlistPics = new ArrayList<>();
            addImageView(R.mipmap.bg_guide_01);
            addImageView(R.mipmap.bg_guide_02);
            addImageView(R.mipmap.bg_guide_03);
            addImageView(R.mipmap.bg_guide_04);
            vp_welcome.setAdapter(new PagerAdapter() {
                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView((View) object);
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    container.addView(mlistPics.get(position));
                    return mlistPics.get(position);
                }

                @Override
                public int getCount() {
                    return mlistPics.size();
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view==object;
                }
            });
        }else{
            btn_welcome.setVisibility(View.GONE);
            vp_welcome.setVisibility(View.GONE);
            showLogoTextAnim();
        }
    }

    @Override
    protected void initEvent() {
        btn_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemUtil.setSharedInt(Constant.VERSION_STRING,mCurrentVersion);
                btn_welcome.setVisibility(View.GONE);
                vp_welcome.setVisibility(View.GONE);
                showLogoTextAnim();
            }
        });
        vp_welcome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == (mlistPics.size()-1)){
                    btn_welcome.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void loadData() {

    }
}
