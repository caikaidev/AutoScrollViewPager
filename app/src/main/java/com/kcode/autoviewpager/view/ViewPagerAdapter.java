package com.kcode.autoviewpager.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kcode.autoviewpager.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caik on 2016/10/11.
 */

public class ViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{

    private List<String> urls = new ArrayList<>();

    private Context mContext;
    private AutoViewPager mView;

    public ViewPagerAdapter(List<String> urls) {
        this.urls = urls;
    }

    public ViewPagerAdapter(Context context,AutoViewPager viewPager) {
        this.mContext = context;
        mView = viewPager;
        mView.setAdapter(this);
        mView.addOnPageChangeListener(this);
        mView.setCurrentItem(0);
    }

    public void add(String path){
        urls.add(path);
        notifyDataSetChanged();
        mView.updatePointView(getRealCount());
    }

    @Override
    public int getCount() {
        return urls == null ? 0 : Integer.MAX_VALUE;
    }

    public int getRealCount(){
        return urls == null ? 0 : urls.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView view = (ImageView) LayoutInflater.from(mContext)
                .inflate(R.layout.imageview,container,false);
        Picasso.with(mContext).load(urls.get(position % getRealCount())).into(view);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mView.onPageSelected(position % getRealCount());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
