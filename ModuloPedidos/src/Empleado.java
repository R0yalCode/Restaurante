public abstract class Empleado extends Persona{
    protected static int contador;
    protected String identificacion;
    //Constructor:
    public Empleado(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.identificacion="24"+contador++;
    }
    //Getter:
    public String getIdentificacion() {
        return identificacion;
    }
    //Metodo:
    public void actualizarEstado(Estado estado, Cliente cliente){
        cliente.getPedido().setEstado(estado);
    }
    public Estado visualizarEstado(Cliente cliente){
        return cliente.getPedido().getEstado();
    }
}
