package com.app.everyday.fragments;

import android.os.Bundle;
import android.widget.ListView;

import com.app.everyday.R;
import com.app.everyday.models.CategoryModel;
import com.app.everyday.utils.ApiClient;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.eventbus.EventBusModel;
import com.app.everyday.utils.eventbus.EventBusTag;
import com.app.everyday.utils.eventbus.EventBusUtils;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/14 18:28
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class CategoryFragment extends BaseFragment {

    CategoryModel.ResultEntity resultEntity;


   @Bind(R.id.listView)
    ListView myListView;

    public static CategoryFragment getInstance(Bundle bundle) {
        CategoryFragment categoryFragment = new CategoryFragment();
        categoryFragment.setArguments(bundle);
        return categoryFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_category;
    }

    @Override
    protected void initLayout() {
        try {
            CategoryModel categoryModel= ApiClient.getInstance().parserJsontoT(CategoryModel.class, Remember.getString("get_recommend2_data", ""));

            resultEntity=categoryModel.getResult().get(getArguments().getInt("position"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }

    public void initTop(){
         CategoryModel.ResultEntity.CategoryGroupEntity groupEntity=resultEntity.getCategoryGroup();
         //通知CatagoryActivity
         EventBusUtils.getInstance().postEventBus(EventBusTag.CHANGE_CATEGORY_TOP,groupEntity,"");

    }


}


































































