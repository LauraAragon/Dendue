package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Letra {
    private int posicion;
    private char letra;
    private int posicionSilaba;


    public Letra(int posicion, char letra, int posicionSilaba){
        this.letra = letra;
        this.posicion = posicion;
        this.posicionSilaba = posicionSilaba;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getPosicionSilaba() {
        return posicionSilaba;
    }

    public void setPosicionSilaba(int posicionSilaba) {
        this.posicionSilaba = posicionSilaba;
    }
}
