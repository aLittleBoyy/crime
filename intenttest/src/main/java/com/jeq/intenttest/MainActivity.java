package com.jeq.intenttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but;
    private Button but_in;
    private Map<String, View> viewMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        viewMap = new HashMap<>();

        but = findViewById(R.id.but);
        but_in = findViewById(R.id.but_in);

        viewMap.put("显示Intent", but);
        viewMap.put("隐式Intent", but_in);


        but.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){

           /*
           *显示intent
           */

            case R.id.but:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
            break;

            case R.id.but_in:

            break;
        }


    }
}
