package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BmiIScreen extends AppCompatActivity {
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
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(BmiIScreen.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(edt_In.getWindowToken(), 0);
                int wt = Integer.parseInt(edt_Wt.getText().toString());
                int height_in_ft = Integer.parseInt(edt_Ft.getText().toString());
                int height_in_inch = Integer.parseInt(edt_In.getText().toString());
                BmiCalculator calcBmi= new BmiCalculator();
                double bmi = calcBmi.calculateBmi( wt,  height_in_ft, height_in_inch);
                String displayingBmi;
                if (bmi > 25) {
                   displayingBmi=getString(R.string.overweight)+Math.round(bmi);
                } else if (bmi < 18) {
                    displayingBmi=getString(R.string.underweight)+Math.round(bmi);

                } else {
                    displayingBmi=getString(R.string.healthy)+Math.round(bmi);
                }
                showToast(displayingBmi);
                edt_Wt.getText().clear();
                edt_Ft.getText().clear();
                edt_In.getText().clear();

            }

            private void showToast( String message) {
                Toast toast = Toast.makeText(BmiIScreen.this, message,  Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 150, 0);
                toast.show();
            }


        });


    }



    ;
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