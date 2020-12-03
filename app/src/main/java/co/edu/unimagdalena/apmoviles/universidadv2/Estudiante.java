package co.edu.unimagdalena.apmoviles.universidadv2;

public class Estudiante {

    private String codigo;
    private String nombre;
    private String programa;

    public Estudiante(String codigo, String nombre, String programa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.programa = programa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", programa='" + programa + '\'' +
                '}';
    }
}

