package modelo;

import com.lauraaragon.dendue.AdminBD;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Aplicacion implements Serializable {
    private ArrayList<Aventura> aventuras;

    public Aplicacion(){

        aventuras = new ArrayList<Aventura>();

    }

    public ArrayList<Aventura> getAventuras() {
        return aventuras;
    }

    public void setAventuras(ArrayList<Aventura> aventuras) {
        this.aventuras = aventuras;
    }
}
