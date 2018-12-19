package com.jeq.criminalintent.com.jeq.criminalintent.activityUtils;

//通用的activity工具类

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.jeq.criminalintent.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    //抽象方法，供子类调用时创建fragment
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这一步必须要有，获取了fragment的容器
        setContentView(R.layout.activity_fragment);

        //manager对象代表容器，可以在这里调用需要加载的fragment
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            //如果需要加载的fragment是空的，就把子类创建的fragment返回给它实现复用
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
