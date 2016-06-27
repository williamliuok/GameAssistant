package com.example.dreamwest.picassoandglide.base;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.dreamwest.picassoandglide.R;

public class MyActivity extends BaseActivity {
    private PopupWindow pw ;
    private View myView;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setAlph(0.5f);
        if(pw == null){
            pw = new PopupWindow(myView, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,false);
            pw.showAtLocation(getWindow().getDecorView(), Gravity.CENTER,0,0);
        }
    }

    private void setAlph(float alpha) {
        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.alpha=alpha;
        getWindow().setAttributes(params);
    }

    @Override
    protected void onDestroy() {
        if(pw != null){
            pw.dismiss();
            pw = null;
        }
        super.onDestroy();
    }

    @Override
    protected int setViewID() {
        return R.layout.activity_my;
    }

    @Override
    protected void findView() {

    }

    @Override
    protected void init() {
        myView = getLayoutInflater().inflate(R.layout.activity_my_popupwindow, null);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
