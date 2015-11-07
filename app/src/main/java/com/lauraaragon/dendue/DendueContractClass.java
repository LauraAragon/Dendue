package com.lauraaragon.dendue;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Laura Aragon on 29/10/2015.
 */
public class DendueContractClass {
    public static final String AVENTURAS_TABLE_NAME = "Aventuras";
    public static final String RETOS_TABLE_NAME = "Retos";
    public static final String SILABAS_TABLE_NAME = "Silabas";
    public static final String LETRAS_TABLE_NAME = "Letras";
    public static final String FRASES_TABLE_NAME = "FrasesHistoria";
    public static final String FRASES_ALEATORIAS_RETO_DOS = "FrasesRetoDos";
    public static final String VARCHAR_TYPE = "VARCHAR";
    public static final String INT_TYPE = "INT";
    public static final String CHAR_TYPE = "CHAR";
    public static final String BOOLEAN_TYPE = "BOOLEAN";

    public static class ColumnAventuras{
        public static final String ID_AVENTURA = "id" ;
        public static final String NOMBRE_AVENTURA = "nombre";
    }

    public static class ColumnRetos{
        public static final String ID_RETO = "id" ;
        public static final String TIPO_RETO = "tipo";
        public static final String COMPLETADO_RETO = "completado";
        public static final String INTENTOS_RETO = "intentos";
        public static final String TIPO_MEDALLA_RETO = "tipoMedalla";
        public static final String ID_AVENTURA_RETO = "idAventura";
    }

    public static class ColumnSilabas{
        public static final String POSICION_SILABA = "posicion" ;
        public static final String ID_RETO_SILABA = "idReto";
        public static final String ID_AVENTURA_SILABA = "idAventura";
    }

    public static class ColumnLetras{
        public static final String POSICION_LETRA = "posicion" ;
        public static final String LETRA = "letra";
        public static final String POSICION_SILABA_LETRA = "posicionSilaba";
        public static final String ID_RETO_LETRA = "idReto";
        public static final String ID_AVENTURA_LETRA = "idAventura";
    }

    public static class ColumnFrasesHistoria{
        public static final String FRASE = "frase" ;
        public static final String ID_RETO_FRASE= "idReto";
        public static final String ID_AVENTURA_FRASE = "idAventura";
    }

    public static class ColumnFraseAletoriaRetoDos{
        public static final String ID_ALEATORIA_RETO_DOS = "id";
        public static final String FRASE = "frase";
    }

    public static final String CREATE_FRASE_ALEATORIA_RETO_DOS =
           "create table if not exists "+FRASES_ALEATORIAS_RETO_DOS+"(" +
            ColumnFraseAletoriaRetoDos.ID_ALEATORIA_RETO_DOS+" "+INT_TYPE+", " +
            ColumnFraseAletoriaRetoDos.FRASE+" "+VARCHAR_TYPE+"(100), "+
            "PRIMARY KEY(id);";

    public static final String CREATE_AVENTURAS_SCRIPT =
            "create table if not exists "+AVENTURAS_TABLE_NAME+"(" +
                    ColumnAventuras.ID_AVENTURA+" "+INT_TYPE+", " +
                    ColumnAventuras.NOMBRE_AVENTURA+" "+VARCHAR_TYPE+"(30), " +
                    "PRIMARY KEY(id));";

    public static final String CREATE_RETOS_SCRIPT =
        "create table if not exists "+RETOS_TABLE_NAME+"(" +
                ColumnRetos.ID_RETO+" "+INT_TYPE+", " +
                ColumnRetos.TIPO_RETO+" "+INT_TYPE + ", "+
                ColumnRetos.COMPLETADO_RETO+" "+BOOLEAN_TYPE + ", "+
                ColumnRetos.INTENTOS_RETO+" "+INT_TYPE + ", "+
                ColumnRetos.TIPO_MEDALLA_RETO+" "+INT_TYPE + ", "+
                ColumnRetos.ID_AVENTURA_RETO+" "+INT_TYPE + ", "+
                "PRIMARY KEY (id), FOREIGN KEY (idAventura) REFERENCES Aventura(id));";


    public static final String CREATE_SILABAS_SCRIPT =
            "create table if not exists "+SILABAS_TABLE_NAME+"(" +
                    ColumnSilabas.POSICION_SILABA+" "+INT_TYPE+", " +
                    ColumnSilabas.ID_RETO_SILABA+" "+INT_TYPE+", " +
                    ColumnSilabas.ID_AVENTURA_SILABA + " " + INT_TYPE+", "+
                    "FOREIGN KEY (idReto, idAventura) REFERENCES Retos(id, idAventura));";


    public static final String CREATE_LETRAS_SCRIPT =
            "create table if not exists "+LETRAS_TABLE_NAME+"(" +
                    ColumnLetras.POSICION_LETRA+" "+INT_TYPE+", " +
                    ColumnLetras.LETRA+" "+CHAR_TYPE+", " +
                    ColumnLetras.POSICION_SILABA_LETRA + " " + INT_TYPE+", "+
                    ColumnLetras.ID_RETO_LETRA + " " + INT_TYPE + ", "+
                    ColumnLetras.ID_AVENTURA_LETRA + " " + INT_TYPE + ", " +
                    "FOREIGN KEY (posicionSilaba, idReto, idAventura) REFERENCES Silabas(posicion, idReto, idAventura));";

    public static final String CREATE_FRASES_SCRIPT =
            "create table if not exists "+FRASES_TABLE_NAME+"(" +
                    ColumnFrasesHistoria.FRASE+" "+VARCHAR_TYPE+"(1000)" + ", " +
                    ColumnFrasesHistoria.ID_RETO_FRASE+" "+INT_TYPE+", " +
                    ColumnFrasesHistoria.ID_AVENTURA_FRASE + " " + INT_TYPE+", "+
                    "PRIMARY KEY(idReto, idAventura), FOREIGN KEY (idReto) REFERENCES Retos(id), FOREIGN KEY (idAventura) REFERENCES Aventura(id));";



    public static final String INSERT_LETRAS_RETO_SEIS_SCRIPT =
            "insert into"+LETRAS_TABLE_NAME +"VALUES(1, 'B', 1, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(2, 'I', 1, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(3, 'E', 2, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(4, 'N', 2, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(5, 'V', 3, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(6, 'E', 3, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(7, 'N', 4, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(8, 'I', 4, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(9, 'D', 5, 6, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(10, 'O', 5, 6, 1);";

    public static final String INSERT_LETRAS_RETO_UNO_SCRIPT =
            "insert into"+LETRAS_TABLE_NAME +"VALUES(1, 'E', 1, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(2, 'N', 1, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(3, 'C', 2, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(4, 'E', 2, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(5, 'N', 2, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(6, 'D', 3, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(7, 'E', 3, 1, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(8, 'R', 3, 1, 1);";

    public static final String INSERT_LETRAS_RETO_TRES_SCRIPT =
            "insert into"+LETRAS_TABLE_NAME +"VALUES(1, 'A', 1, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(2, 'M', 2, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(3, 'A', 2, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(4, 'N', 3, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(5, 'E', 3, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(6, 'C', 4, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(7, 'E', 4, 3, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(8, 'R', 4, 3, 1);";

    public static final String INSERT_LETRAS_RETO_CUATRO_SCRIPT =
            "insert into"+LETRAS_TABLE_NAME +"VALUES(1, 'N', 1, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(2, 'A', 1, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(3, 'T', 2, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(4, 'U', 2, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(5, 'R', 3, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(6, 'A', 3, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(7, 'L', 4, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(8, 'E', 4, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(9, 'Z', 5, 4, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(10, 'A', 5, 4, 1);";

    public static final String INSERT_LETRAS_RETO_DOS_SCRIPT =
            "insert into"+LETRAS_TABLE_NAME +"VALUES(1, 'E', 1, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(2, 'L', 1, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(3, 'B', 2, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(4, 'O', 2, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(5, 'S', 2, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(6, 'Q', 3, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(7, 'U', 3, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(8, 'E', 3, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(9, 'E', 4, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(10, 'S', 4, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(11, 'H', 5, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(12, 'E', 5, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(13, 'R', 5, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(14, 'M', 6, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(15, 'O', 6, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(16, 'S', 7, 2, 1);" +
            "insert into"+LETRAS_TABLE_NAME +"VALUES(17, 'O', 7, 2, 1);";


    public static final String INSERT_AVENTURAS_UNO_SCRIPT =
            "insert into"+AVENTURAS_TABLE_NAME +"VALUES(1, '');";

    public static final String INSERT_RETOS_SCRIPT =
            "insert into"+RETOS_TABLE_NAME +"VALUES(1, 1, 0, 0, 0, 1)" +
            "insert into"+RETOS_TABLE_NAME +"VALUES(2, 1, 0, 0, 0, 1)" +
            "insert into"+RETOS_TABLE_NAME +"VALUES(3, 2, 0, 0, 0, 1)" +
            "insert into"+RETOS_TABLE_NAME +"VALUES(4, 2, 0, 0, 0, 1)" +
            "insert into"+RETOS_TABLE_NAME +"VALUES(5, 3, 0, 0, 0, 1)" +
            "insert into"+RETOS_TABLE_NAME +"VALUES(6, 3, 0, 0, 0, 1)";

    public static final String INSERT_SILABAS_SCRIPT =
            "insert into"+SILABAS_TABLE_NAME +"VALUES(1, 1, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(2, 1, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(3, 1, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(1, 3, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(2, 3, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(3, 3, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(4, 3, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(1, 4, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(2, 4, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(3, 4, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(4, 4, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(5, 4, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(1, 6, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(2, 6, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(3, 6, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(4, 6, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(5, 6, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(1, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(2, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(3, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(4, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(5, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(6, 2, 1);" +
            "insert into"+SILABAS_TABLE_NAME +"VALUES(7, 2, 1);";

    public static final String INSERT_FRASEALEATORIARETODOS_SCRIPT =
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(1, 'FLORES;EN;EL;CAMPO');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(2, 'EN;EL;PARQUE;JUGAMOS');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(3, 'EL;AGUA;TIENE;PECES');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(4, 'VIVE;EN;UN;BOSQUE');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(5, 'UN;BOSQUE;MUY;GRANDE');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(6, 'VOY;AL;BOSQUE;SIEMPRE');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(7, 'LA;PLANTA;ES;LINDA');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(8, 'MARCUS;ES;MUY;CURIOSO');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(9, 'ES;UN;LINDO;DIA');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(10, 'UN;HERMOSO;HONGO;ROJO');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(11, 'LA;NIÑA;VISTE;HERMOSO');" +
            "insert into"+FRASES_ALEATORIAS_RETO_DOS +"VALUES(12, 'TUVE;UN;HERMOSO;SUEÑO');" ;


    private DataBaseOpenHelper openHelper;
    private SQLiteDatabase database;

    public DendueContractClass(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new DataBaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }
}