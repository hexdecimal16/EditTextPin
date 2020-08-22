package com.dhairytripathi.library;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;

public class EditTextPin extends ConstraintLayout {
    private EditText pin1, pin2, pin3, pin4, pin5, pin6;
    private Context context;
    public EditTextPin(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public EditTextPin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LayoutInflater.from(context).inflate(R.layout.edit_pin, this, true);
        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);
        pin3 = findViewById(R.id.pin3);
        pin4 = findViewById(R.id.pin4);
        pin5 = findViewById(R.id.pin5);
        pin6 = findViewById(R.id.pin6);
        //Add TextWatchers to get focus
        pin1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pin1.getText().toString().length() == 1) {
                    pin2.requestFocus();
                }
            }
        });

        pin2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pin2.getText().toString().length() == 0) {
                    pin1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pin2.getText().toString().length() == 1) {
                    pin3.requestFocus();
                }
            }
        });

        pin3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pin3.getText().toString().length() == 0) {
                    pin2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pin3.getText().toString().length() == 1) {
                    pin4.requestFocus();
                }
            }
        });

        pin4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pin4.getText().toString().length() == 0) {
                    pin3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pin4.getText().toString().length() == 1) {
                    pin5.requestFocus();
                }
            }
        });

        pin5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pin5.getText().toString().length() == 0) {
                    pin4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (pin5.getText().toString().length() == 1) {
                    pin6.requestFocus();
                }
            }
        });

        pin6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (pin6.getText().toString().length() == 0) {
                    pin5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    public String getPin(){
        String pin;
        pin = ""+pin1.getText() + pin2.getText() + pin3.getText() + pin4.getText() + pin5.getText() + pin6.getText();
        return pin;
    }
}
