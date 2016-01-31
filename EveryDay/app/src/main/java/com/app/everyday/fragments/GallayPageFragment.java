package com.app.everyday.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.everyday.R;
import com.app.everyday.models.HomeModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author：YJQ on 2016/1/15 14:13
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class GallayPageFragment extends BaseFragment {

    @Bind(R.id.iv_home)
    ImageView ivHome;

    public static GallayPageFragment getInstance(Bundle bundle) {
        GallayPageFragment gallayPageFragment = new GallayPageFragment();
        gallayPageFragment.setArguments(bundle);
        return gallayPageFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_gallay_page;
    }

    @Override
    protected void initLayout() {
        try {
            HomeModel homeModel = ApiClient.getInstance().parserJsontoT(HomeModel.class, Remember.getString("getdayData2", ""));
            ImageUtils.getInstance().loadWebImage(mActivity,ivHome,homeModel.getResult().get(getArguments().getInt("position")).getImage().get(0).getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
