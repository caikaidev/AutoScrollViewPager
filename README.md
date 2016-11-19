##AutoViewPager
![轮播图.gif](http://upload-images.jianshu.io/upload_images/1715403-cbf7c309b85e2770.gif?imageMogr2/auto-orient/strip)

##Download

Gradle:

in module's build.gradle,use:

```
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
```

replace:

```
    repositories {
        jcenter()
    }
```

in app's build.gradle,add:

```
compile 'com.kcode.github:autoScrollViewPager:1.0.1'
```

##Usage
* in layout

    ```
        <com.kcode.autoscrollviewpager.view.AutoScrollViewPager
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="220dp">
            
        </com.kcode.autoscrollviewpager.view.AutoScrollViewPager>
    ```


* in activity:
    
    ```
        package com.kcode.autoviewpager;
        
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ImageView;
        import android.widget.Toast;
        
        import com.kcode.autoscrollviewpager.view.AutoScrollViewPager;
        import com.kcode.autoscrollviewpager.view.BaseViewPagerAdapter;
        import com.kcode.autoviewpager.bean.Picture;
        import com.squareup.picasso.Picasso;
        
        import java.util.ArrayList;
        import java.util.List;
        
        public class MainActivity extends AppCompatActivity {
        
            private AutoScrollViewPager mViewPager;
        
            private String[] paths = {"https://ss3.baidu.com/-fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=c493b482b47eca800d053ee7a1229712/8cb1cb1349540923abd671df9658d109b2de49d7.jpg",
                    "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=45fbfa5555da81cb51e684cd6267d0a4/2f738bd4b31c8701491ea047237f9e2f0608ffe3.jpg",
                    "https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=ae0e95c0fc1986185e47e8847aec2e69/0b46f21fbe096b63eb314ef108338744ebf8ac62.jpg",
                    "https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=1fad2b46952397ddc9799f046983b216/dc54564e9258d109c94bbb13d558ccbf6d814de2.jpg",
                    "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D200/sign=ff0999f6d4160924c325a51be406359b/86d6277f9e2f070861ccd4a0ed24b899a801f241.jpg"};
        
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
        
                mViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
                mViewPager.setAdapter(new BaseViewPagerAdapter<String>(this,initData(),listener) {
                    @Override
                    public void loadImage(ImageView view, int position, String url) {
                        Picasso.with(MainActivity.this).load(url).into(view);
                    }
                });
            }
        
            private List<String> initData() {
                List<String> data = new ArrayList<>();
                Picture picture ;
                for (int i = 0 ; i < paths.length ;i++){
                    data.add(paths[i]);
                }
                return data;
            }
        
            @Override
            protected void onDestroy() {
                super.onDestroy();
                mViewPager.onDestroy();
            }
        
            private BaseViewPagerAdapter.OnAutoViewPagerItemClickListener listener = new BaseViewPagerAdapter.OnAutoViewPagerItemClickListener<Picture>() {
        
                @Override
                public void onItemClick(int position, Picture picture) {
                    Toast.makeText(getApplicationContext(),
        
                            picture.getName(), Toast.LENGTH_SHORT).show();
                }
            };
        }
    
    
    ```


    Override```public void loadImage(ImageView view, int position, String url)``` to load image to ImageView.


* OnClick

    
    ```
    private BaseViewPagerAdapter.OnAutoViewPagerItemClickListener listener = new BaseViewPagerAdapter.OnAutoViewPagerItemClickListener<String>() {
    
            @Override
            public void onItemClick(int position, String url) {
                Toast.makeText(getApplicationContext(),
    
                        url, Toast.LENGTH_SHORT).show();
            }
        };
    ```

    init OnClickListener

    ```
    public BaseViewPagerAdapter(Context context, List<T> data,OnAutoViewPagerItemClickListener listener)
    
    ```

* PointLayout
    add ```xmlns:app="http://schemas.android.com/apk/res-auto"``` to layout file. And ,
     user ```app:point_layout="right|center"```.
sample:[AutoViewPager](https://github.com/fccaikai/AutoScrollViewPager/tree/master/app)


