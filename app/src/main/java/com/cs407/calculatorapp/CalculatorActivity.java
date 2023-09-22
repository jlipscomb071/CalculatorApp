package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity);

        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();

        String resultMessage = intent.getStringExtra("RESULT_MESSAGE");

        textView.setText(resultMessage);
    }
}
