package com.app.everyday.fragments;

import android.os.Bundle;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

/**
 * Author：YJQ on 2016/1/11 18:29
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class ShoppingFragment extends BaseFragment{

    public static ShoppingFragment getInstance(Bundle bundle){
        ShoppingFragment shoppingFragment=new ShoppingFragment();
        shoppingFragment.setArguments(bundle);
        return shoppingFragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_shopping;
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
