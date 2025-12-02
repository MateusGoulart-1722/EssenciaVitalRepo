package com.example.essenciavital;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class ALogicaLogin extends AppCompatActivity {

    Button botao_var;
    TextInputEditText usuario_var;
    EditText senha_var;

    Button botao_var_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.a_tela_login);

        botao_var = findViewById(R.id.btn_login);
        usuario_var = findViewById(R.id.tie_nome);
        senha_var = findViewById(R.id.enp_senha);
        botao_var_2 = findViewById(R.id.btn_cadastrar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botao_var.setOnClickListener(v -> {

            String usuario = usuario_var.getText().toString().trim();
            String senha = senha_var.getText().toString().trim();

            if(usuario.equals("admin") && senha.equals("1234")) {
                Toast.makeText(ALogicaLogin.this, "Login realizado com sucesso!",
                        Toast.LENGTH_SHORT).show();

                Intent mudar_tela_var = new Intent(ALogicaLogin.this,
                        CLogicaBemVindo.class);

                startActivity(mudar_tela_var);

            } else {
                Toast.makeText(ALogicaLogin.this, "Usuário ou senha inválidos",
                        Toast.LENGTH_SHORT).show();
            }

        });

        botao_var_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mudar_tela_var = new Intent(ALogicaLogin.this,
                        BLogicaCadastro.class);

                startActivity(mudar_tela_var);

            }
        });



    }
}
