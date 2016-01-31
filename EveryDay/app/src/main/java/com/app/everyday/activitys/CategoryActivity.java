package com.app.everyday.activitys;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.app.everyday.R;
import com.app.everyday.adapters.CategoryPagerAdapter;
import com.app.everyday.models.CategoryModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.DebugLog;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;
import com.app.everyday.utils.eventbus.EventBusTag;
import com.app.everyday.utils.eventbus.EventBusUtils;
import com.app.everyday.views.ColorAnimationView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/14 17:44
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class CategoryActivity extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_icon)
    ImageView ivIcon;
    @Bind(R.id.iv_defaulticon)
    ImageView ivDefaultIcon;
    @Bind(R.id.my_tablayout)
    TabLayout myTablayout;
    @Bind(R.id.layout_top)
    RelativeLayout layoutTop;
    @Bind(R.id.my_viewpager)
    ViewPager myViewpager;
    @Bind(R.id.ColorAnimationView)
    ColorAnimationView colorAnimationView;
    ArrayList<String> tabTitles = new ArrayList<String>();
    CategoryPagerAdapter categoryPagerAdapter;
    CategoryModel.ResultEntity resultEntity;
    EventBusModel eventBusModel;
    CategoryModel categoryModel;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case EventBusTag.CHANGE_CATEGORY_TOP:
                    eventBusModel = (EventBusModel) msg.obj;
                    CategoryModel.ResultEntity.CategoryGroupEntity categoryGroupEntity = (CategoryModel.ResultEntity.CategoryGroupEntity) eventBusModel.getModel();
                    //layoutTop.setBackgroundColor(Color.parseColor(categoryGroupEntity.getColor()));
                    ivDefaultIcon.setVisibility(View.VISIBLE);
                    ImageUtils.getInstance().loadWebImage(mActivity, ivIcon, categoryGroupEntity.getLargeIcon());
                    ivDefaultIcon.setVisibility(View.INVISIBLE);
                    //Glide.with(mActivity).load(categoryGroupEntity.getLargeIcon()).placeholder(R.mipmap.icon_default_category).into(ivIcon);
                    break;
            }
        }
    };


    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    protected void initLayout() {

        int CatagoryId = getIntent().getIntExtra("category", 0);
        try {
            categoryModel = ApiClient.getInstance().parserJsontoT(CategoryModel.class, Remember.getString("get_recommend2_data", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
        initTab();
        initViewPager();
        myViewpager.setAdapter(categoryPagerAdapter);
        //设置切换动画效果
        colorAnimationView.setmViewPager(myViewpager, categoryModel.getResult().size(),
                Color.parseColor(categoryModel.getResult().get(0).getCategoryGroup().getColor()),
                Color.parseColor(categoryModel.getResult().get(1).getCategoryGroup().getColor()),
                Color.parseColor(categoryModel.getResult().get(2).getCategoryGroup().getColor()),
                Color.parseColor(categoryModel.getResult().get(3).getCategoryGroup().getColor()),
                Color.parseColor(categoryModel.getResult().get(4).getCategoryGroup().getColor()));
        myTablayout.setupWithViewPager(myViewpager);
        myTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        myViewpager.setCurrentItem(CatagoryId);

    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {
        mHandler.sendMessage(mHandler.obtainMessage(ebModel.getType(), ebModel));
    }

    public void initTab() {
        String[] tabs = new String[]{"风尚", "美食", "家居", "旅游", "格物"};
        for (String tab : tabs) {
            tabTitles.add(tab);
        }
        myTablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //DebugLog.e("yjqTab"+String.valueOf(myTablayout.getId()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void initViewPager() {
        categoryPagerAdapter = new CategoryPagerAdapter(getSupportFragmentManager(), tabTitles);
        myViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resultEntity = categoryModel.getResult().get(position);
                CategoryModel.ResultEntity.CategoryGroupEntity groupEntity = resultEntity.getCategoryGroup();
                EventBusUtils.getInstance().postEventBus(EventBusTag.CHANGE_CATEGORY_TOP, groupEntity, "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
