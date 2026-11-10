import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    protected String codigo;
    protected LocalDate fecha;
    protected double distancia;
    protected double costoDomicilio;
    protected EstadoPedido estadoPedido;
    protected EmpresaDomicilio empresaDomicilio;
    ModalidadEntrega ModalidadEntrega;
    protected List<DetallePedido> listaDetallePedido;

    public Pedido(String codigo, LocalDate fecha, ModalidadEntrega modalidadEntrega) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.ModalidadEntrega = modalidadEntrega;
        this.estadoPedido = EstadoPedido.PENDIENTE;
        this.listaDetallePedido = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCostoDomicilio() {
        return costoDomicilio;
    }

    public void setCostoDomicilio(double costoDomicilio) {
        this.costoDomicilio = costoDomicilio;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public EmpresaDomicilio getEmpresaDomicilio() {
        return empresaDomicilio;
    }

    public void setEmpresaDomicilio(EmpresaDomicilio empresaDomicilio) {
        this.empresaDomicilio = empresaDomicilio;
    }

    public ModalidadEntrega getModalidadEntrega() {
        return ModalidadEntrega;
    }

    public void setModalidadEntrega(ModalidadEntrega modalidadEntrega) {
        ModalidadEntrega = modalidadEntrega;
    }


    public List<DetallePedido> getListaDetallePedido() {
        return listaDetallePedido;
    }

    public void setListaDetallePedido(List<DetallePedido> listaDetallePedido) {
        this.listaDetallePedido = listaDetallePedido;
    }
    public void agregarProducto(Producto producto, int cantidad) {
        listaDetallePedido.add(new DetallePedido(producto, cantidad, producto.calcularPrecioVenta()));
    }
    public void agregarDetalle(DetallePedido detalle) {
        listaDetallePedido.add(detalle);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (DetallePedido d : listaDetallePedido) {
            subtotal += d.calcularSubtotal();
        }
        return subtotal;
    }

    public double calcularTotal() {
        return calcularSubtotal() + costoDomicilio;
    }


    public void confirmar() {
        estadoPedido = EstadoPedido.CONFIRMADO;
    }

    public void marcarEntregado() {
        estadoPedido = EstadoPedido.ENTREGADO;
    }

    public void cancelar() {
        estadoPedido = EstadoPedido.CANCELADO;
    }



}
