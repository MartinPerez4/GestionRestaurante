public class Postre extends Producto {
    private double peso;
    private double temperaturaAlmacenamiento;
    private boolean requiereRefrigeracion;

    public Postre(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacion, double peso, double temperaturaAlmacenamaiento, boolean requiereRefrigeracion) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.peso = peso;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamaiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public void setTemperaturaAlmacenamiento(double temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public boolean getRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    public void setRequiereRefrigeracion(boolean requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    @Override
    public double calcularPrecioVenta() {
        double precio = getPrecioBase() * 1.15;
        if (requiereRefrigeracion) {
            precio += getPrecioBase() * 0.05;
        }
        return precio;
    }

    @Override
    public boolean validarCalidad() {
        if (peso < 80 || peso > 500) {
            return false;
        }
        if (requiereRefrigeracion) {
            return temperaturaAlmacenamiento >= 0 && temperaturaAlmacenamiento <= 6;
        }
        return temperaturaAlmacenamiento >= 15 && temperaturaAlmacenamiento <= 30;
    }
}
