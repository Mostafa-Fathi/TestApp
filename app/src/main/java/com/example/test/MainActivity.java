package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText user ,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.main_login_btn);
        user=(EditText)findViewById(R.id.main_user_et) ;
        pass=(EditText)findViewById(R.id.main_pass_et);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userString=user.getText().toString();
                String passString=pass.getText().toString();


                Toast.makeText(MainActivity.this, userString +"\n"+passString, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,ChatMenu.class);
                startActivity(intent);
            }
        });
    }
}
