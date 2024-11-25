import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public class Pedido {
    //Atributos:
    private static int codigo=1;
    private LocalDate fechaActual;
    private String informacion;
    private int numero;
    //Asociacion:
    private Cliente cliente;
    private List <ItemPedido> itemPedidoList;
    private Mesa mesa;
    //Enumerador:
    private Estado estado;
    //Constructor:
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.estado = Estado.PENDIENTE;
        this.fechaActual = LocalDate.now();
        this.itemPedidoList = new ArrayList<>();
        this.numero = codigo++;
        System.out.println("{ Se creo el pedido "+getNumero()+" }");
    }
    //Getter:
    public Cliente getCliente() {
        return cliente;
    }
    public Estado getEstado() {
        return estado;
    }
    public LocalDate getFechaActual() {
        return fechaActual;
    }
    public String getInformacion() {
        return informacion;
    }
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }
    public int getNumero() {
        return numero;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }
    //Metodos:
    public void agregarItem(ItemPedido itemPedido){
        itemPedidoList.add(itemPedido);
    }
    public float calcularTotal(){
        float total=0;
        for (ItemPedido itempedido : itemPedidoList){
            total+=itempedido.getCantidad()*itempedido.getPlato().getPrecio();
        }
        return total;
    }
    public void mostrarTiempoEspera(int tiempo, ItemPedido itemPedido){
        System.out.println("-> El plato de ("+itemPedido.getPlato().getNombre()+") estara en "+tiempo+" minutos");
    }
    public void registrarInformacion(int numeroMesa) {
        if(numeroMesa==0){
            this.informacion = "| Nombre: " + cliente.getNombre() + " | Fecha: " + fechaActual + " | Pedido: " + numero +
                    " | Para Llevar: " + cliente.isEsParaLlevar() + " | Total: " + calcularTotal() + " |";
        } else {
            this.informacion = "| Nombre: " + cliente.getNombre() + " | Fecha: " + fechaActual + " | Pedido: " + numero +
                    " | Nro.Personas: " + cliente.getCantidadPersonas() + " | Para Llevar: " + cliente.isEsParaLlevar() +
                    " | Mesa: " + numeroMesa + " | Total: " + calcularTotal() + " |";
        }
    }
    public void removerItem(ItemPedido itemPedido){
        if(itemPedidoList.contains(itemPedido)){
            itemPedidoList.remove(itemPedido);
        }
    }
}
