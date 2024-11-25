import java.util.ArrayList;
import java.util.List;
public class RegistroHistorico {
    //Asociacion:
    private List <Pedido> pedidos;
    private Restaurante restaurante;
    //Constructor:
    public RegistroHistorico(Restaurante restaurante) {
        this.restaurante = restaurante;
        this.pedidos = new ArrayList<>();
    }
    //Metodos:
    public void registrarPedido(Pedido pedido){
        pedidos.add(pedido);
        System.out.println("{ Pedido "+pedido.getNumero()+" guardado en el Registro del restaurante }");
    }
    public void mostrarListaPedidos(){
        System.out.println("[------- Registro Historico -------]");
        for (Pedido pedido : pedidos){
            System.out.println("| Pedido: "+pedido.getNumero()+" | Fecha: "+pedido.getFechaActual()+" |");
        }
        System.out.println("[__________________________________]");
    }
}
