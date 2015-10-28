package modelo;

import java.util.ArrayList;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Aplicacion {
    private ArrayList<Aventura> aventuras;

    public Aplicacion(){
        aventuras = new ArrayList<Aventura>();
    }

    public boolean agregarAventura(){
        boolean agregado = false;
        return agregado;
    }

    public ArrayList<Aventura> getAventuras() {
        return aventuras;
    }

    public void setAventuras(ArrayList<Aventura> aventuras) {
        this.aventuras = aventuras;
    }
}
