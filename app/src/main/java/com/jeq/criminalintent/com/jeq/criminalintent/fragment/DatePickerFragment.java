package com.jeq.criminalintent.com.jeq.criminalintent.fragment;
/*
弹窗

*/

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.jeq.criminalintent.R;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class DatePickerFragment extends DialogFragment {


    public static final String DATE_ARGS = "date";
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Date date= (Date) getArguments().getSerializable(DATE_ARGS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.dialog_date, null);
        DatePicker datePicker = view.findViewById(R.id.dialog_date_picker);
        datePicker.init(year, month, day, null);
        /* DatePicker datePicker = new DatePicker(getActivity());*/

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();

        return dialog;
    }

    public static DatePickerFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(DATE_ARGS, date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
