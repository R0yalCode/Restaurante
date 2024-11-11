import java.util.ArrayList;
import java.util.List;
public class Historial {
    //Atributos:
    private List <String> informacionList;
    //Asociacion:
    private List <Pedido> pedidos;
    // Constructor:
    public Historial() {
        this.informacionList = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    // Metodos:
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
        String informacion = pedido.registrarInformacion();
        informacionList.add(informacion);
        System.out.println("Pedido " + pedido.getNumero() + " agregado al historial del cliente.");
    }
    public void mostrarHistorial() {
        if (informacionList.isEmpty()) {
            System.out.println("El cliente no tiene pedidos en su historial.");
        } else {
            System.out.println("---- Historial de pedidos ----");
            for (String informacion : informacionList) {
                System.out.println(informacion);
            }
        }
    }
}



