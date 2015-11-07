package com.lauraaragon.dendue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

import modelo.Aplicacion;
import modelo.Aventura;
import modelo.Letra;
import modelo.Medalla;
import modelo.Palabra;
import modelo.Reto;
import modelo.Silaba;

/**
 * Created by Laura Aragon on 06/11/2015.
 */
public class AdminBD {

    public static Aplicacion aplicacion;
    public static SQLiteDatabase database;
    private static DataBaseOpenHelper helper;
    private String[] columnsAventuras = {DendueContractClass.ColumnAventuras.ID_AVENTURA, DendueContractClass.ColumnAventuras.NOMBRE_AVENTURA};
    private String[] columnsRetos = {DendueContractClass.ColumnRetos.ID_RETO, DendueContractClass.ColumnRetos.TIPO_RETO, DendueContractClass.ColumnRetos.COMPLETADO_RETO, DendueContractClass.ColumnRetos.INTENTOS_RETO, DendueContractClass.ColumnRetos.TIPO_MEDALLA_RETO, DendueContractClass.ColumnRetos.ID_AVENTURA_RETO};
    private String[] columnsSilabas ={DendueContractClass.ColumnSilabas.POSICION_SILABA, DendueContractClass.ColumnSilabas.ID_RETO_SILABA, DendueContractClass.ColumnSilabas.ID_AVENTURA_SILABA};
    private String[] columnsLetras = {DendueContractClass.ColumnLetras.POSICION_LETRA, DendueContractClass.ColumnLetras.LETRA, DendueContractClass.ColumnLetras.POSICION_SILABA_LETRA, DendueContractClass.ColumnLetras.ID_RETO_LETRA, DendueContractClass.ColumnLetras.ID_AVENTURA_LETRA};
    private String[] columnsFrasesHistoria = {DendueContractClass.ColumnFrasesHistoria.FRASE, DendueContractClass.ColumnFrasesHistoria.ID_RETO_FRASE, DendueContractClass.ColumnFrasesHistoria.ID_AVENTURA_FRASE};
    private String[] columnsFraseAleatoriaRetoDos = {DendueContractClass.ColumnFraseAletoriaRetoDos.ID_ALEATORIA_RETO_DOS, DendueContractClass.ColumnFraseAletoriaRetoDos.FRASE};

    public AdminBD(Context context) {
        try {
            helper = new DataBaseOpenHelper(context);
            open();
            aplicacion = new Aplicacion();
            aplicacion.setAventuras(createAventuras());
            Aventura aventura = aplicacion.getAventuras().get(0);
            Reto[] retos = aventura.getRetos();
            retos[1].setErroneas(createFrasesAleatoriasRetoDos(2,1));
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void open() throws SQLException {
        database = helper.getWritableDatabase();
    }

    public static void close() {
        helper.close();
    }

    public Reto[] createRetos(int idAventura){
       Reto[] retos = new Reto[6];
        String idaventura = ""+idAventura;
        String sql = "SELECT * FROM "+DendueContractClass.RETOS_TABLE_NAME+" WHERE idAventura="+idaventura+";";
        Cursor cursor = database.rawQuery(sql, null);
       int j = 0;
       cursor.moveToFirst();
       while(!cursor.isAfterLast()){
           Reto reto = cursorToReto(cursor);
           retos[j] = reto;
           j++;
           cursor.moveToNext();
       }

        return retos;
    }

    public Reto cursorToReto(Cursor cursor){
        Reto reto = null;
        int id = Integer.parseInt(cursor.getString(0));
        int tipo = Integer.parseInt(cursor.getString(1));
        int completado = Integer.parseInt(cursor.getString(2));
        boolean completadoBoolean = false;
        if(completado==0){
            completadoBoolean = false;
        }
        else if(completado==1){
            completadoBoolean = true;
        }

        int intentos = Integer.parseInt(cursor.getString(3));
        int tipoMedalla = Integer.parseInt(cursor.getString(4));
        int idaventura = Integer.parseInt(cursor.getString(5));
        String frasehistoria = frasesHistoriaAventura(Integer.parseInt(cursor.getString(0)), 1);

        reto = new Reto(id, tipo, completadoBoolean, intentos, frasehistoria);
        Medalla medalla = new Medalla(tipoMedalla);
        reto.setMedalla(medalla);
        reto.setPalabra(createPalabra(id, idaventura));
        reto.setFraseHistoria(frasesHistoriaAventura(id, idaventura));

        return reto;
    }

    public Letra cursorToLetra(Cursor cursor){
        Letra letra = null;
        int posicion = Integer.parseInt(cursor.getString(0));
        char letraC = cursor.getString(1).charAt(0);
        int posicionsilaba = Integer.parseInt(cursor.getString(2));

        letra = new Letra(posicion, letraC, posicionsilaba);

        return letra;
    }

    public ArrayList<Letra> createLetras(int idReto, int idAventura){
        ArrayList<Letra> letras = new ArrayList<Letra>();
        Letra letra = null;
        int posicionSilaba = 0;
        int j = 0;
        String idreto = ""+idReto;
        String idaventura = ""+idAventura;
        String sql = "SELECT * FROM "+DendueContractClass.LETRAS_TABLE_NAME+" WHERE idReto="+idreto+" AND idAventura="+idaventura+";";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            letra = cursorToLetra(cursor);
            letras.add(letra);
        }
        return letras;
    }

    public ArrayList<Silaba> createSilabas(int idReto, int idAventura){
        ArrayList<Silaba> silabas = new ArrayList<Silaba>();
        String cadena = "";
        int posicionSilaba = 1;
        ArrayList<Letra> letras = createLetras(idReto, idAventura);

        for(int i = 0; i< letras.size(); i++) {
            Letra letra = letras.get(i);

            if(letra.getPosicionSilaba() == posicionSilaba){
                cadena+=letra.getLetra();
            }

            if(letra.getPosicionSilaba() != posicionSilaba){
                Silaba silaba = new Silaba(cadena, posicionSilaba);
                posicionSilaba = letra.getPosicionSilaba();
                cadena = ""+letra.getLetra();
            }
        }

        return silabas;
    }

    public Palabra createPalabra(int idReto, int idAventura){
        Palabra palabra = null;
        String cadena = "";
        int posicionSilaba = 1;

        ArrayList<Silaba> silabas = createSilabas(idReto, idAventura);
        for (int i=0; i<silabas.size(); i++){
            Silaba silaba = silabas.get(i);
            cadena+=silaba.getSilaba();
        }

        palabra = new Palabra(cadena);
        palabra.setSilabas(createSilabas(idReto, idAventura));
        palabra.setLetras(createLetras(idReto, idAventura));
        return palabra;

    }

    public ArrayList<Aventura> createAventuras(){
        ArrayList<Aventura> aventuras = new ArrayList<Aventura>();
        Cursor cursor = database.query(DendueContractClass.AVENTURAS_TABLE_NAME, columnsAventuras, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Aventura aventura = cursorToAventura(cursor);
            aventuras.add(aventura);
            cursor.moveToNext();
        }
        cursor.close();
        return aventuras;

    }

    public Aventura cursorToAventura(Cursor cursor){
        Aventura aventura = null;
        int id = Integer.parseInt(cursor.getString(0));
        String nombre = cursor.getString(1);
        String [] frases = new String[6];

        frases[0] = frasesHistoriaAventura(1,id);
        frases[1] = frasesHistoriaAventura(2,id);
        frases[2] = frasesHistoriaAventura(3,id);
        frases[3] = frasesHistoriaAventura(4,id);
        frases[4] = frasesHistoriaAventura(5,id);
        frases[5] = frasesHistoriaAventura(6,id);

        aventura = new Aventura(id, nombre);
        aventura.setHistoria(frases);
        aventura.setRetos(createRetos(id));
        return aventura;
    }

    public String frasesHistoriaAventura(int idReto, int idAventura){
        String frase = "";
        String idreto = ""+idReto;
        String idaventura = ""+idAventura;
        String sql = "SELECT "+DendueContractClass.ColumnFrasesHistoria.FRASE+" FROM "+DendueContractClass.FRASES_TABLE_NAME+" WHERE idReto="+idreto+" AND idAventura="+idaventura+";";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        frase = cursor.getString(0);
        return frase;
    }

    public ArrayList<String> createFrasesAleatoriasRetoDos(int idReto, int idAventura){
        ArrayList<String> frasesAleatorias = new ArrayList<String>();
        String cadena ="";
        String sql = "SELECT * FROM "+DendueContractClass.FRASES_ALEATORIAS_RETO_DOS+" WHERE idReto="+idReto+"AND idAventura="+idAventura+";";
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            cadena = cursor.getString(1);
            frasesAleatorias.add(cadena);
        }

        return frasesAleatorias;
    }


    public static Aplicacion getAplicacion(){
        return aplicacion;
    }

    public static void actualizarMedallaReto(int idReto, int idAventura, int tipoMedalla, int intentos){
        ContentValues cv = new ContentValues();
        cv.put(DendueContractClass.ColumnRetos.TIPO_MEDALLA_RETO, tipoMedalla);
        cv.put(DendueContractClass.ColumnRetos.COMPLETADO_RETO, 1);
        cv.put(DendueContractClass.ColumnRetos.INTENTOS_RETO, intentos);
        database.update(DendueContractClass.RETOS_TABLE_NAME, cv, DendueContractClass.ColumnRetos.ID_RETO + " = " + idReto + " AND " + DendueContractClass.ColumnRetos.ID_AVENTURA_RETO+" = "+idAventura, null);
    }
}
