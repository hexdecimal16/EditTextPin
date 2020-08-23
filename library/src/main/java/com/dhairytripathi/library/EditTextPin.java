package com.dhairytripathi.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class EditTextPin extends ConstraintLayout {
    private EditText pin1, pin2, pin3, pin4, pin5, pin6;
    private Context context;
    private int underlineColor = R.color.underlineColor;
    private LinearLayout layout;
    private ConstraintLayout viewBackground;
    public EditTextPin(Context context, AttributeSet attrs) {
        super(context, attrs);
        handleAttrs(attrs);
        this.context = context;
    }

    public EditTextPin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handleAttrs(attrs);
        this.context = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LayoutInflater.from(context).inflate(R.layout.edit_pin, this, true);
        ConstraintLayout view = findViewById(R.id.viewBackground);
        LayerDrawable shape = (LayerDrawable) ContextCompat.getDrawable(context,R.drawable.underline);
        GradientDrawable bgShape = (GradientDrawable) (shape.findDrawableByLayerId(R.id.underline));
        bgShape.setStroke(convertDpToPx(2), ContextCompat.getColor(context, underlineColor));
        shape.setDrawable(0, bgShape);
        view.setBackground(shape);
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


    private void handleAttrs(AttributeSet attrs) {
        TypedArray style = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.EditTextPin, 0, 0);
        try {
            underlineColor = style.getResourceId(R.styleable.EditTextPin_underlineColor, R.color.underlineColor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            style.recycle();
        }
        updateStyling();
    }

    private void updateStyling() {


    }
    private int convertDpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
