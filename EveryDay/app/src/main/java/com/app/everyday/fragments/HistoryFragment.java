package com.app.everyday.fragments;

import android.os.Bundle;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

/**
 * Author：YJQ on 2016/1/12 13:32
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class HistoryFragment extends BaseFragment{

    public static HistoryFragment getInstance(Bundle bundle){
        HistoryFragment historyFragment=new HistoryFragment();
        historyFragment.setArguments(bundle);
        return historyFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initLayout() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }
}
