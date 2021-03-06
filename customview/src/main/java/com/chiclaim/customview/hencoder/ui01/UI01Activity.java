package com.chiclaim.customview.hencoder.ui01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.chiclaim.android.base.BaseActivity;
import com.chiclaim.customview.R;


/**
 * Description：
 * <br/>
 * Created by kumu on 2017/8/3.
 */

public class UI01Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_01_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }


    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private String[] titles = new String[]{"DrawColor", "DrawCircle", "DrawRect", "DrawRoundRect",
                "DrawPoint", "DrawOval", "DrawLine", "DrawArc", "DrawPath", "直方图", "饼状图"};

        MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            return UI01Fragment.newInstance(bundle);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
