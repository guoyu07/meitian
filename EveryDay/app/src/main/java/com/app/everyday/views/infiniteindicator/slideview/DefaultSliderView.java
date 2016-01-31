package com.app.everyday.views.infiniteindicator.slideview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.views.CircleImageView;


/**
 * a simple slider view, which just show an image. If you want to make your own slider view,
 *
 * just extend BaseSliderView, and implement getView() method.
 */
public class DefaultSliderView extends BaseSliderView{

    public ImageView mSlider_image;
    public CircleImageView mIv_avatar;
    public TextView mTv_author_name;
    public TextView mTv_title;
    public TextView mTv_count;
    public TextView mTv_current;
    public ProgressBar mLoading_bar;
    String slide_image;
    String avatar_url;
    String author_name;
    String title;
    String currentPage;
    String countPage;

    public DefaultSliderView(Context context, String slide_image, String avatar_url, String author_name, String title, String currentPage, String countPage) {
        super(context);
        this.slide_image = slide_image;
        this.avatar_url = avatar_url;
        this.author_name = author_name;
        this.title = title;
        this.currentPage = currentPage;
        this.countPage = countPage;
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_default,null);
        mSlider_image = (ImageView)v.findViewById(R.id.slider_image);
        mIv_avatar = (CircleImageView) v.findViewById(R.id.iv_avatar);
        mTv_author_name = (TextView) v.findViewById(R.id.tv_author_name);
        mTv_title = (TextView) v.findViewById(R.id.tv_title);
        mTv_count = (TextView) v.findViewById(R.id.tv_count);
        mTv_current = (TextView) v.findViewById(R.id.tv_current);
        ImageUtils.getInstance().loadWebImage(getContext(), mIv_avatar, avatar_url);
        mTv_author_name.setText(author_name);
        if(title.length()>13){
            mTv_title.setText(title.substring(0,13)+"...");
        }else {
            mTv_title.setText(title);
        }
        mTv_count.setText(countPage);
        mTv_current.setText(currentPage);
        bindEventAndShow(v, mSlider_image);
        return v;
    }
}
