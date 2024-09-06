package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
   public Button button;
//    public Button button1;
//    public Button button2;

    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public Toolbar toolbar;
    public ConstraintLayout addemployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationviews);
        toolbar = findViewById(R.id.toolbar);
        addemployee = findViewById(R.id.addEmpreg);

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_hamburger);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.addemp:
                        Intent intent = new Intent(MainActivity.this, addEmployee.class);
                        startActivity(intent);
                        break;
                    case R.id.addtask:
                        Intent intent1 = new Intent(MainActivity.this,addTask.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_log:

                        break;

                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

        button = (Button) findViewById(R.id.Btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);

            }
        });
//
//        button1 = (Button) findViewById(R.id.Btn1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this, addEmployee.class);
//                startActivity(intent1);
//            }
//        });
//
//        button2 = (Button) findViewById(R.id.Btn2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intent1);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }
}
