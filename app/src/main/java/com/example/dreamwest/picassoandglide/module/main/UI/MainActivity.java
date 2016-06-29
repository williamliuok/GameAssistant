package com.example.dreamwest.picassoandglide.module.main.UI;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;

import com.example.dreamwest.picassoandglide.R;
import com.example.dreamwest.picassoandglide.base.BaseActivity;
import com.example.dreamwest.picassoandglide.common.widget.BoottomMenuView;
import com.example.dreamwest.picassoandglide.module.guess.UI.GuessFragment;
import com.example.dreamwest.picassoandglide.module.home.UI.HomeFragment;
import com.example.dreamwest.picassoandglide.module.money.UI.MoneyFragment;
import com.example.dreamwest.picassoandglide.module.my.UI.MyFragment;
import com.example.dreamwest.picassoandglide.module.shop.UI.ShopFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private BoottomMenuView bottommenu1;
    private BoottomMenuView bottommenu2;
    private BoottomMenuView bottommenu3;
    private BoottomMenuView bottommenu4;
    private BoottomMenuView bottommenu5;
    private BoottomMenuView lastone;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private MoneyFragment moneyFragment;
    private GuessFragment guessFragment;
    private ShopFragment shopFragment;
    private MyFragment myFragment;
    private Fragment lastfragment;
    public static MainActivity mainActivity;


    @Override
    protected int setViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void findView() {
        bottommenu1 = (BoottomMenuView) findViewById(R.id.bottommenu_1);
        bottommenu2 = (BoottomMenuView) findViewById(R.id.bottommenu_2);
        bottommenu3 = (BoottomMenuView) findViewById(R.id.bottommenu_3);
        bottommenu4 = (BoottomMenuView) findViewById(R.id.bottommenu_4);
        bottommenu5 = (BoottomMenuView) findViewById(R.id.bottommenu_5);

    }

    @Override
    protected void init() {
        mainActivity = this;
        //默认设置进入后,选择了底部菜单项中的首页选项
        lastone = bottommenu1;
        lastone.onSelected();
        //初始化Fragment
        homeFragment = new HomeFragment();
        moneyFragment = new MoneyFragment();
        guessFragment = new GuessFragment();
        shopFragment = new ShopFragment();
        myFragment = new MyFragment();
        lastfragment = homeFragment;
        //开启事务，默认进入后的Fragment为homeFragment
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, myFragment);
        transaction.hide(myFragment);
        transaction.add(R.id.fragment_container, shopFragment);
        transaction.hide(shopFragment);
        transaction.add(R.id.fragment_container, guessFragment);
        transaction.hide(guessFragment);
        transaction.add(R.id.fragment_container, moneyFragment);
        transaction.hide(moneyFragment);
        transaction.add(R.id.fragment_container, homeFragment);
        transaction.commit();
    }

    @Override
    protected void initEvent() {
        bottommenu1.setOnClickListener(this);
        bottommenu2.setOnClickListener(this);
        bottommenu3.setOnClickListener(this);
        bottommenu4.setOnClickListener(this);
        bottommenu5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //不是连续点击才执行反向动画
        if (v != lastone) {
            lastone.unSelected();
        }
        //再次开启事务，根据点击的选项来替换掉当前Fragment
        transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.bottommenu_1:
                lastone = bottommenu1;
                bottommenu1.onSelected();
                if (!(lastfragment instanceof HomeFragment)) {
                    transaction.hide(lastfragment);
                }
                lastfragment = homeFragment;
                transaction.show(homeFragment);
                break;
            case R.id.bottommenu_2:
                lastone = bottommenu2;
                bottommenu2.onSelected();
                if (!(lastfragment instanceof MoneyFragment)) {
                    transaction.hide(lastfragment);
                    moneyFragment.showPopupWindow();
                }
                lastfragment = moneyFragment;
                transaction.show(moneyFragment);
                break;
            case R.id.bottommenu_3:
                lastone = bottommenu3;
                bottommenu3.onSelected();
                if (!(lastfragment instanceof GuessFragment)) {
                    transaction.hide(lastfragment);
                }
                lastfragment = guessFragment;
                transaction.show(guessFragment);
                break;
            case R.id.bottommenu_4:
                lastone = bottommenu4;
                bottommenu4.onSelected();
                if (!(lastfragment instanceof ShopFragment)) {
                    transaction.hide(lastfragment);
                }
                lastfragment = shopFragment;
                transaction.show(shopFragment);
                break;
            case R.id.bottommenu_5:
                lastone = bottommenu5;
                bottommenu5.onSelected();
                if (!(lastfragment instanceof MyFragment)) {
                    transaction.hide(lastfragment);
                }
                lastfragment = myFragment;
                transaction.show(myFragment);
                break;
        }
        transaction.commit();

    }

    @Override
    protected void loadData() {

    }


}
