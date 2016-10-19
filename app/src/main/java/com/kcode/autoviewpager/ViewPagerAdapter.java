package com.kcode.autoviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.kcode.autoscrollviewpager.view.AutoViewPager;
import com.kcode.autoscrollviewpager.view.BaseViewPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by caik on 2016/10/11.
 */

public class ViewPagerAdapter extends BaseViewPagerAdapter<String> implements ViewPager.OnPageChangeListener{


    private Context mContext;

    public ViewPagerAdapter(Context context, AutoViewPager viewPager) {
        super(context,viewPager);
        mContext = context;
    }

    public ViewPagerAdapter(Context context, AutoViewPager viewPager, OnAutoViewPagerItemClickListener listener) {
        super(context, viewPager, listener);
        this.mContext = context;
    }

    public ViewPagerAdapter(Context context, List<String> data, AutoViewPager viewPager, OnAutoViewPagerItemClickListener listener) {
        super(context, data, viewPager, listener);
        this.mContext = context;
    }

    @Override
    public void loadImage(ImageView view, int position, String url) {
        Picasso.with(mContext).load(url).into(view);
    }
}
