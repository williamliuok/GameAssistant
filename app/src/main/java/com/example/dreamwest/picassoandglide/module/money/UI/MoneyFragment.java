package com.example.dreamwest.picassoandglide.module.money.UI;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.dreamwest.picassoandglide.R;
import com.example.dreamwest.picassoandglide.base.BaseFragment;
import com.example.dreamwest.picassoandglide.base.ListviewCallback;
import com.example.dreamwest.picassoandglide.common.adapter.CommonAdapter;
import com.example.dreamwest.picassoandglide.common.adapter.ViewHolder;
import com.example.dreamwest.picassoandglide.module.main.dao.MoneyDao;
import com.example.dreamwest.picassoandglide.module.money.bean.MoneyJsonInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-6-29.
 */
public class MoneyFragment extends BaseFragment {

    private View moneyView;
    private View myPopupView;
    private PopupWindow mPopupWindow;
    private ListView listView;
    private List<MoneyJsonInfo.InfoBean> mListGames;
    private CommonAdapter<MoneyJsonInfo.InfoBean> mAdapter;
    private boolean mbLoaded; //是否加载完数据
    private Button button;
    private View headerView;

    @Override
    protected int setViewID() {
        return R.layout.layout_fragment_money;
    }

    @Override
    protected void findView(View view) {
        myPopupView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_popupwindow_moneyfragment, null);
        moneyView = view;
        listView = (ListView) moneyView.findViewById(R.id.listVIew_money);
        headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_header_listview, null);

    }

    public void showPopupWindow() {
        if (!mbLoaded && (mPopupWindow == null)) {
            mPopupWindow = new PopupWindow(myPopupView, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, false);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            mPopupWindow.showAtLocation(moneyView, Gravity.CENTER, 0, 0);
            setAlph(0.5f);
            mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    setAlph(1);
                }
            });
        }
    }

    @Override
    protected void init() {
        listView.addHeaderView(headerView);
        mListGames = new ArrayList<>();
        mAdapter = new CommonAdapter<MoneyJsonInfo.InfoBean>(getActivity(),
                mListGames,
                R.layout.layout_listview) {
            @Override
            public void convert(ViewHolder helper, int position, MoneyJsonInfo.InfoBean item) {
                helper.setText(R.id.tv_title, item.getPlatform_name());
                helper.setImageByUrl(R.id.imageView, item.getAd_img(), getActivity());
                helper.setRating(R.id.ratingBar, Integer.parseInt(item.getRank()));
                helper.setText(R.id.button,item.getReward());
                helper.setText(R.id.tv_content,item.getDesc());
            }
        };
        listView.setAdapter(mAdapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void loadData() {
        MoneyDao.getMoneyData(new ListviewCallback() {
            @Override
            public void updateListview(Object object) {
                List<MoneyJsonInfo.InfoBean> datas = (List<MoneyJsonInfo.InfoBean>) object;
                mListGames.addAll(datas);
                mAdapter.notifyDataSetChanged();
                mbLoaded = true;

                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                    mPopupWindow = null;
                }

            }
        });
    }

    public void setAlph(float v) {
        Activity activity = getActivity();
        Window window = activity.getWindow();
        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = v;
        getActivity().getWindow().setAttributes(params);
    }
}
