package modelo;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Medalla {
    public static final int NINGUNA = 0;
    public static final int ORO = 1;
    public static final int PLATA = 2;
    public static final int BRONCE = 3;
    private int tipo;

    public Medalla(int tipo){
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
