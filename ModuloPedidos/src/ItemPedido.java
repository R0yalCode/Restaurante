public class ItemPedido {
    //Atributos:
    private int cantidad;
    private String observacion;
    //Asociacion:
    private Cliente cliente;
    private Plato plato;
    //Constructor:
    public ItemPedido(Cliente cliente, Plato plato, int cantidad, String observacion) {
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.observacion = observacion;
        this.plato = plato;
    }
    //Getter:
    public int getCantidad() {
        return cantidad;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public String getObservacion() {
        return observacion;
    }
    public Plato getPlato() {
        return plato;
    }
}
