public abstract class EmpresaDomicilio {
    protected double tarifaBase;
    protected double costoKilometro;
    protected double distanciaMaxima;

    public EmpresaDomicilio(double tarifaBase, double costoKilometro, double recorridoMaximo) {
        this.tarifaBase = tarifaBase;
        this.costoKilometro = costoKilometro;
        this.distanciaMaxima = recorridoMaximo;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getCostoKilometro() {
        return costoKilometro;
    }

    public void setCostoKilometro(double costoKilometro) {
        this.costoKilometro = costoKilometro;
    }

    public double getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public abstract double calcularCosto(double distancia);

    public abstract boolean aceptarServicio(double distancia);
}
