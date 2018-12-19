package com.jeq.fragmentargument;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import static com.jeq.fragmentargument.FirstFragment.TAG;

public class SecondActivity extends SingleActivity {


    @Override
    public Fragment createFragment() {

        //3.在被托管的Activity中传入，实现fragment独立性在哪里需要就在那里调用instance方法
        String extra = getIntent().getStringExtra(ScondFragment.key);
        Log.d(TAG, "createFragment: 这里应该是创建fragment钱就在intent中了");
        return ScondFragment.newInstance(extra);


    }
}
