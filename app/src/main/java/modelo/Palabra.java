package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Palabra {
    private String palabra;
    private int cantidadSilabas;
    private int cantidadLetras;
    private Silaba[] silabas;
    private Letra[] letras;

    public Palabra(String palabra, int cantidadSilabas, int cantidadLetra){
        this.palabra = palabra;
        this.cantidadSilabas = cantidadSilabas;
        this.cantidadLetras = cantidadLetra;
        silabas = new Silaba[cantidadSilabas];
        letras = new Letra[cantidadLetras];
    }

    public Silaba[] getSilabas() {
        return silabas;
    }

    public void setSilabas(Silaba[] silabas) {
        this.silabas = silabas;
    }

    public Letra[] getLetras() {
        return letras;
    }

    public void setLetras(Letra[] letras) {
        this.letras = letras;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getCantidadSilabas() {
        return cantidadSilabas;
    }

    public void setCantidadSilabas(int cantidadSilabas) {
        this.cantidadSilabas = cantidadSilabas;
    }

    public int getCantidadLetras() {
        return cantidadLetras;
    }

    public void setCantidadLetras(int cantidadLetras) {
        this.cantidadLetras = cantidadLetras;
    }
}
