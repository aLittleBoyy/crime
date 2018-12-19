package com.jeq.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleActivity extends AppCompatActivity {

    public abstract Fragment onCreateFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_total);
        if (fragment == null){
            fragment = onCreateFragment();
            manager.beginTransaction().add(R.id.fragment_total, fragment).commit();

        }

    }


}
