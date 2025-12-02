package com.example.essenciavital;


import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DLogicaQuestionario extends AppCompatActivity {

    RadioGroup grupo_var;
    RadioButton botao_a_var, botao_b_var, botao_c_var, botao_d_var;
    Button botao_var;
    TextView texto_var;

    // Índice da questão atual
    int questaoAtual = 0;

    String[] perguntas = {
            "1. Qual sua pretenção com a dieta?",
            "2. Qual seu estilo alimentar no almoço? O que costuma comer na maioria dos dias da semana?",
            "3. Qual seu estilo alimentar na janta? O que costuma comer na maioria dos dias da semana?",
            "4. Gostaria de aumentar o consumo de alguns desses alimentos?",
            "5. Com que frequÇenci você prepara sua comida na maioria dos dias da semana?"
    };

    String[][] alternativas = {
            {"Perder peso.", "Ganhar massa muscular", "Alimentação Saudável", "Dieta Vegana"},
            {"Comida traducional brasileira (arroz, feijão e acompanhamento)", "Lanches ou salgados", "Não almoço", "Verduras e Legumes"},
            {"Comida traducional brasileira (arroz, feijão e acompanhamento)", "Lanches ou salgados", "Não janto", "Verduras e Legumes"},
            {"Carne vermelha (boi)", "Carne branca (frango e peixe)", "Verdura", "Legume"},
            {"Preparo meu almoço", "Preparo minha janta", "Preparo meu almoço e janta", "Não cozinho"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.d_tela_questionario);

        grupo_var = findViewById(R.id.rdg_perguntas_PG);
        botao_a_var = findViewById(R.id.rdb_a_PG);
        botao_b_var = findViewById(R.id.rdb_b_PG);
        botao_c_var = findViewById(R.id.rdb_c_PG);
        botao_d_var = findViewById(R.id.rdb_d_PG);
        botao_var = findViewById(R.id.btn_enviar);
        texto_var = findViewById(R.id.txv_questao_PG);

        carregarQuestao();

        botao_var.setOnClickListener(v -> {
            if (questaoAtual < perguntas.length - 1) {
                questaoAtual++;
                carregarQuestao();
            } else {
                texto_var.setText("Fim do questionário!");
                grupo_var.setVisibility(android.view.View.GONE);
                botao_var.setEnabled(false);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void carregarQuestao() {
        texto_var.setText(perguntas[questaoAtual]);
        botao_a_var.setText(alternativas[questaoAtual][0]);
        botao_b_var.setText(alternativas[questaoAtual][1]);
        botao_c_var.setText(alternativas[questaoAtual][2]);
        botao_d_var.setText(alternativas[questaoAtual][3]);
        grupo_var.clearCheck();
    }
}
