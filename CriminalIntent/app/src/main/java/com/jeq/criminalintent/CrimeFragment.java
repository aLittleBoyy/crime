package com.jeq.criminalintent;

//import android.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class CrimeFragment extends Fragment {

    public static final String TAG = "CrimeFragment";
    private Crime crime;
    private View inflate;
    private Button crime_date;
    private CheckBox crime_solved;
    private EditText crime_title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_crime, container, false);
        initView();
        return inflate;
    }

    @SuppressLint("SimpleDateFormat")
    private void initView() {
        crime_title = (EditText) findView(R.id.crime_title);
        crime_date = (Button) findView(R.id.crime_date);
        crime_solved = (CheckBox) findView(R.id.crime_solved);

        //editText监听
        crime_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                crime.setmTitle(s.toString());
                Log.d(TAG, "onTextChanged: 文本行改变");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //button操作
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(crime.getmDate());
        crime_date.setText(format);
        crime_date.setEnabled(false);

        //checkBox监听
        crime_solved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setmSolved(isChecked);
                Log.d(TAG, "onCheckedChanged: 选择选中");
            }
        });
    }

    private View findView(int id){
        View v = inflate.findViewById(id);
        return v;
    }
}
