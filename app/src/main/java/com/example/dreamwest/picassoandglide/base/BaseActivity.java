package com.example.dreamwest.picassoandglide.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 16-6-27.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewID());
        findView();
        init();
        initEvent();
        loadData();
    }

    protected abstract int setViewID();


    //查找activity布局里面的控件
    protected abstract void findView();

    //初始化数据
    protected abstract void init();

    //初始化设置各种监听
    protected abstract void initEvent();

    //数据加载
    protected abstract void loadData();


}
