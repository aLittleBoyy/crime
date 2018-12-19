package com.jeq.criminalintent.com.jeq.criminalintent.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeq.criminalintent.R;
import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimeActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimeListActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimePagerActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.data.Crime;

import java.text.SimpleDateFormat;
import static com.jeq.criminalintent.com.jeq.criminalintent.fragment.CrimeFragment.TAG;


public class CrimeHolder extends RecyclerView.ViewHolder {


    public TextView crime_title;
    public TextView crime_date;
    private Crime mcrime;
    private int i;
    private final ImageView crime_solved;

    public CrimeHolder(@NonNull View itemView) {
        super(itemView);
        crime_title = itemView.findViewById(R.id.crime_title);
        crime_date = itemView.findViewById(R.id.crime_date);
        crime_solved = itemView.findViewById(R.id.crime_solved);

        click(itemView);
    }

    public void bind(Crime crime){
        mcrime = crime;
        crime_title.setText(mcrime.getmTitle());

        //日期转换
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(mcrime.getmDate());
        crime_date.setText(date);

        //图片显示
        if (crime.ismSolved() == true){
            i = View.VISIBLE;
        }else{
            i= View.GONE;
        }
        crime_solved.setVisibility(i);
        int i1 = crime_solved.getVisibility();

    }


    private void click(View itemView) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: 点击了"+mcrime.getmTitle());


                //点击事件里执行这个动作，跳转到指定界面,
                //这一个流程是：列表显示的数据存到exra里，从crimeListFragment 开始传值到CrimePagerFragment。
                //Intent intent = CrimeActivity.newintent(v.getContext()  , mcrime.getmId());
                Intent intent = CrimePagerActivity.newintent(v.getContext(), mcrime.getmId());
                Log.d(TAG, "onClick: 点击了传过来的id-----"+mcrime.getmId());
                v.getContext().startActivity(intent);
            }
        });
    }

}
