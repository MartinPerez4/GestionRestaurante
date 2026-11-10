public class PlatoFuerte extends Producto {
    private double peso;

    private boolean cocionaprobada;
    private TipoPreparacion tipoPreparacion;

    public PlatoFuerte(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacion, double peso, double tiempoCoccion, TipoPreparacion tipoPreparacion) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.peso = peso;
        this.tipoPreparacion = tipoPreparacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isCocionaprobada() {
        return cocionaprobada;
    }

    public void setCocionaprobada(boolean cocionaprobada) {
        this.cocionaprobada = cocionaprobada;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }
    @Override
    public double calcularPrecioVenta() {
        return getPrecioBase() * 1.20;
    }

    @Override
    public boolean validarCalidad() {
        return peso >= 200 && peso <= 900 && getTiempoPreparacion() >= 10 && getTiempoPreparacion() <= 60;
    }
}
