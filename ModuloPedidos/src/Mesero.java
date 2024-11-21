public class Mesero extends Empleado{
    //Atributos:
    private boolean estaOcupado;
    //Constructor:
    public Mesero(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.estaOcupado = false;
        this.identificacion = "M0"+contador++;
    }
    //Getter:
    public boolean isEstaOcupado() {
        return estaOcupado;
    }
    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }
    //Metodos:
    public void entregarPedido(Pedido pedido){
        actualizarEstado(Estado.SERVIDO,pedido);
        System.out.println("El pedido "+pedido.getNumero()+" fue entregado al cliente "+pedido.getCliente().getNombre());
    }
}
