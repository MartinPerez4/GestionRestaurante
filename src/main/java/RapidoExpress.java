public class RapidoExpress extends EmpresaDomicilio {

    public RapidoExpress(double tarifaBase, double costoKilometro, double distanciaMaxima) {
        super(tarifaBase, costoKilometro, distanciaMaxima);
    }

    @Override
    public double calcularCosto(double distancia) {
        return tarifaBase + costoKilometro * distancia;
    }

    @Override
    public boolean aceptarServicio(double distancia) {
        return distancia > 0 && distancia <= distanciaMaxima;
    }
}
