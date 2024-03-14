package com.example.secondtryngsamplehehe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button signupButton2;
    EditText username2, password2, name;
    DBHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        signupButton2 = findViewById(R.id.signupButton2);
        username2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        name = findViewById(R.id.name);
        Db = new DBHelper(this);

        signupButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username2.getText().toString();
                String pass = password2.getText().toString();
                String fname = name.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(MainActivity2.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(pass)) {
                        Boolean checkuser = Db.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = Db.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity2.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity2.this, "User already exist! Please Log in", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(MainActivity2.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
                {
                }
            }
        });
    }
}