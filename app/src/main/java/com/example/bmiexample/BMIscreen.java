package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BMIscreen extends AppCompatActivity {
    EditText edt_Wt;
    EditText edt_Ft;
     EditText edt_In;
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmiscreen);
        edt_Wt = (EditText) findViewById(R.id.edt_Wt);
        edt_Ft = (EditText) findViewById(R.id.edt_Ft);
        edt_In = (EditText) findViewById(R.id.edt_In);
        btn_click = findViewById(R.id.btn_click);
        edt_Wt.addTextChangedListener(calculateBMI);
        edt_Ft.addTextChangedListener(calculateBMI);
        edt_In.addTextChangedListener(calculateBMI);


        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager)getSystemService(BMIscreen.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edt_In.getWindowToken(), 0);
                int wt = Integer.parseInt(edt_Wt.getText().toString());
                int height_in_ft = Integer.parseInt(edt_Ft.getText().toString());
                int height_in_inch = Integer.parseInt(edt_In.getText().toString());
                calculate calcBmi= new calculate();
                double bmi = calcBmi.calculateBmi( wt,  height_in_ft, height_in_inch);
                if (bmi > 25) {
                    Toast toast = Toast.makeText(BMIscreen.this, getString(R.string.overweight) + Math.round(bmi), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 150, 0);
                    toast.show();
                } else if (bmi < 18) {
                    Toast toast = Toast.makeText(BMIscreen.this, getString(R.string.underweight) + Math.round(bmi), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 150, 0);
                    toast.show();

                } else {
                    Toast toast = Toast.makeText(BMIscreen.this, getString(R.string.healthy) + Math.round(bmi), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 150, 0);
                    toast.show();

                }
                edt_Wt.getText().clear();
                edt_Ft.getText().clear();
                edt_In.getText().clear();


            }


        });


    };
    private TextWatcher calculateBMI =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String w=edt_Wt.getText().toString().trim();
            String f=edt_Ft.getText().toString().trim();
            String inc=edt_In.getText().toString().trim();
            btn_click.setEnabled(!w.isEmpty() && !f.isEmpty() && !inc.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    } ;

    };