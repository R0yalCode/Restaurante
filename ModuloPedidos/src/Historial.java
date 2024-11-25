import java.util.ArrayList;
import java.util.List;
public class Historial {
    //Asociacion:
    private List <Pedido> pedidos;
    // Constructor:
    public Historial() {
        this.pedidos = new ArrayList<>();
    }
    // Metodos:
    public void agregarPedido(Pedido pedido, int numeroMesa) {
        pedidos.add(pedido);
        pedido.registrarInformacion(numeroMesa);
        System.out.println("--> Pedido " + pedido.getNumero() + " agregado al historial del cliente.");
    }
    public void mostrarInformacion() {
        if (pedidos.isEmpty()) {
            System.out.println("! El cliente no tiene pedidos en su historial! ");
        } else {
            System.out.println("---------------------------------------------- Historial de pedidos " +
                    "----------------------------------------------");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido.getInformacion());
            }
        }
    }
}



