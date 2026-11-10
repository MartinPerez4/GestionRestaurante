import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombreComercio;
    private String nit;
    private String direccion;
    private List<Producto> ListaProductos;
    private List<Cliente> listaClientes;
    private List<Pedido> listaPedidos;

    public Restaurante(String nombreComercio, String nit, String direccion, List<Producto> listaProductos, List<Cliente> listaClientes, List<Pedido> listaPedidos) {
        this.nombreComercio = nombreComercio;
        this.nit = nit;
        this.direccion = direccion;
        ListaProductos = listaProductos;
        this.listaClientes = listaClientes;
        this.listaPedidos = listaPedidos;c
    }

    public String getNombreComercio() {
        return nombreComercio;
    }

    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        ListaProductos = listaProductos;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public void registrarProducto(Producto producto) {
        ListaProductos.add(producto);
    }

    public boolean registrarCliente(Cliente cliente) {
        if (cliente == null || listaClientes.contains(cliente)) {
            return false;
        }
        return listaClientes.add(cliente);
    }

    public boolean registrarPedido(Pedido pedido) {
        if (pedido == null || listaPedidos.contains(pedido)) {
            return false;
        }
        return listaPedidos.add(pedido);
    }
    public Producto buscarProducto(String codigo) {
        for (Producto p : ListaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String documento) {
        for (Cliente c : listaClientes) {
            if (c.getDocumentoIdentidad().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    public Pedido buscarPedido(String codigo) {
        for (Pedido p : listaPedidos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public List<Producto> consultarProductos() {
        return ListaProductos;
    }

    public List<Producto> consultarProductosValidos() {
        List<Producto> validos = new ArrayList<>();
        for (Producto p : ListaProductos) {
            if (p.validarCalidad()) {
                validos.add(p);
            }
        }
        return validos;
    }

    public List<Producto> consultarProductosRechazados() {
        List<Producto> rechazados = new ArrayList<>();
        for (Producto p : ListaProductos) {
            if (!p.validarCalidad()) {
                rechazados.add(p);
            }
        }
        return rechazados;
    }

    public List<Pedido> consultarPedidosCliente(Cliente cliente) {
        return cliente.consultarHistorial();
    }

    public List<Pedido> consultarPedidosPorEstado(EstadoPedido estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getEstadoPedido() == estado) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
