public abstract class Persona {
    //Atributos:
    protected String cedula;
    protected String nombre;
    protected String telefono;
    //Constructor:
    public Persona(String nombre, String cedula, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    //Getter:
    public String getNombre() {
        return nombre;
    }
    public String getCedula() {
        return cedula;
    }
}
