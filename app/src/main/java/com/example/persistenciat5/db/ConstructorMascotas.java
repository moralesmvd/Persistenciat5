package com.example.persistenciat5.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.persistenciat5.R;
import com.example.persistenciat5.db.BaseDatos;
import com.example.persistenciat5.db.ConstantesBaseDatos;
import com.example.persistenciat5.pojo.Mascota;
;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private static final int Hueso = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        BaseDatos db = new BaseDatos(context);
        insertarMisMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMisMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Vaca");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato1);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Caballo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato2);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Cabra");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato3);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Cerdo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato4);

        db.insertarMascota(contentValues);

        contentValues =  new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Oveja");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato5);

        db.insertarMascota(contentValues);
    }

    public void darHuesoMascota(Mascota mascota) {

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_HUESOS_MASCOTA_QTY_HUESOS, Hueso);
        db.insertarHuesosMascota(contentValues);
    }

    public int obtenerHuesosMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerHuesosMascota(mascota);
    }

}

