package com.example.secondtryngsamplehehe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SettingsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setSelectedItemId(R.id.bottom_settings);

        bottomNavView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(),HomeAct.class));
                    finish();
                    return true;
                case R.id.bottom_search:
                    startActivity(new Intent(getApplicationContext(),SearchAct.class));
                    finish();
                    return true;
                case R.id.bottom_settings:
                    return true;
                case R.id.bottom_profile:
                    startActivity(new Intent(getApplicationContext(),ProfileAct.class));
                    finish();
                    return true;
            }
            return false;
        });
    }
}