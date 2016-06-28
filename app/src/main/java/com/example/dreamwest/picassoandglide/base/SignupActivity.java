package com.example.dreamwest.picassoandglide.base;

import android.inputmethodservice.Keyboard;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dreamwest.picassoandglide.R;
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

    @Override
    protected int setViewID() {
        return R.layout.activity_signup;
    }

    @Override
    protected void findView() {
        et_user_signup = (EditText) findViewById(R.id.et_user_signup);
        et_pwd_signup = (EditText) findViewById(R.id.et_pwd_signup);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = et_user_signup.getText().toString();
                String strPwd = et_pwd_signup.getText().toString();
               strPwd =  new String(Base64.encode(strPwd.getBytes(),Base64.DEFAULT));
                Map<String, String> params = new HashMap<String, String>();
                params.put("username",strUser);
                params.put("password",strPwd);
                Log.d("TAG","strUser:"+strUser);
                Log.d("TAG","strPwd:"+strPwd);
                HttpNet.doHttpRequest("POST", Constant.LOGIN_POST, params, new NetCallback() {
                    @Override
                    public void success(String strResult) {
                        Log.d("TAG","网络请求成功");
                        Gson gson = new Gson();
                        Login_Info login_info = gson.fromJson(strResult, Login_Info.class);
                        String state = login_info.getState();
                        if("success".equals(state)){
                            Toast.makeText(SignupActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                            Log.d("TAG","登录成功");
                            Log.d("TAG","strResult :"+strResult);
                        }else{
                            Log.d("TAG","登录失败 : "+state);
                            Log.d("TAG","strResult : "+strResult);
                        }
                    }
                    @Override
                    public void fail(String strMsg) {
                        Log.d("TAG","网络请求失败:"+strMsg);
                    }
                });
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            long current = System.currentTimeMillis();
            if(current - last > 2000){
                Toast.makeText(SignupActivity.this,"再按一次退出",Toast.LENGTH_SHORT).show();
                last = current;
            }else{
                finish();
            }
        }else{
            return super.onKeyDown(keyCode, event);
        }
        return false;
    }
}
