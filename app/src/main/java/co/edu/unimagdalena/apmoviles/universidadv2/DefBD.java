package co.edu.unimagdalena.apmoviles.universidadv2;


public class DefBD {

    public static final String nameDb = "Universidad";
    public static final String tabla_estudiante = "estudiante";
    public static final String col_codigo = "codigo";
    public static final String col_nombre = "nombre";
    public static final String col_programa = "programa";

    public static final String create_tabla_estudiante = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_estudiante + " ( " +
            DefBD.col_codigo + " text primary key," +
            DefBD.col_nombre + " text," +
            DefBD.col_programa + " text" +
            ");";


}
