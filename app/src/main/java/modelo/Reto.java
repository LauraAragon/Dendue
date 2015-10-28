package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Reto {
    public static final int PALABRA = 1;
    public static final int SILABA = 2;
    public static final int LETRA = 3;
    private int tipo;
    private int id;
    private String instrucciones;
    private int intentos;
    private String fraseHistoria;
    private Medalla medalla;
    private Palabra palabra;


    public Reto(int tipo, int id, String instrucciones, int intentos, String fraseHistoria){
        this.tipo = tipo;
        this.id = id;
        this.instrucciones = instrucciones;
        this.intentos = intentos;
        this.fraseHistoria = fraseHistoria;
        this.medalla = null;
        this.palabra = null;
    }

    public void logicaFuncional(){

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

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
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

}
