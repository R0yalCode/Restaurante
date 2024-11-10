public class PersonalCocina extends Empleado{
    //Constructor:
    public PersonalCocina(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
    }
    //Metodos:
    public void prepararPedido(Cliente... clientes){
        int tiempoEspera=0;
        for (Cliente cliente : clientes ){
            actualizarEstado(Estado.EN_PREPRACION,cliente);
            for (Plato plato : cliente.getPedido().getPlatos()){
                if(plato.getNombre().equalsIgnoreCase("Pizza")){
                    tiempoEspera=5;
                    cliente.getPedido().tiempoEspera(tiempoEspera);
                } else if(plato.getNombre().equalsIgnoreCase("Ensalada")){
                    tiempoEspera=7;
                    cliente.getPedido().tiempoEspera(tiempoEspera);
                } else{
                    tiempoEspera=10;
                    cliente.getPedido().tiempoEspera(tiempoEspera);
                }
            }
        }
    }
    public void servirPedido(Cliente... clientes){
        for(Cliente cliente : clientes){
            actualizarEstado(Estado.PREPARADO,cliente);
            System.out.println("El pedido "+cliente.getPedido().getNumero()+" ya esta listo para entregar");
        }
    }
}
