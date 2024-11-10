import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Restaurante {
    //Asociacion:
    private List <Mesa> mesas;
    private Menu menu;
    private List <Cliente> clientes;
    private List <Plato> platos;
    //Constructor:
    public Restaurante() {
        this.mesas = new ArrayList<>();
        this.menu = new Menu();
        this.clientes = new ArrayList<>();
    }
    //Getter:
    public Menu getMenu() {
        return menu;
    }
    //Metodos:
    public void agregarMesa(int... capacidadList){
        for (int capacidad : capacidadList){
            mesas.add(new Mesa(capacidad));
        }
    }
    public boolean asignarMesa(Cliente cliente, int cantidadPersonas){
        for (Mesa mesa : mesas){
            if(mesa.isDisponible()&&(mesa.getCapacidad()==cantidadPersonas||mesa.getCapacidad()==(cantidadPersonas+1))){
                mesa.reservar(mesa);
                cliente.asignarMesa(mesa);
                return true;
            }
        }
        System.out.println("No hay mesas disponibles por el momento");
        return false;
    }
    public void removerMesa(int... numeros){
        for (int numero : numeros){
            for (Mesa mesa : mesas) {
                if(mesa.getNumero()==numero){
                    mesas.remove(mesa);
                }
            }
        }
    }
    public void mostrarMesasDisponibles(){
        for (Mesa mesa : mesas){
            if(mesa.isDisponible()){
                System.out.println("| Mesa: "+mesa.getNumero()+" | Capacidad: "+mesa.getCapacidad()+" | <- Esta disponible");
            }
        }
    }
    public boolean realizarReserva(Cliente cliente, int... numeros){
        for (int numero : numeros){
            for (Mesa mesa : mesas){
                if(mesa.getNumero()==numero && mesa.isDisponible()){
                    mesa.reservar(mesa);
                    cliente.asignarMesa(mesa);
                    clientes.add(cliente);
                    System.out.println("La mesa "+numero+" esta ahora reservada para "+cliente.getNombre());
                    return true;
                }
            }
            System.out.println("La mesa "+numero+" no esta disponible por el momento");
        }
        return false;
    }
    public void gestionarPedido(Cliente cliente,int cantidadPersonas, boolean esParaLlevar, Plato plato){
        if(clientes.contains(cliente)){
            cliente.realizarPedido(plato,cantidadPersonas,esParaLlevar);
            System.out.println("-> El plato ("+plato.getNombre()+") fue asignado al pedido del cliente "+cliente.getNombre());

        } else{
            System.out.println("! Cliente no registrado 1 !");
        }

    }
    public void mostrarMenu(){
        menu.mostrarPlatos();
    }
    public void escogerPlatos(Cliente cliente,int cantidadPersonas, boolean esParaLlevar, String... platosEscogidos) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        mostrarMenu();
        List<Plato> platoList = new ArrayList<>();
        if (!esParaLlevar && cliente.getMesa()==null) {
            asignarMesa(cliente, cantidadPersonas);
        }
        for (String platoEscogido : platosEscogidos) {
            boolean m = false;
            for (Plato plato : menu.getPlatos()) {
                if (platoEscogido.equalsIgnoreCase(plato.getNombre())) {
                    platoList.add(plato);
                    m = true;
                }
            }
            if (!m) {
                System.out.println("! No se  encontro (" + platoEscogido + ") dentro del menu !");

            }

        }
        for (Plato plato : platoList) {
            gestionarPedido(cliente, cantidadPersonas, esParaLlevar, plato);
        }

    }
    public void mostrarCuenta(Cliente cliente){
        if(cliente.getMesa()!=null||cliente.isEsParaLlevar()){
            cliente.realizarPago(cliente.valorPedido());
        } else{
            System.out.println("El cliente no ha realizado el pedido aun");
        }
    }
}
