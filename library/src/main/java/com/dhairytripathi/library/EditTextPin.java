package com.dhairytripathi.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

public class EditTextPin extends ConstraintLayout {
    private EditText pin1, pin2, pin3, pin4, pin5, pin6;
    private Context context;
    private int underlineColor = R.color.underlineColor;
    private int background = R.drawable.background;
    private static final String TAG = "EditTextPin";

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            shape.setDrawable(0, bgShape);
        }
        view.setBackground(shape);
        pin1 = findViewById(R.id.pin1);
        pin2 = findViewById(R.id.pin2);
        pin3 = findViewById(R.id.pin3);
        pin4 = findViewById(R.id.pin4);
        pin5 = findViewById(R.id.pin5);
        pin6 = findViewById(R.id.pin6);

        Drawable drawable = ContextCompat.getDrawable(context, background);
        setTextBackground(drawable);

        //Add TextWatchers to get focus
        pin1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 1) {
                    pin1.setSelection(1);
                    pin2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    Log.i("TEST", "String : " + s.toString());
                    pin2.requestFocus();
                } else if(s.length() > 1){
                    pin1.setText(String.valueOf(s.charAt(0)));
                    pin2.setText(s.subSequence(1, s.length()));
                }
            }
        });

        pin2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    pin1.setSelection(1);
                    pin1.requestFocus();
                } else {
                    pin2.setSelection(1);
                    pin3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    pin3.requestFocus();
                } else if(s.length() > 1){
                    pin2.setText(String.valueOf(s.charAt(0)));
                    pin3.setText(s.subSequence(1, s.length()));
                }
            }
        });

        pin3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    pin2.requestFocus();
                } else {
                    pin3.setSelection(1);
                    pin4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    pin4.requestFocus();
                } else if(s.length() > 1){
                    pin3.setText(String.valueOf(s.charAt(0)));
                    pin4.setText(s.subSequence(1, s.length()));
                }
            }
        });

        pin4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    pin3.requestFocus();
                } else {
                    pin4.setSelection(1);
                    pin5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    pin5.requestFocus();
                } else if(s.length() > 1){
                    pin4.setText(String.valueOf(s.charAt(0)));
                    pin5.setText(s.subSequence(1, s.length()));
                }
            }
        });

        pin5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 0) {
                    pin4.requestFocus();
                } else {
                    pin5.setSelection(1);
                    pin6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    pin6.requestFocus();
                } else if(s.length() > 1){
                    pin5.setText(String.valueOf(s.charAt(0)));
                    pin6.setText(s.subSequence(1, s.length()));
                }
            }
        });

        pin6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    pin5.requestFocus();
                } else {
                    pin6.setSelection(1);
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
            background = style.getResourceId(R.styleable.EditTextPin_textBackground, R.drawable.background);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            style.recycle();
        }
    }
    public String getPin() {
        String pin;
        pin = "" + pin1.getText() + pin2.getText() + pin3.getText() + pin4.getText() + pin5.getText() + pin6.getText();
        return pin;
    }

    private int convertDpToPx(int dp){
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
    private void setTextBackground(Drawable drawable) {
        pin1.setBackground(drawable);
        pin2.setBackground(drawable);
        pin3.setBackground(drawable);
        pin4.setBackground(drawable);
        pin5.setBackground(drawable);
        pin6.setBackground(drawable);
    }
}
