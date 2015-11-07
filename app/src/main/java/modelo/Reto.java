package modelo;

import java.util.ArrayList;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Reto {
    public static final int PALABRA = 1;
    public static final int SILABA = 2;
    public static final int LETRA = 3;
    private int id;
    private int tipo;
    private int intentos;
    private boolean completado;
    private String fraseHistoria;
    private Medalla medalla;
    private Palabra palabra;
    private ArrayList<String> erroneas;


    public Reto(int id, int tipo, boolean completado, int intentos, String fraseHistoria){
        this.id = id;
        this.tipo = tipo;
        this.intentos = intentos;
        this.completado = completado;
        this.fraseHistoria = fraseHistoria;
        this.medalla = null;
        this.palabra = null;
        erroneas = new ArrayList<String>();
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getFraseHistoria() {
        return fraseHistoria;
    }

    public void setFraseHistoria(String fraseHistoria) {
        this.fraseHistoria = fraseHistoria;
    }

    public Medalla getMedalla() {
        return medalla;
    }

    public void setMedalla(Medalla medalla) {
        this.medalla = medalla;
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public ArrayList<String> getErroneas() {
        return erroneas;
    }

    public void setErroneas(ArrayList<String> erroneas) {
        this.erroneas = erroneas;
    }
}
