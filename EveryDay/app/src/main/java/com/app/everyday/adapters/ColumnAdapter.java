package com.app.everyday.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.app.everyday.R;
import com.app.everyday.models.ColumnModel;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.utils.commonadapter.BGAAdapterViewAdapter;
import com.app.everyday.utils.commonadapter.BGAViewHolderHelper;

/**
 * Author：YJQ on 2016/1/17 17:39
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class ColumnAdapter  extends BGAAdapterViewAdapter<ColumnModel.ResultEntity>{

    private Context mContext;
    private int itemLayoutId;

    public ColumnAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
        this.mContext=context;
    }

    @Override
    protected void fillData(BGAViewHolderHelper viewHolderHelper, int position, ColumnModel.ResultEntity model) {
        if(model!=null){
            ImageView imageView = viewHolderHelper.getView(R.id.iv_avatar);
            ImageUtils.getInstance().loadWebImage(mContext, imageView,model.getAuthor().getImage());
            viewHolderHelper.setText(R.id.tv_author_name,model.getAuthor().getName());
            viewHolderHelper.setText(R.id.tv_title,model.getAuthor().getIntroduction());

        }

    }
}
