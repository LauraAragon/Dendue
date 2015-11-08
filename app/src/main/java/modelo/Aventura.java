package modelo;

import java.io.Serializable;

/**
 * Created by Laura Aragon on 27/10/2015.
 */
public class Aventura implements Serializable {
    private int id;
    private String nombre;
    private String[] historia;
    private boolean historiaDesbloqueada;
    private Reto[] retos;

    public Aventura(int id, String nombre)     {
        this.id = id;
        this.nombre = nombre;
        historia = new String[6];
        this.historiaDesbloqueada = false;
        this.retos = new Reto[6];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getHistoria() {
        return historia;
    }

    public void setHistoria(String[] historia) {
        this.historia = historia;
    }

    public boolean isHistoriaDesbloqueada() {
        return historiaDesbloqueada;
    }

    public void setHistoriaDesbloqueada(boolean historiaDesbloqueada) {
        this.historiaDesbloqueada = historiaDesbloqueada;
    }

    public Reto[] getRetos() {
        return retos;
    }

    public void setRetos(Reto[] retos) {
        this.retos = retos;
    }

}
