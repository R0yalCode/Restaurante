public class Empleado extends Persona{
    protected String identificacion;
    private static int contador;
    //Asociacion:
    private Pedido pedido;
    //Constructor:
    public Empleado(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.identificacion="24"+contador++;
    }
    //Metodo:
    public void visualizarEstado(Cliente... clientes){
        for(Cliente cliente : clientes){
            System.out.println("-> El pedido "+cliente.getPedido().getNumero()+" se encuentra "+cliente.getPedido().getEstado());
        }
    }
    public void actualizarEstado(Estado estado, Cliente... clientes){
        for(Cliente cliente : clientes){
            cliente.getPedido().setEstado(estado);
            System.out.println("El pedido "+cliente.getPedido().getNumero()+" ahora esta "+cliente.getPedido().getEstado());
        }

    }
}
