package com.jeq.criminalintent;
/*
引入Fragment，导v4下的包，管理器需要使用getSupportManager，Fragment类同时也需要导v4包
总布局
*/

//import android.app.FragmentManager;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
public class CrimeActivity extends FragmentActivity {

    private CrimeFragment crimeFragment;
    //private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initFragment();
    }

    private void initFragment() {
        //fm = getFragmentManager();
        FragmentManager fm = getSupportFragmentManager();
        fm.findFragmentById(R.id.fragment_container);
        if (crimeFragment ==null){
            crimeFragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.fragment_container, crimeFragment).commit();
        }
    }
}
