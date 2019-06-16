package com.rathana.ui_control_demo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {


    TextView textView;
    Button btnLogin;
    ImageButton btnImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnLogin=findViewById(R.id.btnLogin);
        btnImage=findViewById(R.id.btnImage);

        textView.setTextColor(Color.GREEN);
        textView.setText("changing content for this text view changing content for this text view changing content for this text view changing content for this text view");


        View.OnClickListener btnLoginCallback=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "btn login clicked",
                        Toast.LENGTH_SHORT).show();
            }
        };

        //register event handling to button
        btnLogin.setOnClickListener(btnLoginCallback);
//
//        btnImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Image button clicked ",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });


//        btnImage.setOnClickListener((v)-> {
//            Toast.makeText(this, "implement lambda expression",
//                    Toast.LENGTH_SHORT).show();
//        });


        btnImage.setOnClickListener(this);
    }


    public void onRegisterClicked(View v){

        Toast.makeText(this, "register clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "activity implement directly",
                Toast.LENGTH_SHORT).show();
    }
}
