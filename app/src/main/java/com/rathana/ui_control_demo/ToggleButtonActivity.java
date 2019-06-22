package com.rathana.ui_control_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class ToggleButtonActivity extends AppCompatActivity {

    ToggleButton btnToggle;
    Switch btnSwitch;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        btnToggle=findViewById(R.id.btnToggle);
        btnSwitch=findViewById(R.id.autoPlay);

        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    btnToggle.setBackgroundColor(Color.GREEN);
                else
                    btnToggle.setBackgroundColor(Color.parseColor("#E96060"));
            }
        });

        btnSwitch.setOnCheckedChangeListener((sw,isChecked)->{
            if(isChecked)
                Toast.makeText(this, "turn on auto play",
                        Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "turn off auto play",
                        Toast.LENGTH_SHORT).show();
        });
    }

    public void onRadioButtonClicked(View view){
        if(view instanceof RadioButton){
            RadioButton rd= (RadioButton) view;
            if(rd.isChecked())
                Toast.makeText(this, ""+rd.getText().toString(),
                        Toast.LENGTH_SHORT).show();
        }
    }

    List<String> choices=new ArrayList<>();

    public void onCheckboxClicked(View v){
        if(v instanceof  CheckBox){
            CheckBox checkBox= (CheckBox) v;
            if(checkBox.isChecked()){
                choices.add(checkBox.getText().toString());
            }else{
                choices.remove(checkBox.getText().toString());
            }
        }
        Toast.makeText(this, ""+choices, Toast.LENGTH_SHORT).show();

    }

}
