package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText num1EditText, num2EditText;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            num1EditText = findViewById(R.id.num1EditText);
            num2EditText = findViewById(R.id.num2EditText);
            resultTextView = findViewById(R.id.resultTextView);


            Button addButton = findViewById(R.id.addButton);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calculation('+');
                }
            });

            Button subtractButton = findViewById(R.id.subtractButton);
            subtractButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calculation('-');
                }
            });

            Button multiplyButton = findViewById(R.id.multiplyButton);
            multiplyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calculation('*');
                }
            });

            Button divideButton = findViewById(R.id.divideButton);
            divideButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Calculation('/');
                }
            });

        }

        private void Calculation(char operator) {

            String num1Str = num1EditText.getText().toString();
            String num2Str = num2EditText.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }


            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;


            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }


            DecimalFormat df = new DecimalFormat("#.##");
            resultTextView.setText("Result: " + df.format(result));
        }


    }
