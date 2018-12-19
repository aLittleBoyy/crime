package com.jeq.criminalintent.com.jeq.criminalintent.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jeq.criminalintent.R;
import com.jeq.criminalintent.com.jeq.criminalintent.activityUtils.SingleFragmentActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.data.Crime;
import com.jeq.criminalintent.com.jeq.criminalintent.data.CrimeLab;
import com.jeq.criminalintent.com.jeq.criminalintent.fragment.CrimeFragment;
import com.jeq.criminalintent.com.jeq.criminalintent.fragment.CrimeListFragment;

import java.util.List;
import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {
    public static final String TAG = "CrimeFragment";
    private ViewPager pager;
    private FragmentManager manager;
    private List<Crime> crimes;
    public static final String EXTRA_CRIME_ID = "crime_uuid";
    private UUID id;
    private UUID accid;


    //创建一个传输数据的方法，
    //@parameter  一个制定的页面，一个唯一标识，根据这个标识可以找到条目的所有数据状态
    public static Intent newintent(Context pageContext, UUID crime_id){
        Intent intent = new Intent(pageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crime_id);
        return intent;
    }

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        //这里真正拿到了传过来的id
        accid = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        Log.d(TAG, "onCreate: 传过来的id真正拿到了" + accid);
        initView();
    }

    private void initView() {

        crimes = CrimeLab.get(this).getmCrimes();
        pager = findViewById(R.id.crime_pager);
        manager = getSupportFragmentManager();
        pager.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int i) {
                Crime crime = crimes.get(i);
                id = crime.getmId();
                CrimeFragment crimeFragment = CrimeFragment.newInstance(id);
                return crimeFragment;
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        //通过获取uuid设置viewpager位置对应相应的crimeFragment
        for (int i = 0; i < crimes.size(); i++){
            if (crimes.get(i).getmId().equals(accid)){
                Log.d(TAG, "initView:dinajide  "+i);
                pager.setCurrentItem(i);
                break;
            }
        }
    }
}
