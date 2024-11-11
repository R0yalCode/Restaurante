public class Mesero extends Empleado{
    //Constructor:
    public Mesero(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
    }
    //Metodos:
    public void entregarPedido(Cliente cliente){
        actualizarEstado(Estado.SERVIDO,cliente);
        System.out.println("El pedido "+cliente.getPedido().getNumero()+" fue entregado al cliente "+cliente.getNombre());
    }
}
