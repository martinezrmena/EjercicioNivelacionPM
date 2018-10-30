package usonsonatemio.com.ejercicionivelacion;

import android.support.annotation.NonNull;

import java.io.Serializable;

public class Jugador implements Serializable, Comparable<Jugador> {

    private String name;
    private int puntaje;

    public Jugador(String name, int puntaje) {
        this.name = name;
        this.puntaje = puntaje;
    }

    public Jugador() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public int compareTo(@NonNull Jugador jugador) {
        if (puntaje > jugador.puntaje) {
            return -1;
        }
        if (puntaje < jugador.puntaje) {
            return 1;
        }
        return 0;
    }
}
