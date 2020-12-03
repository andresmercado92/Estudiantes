package co.edu.unimagdalena.apmoviles.universidadv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Estudiante e;
    EstudianteController ec;
    EditText codigo, nombre, programa;
    Button agregar, cancelar, mostrar, editar, eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregar = findViewById(R.id.btnguardar);
        cancelar = findViewById(R.id.btncancelar);
        mostrar = findViewById(R.id.btnlistado);
        codigo = findViewById(R.id.edtcodigo);
        nombre = findViewById(R.id.edtnombre);
        programa = findViewById(R.id.edtprograma);
        editar = findViewById(R.id.btneditar);
        eliminar = findViewById(R.id.btneliminar);

        editar.setOnClickListener(this);
        eliminar.setOnClickListener(this);
        agregar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
        ec = new EstudianteController(this);

        String cod = "";
        String nom = "";
        String prog = "";

        Intent recdData = getIntent();
        cod = recdData.getStringExtra("codigoItem");
        nom = recdData.getStringExtra("nombreItem");
        prog = recdData.getStringExtra("programaItem");
        codigo.setText(cod);
        nombre.setText(nom);
        programa.setText(prog);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnguardar: //agregarEstudiante(e);
                if(TextUtils.isEmpty(codigo.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(programa.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }
                else{
                    e = new Estudiante(codigo.getText().toString(),nombre.getText().toString(),
                            programa.getText().toString());
                    if (ec.buscarEstudiante(e.getCodigo())){
                        Toast.makeText(this,"Estudiante ya esta registrado", Toast.LENGTH_LONG).show();
                    }
                    else{
                        ec.agregarEstudiante(e);
                    }
                }
                break;
            case R.id.btnlistado:
               /* Cursor c = ec.allEstudiantes();
                String cadena = "";
                while (c.moveToNext()){
                    cadena = cadena + c.getString(1) + ",";
                }
                Toast.makeText(this,cadena,Toast.LENGTH_LONG).show();*/
                Intent i = new Intent(this, ListadoActivity.class);
                i.putExtra("codigoItem", "");
                i.putExtra("nombreItem", "");
                i.putExtra("programaItem", "");
                startActivity(i);
                break;
            case R.id.btneliminar:
                if(TextUtils.isEmpty(codigo.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(programa.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }
                else{
                    e = new Estudiante(codigo.getText().toString(),nombre.getText().toString(),programa.getText().toString());
                    if (ec.buscarEstudiante(e.getCodigo())){
                        ec.eliminarEstudiante(e);
                    }else{
                        Toast.makeText(this,"Estudiante No encontrado", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.btneditar:
                if(TextUtils.isEmpty(codigo.getText().toString()) || TextUtils.isEmpty(nombre.getText().toString()) ||
                        TextUtils.isEmpty(programa.getText().toString())){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }
                else{
                    e = new Estudiante(codigo.getText().toString(),nombre.getText().toString(),programa.getText().toString());
                    if (ec.buscarEstudiante(e.getCodigo())){
                        ec.editarEstudiante(e);
                    }else{
                        Toast.makeText(this,"Estudiante No encontrado", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }


}
