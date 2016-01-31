package com.app.everyday.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.adapters.ColumnAdapter;
import com.app.everyday.models.ColumnModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.DebugLog;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;
import com.app.everyday.views.CircleImageView;
import com.app.everyday.views.CompleteGridView;
import com.app.everyday.views.infiniteindicator.InfiniteIndicatorLayout;
import com.app.everyday.views.infiniteindicator.slideview.BaseSliderView;
import com.app.everyday.views.infiniteindicator.slideview.DefaultSliderView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/11 16:30
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class ColumnFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeLayout;
    @Bind(R.id.indicator_default_circle)
    InfiniteIndicatorLayout mDefaultIndicator;
    @Bind(R.id.mygridview)
    CompleteGridView myGridview;
    @Bind(R.id.iv_mine)
    ImageView ivMine;
    ArrayList<ColumnModel.ResultEntity> resultEntities = new ArrayList<ColumnModel.ResultEntity>();
    ColumnAdapter columnAdapter;

    public static ColumnFragment getInstance(Bundle bundle) {
        ColumnFragment columnFragment = new ColumnFragment();
        columnFragment.setArguments(bundle);
        return columnFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_column;
    }

    @Override
    protected void initLayout() {
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(
                android.R.color.holo_red_light,android.R.color.holo_red_dark);
        try {
            ColumnModel columnModel = ApiClient.getInstance().parserJsontoT(ColumnModel.class, Remember.getString("getcomumnData1", ""));
            for (ColumnModel.ResultEntity resultEntity : columnModel.getResult()) {
                resultEntities.add(resultEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initindicatorDefault();
        columnAdapter=new ColumnAdapter(mActivity,R.layout.item_column);
        columnAdapter.setDatas(resultEntities);
        myGridview.setAdapter(columnAdapter);

    }

    @Override
    protected void initLogic() {

    }
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeLayout.setRefreshing(false);
            }
        }, 3000);
    }
    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }

    public void initindicatorDefault() {


        for (int i=0;i< resultEntities.size();i++) {

            DefaultSliderView textSliderView = new DefaultSliderView(mActivity,
                    resultEntities.get(i).getAuthor().getImage(),
                    resultEntities.get(i).getAuthor().getAvatar(),
                    resultEntities.get(i).getAuthor().getName(),
                    resultEntities.get(i).getAuthor().getIntroduction(),
                    String.valueOf(i+1),
                    String.valueOf(resultEntities.size())
            );
            textSliderView
                    .image(resultEntities.get(i).getAuthor().getImage())
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .showImageResForEmpty(R.mipmap.default_banner_cover)
                    .showImageResForError(R.mipmap.default_banner_cover)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {

                        }
                    });
           /* textSliderView.getBundle()
                    .putString("extra",name);*/
            mDefaultIndicator.addSlider(textSliderView);
        }
        mDefaultIndicator.setIndicatorPosition(InfiniteIndicatorLayout.IndicatorPosition.Center_Bottom);
        mDefaultIndicator.setInterval(5000);
        mDefaultIndicator.startAutoScroll();
    }

    @Override
    public void onPause() {
        super.onPause();
        mDefaultIndicator.stopAutoScroll();
    }

}
