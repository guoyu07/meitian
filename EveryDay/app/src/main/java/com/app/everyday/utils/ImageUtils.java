package com.app.everyday.utils;

import android.content.Context;
import android.widget.ImageView;

import com.app.everyday.R;
import com.bumptech.glide.Glide;

/**
 * Author：YJQ on 2016/1/13 15:32
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class ImageUtils {
    private volatile static ImageUtils instance;

    public static ImageUtils getInstance(){
        if(instance==null){
            synchronized (ImageUtils.class){
                if(instance==null){
                    instance = new ImageUtils();
                }
            }
        }
        return instance;
    }




    public void loadWebImage(Context context, ImageView imageView, String assetPath) {
        try {
            DebugLog.e("image path:====>" + assetPath);
            //ImageAware imageAware = new ImageViewAware(imageView,false);
            //ImageLoader.getInstance().displayImage(assetPath,imageAware);
            Glide.with(context).load(assetPath).placeholder(R.mipmap.logo).dontAnimate().into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
