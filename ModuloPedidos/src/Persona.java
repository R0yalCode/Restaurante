public abstract class Persona {
    //Atributos:
    private String nombre;
    private String cedula;
    private String telefono;
    //Constructor:
    public Persona(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }
    //Getter:
    public String getNombre() {
        return nombre;
    }
}
