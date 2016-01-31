package com.app.everyday.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/11 16:30
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class FindFragment extends BaseFragment {


    RecommendFragment recommendFragment;
    ShoppingFragment shoppingFragment;
    TopicFragment topicFragment;
    @Bind(R.id.iv_find_search)
    ImageView ivFindSearch;
    @Bind(R.id.my_tablayout)
    TabLayout myTablayout;
    @Bind(R.id.iv_user)
    ImageView ivUser;
    @Bind(R.id.my_viewpager)
    ViewPager myViewpager;
    private List<Fragment> list_fragment = new ArrayList<>();
    private List<String> list_Title = new ArrayList<>();
    private SimpleFragmentPagerAdapter pagerAdapter;

    private static boolean Flag=true;
    public static FindFragment getInstance(Bundle bundle) {
        FindFragment findFragment = new FindFragment();
        findFragment.setArguments(bundle);
        return findFragment;
    }


    @Override
    protected int getContentView() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initLayout() {
        //初始化子Fragment

        initDatas();


    }
    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }

    public void initDatas(){
        list_fragment.add(new RecommendFragment());
        list_fragment.add(new TopicFragment());
        list_fragment.add(new ShoppingFragment());
        list_Title.add("推荐");
        list_Title.add("话题");
        list_Title.add("闪购");
        pagerAdapter = new SimpleFragmentPagerAdapter(getChildFragmentManager());
        myViewpager.setAdapter(pagerAdapter);
        myTablayout.setupWithViewPager(myViewpager);
        myTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        public SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }

        @Override
        public int getCount() {
            return list_fragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list_Title.get(position);
        }

    }

}
