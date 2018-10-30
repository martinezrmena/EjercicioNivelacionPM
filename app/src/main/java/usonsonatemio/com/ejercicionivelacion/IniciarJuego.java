package usonsonatemio.com.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class IniciarJuego extends AppCompatActivity {

    Button Piedra, Papel, Tijera, Finalizar;
    int Victorias, Empates, Derrotas, Puntaje;
    String HumanoSeleccion, MaquinaSeleccion;
    TextView txtVictorias, txtEmpates, txtDerrotas, txtPuntaje;
    Boolean movimientomaquina, movimientohumano;
    Random aleatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego);

        Piedra = findViewById(R.id.btnPiedra);
        Papel = findViewById(R.id.btnPapel);
        Tijera = findViewById(R.id.btnTijera);
        txtPuntaje = findViewById(R.id.txtPuntajeActual);
        Finalizar = findViewById(R.id.btnFinalizar);
        Victorias = 0;
        Empates = 0;
        Puntaje = 0;
        Derrotas = 0;
        HumanoSeleccion = "";
        MaquinaSeleccion= "";
        txtVictorias = findViewById(R.id.txtVictorias);
        txtEmpates = findViewById(R.id.txtEmpates);
        txtDerrotas = findViewById(R.id.txtDerrotas);
        movimientohumano = false;
        movimientomaquina = false;
        aleatorio = new Random(System.currentTimeMillis());

    }

    public void PiedraOnClick(View v){
        HumanoSeleccion = "O";
        MaquinaOnClick();
        validarGanador();
        HumanoSeleccion = "";
        MaquinaSeleccion = "";
        Toast.makeText(this, "Seleccionaste piedra", Toast.LENGTH_SHORT).show();

    }

    public void PapelOnClick(View v){
        HumanoSeleccion = "[_]";
        MaquinaOnClick();
        validarGanador();
        HumanoSeleccion = "";
        MaquinaSeleccion = "";
        Toast.makeText(this, "Seleccionaste papel", Toast.LENGTH_SHORT).show();

    }

    public void TijeraOnClick(View v){
        HumanoSeleccion = "X";
        MaquinaOnClick();
        validarGanador();
        HumanoSeleccion = "";
        MaquinaSeleccion = "";
        Toast.makeText(this, "Seleccionaste tijera", Toast.LENGTH_SHORT).show();

    }

    public void MaquinaOnClick(){
        int seleccionado = aleatorio.nextInt(3);

        // Refrescar datos aleatorios
        //aleatorio.setSeed(System.currentTimeMillis());

        switch (seleccionado){

            case 0:
                MaquinaSeleccion = "O";
                Toast.makeText(this, "Máquina selecciono: Piedra", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                MaquinaSeleccion="X";
                Toast.makeText(this, "Máquina selecciono: Tijera", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                MaquinaSeleccion = "[_]";
                Toast.makeText(this, "Máquina selecciono: Papel", Toast.LENGTH_SHORT).show();
                break;

        }

    }

    public void FinalizarOnClick(View v){

        Intent resultIntent = new Intent();
        // TODO envio los datos mediante el intent
        resultIntent.putExtra("Puntaje", String.valueOf(Puntaje));
        Toast.makeText(this, "¡Muchas gracias por jugar!", Toast.LENGTH_SHORT).show();
        setResult(MainActivity.ENVIOJUEGO, resultIntent);
        finish();

    }

    private void validarGanador(){

        if(HumanoSeleccion == MaquinaSeleccion){
            Empates++;
            txtEmpates.setText("Empates: "+ Empates);
            Toast.makeText(this, "El resultado fue un empate.", Toast.LENGTH_SHORT).show();
        }else if (HumanoSeleccion == "O" && MaquinaSeleccion == "X"){
            Victorias++;
            Puntaje += 6;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtVictorias.setText("Victorias: "+ Victorias);
            Toast.makeText(this, "¡Felicidades! Ganaste", Toast.LENGTH_SHORT).show();
        }else if (MaquinaSeleccion == "O" && HumanoSeleccion == "X"){
            Derrotas++;
            Puntaje -= 3;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtDerrotas.setText("Derrotas: "+ Derrotas);
            Toast.makeText(this, "El ganador es la máquina. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
        }else if(MaquinaSeleccion == "[_]" && HumanoSeleccion == "X"){
            Victorias++;
            Puntaje += 6;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtVictorias.setText("Victorias: "+ Victorias);
            Toast.makeText(this, "¡Felicidades! Ganaste", Toast.LENGTH_SHORT).show();
        }else if(MaquinaSeleccion == "X" && HumanoSeleccion == "[_]"){
            Derrotas++;
            Puntaje -= 3;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtDerrotas.setText("Derrotas: "+ Derrotas);
            Toast.makeText(this, "El ganador es la máquina. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
        }else if(MaquinaSeleccion == "O" && HumanoSeleccion == "[_]"){
            Victorias++;
            Puntaje += 6;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtVictorias.setText("Victorias: "+ Victorias);
            Toast.makeText(this, "¡Felicidades! Ganaste", Toast.LENGTH_SHORT).show();
        }else if(MaquinaSeleccion == "[_]" && HumanoSeleccion == "O"){
            Derrotas++;
            Puntaje -= 3;
            txtPuntaje.setText("Puntos: " + Puntaje + " pts");
            txtDerrotas.setText("Derrotas: "+ Derrotas);
            Toast.makeText(this, "El ganador es la máquina. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
        }

    }
}
