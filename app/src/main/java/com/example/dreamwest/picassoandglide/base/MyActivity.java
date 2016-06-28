package com.example.dreamwest.picassoandglide.base;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.dreamwest.picassoandglide.R;

public class MyActivity extends BaseActivity {
    private PopupWindow pw;
    private View myView;
    private Button btn_register;
    private TextView tv_signup;
    private Intent intent;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setAlph(0.5f);
        if (pw == null) {
            pw = new PopupWindow(myView, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, false);
            pw.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
        }
    }

    private void setAlph(float alpha) {
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = alpha;
        getWindow().setAttributes(params);
    }

    @Override
    protected void onDestroy() {
        if (pw != null) {
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
        myView = getLayoutInflater().inflate(R.layout.activity_my_popupwindow, null);
        btn_register = (Button) myView.findViewById(R.id.btn_regiter);
        tv_signup = (TextView) myView.findViewById(R.id.tv_signup);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {

    }
}
