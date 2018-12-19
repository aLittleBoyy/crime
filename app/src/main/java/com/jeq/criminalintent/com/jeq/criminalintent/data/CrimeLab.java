package com.jeq.criminalintent.com.jeq.criminalintent.data;

/*
数据存储池
*/

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab scrimeLab;
    //用于存储Crime的list
    private List<Crime> mCrimes;

    public List<Crime> getmCrimes() {
        return mCrimes;
    }

    //构造方法，一旦调用就创建100个数据在Crime中
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
       /* for (int i = 1; i <= 100; i++){
            Crime crime = new Crime();
            crime.setmTitle("CRIME(罪行是)" + i);
            crime.setmSolved(i % 2 == 0);
            mCrimes.add(crime);
        }*/
    }


    //可以被外部访问，返回单例对象
    public static  CrimeLab get(Context context){
        if (scrimeLab == null){
            scrimeLab = new CrimeLab(context);
        }
        return scrimeLab;

    }


    //Crime 对象，通过uuid把mcrimes数组的值付给crime
    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){
            if (crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    //添加crime
    public void add(Crime addCrime){
        mCrimes.add(addCrime);
    }


}
