package com.app.everyday.activitys;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.datas.Constants;
import com.app.everyday.fragments.ColumnFragment;
import com.app.everyday.fragments.EveryDayFragment;
import com.app.everyday.fragments.FindFragment;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.DebugLog;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cz.msebera.android.httpclient.Header;
import frenchtoast.FrenchToast;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    /**
     * UI
     */
    @Bind(R.id.frame_content)
    FrameLayout frameContent;

    @Bind(R.id.layout_every_day)
    RelativeLayout layoutEveryDay;
    @Bind(R.id.layout_find)
    RelativeLayout layoutFind;
    @Bind(R.id.layout_column)
    RelativeLayout layoutColumn;


    Fragment[] fragments;
    EveryDayFragment everyDayFragment;
    ColumnFragment columnFragment;
    FindFragment findFragment;
    @Bind(R.id.iv_every_day)
    ImageView ivEveryDay;
    @Bind(R.id.iv_find)
    ImageView ivFind;
    @Bind(R.id.iv_column)
    ImageView ivColumn;
    @Bind(R.id.tv_every_day)
    TextView tvEveryDay;
    @Bind(R.id.tv_find)
    TextView tvFind;
    @Bind(R.id.tv_column)
    TextView tvColumn;
    @Bind(R.id.line1)
    View line1;
    @Bind(R.id.line2)
    View line2;
    @Bind(R.id.line3)
    View line3;
    @Bind(R.id.iv_mine)
    ImageView ivMine;
    @Bind(R.id.right_menu)
    FrameLayout rightMenu;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    private int currentPage = 1;
    //right ment
    @Bind(R.id.layout_recommend)
    RelativeLayout layoutRecommend;
    //share layout
    @Bind(R.id.layout_share)
    RelativeLayout layoutShare;
    @Bind(R.id.iv_weibo)
    ImageView ivWeibo;
    @Bind(R.id.iv_circle)
    ImageView ivCircle;
    @Bind(R.id.iv_wechat)
    ImageView ivWechat;
    @Bind(R.id.iv_qzone)
    ImageView ivQzone;
    @Bind(R.id.iv_qq)
    ImageView ivQq;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLayout() {
        layoutEveryDay.setOnClickListener(this);
        layoutFind.setOnClickListener(this);
        layoutColumn.setOnClickListener(this);
        rightMenu.setOnClickListener(this);
        ivMine.setOnClickListener(this);
        layoutRecommend.setOnClickListener(this);
        layoutShare.setOnClickListener(this);
        initDrawlayout();

        Bundle bundle = new Bundle();

        everyDayFragment = EveryDayFragment.getInstance(bundle);
        columnFragment = ColumnFragment.getInstance(bundle);
        findFragment = FindFragment.getInstance(bundle);
        fragments = new Fragment[]{everyDayFragment, findFragment, columnFragment};
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //添加fragment,并且隐藏
        for (Fragment fragment : fragments) {
            if (!fragment.isAdded()) {
                transaction.add(R.id.frame_content, fragment).hide(fragment);
            }
        }
        //默认显示第一个
        transaction.show(fragments[0]).commit();
        setSelector(layoutEveryDay);
    }

    @Override
    protected void initLogic() {
        getDayData();
        getRecommendData();
        getComumnData();
    }

    @Override
    public void onClick(View v) {
        setSelector(v);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (v.getId()) {
            case R.id.layout_every_day:
                switchContent(transaction, fragments[0]);
                currentPage = 1;
                break;
            case R.id.layout_find:
                switchContent(transaction, fragments[1]);
                currentPage = 2;
                //发起网络请求 获取数据
                getTopicData();
                break;
            case R.id.layout_column:
                switchContent(transaction, fragments[2]);
                currentPage = 3;
                break;
            case R.id.iv_mine:
                drawer_layout.openDrawer(rightMenu);
                break;
            case R.id.layout_recommend:
                //分享 动画
                layoutShare.setVisibility(View.VISIBLE);
                shareAnimationLayout();
                break;
            case R.id.layout_share:
                layoutShare.setVisibility(View.GONE);
                break;
        }
        transaction.commit();
    }

    public void initDrawlayout() {
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED); //关闭手势滑动
        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                switch (currentPage) {
                    case 1:
                        layoutEveryDay.performClick();
                        break;
                    case 2:
                        layoutFind.performClick();
                        break;
                    case 3:
                        layoutColumn.performClick();
                        break;
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); //打开手势滑动
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED); //关闭手势滑动

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        boolean drawerState = drawer_layout.isDrawerOpen(rightMenu);
        if (drawerState) {
            drawer_layout.closeDrawers();
            return;
        }
        //也就是说，当按下返回功能键的时候，不是直接对Activity进行弹栈，而是先将菜单视图关闭
        super.onBackPressed();
    }


    public void setSelector(View selector) {
        ivEveryDay.setSelected(layoutEveryDay.getId() == selector.getId());
        ivFind.setSelected(layoutFind.getId() == selector.getId());
        ivColumn.setSelected(layoutColumn.getId() == selector.getId());
        tvEveryDay.setSelected(layoutEveryDay.getId() == selector.getId());
        tvFind.setSelected(layoutFind.getId() == selector.getId());
        tvColumn.setSelected(layoutColumn.getId() == selector.getId());
        switch (selector.getId()) {
            case R.id.layout_every_day:
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                break;
            case R.id.layout_find:
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.VISIBLE);
                line3.setVisibility(View.GONE);
                break;
            case R.id.layout_column:
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.VISIBLE);
                break;
        }
    }


    @Override
    public void onEventAsync(EventBusModel ebModel) {
    }

    /**
     * 切换fragment
     */
    public void switchContent(FragmentTransaction transaction, Fragment fragment) {
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame_content, fragment);
        } else {
            transaction.show(fragment);
        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     */
    private void hideFragments(FragmentTransaction transaction) {
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                transaction.hide(fragment);
            }
        }
    }


    public void shareAnimationLayout() {
        List<ImageView> imageViewList = new ArrayList<ImageView>();
        imageViewList.add(ivWeibo);
        imageViewList.add(ivCircle);
        imageViewList.add(ivWechat);
        imageViewList.add(ivQq);
        imageViewList.add(ivQzone);
        for (int i = 0; i < imageViewList.size(); i++) {
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator objectAnimator;
            if (i == 3 || i == 4) {
                objectAnimator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0, -680);
            } else {
                objectAnimator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0, -800);
            }
            set.playTogether(objectAnimator);
            set.setDuration(500);
            /**
             *  AccelerateDecelerateInterpolator 在动画开始与介绍的地方速率改变比较慢，在中间的时候加速

             AccelerateInterpolator  在动画开始的地方速率改变比较慢，然后开始加速

             AnticipateInterpolator 开始的时候向后然后向前甩

             AnticipateOvershootInterpolator 开始的时候向后然后向前甩一定值后返回最后的值

             BounceInterpolator   动画结束的时候弹起

             CycleInterpolator 动画循环播放特定的次数，速率改变沿着正弦曲线

             DecelerateInterpolator 在动画开始的地方快然后慢

             LinearInterpolator   以常量速率改变

             OvershootInterpolator    向前甩一定值后再回到原来位置
             */
            set.setInterpolator(new OvershootInterpolator());
            if (i == 3 || i == 4) {
                set.setStartDelay(100);
            }
            set.start();
        }

    }
    /**.................................................................................................................................................................................*/
    public void getTopicData() {
        ApiClient.getInstance().send(mActivity, Constants.API_TOPIC_TOP, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("topic_data1", data);
                    DebugLog.e("请求#话题数据1Success" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");

                    DebugLog.e("请求话题数据1Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "10");

        //请求#往期话题数据 start
        ApiClient.getInstance().send(mActivity, Constants.API_TOPIC_TWO, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("topic_data2", data);
                    DebugLog.e("请求#往期话题数据onSuccess" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("请求#往期话题数据Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "10");
        //请求#往期话题数据 end

        ApiClient.getInstance().send(mActivity, Constants.API_TOPIC_Three, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("topic_data3", data);
                    DebugLog.e("请求话题数据3onSuccess" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("topic_data3", data);
                    DebugLog.e("请求话题数据3Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "10");

    }

    /**
     * 获取推荐模块数据
     */

    public void getRecommendData() {
        /**Top*/
        ApiClient.getInstance().send(mActivity, Constants.API_RECOMMEND_ONE, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("get_recommend1_data", data);
                    DebugLog.e("推荐数据1Success" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("推荐数据1Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "1");

        ApiClient.getInstance().send(mActivity, Constants.API_RECOMMEND_TWO, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("get_recommend2_data", data);
                    DebugLog.e("推荐数据2Success" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("推荐数据2Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "");
        /**bottom*/
        ApiClient.getInstance().send(mActivity, Constants.API_RECOMMEND_THREE, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("get_recommend3_data", data);
                    DebugLog.e("推荐数据3Success" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("推荐数据3Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "50");
    }

    public void getDayData() {

        ApiClient.getInstance().send(mActivity, Constants.API_DAY_TWO, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("getdayData2", data);
                    DebugLog.e("yjq" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "50");
    }

    //获取专栏数据
    public void getComumnData() {

        ApiClient.getInstance().send(mActivity, Constants.API_Comumn_ONE, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String data = new String(responseBody, "utf-8");
                    Remember.putString("getcomumnData1", data);
                    DebugLog.e("yjq" + data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    String data = new String(responseBody, "utf-8");
                    DebugLog.e("Failure" + data + error);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null, "");
    }


}
