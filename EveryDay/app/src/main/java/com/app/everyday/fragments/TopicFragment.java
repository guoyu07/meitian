package com.app.everyday.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

import com.app.everyday.R;
import com.app.everyday.adapters.ListViewDifferentTypeAdapter;
import com.app.everyday.models.TopicModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/11 18:28
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class TopicFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeLayout;
    @Bind(R.id.lv_topic)
    ListView lvTopic;
    private ArrayList<TopicModel.ResultEntity.ActivityEntity> activityEntities = new ArrayList<TopicModel.ResultEntity.ActivityEntity>();
    private ArrayList<TopicModel.ResultEntity.PostEntity> postEntities = new ArrayList<TopicModel.ResultEntity.PostEntity>();
    private ArrayList<TopicModel.ResultEntity.UserEntity> userEntities = new ArrayList<TopicModel.ResultEntity.UserEntity>();
    private ListViewDifferentTypeAdapter listViewDifferentTypeAdapter;
    Bundle bundle;
    public static TopicFragment getInstance(Bundle bundle) {
        TopicFragment topicFragment = new TopicFragment();
        topicFragment.setArguments(bundle);
        return topicFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_topic;
    }

    @Override
    protected void initLayout() {
        initData();
        mSwipeLayout.setOnRefreshListener(this);
        mSwipeLayout.setColorSchemeResources(
                android.R.color.holo_red_light,android.R.color.holo_red_dark);
        listViewDifferentTypeAdapter = new ListViewDifferentTypeAdapter(mActivity, activityEntities, postEntities, userEntities, bundle);
        lvTopic.setAdapter(listViewDifferentTypeAdapter);

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

    public void initData() {
        //获取数据
        try {
            //分别记录一下数据条数，方便listview 展示不同的item 用
            TopicModel topicModel1 = ApiClient.getInstance().parserJsontoT(TopicModel.class, Remember.getString("topic_data1", ""));
            TopicModel topicModel2 = ApiClient.getInstance().parserJsontoT(TopicModel.class, Remember.getString("topic_data2", ""));
            TopicModel topicModel3 = ApiClient.getInstance().parserJsontoT(TopicModel.class, Remember.getString("topic_data3", ""));
            bundle = new Bundle();
            bundle.putInt("TYPE1_COUNT", topicModel1.getResult().size());
            bundle.putInt("TYPE2_COUNT", topicModel2.getResult().size());
            bundle.putInt("TYPE3_COUNT", topicModel3.getResult().size());
            //封装Api1数据
            for (TopicModel.ResultEntity resultEntity : topicModel1.getResult()) {
                activityEntities.add(resultEntity.getActivity());
            }
            //封装Api3数据
            for (TopicModel.ResultEntity resultEntity : topicModel3.getResult()) {
                activityEntities.add(resultEntity.getActivity());
                postEntities.add(resultEntity.getPost());
                userEntities.add(resultEntity.getUser());
            }
            //封装Api2数据
            for (TopicModel.ResultEntity resultEntity : topicModel2.getResult()) {
                activityEntities.add(resultEntity.getActivity());
            }
            //此处 Api2数据，放在集合最后
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
