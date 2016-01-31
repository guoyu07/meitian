package com.app.everyday.activitys;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.app.everyday.imp.FragmentKeyEvent;
import com.app.everyday.utils.eventbus.EventBusUtils;

import butterknife.ButterKnife;


/**
 * 抽象基类
 * 功能描述
 * ①实现Onclicklistener子类都必须实现onclick
 * ②实现KeyEvent接口。用于子Fragment能够很优雅的处理按键点击事件
 */
public abstract class BaseActivity extends AppCompatActivity implements EventBusUtils.EventBusAsyc, FragmentKeyEvent {
    private LayoutInflater mInflater;
    protected abstract int getContentViewLayoutId();

    /**
     * Bind layout
     */
    protected abstract void initLayout();

    /**
     * init Logic
     */
    protected abstract void initLogic();

    public Activity mActivity;
    private String analyticsTitle = this.getClass().getSimpleName();

    public String getAnalyticsTitle() {
        return analyticsTitle;
    }

    public void setAnalyticsTitle(String analyticsTitle) {
        this.analyticsTitle = analyticsTitle;
    }

    public <T extends View> T getViewById(View rootView, int id) {
        return (T) rootView.findViewById(id);
    }

    public <T extends View> T getViewById(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //  initTheme();
        super.onCreate(savedInstanceState);
        setContentView(getContentViewLayoutId());
        ButterKnife.bind(this);
        initEventBus();
        //BaseApp.getInstance().addActivity(this);//加入统一堆栈

        mActivity = this;
        initLayout();
        initLogic();
    }

    private void initEventBus() {
        EventBusUtils.getInstance().initAsyc(this);
        EventBusUtils.getInstance().registerEventBus(this);
    }


    public View inflate(int resId) {
        if (null == mInflater) {
            mInflater = LayoutInflater.from(this);
        }
        return mInflater.inflate(resId, null);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //BaseApp.getInstance().finishActivity(this);
        ButterKnife.unbind(this);
        EventBusUtils.getInstance().unRegisterEventBus(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    public void onPause() {
        super.onPause();

    }


    /**
     * 实现KeyEvent接口。用于子Fragment能够很优雅的处理按键点击事件
     */
    private KeyEvent.Callback mKeyCallBacks;

    @Override
    public void registKeyEvent(KeyEvent.Callback event) {
        mKeyCallBacks = event;
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (mKeyCallBacks != null
                && mKeyCallBacks.onKeyLongPress(keyCode, event)) {
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        if (mKeyCallBacks != null
                && mKeyCallBacks.onKeyMultiple(keyCode, count, event)) {
            return true;
        }
        return super.onKeyMultiple(keyCode, count, event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mKeyCallBacks != null && mKeyCallBacks.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (mKeyCallBacks != null && mKeyCallBacks.onKeyUp(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

}
