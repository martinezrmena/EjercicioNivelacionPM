package usonsonatemio.com.ejercicionivelacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaJugadores extends AppCompatActivity {

    ListView lstJugadores;
    ArrayList<Jugador> listaJugadoresRecibido;
    Jugador[] listaJugadoresNuevos;
    private Adapter adaptadorJugadores;
    String [] valores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores);

        lstJugadores = findViewById(R.id.lstJugadores);

        setTitle("PUNTAJES DE JUGADORES");
        Bundle contenedor = getIntent().getExtras();
        listaJugadoresRecibido = (ArrayList<Jugador>) contenedor.getSerializable("array");
        listaJugadoresNuevos = new Jugador[listaJugadoresRecibido.size()];
        FillListEncuestado();

        lstJugadores.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,valores));


    }


    private void FillListEncuestado(){

        int i = 0;
        valores = new String[listaJugadoresRecibido.size()];


        for (final Jugador c:listaJugadoresRecibido){
            //String cadena = c.getName() + ", " + c.getPuntaje();
            listaJugadoresNuevos[i] = new Jugador(c.getName(), c.getPuntaje());
            i++;
        }

        Arrays.sort(listaJugadoresNuevos);

        i= 0;

        for (final Jugador c:listaJugadoresNuevos){
            String cadena = c.getName() + ", " + c.getPuntaje();
            valores[i] = cadena;
            i++;
        }
    }

}
