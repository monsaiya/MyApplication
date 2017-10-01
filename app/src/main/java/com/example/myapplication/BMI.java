package com.example.myapplication;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    private EditText mHeight;
    private EditText mWeight;
    private Button mCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        mHeight = (EditText) findViewById(R.id.height_edit_text) ;
        mWeight = (EditText) findViewById(R.id.weight_edit_text) ;
        mCalculate = (Button) findViewById(R.id.calculate_button) ;

        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heighttext = mHeight.getText().toString();
                Double height = Double.valueOf(heighttext);

                Double weight = Double.valueOf(mWeight.getText().toString());

                Double Bmi = weight / ((height/100) * (height/100)) ;
                String BmiText = getBmiText(Bmi);
                String result = String.format("ค่า BMI ที่ได้  %.1f\n\nอยู่ในเกณฑ์ : %s ",Bmi,BmiText);
//                String result = "ค่า BMI ที่ได้ : " + String.valueOf(Bmi);
//                result += "\n\n อยู่ในเกณฑ์ : " + BmiText;


                AlertDialog.Builder dialog = new AlertDialog.Builder(BMI.this);
                dialog.setTitle("BMI result : ");
                dialog.setMessage(result);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mHeight.setText("");
                        mWeight.setText("");
                        mHeight.requestFocus();

                    }
                }
                );
                dialog.show();
            }
        });



    }

    private String getBmiText(Double bmi) {

        String bmiText ;
        if(bmi < 18.5){
            bmiText = "น้ำหนักน้อยกว่าปกติ" ;
        }else if(bmi < 25){
            bmiText = "น้ำหนักปกติ" ;
        }else if (bmi < 30){
            bmiText = "น้ำหนักมากกว่าปกติ" ;
        }else {
            bmiText = "น้ำหนักมากกว่าปกติมาก" ;
        }
        return bmiText;
    }


}
