package modelo;

import java.util.ArrayList;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Palabra {
    private String palabra;
    private ArrayList<Silaba> silabas;
    private ArrayList<Letra> letras;

    public Palabra(String palabra){
        this.palabra = palabra;
        silabas = new ArrayList<Silaba>();
        letras = new ArrayList<Letra>();
    }

    public ArrayList<Silaba> getSilabas() {
        return silabas;
    }

    public void setSilabas(ArrayList<Silaba> silabas) {
        this.silabas = silabas;
    }

    public ArrayList<Letra> getLetras() {
        return letras;
    }

    public void setLetras(ArrayList<Letra> letras) {
        this.letras = letras;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
