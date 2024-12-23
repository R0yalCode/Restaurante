import java.util.List;
import java.util.ArrayList;
public class Menu {
    //Asociacion:
    private List <Plato> platos;
    //Constructor:
    public Menu() {
        this.platos = new ArrayList<>();
    }
    //Getter:
    public List<Plato> getPlatos() {
        return platos;
    }
    //Metodos:
    public void agregarPlato(String nombre, float precio){
        platos.add(new Plato(nombre,precio));
    }
    public void mostrarPlatos(){
        System.out.println("|-------- Platos disponibles --------|");
        for (Plato plato : platos) {
            System.out.println("[ Plato: "+plato.getNombre()+" | Precio: $"+plato.getPrecio()+" ]");
        }
        System.out.println("|____________________________________|");
    }
    public void removerPlato(Plato platoRemover){
        for (Plato plato : platos) {
            if (platos.contains(platoRemover)) {
                platos.remove(platoRemover);
            }
        }
    }
}
