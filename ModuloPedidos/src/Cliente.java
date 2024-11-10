import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Cliente extends Persona{
    //Atributos:
    private int cantidadPersonas;
    private boolean esParaLlevar;
    //Asociacion:
    private Mesa mesa;
    private Pedido pedido;
    //Constructor:
    public Cliente(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.pedido = new Pedido(this);
    }
    //Getter:
    public Mesa getMesa() {
        return mesa;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public boolean isEsParaLlevar() {
        return esParaLlevar;
    }
    //Metodos:
    public void asignarMesa(Mesa mesaAsignada){
        this.mesa = mesaAsignada;
    }
    public void realizarPedido(Plato plato, int cantidadPersonas, boolean esParaLlevar){
        this.cantidadPersonas=cantidadPersonas;
        this.esParaLlevar=esParaLlevar;
        pedido.agregarPlato(plato);
    }
    public float valorPedido(){
        float total = pedido.calcularTotal();
        System.out.println("Total a pagar: $"+total);
        return total;
    }

    public void realizarPago(float total) {
        System.out.println("[ "+getNombre()+" realizo el pago de $"+total+" ]");
        if(!isEsParaLlevar()){
            mesa.desocupar(mesa);
        }
    }
}
