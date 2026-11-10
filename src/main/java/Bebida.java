public class Bebida extends Producto {
    private double volumen;
    private double temperaturaServicio;
    private TipoBebida tipoBebida;
    private boolean preparacionEspecial;

    public Bebida(String codigo, String nombre, String descripcion, double precioBase, int tiempoPreparacion, double volumen, double temperaturaServicio, TipoBebida tipoBebida, boolean preparacionEspecial) {
        super(codigo, nombre, descripcion, precioBase, tiempoPreparacion);
        this.volumen = volumen;
        this.temperaturaServicio = temperaturaServicio;
        this.tipoBebida = tipoBebida;
        this.preparacionEspecial=preparacionEspecial;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public void setTemperaturaServicio(double temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public boolean isPreparacionEspecial() {
        return preparacionEspecial;
    }

    public void setPreparacionEspecial(boolean preparacionEspecial) {
        this.preparacionEspecial = preparacionEspecial;
    }

    @Override
    public double calcularPrecioVenta() {
        double precio = getPrecioBase() * 1.10;
        if (preparacionEspecial) {
            precio += 3000;
        }
        return precio;
    }

    @Override
    public boolean validarCalidad() {
        if (volumen < 150 || volumen > 1500) {
            return false;
        }
        if (tipoBebida == TipoBebida.FRIA) {
            return temperaturaServicio >= 0 && temperaturaServicio <= 10;
        }
        return temperaturaServicio >= 55 && temperaturaServicio <= 85;
    }
}
