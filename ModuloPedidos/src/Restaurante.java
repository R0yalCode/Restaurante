import java.util.List;
import java.util.ArrayList;
public class Restaurante implements InteraccionCliente{
    //Asociacion:
    private List <Cliente> clientes;
    private List <Empleado> empleados;
    private Menu menu;
    private List <Mesa> mesas;
    private List <Pedido> pedidos;
    private RegistroHistorico registroHistorico;
    //Constructor:
    public Restaurante() {
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.menu = new Menu();
        this.mesas = new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.registroHistorico = new RegistroHistorico(this);
    }
    //Getter:
    public Menu getMenu() {
        return menu;
    }
    //Metodos:
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
                System.out.println("! No se puede tomar la orden a "+clientePedido.getNombre()+
                        " ya que no tiene mesa asignada !");
            }
        }
    }
    @Override
    public void agregarCliente(String nombre, String cedula, String telefono){
        Cliente clienteNuevo = comprobarCliente(cedula);
        if(clienteNuevo==null) {
            clientes.add(new Cliente(nombre, cedula, telefono));
        } else{
            System.out.println("! No se pudo agregar al cliente "+nombre+" debido a que la cedula ya pertenece al cliente "
                    +clienteNuevo.getNombre()+" !");
        }
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
                        clienteMesa.visualizarMesaAsignada();
                        clienteMesa.setCantidadPersona(cantidadPersona);
                        mostrarMenu();
                        i = true;
                    }
                }
            } else{
                System.out.println("! El cliente ya tiene reservado la mesa "+clienteMesa.getMesa().getNumero()+" !");
            }
            if(clienteMesa.getMesa()==null&&!i){
                System.out.println("! No hay mesas disponibles por el momento para el cliente "+
                        clienteMesa.getNombre()+" !");
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
                if ((clienteAtender.isRealizoPedido() && clienteAtender.isEsParaLlevar() ||
                        clienteAtender.isRealizoPedido() && !clienteAtender.isEsParaLlevar() && clienteAtender.getMesa() != null
                                && clienteAtender.getItemPedidoList() != null)) {
                    System.out.println("---> Atendiendo a " + clienteAtender.getNombre() + " <---");
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
                                if (!i) {
                                    Pedido pedido = new Pedido(clienteAtender);
                                    registroHistorico.registrarPedido(pedido);
                                    pedidos.add(pedido);
                                    gestionarPedido(clienteAtender, pedido);
                                    gestionarEntregaPedido(mesero, clienteAtender, pedido);
                                }

                            }
                        }
                    }
                } else if ((clienteAtender.isRealizoPedido() && !clienteAtender.isEsParaLlevar() &&
                        clienteAtender.getMesa() == null) || (!clienteAtender.isRealizoPedido() &&
                        clienteAtender.getMesa() == null) ) {
                    System.out.println("! No se puede atender a " + clienteAtender.getNombre() +
                            " ya que no tiene mesa asignada !");
                } else if (!clienteAtender.isRealizoPedido()) {
                    System.out.println("! No se puede atender a " + clienteAtender.getNombre() +
                            " ya que no ha realizado ningun pedido aun !");
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
                System.out.println("--> El pedido "+pedido.getNumero()+" ya esta pagado");
                System.out.println("---> Finalizo el pedido de "+cliente.getNombre());
            }
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " no ha realizado el pedido aun");
        }
    }
    @Override
    public void gestionarPedido(Cliente cliente, Pedido pedido){
        pedido.setItemPedidoList(cliente.getItemPedidoList());
        System.out.println("--> El pedido ("+pedido.getNumero()+") del cliente "+cliente.getNombre()+" ahora esta en proceso");
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
        System.out.println("-> El pedido "+pedido.getNumero()+" ya esta en preparacion");
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
        System.out.println("--> Total a pagar: $"+pedido.calcularTotal());
        cliente.realizarPago(pedido.calcularTotal(),pedido);
    }
    public void mostrarHistorial(String... cedulasClientes){
        for(String cedulaCliente : cedulasClientes) {
            Cliente clienteHistorial = comprobarCliente(cedulaCliente);
            if (clienteHistorial == null) {
                System.out.println("! El cliente ingresado no existe dentro de la lista de clientes !");
            } else {
                clienteHistorial.getHistorial().mostrarInformacion();
            }
        }
    }
    @Override
    public void mostrarMenu() {
        menu.mostrarPlatos();
    }
    public void mostrarMesasDisponibles(){
        System.out.println("<------------ Mesas Disponibles ------------>");
        for (Mesa mesa : mesas){
            if(mesa.isDisponible()){
                System.out.println("| Mesa: "+mesa.getNumero()+" | Capacidad: "+mesa.getCapacidad()+" | <- Esta disponible");
            }
        }
        System.out.println("_____________________________________________");
    }
    public void mostrarRegistroHistorico(){
        registroHistorico.mostrarListaPedidos();
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
                        registroHistorico.registrarPedido(pedido);
                        pedidos.add(pedido);
                        System.out.println("{ La mesa "+numero+" esta ahora reservada para "+ clienteReservar.getNombre()+" }");
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
