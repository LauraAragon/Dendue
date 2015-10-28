package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Letra {
    private char letra;
    private int posicion;

    public Letra(char letra, int posicion){
        this.letra = letra;
        this.posicion = posicion;
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
}
