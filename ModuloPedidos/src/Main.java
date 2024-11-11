public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        restaurante.agregarMesa(2,4,6,5);
        restaurante.getMenu().agregarPlato("Pizza",2.5f);
        restaurante.getMenu().agregarPlato("Ensalada",4);
        restaurante.getMenu().agregarPlato("Hamburguesa",3.25f);
        restaurante.mostrarMesasDisponibles();
        Cliente cliente = new Cliente("Juan","1102984670","0964837368");
        restaurante.realizarReserva(cliente,2);
        restaurante.mostrarMesasDisponibles();
        restaurante.escogerPlatos(cliente,2,false,"pizza","Pizza","Ensalada","HambuRguesa");
        restaurante.mostrarCuenta(cliente);
        Cliente cliente2 = new Cliente("Jose","1103594850","0938775289");
        restaurante.mostrarMesasDisponibles();
        restaurante.escogerPlatos(cliente2,4,false,"Pizza","pizza","PiZza","Pizzza");
        restaurante.mostrarMesasDisponibles();
        restaurante.mostrarCuenta(cliente2);
        Cliente cliente3 = new Cliente("Ivan","1108475980","09785935478");
        restaurante.mostrarMesasDisponibles();
        restaurante.escogerPlatos(cliente3,1,true,"pizza","hamburguesa");
        restaurante.mostrarMesasDisponibles();
        restaurante.mostrarCuenta(cliente3);
        restaurante.mostrarMesasDisponibles();
        Cliente cliente4 = new Cliente("Jean","1105584859","0954782649");
        restaurante.mostrarCuenta(cliente4);
    }
}