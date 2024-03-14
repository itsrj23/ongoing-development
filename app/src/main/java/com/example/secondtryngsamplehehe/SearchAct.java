package com.example.secondtryngsamplehehe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        BottomNavigationView bottomNavView = findViewById(R.id.bottomNavView);
        bottomNavView.setSelectedItemId(R.id.bottom_search);

        bottomNavView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(),HomeAct.class));
                    finish();
                    return true;
                case R.id.bottom_search:
                    return true;
                case R.id.bottom_settings:
                    startActivity(new Intent(getApplicationContext(),SettingsAct.class));
                    finish();
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