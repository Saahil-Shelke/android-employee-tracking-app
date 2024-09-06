package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addTask extends AppCompatActivity {

    EditText empname1, emptask1, emplocation;
    Button btntask;

    DatabaseReference taskreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        empname1 = findViewById(R.id.empname1);
        emptask1 = findViewById(R.id.emptask1);
        emplocation = findViewById(R.id.emplocation);
        btntask = findViewById(R.id.btntask);

        taskreference = FirebaseDatabase.getInstance().getReference().child("Tasks");

        btntask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertTaskDetails();
            }
        });

    }

    private void insertTaskDetails(){

        String name = empname1.getText().toString();
        String task = emptask1.getText().toString();
        String location = emplocation.getText().toString();

        taskDetails taskdetails = new taskDetails(name, task, location);

        taskreference.push().setValue(taskdetails);
        Toast.makeText(addTask.this, "Task Added!", Toast.LENGTH_SHORT).show();
        sendUserToNextActivity();
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(addTask.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}