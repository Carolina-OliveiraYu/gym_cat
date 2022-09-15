package com.ibm.myfistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText etEmail = findViewById(R.id. editTextEmail);
        EditText etSenha = findViewById(R.id. editTextSenha);
        EditText etSenhaConfirma = findViewById(R.id. editTextSenhaConfirm);
        Button btnCadastrar = findViewById(R.id. btnCadastrar);

        etEmail.setText(getIntent().getStringExtra("KeyEmail"));
        etSenha.setText(getIntent().getStringExtra("KeySenha"));

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String email  = etEmail.getText().toString();
                String senha  = etSenha.getText().toString();
                String senhaConfirma  = etSenhaConfirma.getText().toString();


                if ( senha.equals(senhaConfirma) ){

                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    myEdit.putString("email", email );
                    myEdit.putString("senha", senha);
                    myEdit.commit();

                    // Ir tela surpresa
                    Intent intent = new Intent(CadastroActivity.this, ContatoActivity.class);
                    intent.putExtra("Keyemail", email);
                    intent.putExtra("keysenha", senha);
                    startActivity(intent);

                    finish();


                    }else {
                    //erro senhas divergentes
                    alerta ("Senhas divergentes, por favor digite novamente");
                }

            }
        });



       /* try {

            //criar o banco
            SQLiteDatabase bancoDedados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //criar tavela
            bancoDedados.execSQL("CREATE TABLE IF NOT EXISTS dados (usuario VARCHAR,senha VARCHAR)");

            //inserir dados
            bancoDedados.execSQL("INSERT INTO dados (usuario, senha) VALUES ('ibm', '123')");

        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
    private void alerta (String msg){
        new AlertDialog.Builder(CadastroActivity.this)
                .setTitle("ATENÇÃO!")
                .setMessage(msg)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setIcon(android.R.drawable.ic_delete)
                .show();
    }
}