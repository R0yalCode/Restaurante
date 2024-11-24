public interface InteraccionPedido {
    public void actualizarEstado(Estado estado, Pedido pedido);
    public Estado visualizarEstado(Pedido pedido);
}
