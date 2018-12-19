package com.jeq.criminalintent.com.jeq.criminalintent.fragment;

//import android.app.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimeActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimePagerActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.adapter.CrimeAdapter;
import com.jeq.criminalintent.com.jeq.criminalintent.adapter.CrimeHolder;
import com.jeq.criminalintent.com.jeq.criminalintent.data.Crime;
import com.jeq.criminalintent.R;
import com.jeq.criminalintent.com.jeq.criminalintent.data.CrimeLab;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

public class CrimeFragment extends Fragment{

    public static final String TAG = "CrimeFragment";
    private Crime crime;
    private View inflate;
    private Button crime_date;
    private CheckBox crime_solved;
    private EditText crime_title;
    private UUID id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //crime = new Crime();
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

        //接到CrimePagerActivity传过来的intent
        //在工具类中处理数据，通过id找到crime的所有数据
        //UUID id = (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);

        id = (UUID) getArguments().getSerializable(CrimePagerActivity.EXTRA_CRIME_ID);

        Log.d(TAG, "initView: 收到的id------" + id);
        crime = CrimeLab.get(getActivity()).getCrime(id);

        crime_title.setText(crime.getmTitle());
        crime_solved.setChecked(crime.ismSolved());


        //button操作
        final String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.crime.getmDate());
        crime_date.setText(format);
        crime_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                FragmentManager manager = getFragmentManager();
                //DatePickerFragment fragment = new DatePickerFragment();
                getActivity().getIntent().getSerializableExtra(DatePickerFragment.DATE_ARGS);
                DatePickerFragment fragment = DatePickerFragment.newInstance(crime.getmDate());
                fragment.show(manager, "DIALOG_DATE");
            }
        });


        //editText监听
        crime_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CrimeFragment.this.crime.setmTitle(s.toString());
                Log.d(TAG, "onTextChanged: 文本行改变");

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



        //checkBox监听
        crime_solved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setmSolved(isChecked);
                Log.d(TAG, "onCheckedChanged: 选择选中");
            }
        });

    }

    //使用argument传值
   public static CrimeFragment newInstance(UUID uid) {
        Bundle args = new Bundle();
        args.putSerializable(CrimePagerActivity.EXTRA_CRIME_ID, uid);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View findView(int id) {
        View v = inflate.findViewById(id);
        return v;
    }

}
