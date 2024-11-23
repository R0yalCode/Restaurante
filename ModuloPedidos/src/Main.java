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
        restaurante.agregarMesero("Luis","1106584580","0945859279");
        restaurante.agregarPersonalCocina("Carlos","1103958670","0965835789");
        //Clientes:
        restaurante.agregarCliente("Juan","1102984670","0964837368");
        restaurante.agregarCliente("Jose","1103594850","0938775289");
        restaurante.agregarCliente("Ivan","1108475980","09785935478");
        restaurante.agregarCliente("Jean", "1103854908","0947901289");
        restaurante.agregarCliente("Pepe","1109985660","0944987090");
        restaurante.agregarCliente("Daniel","1106768780","0986299189");
        restaurante.agregarCliente("Diego","1108475980","0982209169");
        //Procesos:
        restaurante.mostrarMesasDisponibles();
        //---------------------------------------- Juan -------------------------------------------------
        restaurante.realizarReserva("1102984670",2,1);
        restaurante.anotarPedido("1102984670",false,"pizza",
                2,"ninguna");
        restaurante.anotarPedido("1102984670",false,"eNZalada",
                1,"ninguna");
        restaurante.anotarPedido("1102984670",false,"HamburGuesa",
                1,"Sin mayonesas");
        //---------------------------------------- Jose -------------------------------------------------
        restaurante.asignarMesa("1103594850",4);
        restaurante.anotarPedido("1103594850",false,"PiZza",
                4,"Ninguna");
        //---------------------------------------- Ivan -------------------------------------------------
        restaurante.anotarPedido("1108475980",true,"Pizza",
                1,"Ninguna");
        restaurante.anotarPedido("1108475980",true,"hamburguesa",
                1,"Ninguna");
        //---------------------------------------- Pepe -------------------------------------------------
        restaurante.asignarMesa("1109985660",3);
        restaurante.anotarPedido("1109985660",false,"Pizza",
                3,"Ninguna");
        //---------------------------------------- Daniel -------------------------------------------------
        restaurante.asignarMesa("1106768780",6);
        //-------------------------------------------------------------------------------------------------
        restaurante.mostrarMesasDisponibles();
        restaurante.mostrarHistorial("1102984670","1103594850","1108475980","1109985660","1106768780");
        restaurante.mostrarRegistroHistorico();
        restaurante.atenderPedido("1102984670","1103594850","1108475980","1109985660","1106768780");
        restaurante.mostrarMesasDisponibles();
        restaurante.mostrarRegistroHistorico();
        //---------------------------------------- Daniel -------------------------------------------------
        restaurante.anotarPedido("1106768780",false,"HamBurguesA",
                2,"Sin ensalada");
        //---------------------------------------- Jean -------------------------------------------------
        restaurante.asignarMesa("1103854908",5);
        restaurante.anotarPedido("1103854908",false,"fizzA",
                1,"Ninguna");
        restaurante.anotarPedido("110385498",false,"HAmburguesA",
                1,"Ninguna");
        restaurante.anotarPedido("1103854908",false,"ensAladA",
                2,"Ninguna");
        //---------------------------------------- Jose -------------------------------------------------
        restaurante.asignarMesa("110359480",3);
        restaurante.anotarPedido("1103594850",false,"HamBurguesa",
                2,"Ninguna");
        restaurante.anotarPedido("1103594850",false,"PiZZa",
                1,"Ninguna");
        //---------------------------------------- Ivan -------------------------------------------------
        restaurante.realizarReserva("1108475980",2,1);
        restaurante.mostrarMesasDisponibles();
        restaurante.asignarMesa("1108475980",2);
        restaurante.mostrarMesasDisponibles();
        restaurante.anotarPedido("1108475980",false,"PiZZa",
                1,"sin queso");
        restaurante.anotarPedido("1108475980",false,"Ensalada",
                1,"Ninguna");
        //---------------------------------------------------------------------------------------
        restaurante.mostrarMesasDisponibles();
        restaurante.atenderPedido("1106768780","1103854908","1103594850","1108475980");
        restaurante.mostrarMesasDisponibles();
        restaurante.mostrarHistorial("1106768780","1103854908","1103594850","1108475980");
        restaurante.mostrarRegistroHistorico();
    }
}