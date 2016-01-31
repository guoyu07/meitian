package com.app.everyday.views.Scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Author：YJQ on 2016/1/18 11:51
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class SlidingMenu extends ScrollView {
    private int mScreenHeight;
    private ScrollViewPageOne scrollViewPageOne;
    private ScrollViewPageTwo scrollViewPageTwo;
    private boolean isSetted = false;
    private boolean ispageOne = true;

    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        mScreenHeight = metrics.heightPixels;//得到屏幕的宽度(像素)
    }

    public SlidingMenu(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isSetted) {

            final LinearLayout wrapper = (LinearLayout) getChildAt(0);
            scrollViewPageOne = (ScrollViewPageOne) wrapper.getChildAt(0);
            scrollViewPageTwo = (ScrollViewPageTwo) wrapper.getChildAt(1);
            //设置两个子View的高度为手机的高度
            scrollViewPageOne.getLayoutParams().height = mScreenHeight;
            scrollViewPageTwo.getLayoutParams().height = mScreenHeight;
            isSetted = true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            this.scrollTo(0, 0);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:

                int scrollY = getScrollY();
                int creteria = mScreenHeight / 5;//滑动多少距离，可以实现页面的切换
                if (ispageOne) {
                    if (scrollY <= creteria) {
                        //当滑动的距离小于creteria ,留在该view
                        this.smoothScrollTo(0, 0);//回到原位置
                    } else {
                        this.smoothScrollTo(0, mScreenHeight);
                        //this.setFocusable(false);
                        ispageOne = false;
                    }
                } else {
                    int scrollpadding = mScreenHeight - scrollY;
                    if (scrollpadding >= creteria) {
                        this.smoothScrollTo(0, 0);
                        ispageOne = true;
                    } else {
                        this.smoothScrollTo(0, mScreenHeight);
                    }
                }

                return true;
        }
        return super.onTouchEvent(ev);
    }


    public void closeMenu() {
        if (ispageOne) return;
        this.smoothScrollTo(0, 0);
        ispageOne = true;
    }

    public void openMenu() {
        if (!ispageOne) return;
        this.smoothScrollTo(0, mScreenHeight);
        ispageOne = false;
    }

    /**
     * 打开和关闭菜单
     */
    public void toggleMenu() {
        if (ispageOne) {
            openMenu();
        } else {
            closeMenu();
        }
    }


}
