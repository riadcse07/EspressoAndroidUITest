package com.example.mahmudriad.espressouitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClick_LogIn ();
    }

    private void onClick_LogIn () {

        Button logInButton = (Button) findViewById(R.id.loginButton);

        logInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText userNameText = (EditText) findViewById(R.id.userNameText);
                EditText passwordText = (EditText) findViewById(R.id.passwordText);

                if (!userNameText.getText().toString().isEmpty()) {

                    if (!passwordText.getText().toString().isEmpty()) {

                        if (userNameText.getText().toString().equalsIgnoreCase("admin")) {
                            if (passwordText.getText().toString().equalsIgnoreCase("123456")) {
                                // Goto Next Page
                                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
//                                intent.putExtra("itemName",itemNames[pos]);
                                startActivity(intent);

                            } else {
                                Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Password is empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
