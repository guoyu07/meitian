package com.app.everyday;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.app.everyday.datas.Constants;
import com.app.everyday.models.UserInfo;
import com.app.everyday.utils.FileUtil;
import com.app.everyday.utils.Remember;
import com.app.everyday.utils.UnCeHandler;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;
import java.util.Stack;

import frenchtoast.FrenchToast;

/**
 * Author：YJQ on 2016/1/12 23:06
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class BaseApp extends Application {
    private static BaseApp instance;
    private UserInfo mUserInfo;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        FrenchToast.install(this);
        //LitePalApplication.initialize(this);
        FileUtil.createMustFolder(this, Constants.ROOT_DIR_NAME, new String[]{Constants.TEMP_DIR_NAME, Constants.FILE_DIR_NAME, Constants.IMAGE_DIR_NAME});
        Remember.init(this, Constants.ROOT_DIR_NAME);
        mUserInfo = Remember.getObject(Constants.PRE_USER, UserInfo.class);
        init();//崩溃抑制
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
                .Builder(this)
                .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new UnlimitedDiskCache(new File(FileUtil.getFilePath(Constants.IMAGE_DIR_NAME)))) // 设置图片缓存的路径
                        //.diskCache(new UnlimitedDiskCache() // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(1200)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .imageDecoder(new BaseImageDecoder(true)) // default
                .defaultDisplayImageOptions(getImageLoaderConfig())
                .build();//开始构建
        ImageLoader.getInstance().init(configuration);
    }
    public DisplayImageOptions getImageLoaderConfig() {
        //显示图片的配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.logo)
                .showImageOnFail(R.mipmap.logo)
                .displayer(new SimpleBitmapDisplayer())
                .cacheInMemory(false)//设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.NONE)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }

    public void init(){
        //设置该CrashHandler为程序的默认处理器
        UnCeHandler catchExcep = new UnCeHandler(this);
        Thread.setDefaultUncaughtExceptionHandler(catchExcep);
    }

    public static BaseApp getInstance() {
        return instance;
    }


    private static Stack<Activity> activityStack;


    public static Activity getBeforActivity() {
        Activity activity;
        try {
            activity = activityStack.get(1);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return activity;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
//            activityStack.iterator().remove();
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public boolean findActivity(Class<?> cls) {
        boolean isCreate = false;
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                isCreate = true;
            } else {
                isCreate = false;
            }
        }
        return isCreate;
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束所有Activity 除了当前Activity
     */
    public void finishAllActivity(Activity activity) {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (activity != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

    public int getCurrentActivitySize() {
        return activityStack.size();
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        Remember.putObject(Constants.PRE_USER, userInfo);
        this.mUserInfo = userInfo;
    }



}
