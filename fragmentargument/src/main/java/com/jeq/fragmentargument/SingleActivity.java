package com.jeq.fragmentargument;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        onCtrateFragment();
    }

    private void onCtrateFragment() {

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.frag);

        if (fragment == null){
            fragment = createFragment();
            manager.beginTransaction().add(R.id.frag, fragment).commit();
        }


    }


}
