package com.example.dreamwest.picassoandglide.module.main.dao;

import android.os.AsyncTask;

import com.example.dreamwest.picassoandglide.base.ListviewCallback;
import com.example.dreamwest.picassoandglide.common.constant.Constant;
import com.example.dreamwest.picassoandglide.module.money.bean.MoneyJsonInfo;
import com.google.gson.Gson;

/**
 * Created by Administrator on 16-6-29.
 */
public class MoneyDao {
    /**
     * 访问得到赚钱页面对应的网络数据
     * 因为赚钱页面的网络接口加密了，所以这里用离线数据替代
     */
    public static void getMoneyData(final ListviewCallback listviewCallBack){

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                Gson gson = new Gson();
                MoneyJsonInfo taskGameInfo = gson.fromJson(Constant.GAME_TASK_LIST_JSON, MoneyJsonInfo.class);

                //把json数据解析成一个bean对象之后，通过回调，传给listview来更新条目
                listviewCallBack.updateListview(taskGameInfo.getInfo());
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();



    }
}
