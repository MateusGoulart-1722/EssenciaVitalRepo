package com.example.essenciavital;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class BLogicaCadastro extends AppCompatActivity {
    Button botao_var;
    TextInputEditText email_var;
    EditText usuario_var;
    EditText senha_var;
    EditText conf_senha_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.b_tela_cadastro);
        botao_var = findViewById(R.id.btn_cadastrar);
        email_var = findViewById(R.id.tie_nome);
        usuario_var = findViewById(R.id.enp_nome);
        senha_var = findViewById(R.id.enp_csenha);
        conf_senha_var = findViewById(R.id.enp_confsenha);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String email_var_2 = email_var.getText().toString().trim();
        String usuario_var_2 = usuario_var.getText().toString().trim();
        String senha_var_2 = senha_var.getText().toString().trim();
        String conf_senha_var_2 = conf_senha_var.getText().toString().trim();
        if (email_var_2.isEmpty()){
            Toast.makeText(this, "Digite seu Email", Toast.LENGTH_SHORT).show();
        } else if (usuario_var_2.isEmpty()) {
            Toast.makeText(this, "Digite seu Nome de Usuário", Toast.LENGTH_SHORT).show();
        } else if (senha_var_2.isEmpty()) {
            Toast.makeText(this, "Crie uma Senha", Toast.LENGTH_SHORT).show();
        } else if (conf_senha_var_2 != senha_var_2) {
            Toast.makeText(this, "As Senha estão Diferentes", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Usuário Cadastrado!", Toast.LENGTH_SHORT).show();
            Intent mudar_tela_var = new Intent(BLogicaCadastro.this, CLogicaBemVindo.class);
            startActivity(mudar_tela_var);
        }
    }
}