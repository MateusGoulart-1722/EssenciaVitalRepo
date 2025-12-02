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

public class ELogicaReceitaVegana extends AppCompatActivity {
    Button botao_var;
    Button botao_var_2;
    Button botao_var_3;
    Button botao_var_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.e_tela_receita_vegana);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        botao_var = findViewById(R.id.btnVerQuest);
        botao_var_2 = findViewById(R.id.btn_verreceita1);
        botao_var_3 = findViewById(R.id.btn_verreceita2);
        botao_var_4 = findViewById(R.id.btn_verreceita3);
        botao_var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mudar_tela_var = new Intent(ELogicaReceitaVegana.this, DLogicaQuestionario.class);
                startActivity(mudar_tela_var);
            }
        });
    }
}