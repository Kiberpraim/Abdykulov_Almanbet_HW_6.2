package com.example.Lesson_2_6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btnEntry = findViewById(R.id.btn_entry);
        EditText edEmail = findViewById(R.id.ed_email);
        EditText edPassword = findViewById(R.id.ed_password);
        TextView txClickable = findViewById(R.id.tx_сlickable);
        TextView txEdict = findViewById(R.id.tx_edict);
        TextView txEntry = findViewById(R.id.tx_entry);

        edEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int colorOrange = Color.parseColor("#FF9800");
                if (!edEmail.getText().toString().isEmpty() && !edPassword.getText().toString().isEmpty()) {
                    btnEntry.setBackgroundColor(colorOrange);
                } else {
                    btnEntry.setBackgroundColor(Color.GRAY);
                }
            }
        });

        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int colorOrange = Color.parseColor("#FF9800");
                if (edEmail.getText().toString().isEmpty() && edPassword.getText().toString().isEmpty()) {
                    btnEntry.setBackgroundColor(Color.GRAY);
                } else {
                    btnEntry.setBackgroundColor(colorOrange);
                }
            }
        });

        btnEntry.setOnClickListener(v -> {
            if (edEmail.getText().toString().equals("admin") && edPassword.getText().toString().equals("admin")) {

                txEntry.animate().alpha(0);
                txEdict.animate().alpha(0);
                edEmail.animate().alpha(0);
                edPassword.animate().alpha(0);
                btnEntry.animate().alpha(0);
                txClickable.animate().alpha(0);

                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль.", Toast.LENGTH_LONG).show();
            }
        });
    }
}