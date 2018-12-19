package com.jeq.criminalintent.com.jeq.criminalintent.activity;
/*
引入Fragment，导v4下的包，管理器需要使用getSupportManager，Fragment类同时也需要导v4包
总布局
*/

//import android.app.FragmentManager;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.jeq.criminalintent.com.jeq.criminalintent.activityUtils.SingleFragmentActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.fragment.CrimeFragment;

import java.io.Serializable;
import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity /*FragmentActivity*/ {
    @Override
    protected Fragment createFragment() {
        return null;
    }

 /*   public static final String EXTRA_CRIME_ID = "crime_uuid";

    protected Fragment createFragment() {

        UUID id = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return new CrimeFragment().newInstance(id);
    }




    //创建一个传输数据的方法，
    //@parameter  一个制定的页面，一个唯一标识，根据这个标识可以找到条目的所有数据状态
    public static Intent newintent(Context pageContext, UUID crime_id){
        Intent intent = new Intent(pageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crime_id);
        return intent;
    }
*/
}
