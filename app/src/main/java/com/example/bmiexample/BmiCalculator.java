package com.example.bmiexample;

public class BmiCalculator  {
        public double calculateBmi (int wt, int height_in_ft, int height_in_inch) {
            int totalIn = height_in_ft * 12 + height_in_inch;
            double totalCm = totalIn * 2.53;
            double totalM = totalCm / 100;
            double bmi = wt / Math.pow(totalM, totalM);
            return bmi;

        }
    }




