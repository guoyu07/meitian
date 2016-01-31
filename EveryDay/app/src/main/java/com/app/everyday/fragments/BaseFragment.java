package com.app.everyday.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.everyday.utils.DebugLog;
import com.app.everyday.utils.eventbus.EventBusUtils;

import butterknife.ButterKnife;

/**
 * Author：YJQ on 2016/1/11 18:00
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */

public abstract class BaseFragment extends Fragment implements EventBusUtils.EventBusAsyc{
    public ViewGroup rootView;
    public LayoutInflater inflater;

    /**
     * @return Activity layout resource
     */
    protected abstract int getContentView();

    /**
     * Bind layout
     */
    protected abstract void initLayout();

    /**
     * init Logic
     */
    protected abstract void initLogic();

    public Activity mActivity;

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(getContentView(), container, false);
        // Inject views after inflating and just before init layout. This way every child fragment follows correct sequence
        ButterKnife.bind(this, rootView);
        this.inflater=inflater;
        initEventBus();
        initLayout();
        initLogic();
        return rootView;
    }

    private void initEventBus() {
        EventBusUtils.getInstance().initAsyc(this);
        EventBusUtils.getInstance().registerEventBus(this);
    }

    public <T extends View> T getViewById(View rootView, int id) {
        return (T) rootView.findViewById(id);
    }

    @Override
    public void onResume() {
        super.onResume();
        DebugLog.e("Fragment开始：" + ((Object) this).getClass().getSimpleName());

    }

    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusUtils.getInstance().unRegisterEventBus(this);
    }
}
