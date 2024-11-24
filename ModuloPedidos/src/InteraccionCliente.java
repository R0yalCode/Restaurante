public interface InteraccionCliente {
    public void agregarCliente(String nombre, String cedula, String telefono);
    public void anotarPedido(String cedulaCliente,boolean esParaLlevar, String platoEscogido,
                             int cantidad, String observacion);
    public void asignarMesa(String cedulaCliente, int cantidadPersonas);
    public void atenderPedido(String... cedulaClientes);
    public void gestionarPedido(Cliente cliente, Pedido pedido);
    public void mostrarCuenta(Cliente cliente,Pedido pedido);
    public void mostrarMenu();
    public void realizarReserva(String cedulaCliente, int cantidadPersona, int... numeros);
}
