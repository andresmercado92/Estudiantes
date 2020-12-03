package co.edu.unimagdalena.apmoviles.universidadv2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EstudianteCursorAdapter extends CursorAdapter {
    public EstudianteCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_estudiante,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView cod = view.findViewById(R.id.txtcodigo);
        TextView nom = view.findViewById(R.id.txtnombre);
        TextView prg = view.findViewById(R.id.txtprograma);
        String codigo = cursor.getString(0);
        String nombre = cursor.getString(1);
        String prog = cursor.getString(2);
        cod.setText(codigo);
        nom.setText(nombre);
        prg.setText(prog);
    }
}

