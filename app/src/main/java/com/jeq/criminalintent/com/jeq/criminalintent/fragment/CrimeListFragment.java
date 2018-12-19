package com.jeq.criminalintent.com.jeq.criminalintent.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimeListActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.activity.CrimePagerActivity;
import com.jeq.criminalintent.com.jeq.criminalintent.data.Crime;
import com.jeq.criminalintent.com.jeq.criminalintent.adapter.CrimeAdapter;
import com.jeq.criminalintent.R;
import com.jeq.criminalintent.com.jeq.criminalintent.data.CrimeLab;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeListFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private CrimeAdapter adapter;
    private List<Crime> mCrimes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //接收menu
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_crime, container, false);
        initRecylerView();
        return view;
    }

    private void initRecylerView() {
        //recylerView必须要布局管理器支持
        recyclerView = view.findViewById(R.id.recylerView);
        //updateUI();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        layoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), layoutManager.getOrientation()));
        recyclerView.setLayoutManager(layoutManager);

    }

    private void updateUI() {

        //使用了单例
        CrimeLab crimeLab = CrimeLab.get(getActivity());

        List<Crime> list = crimeLab.getmCrimes();

        //getCrimes();

        if (adapter == null){
            adapter = new CrimeAdapter(list);
            //adapter = new CrimeAdapter(mCrimes);
            Toast.makeText(getActivity(), "列表没有数据", Toast.LENGTH_SHORT).show();
            recyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }

        recyclerView.getAdapter().notifyItemMoved(0, 5);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    //实例化menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);
    }

    //点击菜单栏菜单选项
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_crime:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).add(crime);
                Intent intent = CrimePagerActivity.newintent(getActivity(), crime.getmId());
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
