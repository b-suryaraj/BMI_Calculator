package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightInch;
        Button btnCalculate;
        TextView txtResult, txtBMI;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightInch = findViewById(R.id.edtHeightInch);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById((R.id.txtResult));
        txtBMI = findViewById((R.id.txtBMI));
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int htF = Integer.parseInt(edtHeightFt.getText().toString());
                int htIn = Integer.parseInt(edtHeightInch.getText().toString());

                int totalIn = htF * 12 + htIn;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                double bmi = wt/(totalM * totalM);
                String bmiStr = String.format("%.2f", bmi);
                txtBMI.setText(bmiStr);
                if (bmi>25){
                    txtResult.setText("You're Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }else if(bmi<18){
                    txtResult.setText("You're UnderWeight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }else{
                    txtResult.setText("You're Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });




    }
}