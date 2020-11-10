package com.example.newsreaderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btn;
    private TextView etAttempts;

    private String Username = "Admin";
    private String Password = "123456";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btn = findViewById(R.id.btn);
        etAttempts = findViewById(R.id.etAttempts);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputUsername = etUsername.getText().toString();
                String inputPassword = etPassword.getText().toString();

                if(inputUsername.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputUsername, inputPassword);

                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();

                        etAttempts.setText("No. of attempts remaining: " +counter);

                        if(counter == 0){
                            btn.setEnabled(false);
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                        // ADD THE CODE TO GO TO NEW ACTIVITY HERE
                        Intent intent = new Intent(MainActivity.this, NewsReaderHomePage.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private boolean validate(String username, String password){

        if(username.equals(Username) && password.equals(Password)){
            return true;
        }

        return false;
    }
}