package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPage extends AppCompatActivity {

    public Button button;
    public Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        button = (Button) findViewById(R.id.fpbtn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPage.this,Login.class);
                startActivity(intent);

            }
        });

        button1 = (Button) findViewById(R.id.fpbtn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPage.this,Login2.class);
                startActivity(intent);

            }
        });
    }
}