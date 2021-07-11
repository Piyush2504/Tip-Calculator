package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatedTip extends AppCompatActivity {
    TextView Totalbill;
    TextView Tips;
    TextView TotalBill_Tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculated_tip);
        Totalbill= findViewById(R.id.textView2);
        Tips =findViewById(R.id.textView3);
        TotalBill_Tip=findViewById(R.id.textView4);
        Intent intent1 = getIntent();

        double bill= intent1.getDoubleExtra(MainActivity.Calculated,0);
        double tip=intent1.getDoubleExtra(MainActivity.Calculating,0);
        double totalbill=intent1.getDoubleExtra(MainActivity.Calculator,0);
        Totalbill.setText("Your Total Bill is "+ bill);
        Tips.setText("Your Total Tip Amount is "+ tip);
        TotalBill_Tip.setText("Your Total Bill After Adding Tip is "+totalbill);

    }
}