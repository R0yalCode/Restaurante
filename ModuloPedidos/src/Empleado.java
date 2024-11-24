import java.util.List;
import java.util.ArrayList;
public abstract class Empleado extends Persona implements InteraccionPedido{
    protected static int contador;
    protected String identificacion;
    //Asociacion:
    protected List <Pedido> pedidos = new ArrayList<>();;
    //Constructor:
    public Empleado(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
    }
    //Getter:
    public String getIdentificacion() {
        return identificacion;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    //Metodo:
    @Override
    public void actualizarEstado(Estado estado, Pedido pedido) {
        pedido.setEstado(estado);
    }
    @Override
    public Estado visualizarEstado(Pedido pedido) {
        return pedido.getEstado();
    }
}
