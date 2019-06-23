package com.rathana.ui_control_demo.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Person;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import java.util.Calendar;

public class MyTimePicker extends DialogFragment
implements TimePickerDialog.OnTimeSetListener {

    OnPickTimeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener=(OnPickTimeListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();
        int h=calendar.get(Calendar.HOUR);
        int mn=calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(
                getActivity(),
                this,
                h,
                mn,
                DateFormat.is24HourFormat(getActivity())
        );
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        listener.onPickTimeResult(hourOfDay+":"+minute);

    }


    public interface OnPickTimeListener{
        void onPickTimeResult(String time);
    }
}
