package com.example.essenciavital;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CLogicaBemVindo extends AppCompatActivity {

    Button botao_var;
    Button botao_var_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.c_tela_bem_vindo);

        botao_var = findViewById(R.id.btn_questionario);
        botao_var_2 = findViewById(R.id.btn_receitas);

        botao_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mudar_tela_var = new Intent(CLogicaBemVindo.this,
                        DLogicaQuestionario.class);

                startActivity(mudar_tela_var);
            }
        });

        botao_var_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mudar_tela_var = new Intent(CLogicaBemVindo.this,
                        ELogicaReceitaVegana.class);

                startActivity(mudar_tela_var);
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




    }
}