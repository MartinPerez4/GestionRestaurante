public class DetallePedido {
    private Producto Producto;
    private int cantidad;
    private double precioUnitario;

    public DetallePedido(Producto producto, int cantidad, double precioUnitario) {
        Producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto producto) {
        Producto = producto;
    }

    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }


}
