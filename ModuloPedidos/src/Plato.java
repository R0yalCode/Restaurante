public class Plato {
    //Atributos:
    private String nombre;
    private float precio;
    //Constructor:
    public Plato(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    //Getter:
    public String getNombre() {
        return nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
