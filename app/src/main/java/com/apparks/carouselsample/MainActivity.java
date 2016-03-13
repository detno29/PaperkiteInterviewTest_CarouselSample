package com.apparks.carouselsample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends FragmentActivity {
    public final static int LOOPS = 1000;
    public static int FIRST_PAGE; // = count * LOOPS / 2;
    public final static float BIG_SCALE = 1.0f;
    public final static float SMALL_SCALE = 0.5f;
    public final static float FULL_OPACITY = 1.0f;
    public final static float ALMOST_HALF_OPACITY = 0.4f;
    public final static float MINI_OPACITY = 0.05f;
    public final static float DIFF_OPACITY_1 = FULL_OPACITY - ALMOST_HALF_OPACITY;
    public final static float DIFF_OPACITY_2 = ALMOST_HALF_OPACITY - MINI_OPACITY;
    public final static float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;
    public PagerAdapter adapter;
    public PagerAdapter adapter2;
    public PagerAdapter adapter3;
    public ViewPager pager;
    public ViewPager pager2;
    public ViewPager pager3;
    /*** variables for the View */
    public int coverUrl[];
    public static int count;

    public static MainActivity mainActivityCtx;

    public static int currentPage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coverUrl = new int[] { R.drawable.icon0, R.drawable.icon1,
                R.drawable.icon2, R.drawable.icon3, R.drawable.icon4,
                R.drawable.icon5, R.drawable.icon6, R.drawable.icon7,
                R.drawable.icon8, R.drawable.icon9 };

        mainActivityCtx = this;
        pager = (ViewPager) findViewById(R.id.myviewpager);
        pager2 = (ViewPager) findViewById(R.id.myviewpager2);
        pager3 = (ViewPager) findViewById(R.id.myviewpager3);
        count = coverUrl.length;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = 0;
        pageMargin = (int) ((metrics.widthPixels / 4) *3);
        pager.setPageMargin(-1020);
        pager2.setPageMargin(-1020);
        pager3.setPageMargin(-1020);

        try {
            FIRST_PAGE = count * LOOPS / 2;

            adapter = new PagerAdapter(this, this.getSupportFragmentManager());
            pager.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            pager.setOnPageChangeListener(adapter);
            pager.setCurrentItem(FIRST_PAGE); // FIRST_PAGE
            pager.setOffscreenPageLimit(15);

            /*
            adapter2 = new PagerAdapter(this, this.getSupportFragmentManager());
            pager2.setAdapter(adapter2);
            //adapter.notifyDataSetChanged();
            //FIRST_PAGE = count * LOOPS / 2;
            pager2.setOnPageChangeListener(adapter2);
            pager2.setCurrentItem(FIRST_PAGE); // FIRST_PAGE
            pager2.setOffscreenPageLimit(15);

            adapter3 = new PagerAdapter(this, this.getSupportFragmentManager());
            pager3.setAdapter(adapter3);
            //adapter.notifyDataSetChanged();
            //FIRST_PAGE = count * LOOPS / 2;
            pager3.setOnPageChangeListener(adapter3);
            pager3.setCurrentItem(FIRST_PAGE); // FIRST_PAGE
            pager3.setOffscreenPageLimit(15);
            */
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
