package com.jeq.fragmentargument;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button but_click;
    private TextView text;
    private String text1;
    public static final String TAG = "arguments";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment01, container, false);
        initView();
        return view;
    }

    private void initView() {
        but_click = view.findViewById(R.id.cilckB);
        text = view.findViewById(R.id.text_01);
        text1 = (String) this.text.getText();
        but_click.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        //使用Intetnt传值，把值存进extra中，在另一个界面中获取

        Intent intent = new Intent(v.getContext(), SecondActivity.class);
        intent.putExtra(ScondFragment.key, text1);
        Log.d(TAG, "onClick: 开始跳转并传值到scondAvtivity" + text1);
        v.getContext().startActivity(intent);



    }
}
