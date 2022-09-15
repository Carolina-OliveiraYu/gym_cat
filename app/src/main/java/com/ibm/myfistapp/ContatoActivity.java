package com.ibm.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ContatoActivity extends AppCompatActivity {

    private EditText editTextAltura;
    private EditText editTextPeso;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        textResultado = findViewById(R.id.textResultado);


        //TextView tvEmail = findViewById(R.id.tvEmail);

        //String extraEmail = getIntent().getStringExtra("Keyemail");
        //tvEmail.setText(extraEmail);

    }

    public void calcularImc(View view) {
        float altura, peso, imc;
        altura = Float.parseFloat(editTextAltura.getText().toString());
        peso = Float.parseFloat(editTextPeso.getText().toString());

        imc = peso / (altura * altura);
        try {
            if (imc > 0 && imc <= 18.5) {
                textResultado.setText("Você está abaixo de peso" + imc);
            } else if (imc >= 18.6 && imc <= 24.9) {
                textResultado.setText("Você está no peso ideal (PARABÉNS)" + imc);
            } else if (imc >= 25 && imc <= 29.9) {
                textResultado.setText("Levemente acima do peso" + imc);
            } else if (imc >= 30.0 && imc <= 34.9) {
                textResultado.setText("Obseidade grau 1 " + imc);
            } else if (imc >= 35.0 && imc <= 39.9) {
                textResultado.setText("Obesidade grau 2 (Severa)" + imc);
            } else {
                textResultado.setText("Obesidade grau 3 (Mórbido)" + imc);
            }
        } catch (Exception e) {
            //
        }
    }
}