package com.example.bmiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

public class home_2 extends AppCompatActivity {
    EditText edt_Wt,edt_Ft,edt_In;
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        RelativeLayout main;
        main = findViewById(R.id.main);
        edt_Wt =(EditText) findViewById(R.id.edt_Wt);

        edt_Ft = (EditText) findViewById(R.id.edt_Ft);
        edt_In = (EditText) findViewById(R.id.edt_In);
        btn_click =findViewById(R.id.btn_click);
        edt_Wt.addTextChangedListener(go_login);
        edt_Ft.addTextChangedListener(go_login);
        edt_In.addTextChangedListener(go_login);


        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edt_Wt.getText().toString());
                int ft = Integer.parseInt(edt_Ft.getText().toString());
                int in = Integer.parseInt(edt_In.getText().toString());
                int totalIn = ft * 12 + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;
                double bmi = wt / Math.pow(totalM, totalM);
                if (bmi > 25) {
                    Snackbar.make(main, "You are Overweight and your bmi is " + Math.round(bmi), Snackbar.LENGTH_LONG).show();

                } else if (bmi < 18) {
                    Snackbar.make(main, "You are Underweight and your bmi is " + Math.round(bmi), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(main, "You are Healthy and your bmi is " + Math.round(bmi), Snackbar.LENGTH_LONG).show();
                }
                edt_Wt.getText().clear();
                edt_Ft.getText().clear();
                edt_In.getText().clear();

            }


        });


    };
    private TextWatcher go_login =new TextWatcher() {
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

    };
    }
