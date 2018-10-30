package usonsonatemio.com.ejercicionivelacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoJugador extends AppCompatActivity {

    EditText nick;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_jugador);

        setTitle("NUEVO JUGADOR");

        nick = findViewById(R.id.txtNick);
        guardar = findViewById(R.id.btnGuardar);

    }

    public void Procesar(View v){

        if (!nick.getText().toString().isEmpty()){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putExtra("NOMBRE", nick.getText().toString());
            setResult(MainActivity.GUARDADO, resultIntent);
            finish();
        }else{

            Toast.makeText(this, "El campo del nick esta vacio", Toast.LENGTH_SHORT).show();
        }
    }
}
