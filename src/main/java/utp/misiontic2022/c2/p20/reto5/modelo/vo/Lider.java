package utp.misiontic2022.c2.p20.reto5.modelo.vo;

public class Lider {
    // Definición de Objetos y caracteristicas
    private String Nombre;
    private String Primer_Apellido;
    private String Segundo_Apellido;
    private float Salario;

    // Constructor
    public Lider() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }

    public String getSegundo_Apellido() {
        return Segundo_Apellido;
    }

    public void setSegundo_Apellido(String segundo_Apellido) {
        Segundo_Apellido = segundo_Apellido;
    }

    public float getSalario() {
        return Salario;
    }

    public void setSalario(float salario) {
        Salario = salario;
    }
    
} 
