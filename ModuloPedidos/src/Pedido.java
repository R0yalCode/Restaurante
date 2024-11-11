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
    private List <Plato> platos;
    //Enumerador:
    private Estado estado;
    //Constructor:
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.fechaActual = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.platos = new ArrayList<>();
        this.numero = codigo++;
    }
    //Getter:
    public Estado getEstado() {
        return estado;
    }
    public String getInformacion() {
        return informacion;
    }
    public int getNumero() {
        return numero;
    }
    public List<Plato> getPlatos() {
        return platos;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    //Metodos:
    public void agregarPlato(Plato plato){
        platos.add(plato);
    }
    public float calcularTotal(){
        float total=0;
        for(Plato plato: platos){
            total+=plato.getPrecio();
        }
        return total;
    }
    public void registrarInformacion(int numeroMesa) {
        if(numeroMesa==0){
            this.informacion = "| Nombre: " + cliente.getNombre() + " | Fecha: " + fechaActual + " | Pedido: " + numero +
                    " | Nro.Personas: " + cliente.getCantidadPersonas() + " | Para Llevar: " + cliente.isEsParaLlevar() +
                    " | Mesa: Null | Total: " + cliente.valorPedido() + " |";
        } else {
            this.informacion = "| Nombre: " + cliente.getNombre() + " | Fecha: " + fechaActual + " | Pedido: " + numero +
                    " | Nro.Personas: " + cliente.getCantidadPersonas() + " | Para Llevar: " + cliente.isEsParaLlevar() +
                    " | Mesa: " + numeroMesa + " | Total: " + cliente.valorPedido() + " |";
        }
    }
    public void removerPlato(Plato plato){
        if(platos.contains(plato)){
            platos.remove(plato);
        }
    }
    public void mostrarTiempoEspera(int tiempo, Plato plato){
        System.out.println("El plato de ("+plato.getNombre()+") estara en "+tiempo+" minutos");
    }

}
