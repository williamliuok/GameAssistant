package com.example.dreamwest.picassoandglide.module.main.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dreamwest.picassoandglide.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String strUrl = "http://desk.fd.zol-img.com.cn/t_s1280x800c5/g2/M00/0E/04/Cg-4WlV_kTuIbu20ABDSmRN6bJwAAFcxQGfUDAAENKx866.jpg";
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        //Picasso显示图片质量高些(ARGB_8888   一个像素占4字节)加载稍慢，图片占用内存大,不可加载Gif动态图
        Picasso.with(this)
                .load(strUrl)//图片加载的地址
                .placeholder(R.mipmap.ic_launcher)//设置加载完成前默认的图片
                .error(R.mipmap.ic_launcher)//设置加载出错时的图片
                .resize(200,200)//重新设定加载图片的尺寸
                .into(imageView);//图片加载到哪个ImageView控件
        //Glide显示图片质量稍差(RGB_565  一个像素占2字节)加载快，图片占用内存小，可以加载Gif动态图

    }
}
