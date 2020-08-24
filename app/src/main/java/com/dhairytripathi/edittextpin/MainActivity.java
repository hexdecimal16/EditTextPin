package com.dhairytripathi.edittextpin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dhairytripathi.library.EditTextPin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditTextPin pin = findViewById(R.id.pin);
    }
}