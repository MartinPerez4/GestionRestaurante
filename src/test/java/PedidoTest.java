import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;
    private Producto productoA;

    @BeforeEach
    void setUp() {
        productoA = new Bebida("002", "Limonada", "bebida refrescante", 5000, 5, 350, 4, TipoBebida.GASEOSA, false
        );


        pedido = new Pedido(
                "123",
                LocalDate.of(2026, 11, 10),
                "123";
                ModalidadEntrega.RESTAURANTE,
                null,
                ModalidadEntrega.DOMICILIO,);
    }

    @Test
    void pedidoVacioTieneSubtotalCero() {
        assertEquals(0, pedido.calcularSubtotal());
    }

    @Test
    void agregarProductoSumaSuPrecioAlSubtotal() {
        pedido.agregarProducto(productoA, 2);

        assertEquals(50000, pedido.calcularSubtotal());
    }

    @Test
    void subtotalSumaTodosLosDetalles() {
        pedido.agregarProducto(productoA, 2);


        assertEquals(43000, pedido.calcularSubtotal());
    }

    @Test
    void totalIncluyeElCostoDeDomicilio() {
        pedido.agregarProducto(productoA, 1);

        assertEquals(30000, pedido.calcularTotal());
    }

    @Test
    void confirmarCambiaElEstadoAConfirmado() {
        pedido.confirmar();

        assertEquals(EstadoPedido.CONFIRMADO, pedido.getEstadoPedido());
    }
}