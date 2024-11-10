import java.util.List;
import java.util.ArrayList;
public class Menu {
    //private static List<Menu> menuList = new ArrayList<>();
    private List <Plato> platos;
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
    public void removerPlato(String nombre){
        for (Plato plato : platos) {
            if (platos.contains(plato)) {
                platos.remove(plato);
            }
        }
    }
    public void mostrarPlatos(){
        System.out.println("-> Platos disponibles:");
        for (Plato plato : platos) {
            System.out.println("| Plato: "+plato.getNombre()+" | Precio: $"+plato.getPrecio()+" |");
        }
    }

}
