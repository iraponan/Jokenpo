package br.eti.inovare.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.jokenpo("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.jokenpo("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.jokenpo("Tesoura");
    }

    public void jokenpo(String escolhaUsuario) {
        String[] jokenpo = {
                "Pedra",
                "Papel",
                "Tesoura"
        };

        String escolhaApp = jokenpo[new Random().nextInt(jokenpo.length)];

        ImageView imageEscolhaApp = findViewById((R.id.imageEscolhaApp));
        TextView textResultado = findViewById(R.id.textResultado);

        switch (escolhaApp) {
            case "Pedra":
                imageEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageEscolhaApp.setImageResource(R.drawable.tesoura);
                break;
            default:
                imageEscolhaApp.setImageResource(R.drawable.padrao);
                break;
        }

        if (escolhaUsuario == escolhaApp) {
            textResultado.setText("Empatou! :|");
        }
        else if ((escolhaUsuario == "Pedra" && escolhaApp != "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp != "Tesoura") ||
                (escolhaUsuario == "Tesoura" && escolhaApp != "Pedra")){
            textResultado.setText("Você Ganhou! :)");
        }
        else {
            textResultado.setText("Você Perdeu! :(");
        }
    }
}