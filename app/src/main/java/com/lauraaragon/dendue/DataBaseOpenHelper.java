package com.lauraaragon.dendue;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import modelo.Reto;

/**
 * Created by Laura Aragon on 28/10/2015.
 */
public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Dendue.db";

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DendueContractClass.CREATE_AVENTURAS_SCRIPT);
        db.execSQL(DendueContractClass.CREATE_RETOS_SCRIPT);
        db.execSQL(DendueContractClass.CREATE_SILABAS_SCRIPT);
        db.execSQL(DendueContractClass.CREATE_LETRAS_SCRIPT);
        db.execSQL(DendueContractClass.CREATE_FRASES_SCRIPT);
        db.execSQL(DendueContractClass.CREATE_FRASE_ALEATORIA_RETO_DOS);
        db.execSQL(DendueContractClass.INSERT_AVENTURAS_UNO_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_RETOS_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_SILABAS_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_LETRAS_RETO_UNO_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_LETRAS_RETO_DOS_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_LETRAS_RETO_TRES_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_LETRAS_RETO_CUATRO_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_LETRAS_RETO_SEIS_SCRIPT);
        db.execSQL(DendueContractClass.INSERT_FRASEALEATORIARETODOS_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
