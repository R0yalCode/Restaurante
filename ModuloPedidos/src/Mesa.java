import java.util.ArrayList;
import java.util.List;

public class Mesa {
    //Atributos:
    private int numero;
    private static int contador=1;
    private int capacidad;
    private boolean disponible;
    //Constructor:
    public Mesa(int capacidad) {
        this.capacidad = capacidad;
        this.disponible = true;
        this.numero = contador++;
    }
    //Getter:
    public int getCapacidad() {
        return capacidad;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public int getNumero() {
        return numero;
    }
    //Metodos:
    public void reservar(Mesa mesa){
        mesa.disponible=false;
    }
    public void desocupar(Mesa mesa){
        mesa.disponible=true;
    }
    // ---------------------------------
    public void indicarMesa(){
        System.out.println("| Mesa: "+numero+" | Capacidad: "+capacidad+" personas | Disponible: "+disponible+" |");
    }
}
