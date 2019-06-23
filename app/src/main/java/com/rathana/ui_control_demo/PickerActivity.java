package com.rathana.ui_control_demo;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.rathana.ui_control_demo.util.MyTimePicker;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.Calendar;

public class PickerActivity extends AppCompatActivity
implements MyTimePicker.OnPickTimeListener {

    TextView datePickerResult;
    TextView timePickerResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        datePickerResult=findViewById(R.id.datePickerResult);
        timePickerResult=findViewById(R.id.timePickerResult);

    }



    public void onPickTime(View view){

        new MyTimePicker().show(getSupportFragmentManager(),"time picker");

    }

    public void onPickDate(View view){
        createDatePicker();
    }


    private void createDatePicker(){

        Calendar calendar= Calendar.getInstance();
        int yy=calendar.get(Calendar.YEAR);
        int m=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                listener,
                yy,
                m,
                day
        );

        datePickerDialog.show();
    }

    private DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String date="";
            date=dayOfMonth+"/"+(month+1) +"/"+year;

            datePickerResult.setText(date);
        }
    };

    @Override
    public void onPickTimeResult(String time) {
        timePickerResult.setText(time);
    }
}
