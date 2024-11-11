public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        //Mesas:
        restaurante.agregarMesa(2,4,6,5);
        //Platos:
        restaurante.getMenu().agregarPlato("Pizza",2.5f);
        restaurante.getMenu().agregarPlato("Ensalada",4);
        restaurante.getMenu().agregarPlato("Hamburguesa",3.25f);
        //Empleados:
        Mesero mesero = new Mesero("Luis","1106584580","0945859279");
        restaurante.agregarPersonalCocina("Carlos","1103958670","0965835789");
        //Clientes:
        Cliente cliente = new Cliente("Juan","1102984670","0964837368");
        Cliente cliente2 = new Cliente("Jose","1103594850","0938775289");
        Cliente cliente3 = new Cliente("Ivan","1108475980","09785935478");
        Cliente cliente4 = new Cliente("Jean", "1103854908","0947901289");
        restaurante.mostrarMesasDisponibles();
        restaurante.realizarReserva(cliente,2);
        restaurante.mostrarMesasDisponibles();
        restaurante.escogerPlatos(cliente,2,false,"pizza","Pizza","Ensalada","HambuRguesa");
        restaurante.escogerPlatos(cliente2,4,false,"Pizza","pizza","PiZza","Pizzza");
        restaurante.escogerPlatos(cliente3,1,true,"pizza","hamburguesa");
        restaurante.mostrarMesasDisponibles();
        restaurante.gestionarEntregaPedido(mesero,cliente,cliente2,cliente3,cliente4);
        cliente.getHistorial().mostrarHistorial();
        restaurante.mostrarMesasDisponibles();
        restaurante.escogerPlatos(cliente,5,false,"pizza","HamBurguesa","ENSalada","ensalada");
        System.out.println("mesa del cliente 1"+cliente.getMesa().getNumero());
        restaurante.mostrarMesasDisponibles();
        restaurante.gestionarEntregaPedido(mesero,cliente);
        restaurante.mostrarMesasDisponibles();
        cliente.getHistorial().mostrarHistorial();
        cliente2.getHistorial().mostrarHistorial();
        restaurante.escogerPlatos(cliente3,2,false,"PiZZA","Ensalada");
        restaurante.mostrarMesasDisponibles();
        restaurante.gestionarEntregaPedido(mesero,cliente3);
        restaurante.mostrarMesasDisponibles();
        cliente3.getHistorial().mostrarHistorial();
    }
}