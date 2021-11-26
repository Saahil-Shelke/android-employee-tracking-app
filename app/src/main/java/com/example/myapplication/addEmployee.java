package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class addEmployee extends AppCompatActivity {

    EditText email, pass, conpass;
    Button btnreg;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        email  = findViewById(R.id.empemail);
        pass  = findViewById(R.id.emppass);
        conpass  = findViewById(R.id.empconpass);
        btnreg = findViewById(R.id.empbtnreg);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btnreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                PerformAuth();

            }
        });

    }

    private void PerformAuth() {

        String e = email.getText().toString();
        String p = pass.getText().toString();
        String cp = conpass.getText().toString();

        if(!e.matches(emailPattern))
        {
            email.setError("Enter correct email");
        }else if (p.isEmpty() || p.length()<6)
        {
            pass.setError("Enter proper Password");
        }else if (!p.equals(cp))
        {
            conpass.setError("Entered Password Does not Match");
        }else
        {
            progressDialog.setMessage("Please wait until registration");
            progressDialog.setTitle("Registration Done");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(addEmployee.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(addEmployee.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(addEmployee.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}