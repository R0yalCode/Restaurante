import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
public class Pedido {
    //Atributos:
    private int numero;
    private static int codigo=1;
    private LocalDate fechaActual;
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
    public int getNumero() {
        return numero;
    }
    public Estado getEstado() {
        return estado;
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
    public void removerPlato(Plato plato){
        if(platos.contains(plato)){
            platos.remove(plato);
        }
    }
    public float calcularTotal(){
        float total=0;
        for(Plato plato: platos){
            total+=plato.getPrecio();
        }
        return total;
    }
    public void tiempoEspera(int tiempo){
        System.out.println("El plato estara en "+tiempo+" minutos");
    }
    public String registrarInformacion(){
        return "| Nombre: "+cliente.getNombre()+" | Fecha: "+fechaActual+" | Pedido: "+numero+
                " | Nro.Personas: "+cliente.getCantidadPersonas()+" | Para Llevar: "+cliente.isEsParaLlevar()+
                " | Mesa: "+cliente.getMesa()+" | Total: "+cliente.valorPedido()+" |";
    }



}
