package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Silaba {
    private String silaba;
    private int posicion;

    public Silaba(String silaba, int posicion){
        this.silaba = silaba;
        this.posicion = posicion;
    }

    public String getSilaba() {
        return silaba;
    }

    public void setSilaba(String silaba) {
        this.silaba = silaba;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }


}
