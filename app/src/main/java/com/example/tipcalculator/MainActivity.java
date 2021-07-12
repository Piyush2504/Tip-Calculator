package com.example.tipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {
     Slider slider;
     EditText TotalBill;
     TextView TipPercent;
     public static final String Calculated="com.example.tipcalculator.calculate";
    public static final String Calculating="com.example.tipcalculator.calculated";
    public static final String Calculator="com.example.tipcalculator.calculating";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Welcome to Tip Calculator",Toast.LENGTH_SHORT).show();
        slider=findViewById(R.id.slider);
        TotalBill=findViewById(R.id.BillAmount);
        TipPercent=findViewById(R.id.textView);

        slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull @org.jetbrains.annotations.NotNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull @org.jetbrains.annotations.NotNull Slider slider) {
                float percentValue= slider.getValue();
                TipPercent.setText(percentValue+"%");


            }
        });
    }

    public void TipCalc(View v){
        Toast.makeText(this, "Calculating!!", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this,CalculatedTip.class);
        if(TotalBill.length()==0){
            TotalBill.setError("Please Enter the Bill Amount First");
            TotalBill.requestFocus();
        }
        else {
            double BillAmount = Double.parseDouble(TotalBill.getText().toString());

            float percent = slider.getValue();
            double tipAmount = BillAmount * Double.parseDouble(String.valueOf(percent)) / 100;
            double totalbill_tip = BillAmount + tipAmount;
            intent1.putExtra(Calculated, BillAmount);
            intent1.putExtra(Calculating, tipAmount);
            intent1.putExtra(Calculator, totalbill_tip);
            startActivity(intent1);
        }
    }

}