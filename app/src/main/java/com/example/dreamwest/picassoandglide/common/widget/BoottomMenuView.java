package com.example.dreamwest.picassoandglide.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dreamwest.picassoandglide.R;

/**
 * Created by Administrator on 16-6-28.
 */
public class BoottomMenuView extends FrameLayout{
    private ImageView imageview;
    private TextView textView;
    private String mMenuText;
    private int normalId;
    private int pressId;
    boolean selected = false;

    public BoottomMenuView(Context context) {
        super(context);
    }

    public BoottomMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.bottommenu_layout, this, true);
        imageview = (ImageView) view.findViewById(R.id.iv_bottommenu);
        textView = (TextView) view.findViewById(R.id.tv_bottommenu);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BoottomMenuView);

        mMenuText = (String) typedArray.getText(R.styleable.BoottomMenuView_text);
        normalId = typedArray.getResourceId(R.styleable.BoottomMenuView_srcnormal, -1);
        pressId = typedArray.getResourceId(R.styleable.BoottomMenuView_srcpress, -1);

        textView.setText(mMenuText);
        imageview.setImageResource(normalId);
        typedArray.recycle();

    }

    /**
     *点击执行该动画方法
     */
    public void onSelected(){
        if(selected){
            return;
        }else{
            selected = true;
            imageview.setImageResource(pressId);
            //设置文字评议动画
            TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                    0,
                    Animation.RELATIVE_TO_SELF,
                    0,
                    Animation.RELATIVE_TO_SELF,
                    0,
                    Animation.RELATIVE_TO_SELF,
                    1.5f);
            translateAnimation.setDuration(20);
            translateAnimation.setFillAfter(true);
            textView.startAnimation(translateAnimation);
            //设置图片缩放动画
            ScaleAnimation scaleAnimation = new ScaleAnimation(1,1.5f,1,1.5f,
                    Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0);
            scaleAnimation.setDuration(200);
            scaleAnimation.setFillAfter(true);
            imageview.startAnimation(scaleAnimation);
        }
    }

    /**
     *动画反向执行方法
     */
    public void unSelected(){
        if(selected){
            selected = false;
            imageview.setImageResource(normalId);
            //设置文字评议动画
            TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                    0,
                    Animation.RELATIVE_TO_SELF,
                    0,
                    Animation.RELATIVE_TO_SELF,
                    1.5f,
                    Animation.RELATIVE_TO_SELF,
                    0);
            translateAnimation.setDuration(150);
            textView.startAnimation(translateAnimation);
            //设置图片缩放动画
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.5f , 1 , 1.5f , 1 ,
                    Animation.RELATIVE_TO_SELF , 0.5f ,
                    Animation.RELATIVE_TO_SELF , 0 );
            scaleAnimation.setDuration(150);
            imageview.startAnimation(scaleAnimation);
        }else{
            return;
        }
    }

}
