package com.kcode.autoscrollviewpager.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kcode.autoscrollviewpager.R;

import static com.kcode.autoscrollviewpager.R.id.pointLayout;

/**
 * Created by caik on 2016/10/17.
 */

public class AutoScrollViewPager extends RelativeLayout {

    private final static String RIGHT_POINT = "right";
    private final static String CENTER_POINT = "center";

    private final static int RIGHT_INT = 0;
    private final static int CENTER_INT = 1;

    private AutoViewPager mViewPager;

    private Context mContext;

    private LinearLayout layout;
    private View view;//底部文字和小圆点
    private TextView mSubTitle;//标题文字

    public TextView getSubTitle() {
        return mSubTitle;
    }

    public AutoViewPager getViewPager() {
        return mViewPager;
    }

    public AutoScrollViewPager(Context context) {
        this(context,null);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public AutoScrollViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AutoScrollViewPager, defStyleAttr, 0);
        String pointLayoutStr = typedArray.getString(R.styleable.AutoScrollViewPager_point_layout);
        switch (pointLayoutStr) {
            case RIGHT_POINT:
                view = LayoutInflater.from(context).inflate(R.layout.point_right_text,null);
                break;
            case CENTER_POINT:
                view = LayoutInflater.from(context).inflate(R.layout.point_center_text,null);
                break;
            default:
                view = LayoutInflater.from(context).inflate(R.layout.point_center_text,null);
                break;
        }

        typedArray.recycle();

        init(context);

    }

    private void init(Context context) {
        mContext = context;
        mViewPager = new AutoViewPager(context);
        addView(mViewPager);

        if (view != null) {
            mSubTitle = (TextView) view.findViewById(R.id.subTitle);
            layout = (LinearLayout) view.findViewById(pointLayout);
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(ALIGN_PARENT_BOTTOM);
            view.setLayoutParams(params);
            addView(view);
        }

    }

    public void setAdapter(BaseViewPagerAdapter adapter) {
        if (mViewPager != null) {
            mViewPager.init(mViewPager, adapter);
        }
    }

    public void initPointView(int size) {
        initPointView(size,0);
    }

    public void initPointView(int size,int currentPoint) {

        layout.removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.leftMargin = 8;
            imageView.setLayoutParams(params);
            if (i == currentPoint) {
                imageView.setBackgroundResource(R.drawable.point_checked);
            } else {
                imageView.setBackgroundResource(R.drawable.point_normal);
            }

            layout.addView(imageView);
        }
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

    public void onResume(){
        if (mViewPager != null && !mViewPager.isStart()) {
            mViewPager.start();
        }
    }

    public void onPause(){
        if (mViewPager != null) {
            mViewPager.onStop();
        }
    }

}
