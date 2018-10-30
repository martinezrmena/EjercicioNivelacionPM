package usonsonatemio.com.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnNuevo, btnIniciarJuego, btnPuntajes;
    public static int GUARDADO=47;
    public static int ENVIOJUEGO=48;
    public static int ENVIORESULTADOS=49;
    private String Nick;
    private ArrayList<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevo = findViewById(R.id.btnNuevoJugador);
        btnIniciarJuego = findViewById(R.id.btnIniciarJuego);
        btnPuntajes = findViewById(R.id.btnPutanjes);
        Nick = "";
        jugadores = new ArrayList<>();
    }

    public void btnNuevoOnclick(View v){
        Intent nuevo = new Intent(this, NuevoJugador.class);
        startActivityForResult(nuevo, GUARDADO);
    }

    public void btnIniciarJuegoOnClick(View v){
        if(!Nick.isEmpty()){
            Intent nuevo = new Intent(this, IniciarJuego.class);
            startActivityForResult(nuevo, ENVIOJUEGO);

        }else{

            Toast.makeText(this, "No ha ingresado ningun jugador.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo los datos

            Nick = data.getStringExtra("NOMBRE");

            Toast.makeText(this, "Nombre ingresado exitosamente.", Toast.LENGTH_SHORT).show();
        }

        if(requestCode==ENVIOJUEGO){
            if(data==null) return;
            //recibo los datos
            int puntaje  = 0;
            Jugador player = new Jugador();

            puntaje = Integer.parseInt(data.getStringExtra("Puntaje"));


            player.setName(Nick);
            player.setPuntaje(puntaje);

            jugadores.add(player);

            Toast.makeText(this, "Puntaje de jugador registrado: " + puntaje, Toast.LENGTH_SHORT).show();
        }
    }

    public void lstJugadoresView(View v){

        if (jugadores.size() != 0){
            Intent intento = new Intent(MainActivity.this, ListaJugadores.class);
            Bundle contenedor = new Bundle();
            contenedor.putSerializable("array", jugadores);
            intento.putExtras(contenedor);
            startActivity(intento);
        }else{
            Toast.makeText(this, "Ningun jugador ha iniciado la partida.", Toast.LENGTH_SHORT).show();
        }
    }

}
