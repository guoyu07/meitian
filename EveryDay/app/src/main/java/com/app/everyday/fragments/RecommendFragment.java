package com.app.everyday.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.activitys.CategoryActivity;
import com.app.everyday.adapters.RecommendAdapter;
import com.app.everyday.models.CategoryModel;
import com.app.everyday.models.RecommendModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;
import com.app.everyday.views.CircleImageView;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/11 18:27
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class RecommendFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    //head
    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeLayout;

    private FrameLayout mLayout_head;
    private ImageView mIv_head;
    private TextView mTv_title;
    private TextView mTv_catagory_name;
    private TextView mTv_author_name;
    private LinearLayout layoutCategory;
    RecommendAdapter recommendAdapter;
    ArrayList<RecommendModel.ResultEntity> resultEntities = new ArrayList<RecommendModel.ResultEntity>();
    @Bind(R.id.lv_recommend)
    ListView lvRecommend;

    public static RecommendFragment getInstance(Bundle bundle) {
        RecommendFragment recommendFragment = new RecommendFragment();
        recommendFragment.setArguments(bundle);
        return recommendFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initLayout() {
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(
                android.R.color.holo_red_light, android.R.color.holo_red_dark);
        initHeadView();
        initData();

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

    public void initHeadView() {
        View view = inflater.inflate(R.layout.activity_recommend_head, null);
        bindHeadViews(view);
        RecommendModel recommendModel;
        try {
            recommendModel = ApiClient.getInstance().parserJsontoT(RecommendModel.class, Remember.getString("get_recommend1_data", ""));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        ImageUtils.getInstance().loadWebImage(mActivity, mIv_head, recommendModel.getResult().get(0).getImage().get(0).getUrl());
        mTv_title.setText(recommendModel.getResult().get(0).getArticle().getTitle());
        mTv_catagory_name.setText(recommendModel.getResult().get(0).getCategory().getName());
        mTv_author_name.setText(recommendModel.getResult().get(0).getAuthor().getName());
        lvRecommend.addHeaderView(view);
    }

    public void initData() {
        try {
            RecommendModel recommendModel = ApiClient.getInstance().parserJsontoT(RecommendModel.class, Remember.getString("get_recommend3_data", ""));
            for (RecommendModel.ResultEntity resultEntity : recommendModel.getResult()) {
                resultEntities.add(resultEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        recommendAdapter = new RecommendAdapter(mActivity, resultEntities);
        lvRecommend.setAdapter(recommendAdapter);


    }

    private void bindHeadViews(View view) {
        mLayout_head = (FrameLayout) view.findViewById(R.id.layout_head);
        mIv_head = (ImageView) view.findViewById(R.id.iv_head);
        mTv_title = (TextView) view.findViewById(R.id.tv_title);
        mTv_catagory_name = (TextView) view.findViewById(R.id.tv_catagory_name);
        mTv_author_name = (TextView) view.findViewById(R.id.tv_author_name);
        layoutCategory = (LinearLayout) view.findViewById(R.id.layout_category);
        try {
            CategoryModel categoryModel = ApiClient.getInstance().parserJsontoT(CategoryModel.class, Remember.getString("get_recommend2_data", ""));
            initCatrgory(categoryModel);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void initCatrgory(CategoryModel categoryModel) {
        if(categoryModel.getResult().size()==0){
            return;
        }
        for (int i = 0; i < categoryModel.getResult().size(); i++) {
            RelativeLayout relativeLayout = new RelativeLayout(mActivity);
            relativeLayout.setId(i);
            //宽度：0;高度：充满;权重1
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, RelativeLayout.LayoutParams.MATCH_PARENT, 1);
            //设置RelativeLayout size
            relativeLayout.setLayoutParams(layoutParams);
            FrameLayout frameLayout = new FrameLayout(mActivity);
            //FrameLayout size
            RelativeLayout.LayoutParams layoutParamsfra = new RelativeLayout.LayoutParams(100, 100);
            layoutParamsfra.addRule(RelativeLayout.CENTER_IN_PARENT);
            frameLayout.setLayoutParams(layoutParamsfra);
            //设置背景图
            CircleImageView circleImageView1 = new CircleImageView(mActivity);
            circleImageView1.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER));
            ImageUtils.getInstance().loadWebImage(mActivity, circleImageView1, categoryModel.getResult().get(i).getCategoryGroup().getImage());
            CircleImageView circleImageView2 = new CircleImageView(mActivity);
            circleImageView2.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER));
            ImageUtils.getInstance().loadWebImage(mActivity, circleImageView2, categoryModel.getResult().get(i).getCategoryGroup().getLargeIcon());
            frameLayout.addView(circleImageView1);
            frameLayout.addView(circleImageView2);
            //添加title
            TextView textView = new TextView(mActivity);
            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
            layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.setMargins(0,0,0,20);
            textView.setLayoutParams(layoutParams1);
            textView.setText(categoryModel.getResult().get(i).getCategoryGroup().getName());
            textView.setTextColor(getResources().getColor(R.color.grey_500));
            textView.setTextSize(12);
            relativeLayout.addView(frameLayout);
            relativeLayout.addView(textView);
            layoutCategory.addView(relativeLayout);
            //category 点击事件
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mActivity, CategoryActivity.class);
                    intent.putExtra("category", v.getId());
                    startActivity(intent);
                }
            });
        }
    }
}

