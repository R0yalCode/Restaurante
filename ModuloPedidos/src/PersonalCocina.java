public class PersonalCocina extends Empleado{
    //Atributos:
    private boolean estaCocinando;
    //Asociacion:
    private Cliente cliente;
    //Constructor:
    public PersonalCocina(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.estaCocinando=false;
    }
    //Getter:
    public boolean isEstaCocinando() {
        return estaCocinando;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setEstaCocinando(boolean estaCocinando) {
        this.estaCocinando = estaCocinando;
    }
    //Metodos:
    public void prepararPedido(Cliente cliente){
        this.cliente = cliente;
        setEstaCocinando(true);
        int tiempoEspera=0;
        actualizarEstado(Estado.EN_PREPRACION,cliente);
        for (Plato plato : cliente.getPedido().getPlatos()) {
            if (plato.getNombre().equalsIgnoreCase("Pizza")) {
                tiempoEspera = 5;
                cliente.getPedido().mostrarTiempoEspera(tiempoEspera,plato);
            } else if (plato.getNombre().equalsIgnoreCase("Ensalada")) {
                tiempoEspera = 7;
                cliente.getPedido().mostrarTiempoEspera(tiempoEspera,plato);
            } else {
                tiempoEspera = 10;
                cliente.getPedido().mostrarTiempoEspera(tiempoEspera,plato);
            }
        }
    }
    public void servirPedido(Cliente cliente) {
        actualizarEstado(Estado.PREPARADO, cliente);
        System.out.println("El pedido " + cliente.getPedido().getNumero() + " ya esta listo para entregar");

    }
}
