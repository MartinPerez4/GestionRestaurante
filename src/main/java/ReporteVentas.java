public class ReporteVentas {
    private Restaurante restaurante;

    public ReporteVentas(Restaurante restaurante) {
        this.restaurante = restaurante;
    }


    public double calcularIngresosRestaurante() {
        double total = 0;
        for (Pedido p : restaurante.getListaPedidos()) {
            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO
                    || p.getEstadoPedido() == EstadoPedido.ENTREGADO) {
                total += p.calcularSubtotal();
            }
        }
        return total;
    }

    public double calcularIngresosPorCategoria(String categoria) {
        double ingresos = 0;

        for (Pedido p : restaurante.getListaPedidos()) {
            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO ||
                    p.getEstadoPedido() == EstadoPedido.ENTREGADO) {

                for (DetallePedido d : p.getListaDetallePedido()) {

                    if (d.getProducto().getClass().getSimpleName().equals(categoria)) {
                        ingresos += d.calcularSubtotal();
                    }
                }
            }
        }

        return ingresos;
    }

    public int obtenerUnidadesVendidas(Producto producto) {
        int unidades = 0;

        for (Pedido p : restaurante.getListaPedidos()) {
            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO ||
                    p.getEstadoPedido() == EstadoPedido.ENTREGADO) {

                for (DetallePedido d : p.getListaDetallePedido()) {
                    if (d.getProducto().equals(producto)) {
                        unidades += d.getCantidad();
                    }
                }
            }
        }

        return unidades;
    }

    public Producto obtenerProductoMasVendido() {
        Producto masVendido = null;
        int max = 0;

        for (Producto producto : restaurante.getListaProductos()) {

            int unidades = obtenerUnidadesVendidas(producto);

            if (unidades > max) {
                max = unidades;
                masVendido = producto;
            }
        }

        return masVendido;
    }

    public double consultarIngresosDomicilios() {
        double total = 0;
        for (Pedido p : restaurante.getListaPedidos()) {
            if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO
                    || p.getEstadoPedido() == EstadoPedido.ENTREGADO) {
                total += p.getCostoDomicilio();
            }
        }
        return total;
    }
}
