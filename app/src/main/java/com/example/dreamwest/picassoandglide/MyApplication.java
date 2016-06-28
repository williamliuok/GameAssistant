package com.example.dreamwest.picassoandglide;

import android.app.Application;

import com.se7en.utils.SystemUtil;

/**
 * Created by Administrator on 16-6-27.
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SystemUtil.setContext(this);
    }

}
