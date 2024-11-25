public class PersonalCocina extends Empleado{
    //Atributos:
    private boolean estaCocinando;
    //Constructor:
    public PersonalCocina(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.estaCocinando=false;
    }
    //Getter:
    public boolean isEstaCocinando() {
        return estaCocinando;
    }
    public void setEstaCocinando(boolean estaCocinando) {
        this.estaCocinando = estaCocinando;
    }
    //Metodos:
    public void prepararPedido(Pedido pedido){
        setEstaCocinando(true);
        int tiempoEspera=0;
        actualizarEstado(Estado.EN_PREPRACION,pedido);
        pedidos.add(pedido);
        for (ItemPedido itemPedido : pedido.getItemPedidoList()) {
            if (itemPedido.getPlato().getNombre().equalsIgnoreCase("Pizza")) {
                tiempoEspera = 5;
                pedido.mostrarTiempoEspera(tiempoEspera,itemPedido);
            } else if (itemPedido.getPlato().getNombre().equalsIgnoreCase("Ensalada")) {
                tiempoEspera = 7;
                pedido.mostrarTiempoEspera(tiempoEspera,itemPedido);
            } else {
                tiempoEspera = 10;
                pedido.mostrarTiempoEspera(tiempoEspera,itemPedido);
            }
        }
    }
    public void servirPedido(Pedido pedido) {
        actualizarEstado(Estado.PREPARADO, pedido);
        System.out.println("-> El pedido "+pedido.getNumero()+" ya esta listo para entregar");

    }
}
