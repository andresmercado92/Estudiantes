package co.edu.unimagdalena.apmoviles.universidadv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(@Nullable Context context,int version) {
        super(context, DefBD.nameDb, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DefBD.create_tabla_estudiante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

}
