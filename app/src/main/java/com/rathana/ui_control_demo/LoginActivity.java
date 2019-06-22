package com.rathana.ui_control_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText userName,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);

    }

    public void onLogin(View v){

        String username=userName.getText().toString();
        String pass=password.getText().toString();

        if(username.equals("admin") && pass.equals("admin")){
            startActivity(new Intent(this,MainActivity.class));
            Toast.makeText(this, "login success",
                    Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "login fail",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
