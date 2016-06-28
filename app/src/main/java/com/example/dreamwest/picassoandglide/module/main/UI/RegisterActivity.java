package com.example.dreamwest.picassoandglide.module.main.UI;

import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dreamwest.picassoandglide.R;
import com.example.dreamwest.picassoandglide.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    private TextView tv_agreement_register;
    private Button btn_verifycode;
    private int duration = 12;

    @Override
    protected int setViewID() {
        return R.layout.activity_register;
    }

    @Override
    protected void findView() {
        tv_agreement_register = (TextView) findViewById(R.id.tv_agreement_register);
        btn_verifycode = (Button) findViewById(R.id.btn_verifycode_register);
        btn_verifycode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_verifycode.setClickable(false);
                new CountDownTimer(duration*1000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        duration--;
                        btn_verifycode.setText(duration+" s");
                    }

                    @Override
                    public void onFinish() {
                        btn_verifycode.setClickable(true);
                        duration = 12;
                        btn_verifycode.setText("重新获取");
                    }
                }.start();
            }
        });
        tv_agreement_register.setMovementMethod(new LinkMovementMethod());

        String strAgree = "我已阅读并接受注册协议";
        //把原始字符串封装到SpannableString里面去，以便增加超连接功能
        SpannableString spannableString = new SpannableString(strAgree);
        //第一个参数:点击链接时候的监听
        //第2-3个参数，超链接文字的起始和结束位置
        //第四个参数，标示增加的是超链接功能
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(RegisterActivity.this,"adcd",Toast.LENGTH_SHORT).show();
            }
        }, 7, strAgree.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_agreement_register.setText(strAgree);
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
