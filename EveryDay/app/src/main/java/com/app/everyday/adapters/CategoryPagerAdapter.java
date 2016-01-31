package com.app.everyday.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.everyday.fragments.CategoryFragment;

import java.util.ArrayList;

/**
 * Author：YJQ on 2016/1/14 18:21
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter{
    ArrayList<String> tabTitles;

    public CategoryPagerAdapter(FragmentManager fm, ArrayList<String> tabTitles) {
        super(fm);
        this.tabTitles=tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        bundle.putInt("position",position);
        return CategoryFragment.getInstance(bundle);

    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}

