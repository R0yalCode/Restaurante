import java.util.ArrayList;
import java.util.List;
public class Cliente extends Persona{
    //Atributos:
    private int cantidadPersona;
    private boolean esParaLlevar;
    //Asociacion:
    private Historial historial;
    private List <ItemPedido> itemPedidoList;
    private Mesa mesa;
    //Constructor:
    public Cliente(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.historial = new Historial();
        this.itemPedidoList = new ArrayList<>();
    }
    //Getter:
    public int getCantidadPersonas() {
        return cantidadPersona;
    }
    public Historial getHistorial() {
        return historial;
    }
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public boolean isEsParaLlevar() {
        return esParaLlevar;
    }
    public void setCantidadPersona(int cantidadPersona) {
        this.cantidadPersona = cantidadPersona;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    //Metodos:
    public void ocuparMesa(Mesa mesaOcupada){
        this.mesa = mesaOcupada;
    }
    public void modificarPedido(ItemPedido itemPedido, boolean esParaEliminar){
        if(esParaEliminar){
            if(itemPedidoList.contains(itemPedido)){
                itemPedidoList.remove(itemPedido);
            } else{
                System.out.println("El pedido no posee dicho item");
            }
        } else{
            itemPedidoList.add(itemPedido);
            System.out.println("El item fue agregado al pedido");
        }
    }
    public void realizarPago(float total,Pedido pedido) {
        System.out.println("[ "+getNombre()+" realizo el pago de $"+total+" ]");
        if(mesa!=null) {
            historial.agregarPedido(pedido, mesa.getNumero());
        } else{
            historial.agregarPedido(pedido, 0);
        }
        if(!isEsParaLlevar()){
            mesa.desocupar(mesa);
            System.out.println(getNombre()+" ha desocupado la mesa "+mesa.getNumero());
            setMesa(mesa=null);
        }
        itemPedidoList.clear();
    }
    public void realizarPedido(boolean esParaLlevar, Plato plato, int cantidad, String observacion){
        this.esParaLlevar = esParaLlevar;
        boolean m = false;
        itemPedidoList.add(new ItemPedido(this,plato,cantidad,observacion));
        if(observacion.equalsIgnoreCase("Ninguna")) {
            System.out.println(getNombre() + " pidio [" + cantidad + "] (" + plato.getNombre() + ")");
        } else{
            System.out.println(getNombre() + " pidio [" + cantidad + "] (" + plato.getNombre() + ") {"+observacion+"}");
        }
    }
    public void visualizarMesaAsignada(){
        System.out.println("El cliente ("+getNombre()+") ocupa la mesa "+mesa.getNumero());
    }
}
