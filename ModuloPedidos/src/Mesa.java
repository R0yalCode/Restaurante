public class Mesa {
    //Atributos:
    private int capacidad;
    private static int contador=1;
    private boolean disponible;
    private int numero;
    //Constructor:
    public Mesa(int capacidad) {
        this.capacidad = capacidad;
        this.disponible = true;
        this.numero = contador++;
    }
    //Getter:
    public boolean isDisponible() {
        return disponible;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public int getNumero() {
        return numero;
    }
    //Metodos:
    public void desocupar(Mesa mesa){
        mesa.disponible=true;
    }
    public void reservar(Mesa mesa){
        mesa.disponible=false;
    }
}
