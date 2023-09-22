package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myFirstNumber, mySecondNumber;
    Button clickAddition, clickSubtraction, clickMultiplication, clickDivision;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myFirstNumber = findViewById(R.id.myFirstNumber);
        mySecondNumber = findViewById(R.id.mySecondNumber);

        clickAddition = findViewById(R.id.clickAddition);
        clickSubtraction = findViewById(R.id.clickSubtraction);
        clickMultiplication = findViewById(R.id.clickMultiplication);
        clickDivision = findViewById(R.id.clickDivision);
    }

    public void clickFunction(View view) {
        if (myFirstNumber.getText().toString().equals("") || mySecondNumber.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Please enter numbers in both fields", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(myFirstNumber.getText().toString());
        double num2 = Double.parseDouble(mySecondNumber.getText().toString());

        int viewId = view.getId();

        if (viewId == R.id.clickAddition) {
            result = num1 + num2;
        } else if (viewId == R.id.clickSubtraction) {
            result = num1 - num2;
        } else if (viewId == R.id.clickMultiplication) {
            result = num1 * num2;
        } else if (viewId == R.id.clickDivision) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                Toast.makeText(MainActivity.this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
        intent.putExtra("RESULT_MESSAGE", "Result: " + result);
        startActivity(intent);

    }
}
