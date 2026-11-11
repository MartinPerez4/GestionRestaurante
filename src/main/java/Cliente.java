import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String documentoIdentidad;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String direccion;
    private List<Pedido> listaHistorialPedido;

    public Cliente(String documentoIdentidad, String direccion, String correo, String telefono, String nombreCompleto) {
        this.documentoIdentidad = documentoIdentidad;
        this.listaHistorialPedido = new ArrayList<>();
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public List<Pedido> getListaHistorialPedido() {
        return listaHistorialPedido;
    }

    public void setListaHistorialPedido(List<Pedido> listaHistorialPedido) {
        this.listaHistorialPedido = listaHistorialPedido;
    }
    public List<Pedido> consultarHistorial() {
        return new ArrayList<>(listaHistorialPedido);
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido != null && !listaHistorialPedido.contains(pedido)) {
            listaHistorialPedido.add(pedido);
        }
    }
}
