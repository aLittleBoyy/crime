package com.jeq.criminalintent.com.jeq.criminalintent.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jeq.criminalintent.com.jeq.criminalintent.data.Crime;
import com.jeq.criminalintent.R;

import java.util.List;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

    private List<Crime> mcrimes;

    public CrimeAdapter(List<Crime> crimes) {
        mcrimes = crimes;
    }

    @NonNull
    @Override


    public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_crime, viewGroup, false);
        CrimeHolder holder = new CrimeHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {
        Crime crime = mcrimes.get(i);
        crimeHolder.bind(crime);
    }

    @Override
    public int getItemCount() {
        return mcrimes.size();
    }
}
