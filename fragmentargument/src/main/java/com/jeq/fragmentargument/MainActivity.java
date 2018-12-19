package com.jeq.fragmentargument;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SingleActivity {

    @Override
    public Fragment createFragment() {
        return new FirstFragment();
    }


}
