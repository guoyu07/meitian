package com.app.everyday.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author：YJQ on 2016/1/12 13:23
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class EveryDayPagerAdapter extends FragmentPagerAdapter{

    private FragmentManager fm;
    private List<Fragment> fragmentList;
    public EveryDayPagerAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fm=fm;
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
