package com.app.everyday.fragments;

import android.os.Bundle;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

/**
 * Author：YJQ on 2016/1/12 13:32
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class EveryDayGallayFragment extends BaseFragment {

    public static EveryDayGallayFragment getInstance(Bundle bundle) {
        EveryDayGallayFragment everyDayGallayFragment = new EveryDayGallayFragment();
        everyDayGallayFragment.setArguments(bundle);
        return everyDayGallayFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_gallay;
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
