package com.example.dreamwest.picassoandglide.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 16-6-27.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//      return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(setViewID(),container,false);
        findView(view);
        init();
        initEvent();
        loadData();
        return view;
    }

    protected abstract int setViewID();

    //查找activity布局里面的控件
    protected abstract void findView(View view);

    //初始化数据
    protected abstract void init();

    //初始化设置各种监听
    protected abstract void initEvent();

    //数据加载
    protected abstract void loadData();


}
