import java.util.List;
import java.util.ArrayList;
public class Restaurante implements InteraccionCliente{
    //Asociacion:
    private List <Cliente> clientes;
    private List <Empleado> empleados;
    private Menu menu;
    private List <Mesa> mesas;
    private List <Pedido> pedidos;
    //Constructor:
    public Restaurante() {
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.menu = new Menu();
        this.mesas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }
    //Getter:
    public Menu getMenu() {
        return menu;
    }
    //Metodos:
    public void actualizarMenu(boolean esParaEliminar, String platoActualizar, float precio){
        boolean m = false;
        if(!esParaEliminar){
            for (Plato plato : menu.getPlatos()) {
                if(platoActualizar.equalsIgnoreCase(plato.getNombre())&&plato.getPrecio()!=precio){
                    plato.setPrecio(precio);
                    m = true;
                    System.out.println("El plato ("+plato.getNombre()+") ahora tiene el precio de $"+plato.getPrecio());
                }
            }
            if (!m) {
                System.out.println("! No se  encontro (" + platoActualizar + ") dentro del menu !");
            }
        } else{
            for (Plato plato : menu.getPlatos()) {
                if(platoActualizar.equalsIgnoreCase(plato.getNombre())&&plato.getPrecio()==precio){
                    menu.removerPlato(plato);
                    m = true;
                    System.out.println("-> El plato ("+plato.getNombre()+") ya no esta dentro del menu");
                }
            }
            if(!m){
                System.out.println("! No se  encontro (" + platoActualizar + ") dentro del menu !");
            }
        }
    }
    @Override
    public void anotarPedido(String cedulaCliente,boolean esParaLlevar, String platoEscogido,
                             int cantidad, String observacion){
        Cliente clientePedido = comprobarCliente(cedulaCliente);
        if(clientePedido==null) {
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
             if(clientePedido.getMesa()!=null || esParaLlevar) {
                boolean m = false;
                for (Plato plato : menu.getPlatos()) {
                    if (platoEscogido.equalsIgnoreCase(plato.getNombre())) {
                        clientePedido.realizarPedido(esParaLlevar, plato, cantidad, observacion);
                        m = true;
                    }
                }
                if (!m) {
                    System.out.println("! No se  encontro (" + platoEscogido + ") dentro del menu !");
                }
            } else{
                System.out.println("! No se puede tomar la orden ya que no tiene mesa asignada !");
            }
        }
    }
    @Override
    public void agregarCliente(String nombre, String cedula, String telefono){
        clientes.add(new Cliente(nombre,cedula,telefono));
    }
    public void agregarMesa(int... capacidadList){
        for (int capacidad : capacidadList){
            mesas.add(new Mesa(capacidad));
        }
    }
    public void agregarMesero(String nombre, String cedula, String telefono){
        empleados.add(new Mesero(nombre, cedula, telefono));
    }
    public void agregarPersonalCocina(String nombre,String cedula, String telefono){
        empleados.add(new PersonalCocina(nombre,cedula,telefono));
    }
    @Override
    public void asignarMesa(String cedulaCliente, int cantidadPersona){
        Cliente clienteMesa = comprobarCliente(cedulaCliente);
        if(clienteMesa==null) {
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else {
            boolean i = false;
            if(clienteMesa.getMesa()==null) {
                for (Mesa mesa : mesas) {
                    if (mesa.isDisponible() && (mesa.getCapacidad() == cantidadPersona ||
                            mesa.getCapacidad() == (cantidadPersona + 1)) && !i) {
                        mesa.reservar(mesa);
                        clienteMesa.ocuparMesa(mesa);
                        clienteMesa.setCantidadPersona(cantidadPersona);
                        mostrarMenu();
                        i = true;
                    }
                }
            } else{
                System.out.println("El cliente ya tiene reservado la mesa "+clienteMesa.getMesa().getNumero());
            }
            if(!i){
                System.out.println("No hay mesas disponibles por el momento");
            }
        }
    }
    @Override
    public void atenderPedido(String... cedulaClientes) {
        for (String cedulaCliente : cedulaClientes) {
            Cliente clienteAtender = comprobarCliente(cedulaCliente);
            if (clienteAtender == null) {
                System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
            } else {
                for (Empleado empleado : empleados) {
                    if (empleado instanceof Mesero) {
                        Mesero mesero = (Mesero) empleado;
                        if (!mesero.isEstaOcupado()) {
                            mesero.setEstaOcupado(true);
                            boolean i = false;
                            for (Pedido pedido : pedidos) {
                                if (pedido.getCliente() == clienteAtender && pedido.getEstado() == Estado.RESERVADO) {
                                    gestionarPedido(clienteAtender, pedido);
                                    gestionarEntregaPedido(mesero, clienteAtender, pedido);
                                    i = true;
                                }
                            }
                            if(!i) {
                                Pedido pedido = new Pedido(clienteAtender);
                                pedidos.add(pedido);
                                gestionarPedido(clienteAtender, pedido);
                                gestionarEntregaPedido(mesero, clienteAtender, pedido);
                            }

                        }
                    }
                }
            }
        }
    }
    public Cliente comprobarCliente(String cedulaCliente){
        for (Cliente cliente :clientes){
            if(cliente.getCedula().equals(cedulaCliente)){
                return cliente;
            }
        }
        return null;
    }
    public void gestionarEntregaPedido(Mesero mesero,Cliente cliente, Pedido pedido) {
        if (cliente.getMesa() != null || cliente.isEsParaLlevar()) {
            if (mesero.visualizarEstado(pedido) == Estado.RESERVADO) {
                mesero.actualizarEstado(Estado.PENDIENTE,pedido);
            }
            if (mesero.visualizarEstado(pedido) == Estado.PENDIENTE) {
                gestionarPedidoPendiente(pedido);
            }
            if (mesero.visualizarEstado(pedido) == Estado.EN_PREPRACION) {
                gestionarPedidoPreparacion(pedido);
            }
            if (mesero.visualizarEstado(pedido) == Estado.PREPARADO) {
                mesero.entregarPedido(pedido);
            }
            if (mesero.visualizarEstado(pedido) == Estado.SERVIDO) {
                mostrarCuenta(cliente,pedido);
                mesero.actualizarEstado(Estado.PAGADO, pedido);
            }
            if (mesero.visualizarEstado(pedido) == Estado.PAGADO) {
                mesero.setEstaOcupado(false);
                System.out.println("El pedido ya esta pagado");
            }
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no ha realizado el pedido aun");
        }
    }
    @Override
    public void gestionarPedido(Cliente cliente, Pedido pedido){
        pedido.setItemPedidoList(cliente.getItemPedidoList());
        System.out.println("-> El pedido ("+pedido.getNumero()+") del cliente "+cliente.getNombre()+" ahora esta en proceso");
    }
    private void gestionarPedidoPendiente(Pedido pedido){
        for(Empleado empleado : empleados){
            if(empleado instanceof PersonalCocina){
                PersonalCocina personalCocina = (PersonalCocina) empleado;
                if(!personalCocina.isEstaCocinando()){
                    personalCocina.prepararPedido(pedido);
                    return;
                }
            }
        }
    }
    private void gestionarPedidoPreparacion(Pedido pedido){
        System.out.println("El pedido "+pedido.getNumero()+" ya esta en preparacion");
        for(Empleado empleado : empleados){
            if(empleado instanceof PersonalCocina){
                PersonalCocina personalCocina = (PersonalCocina) empleado;
                if(personalCocina.isEstaCocinando()){
                    if(personalCocina.getPedidos().contains(pedido)){
                        personalCocina.servirPedido(pedido);
                        personalCocina.setEstaCocinando(false);
                    }
                }
            }
        }
    }
    @Override
    public void mostrarCuenta(Cliente cliente,Pedido pedido){
        System.out.println("Total a pagar: $"+pedido.calcularTotal());
        cliente.realizarPago(pedido.calcularTotal(),pedido);
    }
    public void mostrarHistorial(String cedulaCliente){
        Cliente clienteHistorial = comprobarCliente(cedulaCliente);
        if(clienteHistorial==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else{
            clienteHistorial.getHistorial().mostrarHistorial();
        }
    }
    @Override
    public void mostrarMenu() {
        menu.mostrarPlatos();
    }
    public void mostrarMesasDisponibles(){
        for (Mesa mesa : mesas){
            if(mesa.isDisponible()){
                System.out.println("| Mesa: "+mesa.getNumero()+" | Capacidad: "+mesa.getCapacidad()+" | <- Esta disponible");
            }
        }
    }
    public void mostrarTotalPedidos(){
        for (Pedido pedido : pedidos){
            System.out.println("--> Existe el pedido " + pedido.getNumero());
        }
    }
    @Override
    public void realizarReserva(String cedulaCliente, int cantidadPersona, int... numeros){
        Cliente clienteReservar = comprobarCliente(cedulaCliente);
        if(clienteReservar==null){
            System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
        } else {
            for (int numero : numeros) {
                for (Mesa mesa : mesas) {
                    if (mesa.getNumero() == numero && mesa.isDisponible() && (mesa.getCapacidad() == cantidadPersona ||
                                    mesa.getCapacidad() == (cantidadPersona + 1))) {
                        mesa.reservar(mesa);
                        clienteReservar.ocuparMesa(mesa);
                        clienteReservar.setCantidadPersona(cantidadPersona);
                        Pedido pedido = new Pedido(clienteReservar);
                        pedido.setEstado(Estado.RESERVADO);
                        pedidos.add(pedido);
                        System.out.println("La mesa "+numero+" esta ahora reservada para "+ clienteReservar.getNombre());
                        return;
                    }
                }
                System.out.println("La mesa " + numero + " no esta disponible por el momento");
            }
        }
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
}
