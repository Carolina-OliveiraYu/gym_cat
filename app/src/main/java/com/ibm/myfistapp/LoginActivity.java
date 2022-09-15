package com.ibm.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {





    private String msg;
    private String email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText emailEditText, senhaEditText;

        emailEditText = findViewById(R.id.editTextEmail);
        senhaEditText = findViewById(R.id.editTextSenha);


        Button botao = findViewById(R.id.button);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          email = emailEditText.getText().toString();
          senha = senhaEditText.getText().toString();

            SharedPreferences pref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            String emailShared = pref.getString("email", null);
            String senhaShared = pref.getString("senha", null);

                if( email.equals(emailShared) && senha.equals(senhaShared)){
                      msg = "";

                    Intent intent = new Intent(LoginActivity.this,ContatoActivity.class);

                    intent.putExtra("Keyemail", email);
                    intent.putExtra("keysenha", senha);

                    startActivity(intent);
                }

                else {
                    dialog();



                }




                enviar();
            }
        });
    }
    void enviar(){

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
    private void dialog(){
        new AlertDialog.Builder(LoginActivity.this)
                .setTitle("ATENÇÃO!")
                .setMessage("Você não possui cadastro, deseja se cadastrar?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                        intent.putExtra("Keyemail", email);
                        intent.putExtra("keysenha", senha);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}