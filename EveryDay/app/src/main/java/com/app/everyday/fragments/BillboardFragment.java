package com.app.everyday.fragments;

import android.os.Bundle;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

/**
 * Author：YJQ on 2016/1/12 13:31
 * Eamil：yujiaqi@fenzotech.com
 * Description:排行榜
 */
public class BillboardFragment extends BaseFragment{

    public static BillboardFragment getInstance(Bundle bundle){
        BillboardFragment billboardFragment=new BillboardFragment();
        billboardFragment.setArguments(bundle);
        return billboardFragment;
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_billboard;
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
}
