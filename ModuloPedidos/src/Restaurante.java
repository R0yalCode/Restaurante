import java.util.List;
import java.util.ArrayList;
public class Restaurante {
    //Asociacion:
    private List <Cliente> clientes;
    private Menu menu;
    private List <Mesa> mesas;
    private List <Mesero> meseros;
    private List <PersonalCocina> personalCocinaList;
    //Constructor:
    public Restaurante() {
        this.clientes = new ArrayList<>();
        this.menu = new Menu();
        this.mesas = new ArrayList<>();
        this.meseros = new ArrayList<>();
        this.personalCocinaList = new ArrayList<>();
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
    public void agregarPersonalCocina(String nombre,String cedula, String telefono){
        personalCocinaList.add(new PersonalCocina(nombre,cedula,telefono));
    }
    private boolean asignarMesa(Cliente cliente, int cantidadPersona){
        for (Mesa mesa : mesas){
            if(mesa.isDisponible()&&(mesa.getCapacidad()==cantidadPersona||mesa.getCapacidad()==(cantidadPersona+1))){
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
    private void gestionarPedido(Cliente cliente,int cantidadPersona, boolean esParaLlevar, Plato plato, Pedido pedido){
        if(clientes.contains(cliente)){
            cliente.realizarPedido(plato,cantidadPersona,esParaLlevar,pedido);
            System.out.println("-> El plato ("+plato.getNombre()+") fue asignado al pedido del cliente "+cliente.getNombre());

        } else{
            System.out.println("! Cliente no registrado !");
        }

    }
    private void mostrarMenu(){
        menu.mostrarPlatos();
    }
    public void escogerPlatos(Cliente cliente,int cantidadPersona, boolean esParaLlevar, String... platosEscogidos) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
        mostrarMenu();
        List<Plato> platoList = new ArrayList<>();
        if (!esParaLlevar && cliente.getMesa()==null) {
            asignarMesa(cliente, cantidadPersona);
        }
        Pedido pedido = new Pedido(cliente);
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
            gestionarPedido(cliente, cantidadPersona, esParaLlevar, plato, pedido);
        }
    }
    private void mostrarCuenta(Cliente cliente){
        System.out.println("Total a pagar: $"+cliente.valorPedido());
        cliente.realizarPago(cliente.valorPedido());
    }
    public void gestionarEntregaPedido(Mesero mesero,Cliente... clientes){
        if(!meseros.contains(mesero)){
            meseros.add(mesero);
        }
        for (Cliente cliente : clientes){
            if(cliente.getMesa()!=null||cliente.isEsParaLlevar()) {
                if (mesero.visualizarEstado(cliente) == Estado.PENDIENTE) {
                    gestionarPedidoPendiente(cliente);
                }
                if (mesero.visualizarEstado(cliente) == Estado.EN_PREPRACION) {
                    gestionarPedidoPreparacion(cliente);
                }
                if (mesero.visualizarEstado(cliente) == Estado.PREPARADO) {
                    mesero.entregarPedido(cliente);
                }
                if (mesero.visualizarEstado(cliente) == Estado.SERVIDO) {
                    mostrarCuenta(cliente);
                    mesero.actualizarEstado(Estado.PAGADO, cliente);
                }
                if (mesero.visualizarEstado(cliente) == Estado.PAGADO) {
                    System.out.println("El pedido ya esta pagado");
                }
            } else{
                System.out.println("El cliente "+cliente.getNombre()+" no ha realizado el pedido aun");
            }
        }
    }
    private void gestionarPedidoPendiente(Cliente cliente){
        for (PersonalCocina personalCocina : personalCocinaList){
            if(!personalCocina.isEstaCocinando()){
                personalCocina.prepararPedido(cliente);
                return;
            }
        }
    }
    private void gestionarPedidoPreparacion(Cliente cliente){
        System.out.println("El pedido "+cliente.getPedido().getNumero()+" ya esta en preparacion");
        for (PersonalCocina personalCocina : personalCocinaList){
            if(personalCocina.isEstaCocinando()) {
                if (personalCocina.getCliente() == cliente) {
                    personalCocina.servirPedido(cliente);
                    personalCocina.setEstaCocinando(false);
                }

            }
        }
    }
}
