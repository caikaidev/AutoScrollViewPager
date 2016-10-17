package com.kcode.autoviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kcode.autoviewpager.view.AutoScrollViewPager;
import com.kcode.autoviewpager.view.AutoViewPager;
import com.kcode.autoviewpager.view.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private AutoViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    private AutoScrollViewPager autoScrollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
        mViewPager = autoScrollViewPager.getViewPager();
        mAdapter = new ViewPagerAdapter(getApplicationContext(),mViewPager);

        mAdapter.add("https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=c493b482b47eca800d053ee7a1229712/8cb1cb1349540923abd671df9658d109b2de49d7.jpg");
        mAdapter.add("https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=45fbfa5555da81cb51e684cd6267d0a4/2f738bd4b31c8701491ea047237f9e2f0608ffe3.jpg");
        mAdapter.add("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=ae0e95c0fc1986185e47e8847aec2e69/0b46f21fbe096b63eb314ef108338744ebf8ac62.jpg");

        mViewPager.start();
        mAdapter.add("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=1fad2b46952397ddc9799f046983b216/dc54564e9258d109c94bbb13d558ccbf6d814de2.jpg");
        mAdapter.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=ff0999f6d4160924c325a51be406359b/86d6277f9e2f070861ccd4a0ed24b899a801f241.jpg");
    }


}
