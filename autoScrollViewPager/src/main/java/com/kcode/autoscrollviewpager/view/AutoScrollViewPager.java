package com.kcode.autoscrollviewpager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.kcode.autoscrollviewpager.R;

import static android.view.Gravity.CENTER;

/**
 * Created by caik on 2016/10/17.
 */

public class AutoScrollViewPager extends RelativeLayout{

    private AutoViewPager mViewPager;

    private Context mContext;

    private LinearLayout layout;

    public AutoScrollViewPager(Context context) {
        super(context);
        init(context);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        mContext = context;
        mViewPager = new AutoViewPager(context);
        layout = new LinearLayout(mContext);
        addView(mViewPager);
    }

    public AutoViewPager getViewPager() {
        return mViewPager;
    }

    public void initPointView(int size){

        layout = new LinearLayout(mContext);
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            params.leftMargin = 8;
            params.gravity = CENTER;
            imageView.setLayoutParams(params);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            }else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

            layout.addView(imageView);
        }

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(ALIGN_PARENT_RIGHT);
        layoutParams.setMargins(12,20,12,20);
        layout.setLayoutParams(layoutParams);
        addView(layout);
    }

    public void updatePointView(int position) {
        int size = layout.getChildCount();
        for (int i = 0; i < size; i++) {
            ImageView imageView = (ImageView) layout.getChildAt(i);
            if (i == position){
                imageView.setBackgroundResource(R.drawable.point_checked);
            }else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

        }
    }

}
