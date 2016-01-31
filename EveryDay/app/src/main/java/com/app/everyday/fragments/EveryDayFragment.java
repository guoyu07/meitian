package com.app.everyday.fragments;

import android.os.Bundle;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

/**
 * Author：YJQ on 2016/1/11 16:30
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class EveryDayFragment extends BaseFragment {
    public static EveryDayFragment getInstance(Bundle bundle) {
        EveryDayFragment everyDayFragment = new EveryDayFragment();
        everyDayFragment.setArguments(bundle);
        return everyDayFragment;
    }


    @Override
    protected int getContentView() {
        return R.layout.fragment_every_day;
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

   /* public void initViewPager() {
        Bundle bundle = new Bundle();
        billboardFragment = BillboardFragment.getInstance(bundle);
        everyDayGallayFragment = EveryDayGallayFragment.getInstance(bundle);
        historyFragment = HistoryFragment.getInstance(bundle);
        fragmentList.add(billboardFragment);
        fragmentList.add(everyDayGallayFragment);
        fragmentList.add(historyFragment);
        myPagerAdapter = new EveryDayPagerAdapter(getChildFragmentManager(), fragmentList);
        myViewpager.setAdapter(myPagerAdapter);
        //设置ViewPager在垂直方向上滑动
        myViewpager.setOrientation(DirectionalViewPager.VERTICAL);
        myViewpager.setCurrentItem(1);

    }*/


}
