package com.example.calculatorajmh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txt2;
    private int firstValue = 0;
    private int secondValue = 0;
    private String operator = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt2 = findViewById(R.id.txt2);  // Asegúrate de que el ID coincide con tu layout.

        // Configuración de los botones numéricos uno por uno
        Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("0");
            }
        });

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("1");
            }
        });

        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("2");
            }
        });

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("3");
            }
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("4");
            }
        });

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("5");
            }
        });

        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("6");
            }
        });

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("7");
            }
        });

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("8");
            }
        });

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberButtonClick("9");
            }
        });

        // Configuración de los botones de operadores
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClick("+");
            }
        });

        Button btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClick("-");
            }
        });

        Button btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClick("*");
            }
        });

        Button btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClick("/");
            }
        });

        // Configuración del botón "="
        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Configuración del botón "C"
        Button btnClear = findViewById(R.id.btnC);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });
    }

    // Método que maneja la pulsación de los botones numéricos
    private void onNumberButtonClick(String number) {
        if (isNewOperation) {
            txt2.setText("");
            isNewOperation = false;
        }
        String currentText = txt2.getText().toString();
        txt2.setText(currentText + number);
    }

    // Método que maneja la pulsación de los botones de operadores
    private void onOperatorButtonClick(String operatorInput) {
        operator = operatorInput;
        try {
            firstValue = Integer.parseInt(txt2.getText().toString());
        } catch (NumberFormatException e) {
            txt2.setText("Error");
            isNewOperation = true;
            return;
        }
        isNewOperation = true;
    }

    // Método para calcular el resultado
    private void calculateResult() {
        try {
            secondValue = Integer.parseInt(txt2.getText().toString());
        } catch (NumberFormatException e) {
            txt2.setText("Error");
            isNewOperation = true;
            return;
        }

        int result = 0;
        if (operator.equals("+")) {
            result = firstValue + secondValue;
        } else if (operator.equals("-")) {
            result = firstValue - secondValue;
        } else if (operator.equals("*")) {
            result = firstValue * secondValue;
        } else if (operator.equals("/")) {
            if (secondValue != 0) {
                result = firstValue / secondValue;
            } else {
                txt2.setText("Error");
                isNewOperation = true;
                return;
            }
        } else {
            txt2.setText("Error");
            isNewOperation = true;
            return;
        }

        txt2.setText(String.valueOf(result));
        isNewOperation = true;
    }

    // Método que maneja la limpieza de la calculadora
    private void clearCalculator() {
        txt2.setText("0");
        firstValue = 0;
        secondValue = 0;
        operator = "";
        isNewOperation = true;
    }
}