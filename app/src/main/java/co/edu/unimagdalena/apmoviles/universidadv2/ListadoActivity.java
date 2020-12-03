package co.edu.unimagdalena.apmoviles.universidadv2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity {

    ListView listado;
    EstudianteController estudianteController;
    private Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        mCtx = this;
        listado = findViewById(R.id.lstlistado);
        estudianteController = new EstudianteController(this);
        Cursor c = estudianteController.allEstudiantes2();
        EstudianteCursorAdapter estcursor = new EstudianteCursorAdapter(this,c,false);
        listado.setAdapter(estcursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView nombre = view.findViewById(R.id.txtnombre);
                TextView codigo = view.findViewById(R.id.txtcodigo);
                TextView programa = view.findViewById(R.id.txtprograma);
                Intent i = new Intent(mCtx, MainActivity.class);
                i.putExtra("nombreItem", nombre.getText().toString());
                i.putExtra("codigoItem", codigo.getText().toString());
                i.putExtra("programaItem", programa.getText().toString());
                startActivity(i);
            }
        });
    }
}
