package com.apparks.carouselsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by longdao on 13/03/16.
 */
public class PagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private CustomLinearLayout cur = null;
    private CustomLinearLayout next = null;
    private CustomLinearLayout nextnext = null;
    private CustomLinearLayout prepre = null;
    private CustomLinearLayout pre = null;
    private MainActivity context;
    private FragmentManager fm;
    private float scale;
    private float opacity;
    int pCount = 0;

    public PagerAdapter(MainActivity context, FragmentManager fm) {
        super(fm);
        this.fm = fm;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        // make the first pager bigger than others
        try {
            if (position == MainActivity.FIRST_PAGE) {
                scale = MainActivity.BIG_SCALE;
                opacity = MainActivity.FULL_OPACITY;
            } else if (position == (MainActivity.FIRST_PAGE + 1) || position == (MainActivity.FIRST_PAGE - 1)){
                scale = MainActivity.SMALL_SCALE;
                opacity = MainActivity.ALMOST_HALF_OPACITY;
            } else {
                scale = MainActivity.SMALL_SCALE;
                opacity = MainActivity.MINI_OPACITY;
            }

            position = position % MainActivity.count;

        } catch (Exception e) {
            // TODO: handle exception
        }
        return CustomFragment.newInstance(context, position, scale, opacity);
    }

    @Override
    public int getCount() {
        int count = 0;
        try {
            count = MainActivity.count * MainActivity.LOOPS;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return  count  ;
    }

    @Override
    public void onPageScrolled( int position, float positionOffset, int positionOffsetPixels){
        try {
            if (positionOffset >= 0f && positionOffset <= 2f) {
                cur = getRootView(position);
                next = getRootView(position + 1);
                nextnext = getRootView(position + 2);
                prepre = getRootView(position - 2);
                pre = getRootView(position - 1);

                cur.setScaleBoth(MainActivity.BIG_SCALE - MainActivity.DIFF_SCALE * positionOffset);
                cur.setAlpha(MainActivity.FULL_OPACITY - MainActivity.DIFF_OPACITY_1 * positionOffset);

                next.setScaleBoth(MainActivity.SMALL_SCALE + MainActivity.DIFF_SCALE * positionOffset);
                next.setAlpha(MainActivity.ALMOST_HALF_OPACITY + MainActivity.DIFF_OPACITY_1 * positionOffset);

                pre.setAlpha(MainActivity.ALMOST_HALF_OPACITY);
                nextnext.setAlpha(MainActivity.MINI_OPACITY + MainActivity.DIFF_OPACITY_2 * positionOffset);
                prepre.setAlpha(MainActivity.MINI_OPACITY);



                pCount++;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private CustomLinearLayout getRootView(int position) {
        return (CustomLinearLayout) fm.findFragmentByTag(this.getFragmentTag(position)).getView().findViewById(R.id.root);
    }

    private CustomLinearLayout getRootView2(int position) {
        return (CustomLinearLayout) fm.findFragmentByTag(this.getFragmentTag(position)).getView().findViewById(R.id.root);
    }

    private CustomLinearLayout getRootView3(int position) {
        return (CustomLinearLayout) fm.findFragmentByTag(this.getFragmentTag(position)).getView().findViewById(R.id.root);
    }

    private String getFragmentTag(int position) {
        return "android:switcher:" + context.pager.getId() + ":" + position;
    }
}
