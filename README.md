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
compile 'com.kcode.github:autoScrollViewPager:0.1.0'
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
	private AutoViewPager mViewPager;
    private PictureViewPagerAdapter mAdapter;
    private AutoScrollViewPager autoScrollViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoScrollViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
        mViewPager = autoScrollViewPager.getViewPager();
        mAdapter = new PictureViewPagerAdapter(getApplicationContext(),initData(),mViewPager, listener);

    }
    
    private List<Picture> initData() {
        List<Picture> data = new ArrayList<>();
        Picture picture ;
        for (int i = 0 ; i < paths.length ;i++){
            picture = new Picture(paths[i],"图片" + i);
            data.add(picture);
        }
        return data;
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewPager.onDestroy();
    }
```

you must create Adapter extends BaseViewPagerAdapter< T> ,like this

```
package com.kcode.autoviewpager;

/**
 * Created by caik on 2016/10/11.
 */

public class PictureViewPagerAdapter extends BaseViewPagerAdapter<Picture> implements ViewPager.OnPageChangeListener{


    private Context mContext;

    public PictureViewPagerAdapter(Context context, AutoViewPager viewPager) {
        super(context,viewPager);
        mContext = context;
    }

    public PictureViewPagerAdapter(Context context, AutoViewPager viewPager, OnAutoViewPagerItemClickListener listener) {
        super(context, viewPager, listener);
        this.mContext = context;
    }

    @Override
    public void loadImage(ImageView view, int position, Picture picture) {
        Picasso.with(mContext).load(picture.getPath()).into(view);
    }

    public PictureViewPagerAdapter(Context context, List<Picture> data, AutoViewPager viewPager, OnAutoViewPagerItemClickListener listener) {
        super(context, data, viewPager, listener);
        this.mContext = context;
    }
}

```

Picture.java

```

public class Picture {
    private String path;
    private String name;

    public Picture(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

there, I extends BaseViewPagerAdapter< Picture>,you can extends BaseViewPagerAdapter< String>,like [ViewPagerAdapter.java](https://github.com/fccaikai/AutoScrollViewPager/blob/master/app/src/main/java/com/kcode/autoviewpager/ViewPagerAdapter.java)


Override```public void loadImage(ImageView view, int position, String url)``` to load image to ImageView.

* OnClick

```
private BaseViewPagerAdapter.OnAutoViewPagerItemClickListener listener = new BaseViewPagerAdapter.OnAutoViewPagerItemClickListener<Picture>() {

        @Override
        public void onItemClick(int position, Picture picture) {
            Toast.makeText(getApplicationContext(),

                    picture.getName(), Toast.LENGTH_SHORT).show();
        }
    };
```

init OnClickListener

```
mAdapter = new PictureViewPagerAdapter(getApplicationContext(),initData(),mViewPager, listener);

```

sample:[AutoViewPager](https://github.com/fccaikai/AutoScrollViewPager/tree/master/app)


