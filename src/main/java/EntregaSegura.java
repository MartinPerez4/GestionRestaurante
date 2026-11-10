public class EntregaSegura extends EmpresaDomicilio {

    private double recargoDistancia;
    private double distanciaRecargo;

    public EntregaSegura(double tarifaBase, double costoKilometro, double distanciaMaxima,
                         double recargoDistancia, double distanciaRecargo) {
        super(tarifaBase, costoKilometro, distanciaMaxima);
        this.recargoDistancia = recargoDistancia;
        this.distanciaRecargo = distanciaRecargo;
    }

    public double getRecargoDistancia() {
        return recargoDistancia;
    }

    public void setRecargoDistancia(double recargoDistancia) {
        this.recargoDistancia = recargoDistancia;
    }

    public double getDistanciaRecargo() {
        return distanciaRecargo;
    }

    public void setDistanciaRecargo(double distanciaRecargo) {
        this.distanciaRecargo = distanciaRecargo;
    }

    @Override
    public double calcularCosto(double distancia) {
        double costo = tarifaBase + costoKilometro * distancia;
        if (distancia > distanciaRecargo) {
            costo += recargoDistancia;
        }
        return costo;
    }

    @Override
    public boolean aceptarServicio(double distancia) {

        return distancia > 0 && distancia <= distanciaMaxima;
    }


}
