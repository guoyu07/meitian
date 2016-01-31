package com.app.everyday.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @title 在scrollView 中也能显示全的GridView
 */
public class CompleteGridView extends GridView{
    public CompleteGridView(Context context, AttributeSet attrs) {
          super(context, attrs); 
      } 
   
      public CompleteGridView(Context context) {
          super(context); 
      } 
   
      public CompleteGridView(Context context, AttributeSet attrs, int defStyle) {
          super(context, attrs, defStyle); 
      } 
   
      @Override 
      public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
   
          int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, 
                  MeasureSpec.AT_MOST); 
          super.onMeasure(widthMeasureSpec, expandSpec); 
      } 
}