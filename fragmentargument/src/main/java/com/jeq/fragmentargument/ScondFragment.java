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
import android.widget.EditText;

import static com.jeq.fragmentargument.FirstFragment.TAG;


public class ScondFragment extends Fragment {

    private View view;
    private EditText text;
    public static final String key = "THIS_EXTRA";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        initView();
        return view;
    }

    private void initView() {
        text = view.findViewById(R.id.text_02);
        //2.使用argument获取传值
        String s = getArguments().getString(key);
        Log.d(TAG, "initView: 获取到arguments中的值" + s);
        text.setText(s);



        /* 常规的获取值的方法
         Intent intent = getActivity().getIntent();
        Serializable extra = intent.getSerializableExtra("this");
        text.setText(extra.toString());*/

    }



    //1.调用newInstance方法，传入一个value或者其他数据类型的标识（传值的类型）
    //初始化fragment,获取bundle对象及arguments中存的值
    public static ScondFragment newInstance(String value) {

        Bundle args = new Bundle();
        Log.d(TAG, "newInstance: 初始化fragment,并把值存进arguments" + value);
        args.putString(key, value);
        ScondFragment fragment = new ScondFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
