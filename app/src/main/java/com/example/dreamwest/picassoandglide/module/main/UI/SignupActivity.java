package com.example.dreamwest.picassoandglide.module.main.UI;

import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dreamwest.picassoandglide.R;
import com.example.dreamwest.picassoandglide.base.BaseActivity;
import com.example.dreamwest.picassoandglide.base.NetCallback;
import com.example.dreamwest.picassoandglide.common.constant.Constant;
import com.example.dreamwest.picassoandglide.common.net.HttpNet;
import com.example.dreamwest.picassoandglide.module.main.bean.Login_Info;
import com.google.gson.Gson;
import com.se7en.utils.SystemUtil;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends BaseActivity {
    private long last = 0;
    private EditText et_pwd_signup;
    private EditText et_user_signup;
    private Button btn_signup;
    private CheckBox checkbox_signup;

    @Override
    protected int setViewID() {
        return R.layout.activity_signup;
    }

    @Override
    protected void findView() {
        et_user_signup = (EditText) findViewById(R.id.et_user_signup);
        et_pwd_signup = (EditText) findViewById(R.id.et_pwd_signup);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        checkbox_signup = (CheckBox) findViewById(R.id.checkbox_signup);

    }

    private void doInLogin(String strResult) {
        Gson gson = new Gson();
        Login_Info login_info = gson.fromJson(strResult, Login_Info.class);
        String state = login_info.getState();
        if ("success".equals(state)) {
            Toast.makeText(SignupActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            //如果登录成功，并且勾选了下次自动登录,则记录这种状态
            //下次欢迎页面结束后，直接进入主界面，不在出现红包页面
            if (checkbox_signup.isChecked()){
                SystemUtil.setSharedBoolean(Constant.LOGIN_FLAG,true);
            }else{
                SystemUtil.setSharedBoolean(Constant.LOGIN_FLAG,false);
            }

            //登录成功后，显示主页面，并销毁当前页面
            Intent intent = new Intent();
            intent.setClass(SignupActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            SystemUtil.setSharedBoolean(Constant.LOGIN_FLAG,false);
            Log.d("TAG","登录失败");
        }
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initEvent() {
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = et_user_signup.getText().toString();
                String strPwd = et_pwd_signup.getText().toString();
                strPwd = new String(Base64.encode(strPwd.getBytes(), Base64.DEFAULT));
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", strUser);
                params.put("password", strPwd);
                Log.d("TAG", "strUser:" + strUser);
                Log.d("TAG", "strPwd:" + strPwd);
                HttpNet.doHttpRequest("POST", Constant.LOGIN_POST, params, new NetCallback() {
                    @Override
                    public void success(String strResult) {
                        Log.d("TAG", "网络请求成功");
                        doInLogin(strResult);
                    }

                    @Override
                    public void fail(String strMsg) {
                        Log.d("TAG", "网络请求失败:" + strMsg);
                    }
                });
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long current = System.currentTimeMillis();
            if (current - last > 2000) {
                Toast.makeText(SignupActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                last = current;
            } else {
                finish();
            }
        } else {
            return super.onKeyDown(keyCode, event);
        }
        return false;
    }
}
