package com.jeq.criminalintent.com.jeq.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.jeq.criminalintent.com.jeq.criminalintent.activityUtils.SingleFragmentActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
