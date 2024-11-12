public class Cliente extends Persona{
    //Atributos:
    private int cantidadPersona;
    private boolean esParaLlevar;
    //Asociacion:
    private Historial historial;
    private Mesa mesa;
    private Pedido pedido;
    //Constructor:
    public Cliente(String nombre, String cedula, String telefono) {
        super(nombre, cedula, telefono);
        this.historial = new Historial();
    }
    //Getter:
    public int getCantidadPersonas() {
        return cantidadPersona;
    }
    public Historial getHistorial() {
        return historial;
    }
    public boolean isEsParaLlevar() {
        return esParaLlevar;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    //Metodos:
    public void asignarMesa(Mesa mesaAsignada){
        this.mesa = mesaAsignada;
    }
    public void realizarPago(float total) {
        System.out.println("[ "+getNombre()+" realizo el pago de $"+total+" ]");
        if(mesa!=null) {
            historial.agregarPedido(pedido, mesa.getNumero());
        } else{
            historial.agregarPedido(pedido, 0);
        }
        if(!isEsParaLlevar()){
            mesa.desocupar(mesa);
            System.out.println(getNombre()+" ha desocupado la mesa "+mesa.getNumero());
            setMesa(mesa=null);
        }
    }
    public void realizarPedido(Plato plato, int cantidadPersona, boolean esParaLlevar,Pedido pedido){
        this.cantidadPersona=cantidadPersona;
        this.esParaLlevar=esParaLlevar;
        this.pedido = pedido;
        this.pedido.agregarPlato(plato);
    }
    public float valorPedido(){
        return pedido.calcularTotal();
    }
}
