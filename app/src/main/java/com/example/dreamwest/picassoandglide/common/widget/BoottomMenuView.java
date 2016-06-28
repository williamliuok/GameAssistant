package com.example.dreamwest.picassoandglide.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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

    public BoottomMenuView(Context context) {
        super(context);
    }

    public BoottomMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.bottommenu_layout, this, true);
        view.setClickable(true);
        imageview = (ImageView) view.findViewById(R.id.iv_bottommenu);
        textView = (TextView) findViewById(R.id.tv_bottommenu);
    }

    public void setImageviewRes(int resID){
        imageview.setImageResource(resID);
    }

    public void setTextViewText(String str){
        textView.setText(str);
    }
}
