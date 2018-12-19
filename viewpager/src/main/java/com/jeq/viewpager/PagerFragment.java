package com.jeq.viewpager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jeq.viewpager.fragment.FirstFragment;
import com.jeq.viewpager.fragment.MessageFragment;
import com.jeq.viewpager.fragment.MyFragment;
import com.jeq.viewpager.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerFragment extends Fragment {

    private View view;
    private ViewPager pager;
    private BottomNavigationView bottomV;
    private List<Fragment> fragments;
    private MyFragment myFragment;
    private MessageFragment messageFragment;
    private NewsFragment newsFragment;
    private FirstFragment firstFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.pager, container, false);
        init();
        return view;
    }

    private void init() {

        pager = view.findViewById(R.id.viewpager);
        bottomV = view.findViewById(R.id.bottomv);

        fragments = new ArrayList<>();
        firstFragment = new FirstFragment();
        newsFragment = new NewsFragment();
        messageFragment = new MessageFragment();
        myFragment = new MyFragment();

        fragments.add(firstFragment);
        fragments.add(newsFragment);
        fragments.add(messageFragment);
        fragments.add(myFragment);
        System.out.println("-----" + fragments.size());

        /*bottomV.setSelectedItemId(0);
        pager.setCurrentItem(0);*/


        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            @Override
            public Fragment getItem(int i) {
                return fragments.get(i);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        bottomV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                pager.setCurrentItem(menuItem.getOrder());
                bottomV.setItemIconTintList(null);

                    switch (menuItem.getOrder()){
                        case 0:
                            menuItem.setIcon(R.mipmap.first_y);
                            //return true;
                            break;
                        case 1:
                            menuItem.setIcon(R.mipmap.news_y);

                            //return true;
                            break;
                        case 2:
                            menuItem.setIcon(R.mipmap.message_y);
                            //return true;
                            break;
                        case 3:
                            menuItem.setIcon(R.mipmap.my_y);
                            //return true;
                            break;
                }


                return false;
            }
        });


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                bottomV.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
