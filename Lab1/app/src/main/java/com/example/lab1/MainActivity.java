package com.example.lab1;

import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText passwordInput = findViewById(R.id.passwordInput);
        TextView passwordOutput = findViewById(R.id.enteredPassword);

        RadioGroup passwordVisibility = findViewById(R.id.passwordVisibility);
        passwordVisibility.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id) {
                    case R.id.showPassword:
                        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    case R.id.hidePassword:
                        passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        break;
                }
            }
        });

        Button submit = findViewById(R.id.buttonOk);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordInput.getText().toString();
                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please, complete the input!", Toast.LENGTH_SHORT).show();
                }
                passwordOutput.setText(password);
            }
        });
    }
}