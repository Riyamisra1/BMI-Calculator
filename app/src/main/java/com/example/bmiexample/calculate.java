package com.example.bmiexample;

import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class calculate extends BMIscreen {
        public double calculateBmi (int wt, int height_in_ft, int height_in_inch) {
            int totalIn = height_in_ft * 12 + height_in_inch;
            double totalCm = totalIn * 2.53;
            double totalM = totalCm / 100;
            double bmi = wt / Math.pow(totalM, totalM);
            return bmi;

        }
    }




