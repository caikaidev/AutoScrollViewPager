package com.kcode.autoscrollviewpager.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.kcode.autoscrollviewpager.R;

/**
 * Created by caik on 2016/10/17.
 */

public class AutoScrollViewPager extends RelativeLayout {

    private final static String LEFT_POINT = "left";
    private final static String RIGHT_POINT = "right";
    private final static String CENTER_POINT = "center";

    private final static int RIGHT_INT = 0;
    private final static int CENTER_INT = 1;
    private final static int LEFT_INT = 2;

    private int pointLayout;

    private AutoViewPager mViewPager;

    private Context mContext;

    private LinearLayout layout;

    public AutoScrollViewPager(Context context) {
        super(context);
        init(context);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoScrollViewPager, defStyleAttr, 0);

        String pointLayoutStr = typedArray.getString(R.styleable.AutoScrollViewPager_point_layout);
        switch (pointLayoutStr) {
            case LEFT_POINT:
                pointLayout = LEFT_INT;
                break;
            case RIGHT_POINT:
                pointLayout = RIGHT_INT;
                break;
            case CENTER_POINT:
                pointLayout = CENTER_INT;
                break;
            default:
                break;
        }

        typedArray.recycle();

        init(context);

    }

    private void init(Context context) {
        mContext = context;
        mViewPager = new AutoViewPager(context);
        layout = new LinearLayout(mContext);
        addView(mViewPager);
    }

    public void setAdapter(BaseViewPagerAdapter adapter) {
        if (mViewPager != null) {
            mViewPager.init(mViewPager, adapter);
        }
    }

    public AutoViewPager getViewPager() {
        return mViewPager;
    }

    public void initPointView(int size) {

        layout = new LinearLayout(mContext);
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.leftMargin = 8;
            params.gravity = Gravity.CENTER;
            imageView.setLayoutParams(params);
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

            layout.addView(imageView);
        }

        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(ALIGN_PARENT_BOTTOM);
        switch (pointLayout) {
            case RIGHT_INT:
                layoutParams.addRule(ALIGN_PARENT_RIGHT);
                break;
            case LEFT_INT:
                layoutParams.addRule(ALIGN_PARENT_LEFT);
                break;
            case CENTER_INT:
                layoutParams.addRule(CENTER_HORIZONTAL);
                break;
            default:
                layoutParams.addRule(ALIGN_PARENT_RIGHT);
                break;
        }


        layoutParams.setMargins(12, 20, 12, 20);
        layout.setLayoutParams(layoutParams);
        addView(layout);
    }


    public void updatePointView(int position) {
        int size = layout.getChildCount();
        for (int i = 0; i < size; i++) {
            ImageView imageView = (ImageView) layout.getChildAt(i);
            if (i == position) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

        }
    }

    public void onDestroy() {
        if (mViewPager != null) {
            mViewPager.onDestroy();
        }
    }

}
