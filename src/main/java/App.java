import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
public class App {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

        Restaurante restaurante = new Restaurante("Sabor & Tradición", "123456789", "Armenia, Quindío");


        int opcion;

        do {
            System.out.println("\n--- SABOR & TRADICIÓN ---");
            System.out.println("1. Registrar productos");
            System.out.println("2. Registrar clientes");
            System.out.println("3. Consultar productos");
            System.out.println("4. Calcular precio de venta");
            System.out.println("5. Verificar calidad");
            System.out.println("6. Registrar pedidos");
            System.out.println("7. Consultar pedidos de un cliente");
            System.out.println("8. Gestionar domicilios");
            System.out.println("9. Confirmar pedidos");
            System.out.println("10. Calcular total del pedido");
            System.out.println("11. Actualizar estado");
            System.out.println("12. Consultar estado");
            System.out.println("13. Reportes de ventas");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n------ Registrar productos ------");
                    System.out.println("1. Plato fuerte");
                    System.out.println("2. Bebida");
                    System.out.println("3. Postre");
                    System.out.print("Seleccione el tipo de producto: ");

                    int tipoProducto = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    String codigo = sc.nextLine();
                    if (codigo.isEmpty()){
                        System.out.print("codigo vacio");
                        break;
                    }

                    if (restaurante.buscarProducto(codigo) != null) {
                        System.out.println("Ya existe un producto con ese código.");
                        break;
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    System.out.print("Precio base: ");
                    double precioBase = sc.nextDouble();

                    System.out.print("Tiempo de preparación (minutos): ");
                    int tiempoPreparacion = sc.nextInt();

                    Producto producto = null;

                    switch (tipoProducto) {

                        case 1:
                            System.out.print("Peso en gramos: ");
                            double pesoPlato = sc.nextDouble();

                            System.out.print("Tiempo de cocción: ");
                            double tiempoCoccion = sc.nextDouble();

                            TipoPreparacion[] preparaciones = TipoPreparacion.values();

                            System.out.println("Tipos de preparación:");
                            for (int i = 0; i < preparaciones.length; i++) {
                                System.out.println((i + 1) + ". " + preparaciones[i]);
                            }

                            System.out.print("Seleccione preparación: ");
                            int opcionPreparacion = sc.nextInt();

                            if (opcionPreparacion < 1 ||
                                    opcionPreparacion > preparaciones.length) {
                                System.out.println("Preparación no válida.");
                                break;
                            }

                            TipoPreparacion preparacion =
                                    preparaciones[opcionPreparacion - 1];

                            System.out.print("¿La cocción fue aprobada? (1. Sí / 2. No): ");
                            int respuestaCoccion = sc.nextInt();

                            boolean coccionAprobada = respuestaCoccion == 1;

                            PlatoFuerte plato = new PlatoFuerte(
                                    codigo, nombre, descripcion, precioBase,
                                    tiempoPreparacion, pesoPlato, tiempoCoccion,
                                    preparacion
                            );

                            plato.setCocionaprobada(coccionAprobada);
                            producto = plato;
                            break;

                        case 2:
                            System.out.print("Volumen en mililitros: ");
                            double volumen = sc.nextDouble();

                            System.out.print("Temperatura de servicio: ");
                            double temperatura = sc.nextDouble();

                            TipoBebida[] tiposBebida = TipoBebida.values();

                            System.out.println("Tipos de bebida:");
                            for (int i = 0; i < tiposBebida.length; i++) {
                                System.out.println((i + 1) + ". " + tiposBebida[i]);
                            }

                            System.out.print("Seleccione el tipo: ");
                            int opcionBebida = sc.nextInt();

                            if (opcionBebida < 1 ||
                                    opcionBebida > tiposBebida.length) {
                                System.out.println("Tipo de bebida no válido.");
                                break;
                            }

                            TipoBebida tipoBebida = tiposBebida[opcionBebida - 1];

                            System.out.print("¿Tiene preparación especial? (1. Sí / 2. No): ");
                            int respuestaEspecial = sc.nextInt();

                            boolean especial = respuestaEspecial == 1;

                            producto = new Bebida(
                                    codigo, nombre, descripcion, precioBase,
                                    tiempoPreparacion, volumen, temperatura,
                                    tipoBebida, especial
                            );
                            break;

                        case 3:
                            System.out.print("Peso en gramos: ");
                            double pesoPostre = sc.nextDouble();

                            System.out.print("Temperatura de almacenamiento: ");
                            double temperaturaAlmacenamiento = sc.nextDouble();

                            System.out.print("¿Requiere refrigeración? (1. Sí / 2. No): ");
                            int respuestaRefrigeracion = sc.nextInt();

                            boolean refrigeracion = respuestaRefrigeracion == 1;

                            producto = new Postre(
                                    codigo, nombre, descripcion, precioBase,
                                    tiempoPreparacion, pesoPostre,
                                    temperaturaAlmacenamiento, refrigeracion
                            );
                            break;

                        default:
                            System.out.println("Tipo de producto no válido.");
                    }

                    if (producto != null) {
                        restaurante.registrarProducto(producto);
                        System.out.println("Producto registrado correctamente.");
                        System.out.println("Precio de venta: "
                                + producto.calcularPrecioVenta());
                        System.out.println("Calidad: "
                                + (producto.validarCalidad() ? "Aprobado" : "No aprobado"));
                    }

                    break;
                case 2:
                    System.out.println("\n------ Registrar cliente ------");

                    System.out.print("Documento: ");
                    String documentoIdentidad = sc.nextLine();
                    if (documentoIdentidad.isEmpty()){
                        System.out.print("codigo vacio");
                        break;
                    }

                    if (restaurante.buscarCliente(documentoIdentidad) != null) {
                        System.out.println("El cliente ya está registrado.");
                        break;
                    }

                    System.out.print("Nombre completo: ");
                    String nombreCliente = sc.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    Cliente cliente = new Cliente(documentoIdentidad, nombreCliente,telefono, correo, direccion
                    );

                    if (restaurante.registrarCliente(cliente)) {
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("No fue posible registrar el cliente.");
                    }

                    break;
                case 3:
                    System.out.println("\n------ Productos del menú ------");

                    List<Producto> productos = restaurante.consultarProductos();

                    if (productos.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (Producto p : productos) {
                            System.out.println("\nCódigo: " + p.getCodigo());
                            System.out.println("Nombre: " + p.getNombre());
                            System.out.println("Descripción: " + p.getDescripcion());
                            System.out.println("Precio base: " + p.getPrecioBase());
                            System.out.println("Precio de venta: " + p.calcularPrecioVenta());
                            System.out.println("Tiempo de preparación: "
                                    + p.getTiempoPreparacion() + " minutos");
                            System.out.println("--------------------------------");
                        }
                        break;
                    }
                    break;

                case 4:
                    System.out.println("\n------ Calcular precio de venta ------");

                    System.out.print("Código del producto: ");
                    String codigoBuscar = sc.nextLine();

                    Producto productoBuscar = restaurante.buscarProducto(codigoBuscar);

                    if (productoBuscar != null) {
                        System.out.println("Producto: " + productoBuscar.getNombre());
                        System.out.println("Precio base: " + productoBuscar.getPrecioBase());
                        System.out.println("Precio de venta: "
                                + productoBuscar.calcularPrecioVenta());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 5:
                    System.out.println("\n------ Verificar calidad ------");

                    System.out.println("\nPRODUCTOS APROBADOS:");

                    List<Producto> productosValidos =
                            restaurante.consultarProductosValidos();

                    if (productosValidos.isEmpty()) {
                        System.out.println("No hay productos aprobados.");
                    } else {
                        for (Producto p : productosValidos) {
                            System.out.println(p.getNombre()
                                    + " - Código: " + p.getCodigo());
                        }
                    }

                    System.out.println("\nPRODUCTOS NO APROBADOS:");

                    List<Producto> productosRechazados =
                            restaurante.consultarProductosRechazados();

                    if (productosRechazados.isEmpty()) {
                        System.out.println("No hay productos rechazados.");
                    } else {
                        for (Producto p : productosRechazados) {
                            System.out.println(p.getNombre()
                                    + " - Código: " + p.getCodigo());
                        }
                    }

                    break;
                case 6:
                    System.out.println("\n------ Registrar pedido ------");

                    System.out.print("Documento del cliente: ");
                    String documentoPedido = sc.nextLine();

                    Cliente clientePedido = restaurante.buscarCliente(documentoPedido);

                    if (clientePedido == null) {
                        System.out.println("El cliente no está registrado.");
                        break;
                    }

                    System.out.print("Código del pedido: ");
                    String codigoPedido = sc.nextLine();

                    if (restaurante.buscarPedido(codigoPedido) != null) {
                        System.out.println("Ya existe un pedido con ese código.");
                        break;
                    }

                    System.out.println("1. Restaurante");
                    System.out.println("2. Domicilio");
                    System.out.print("Seleccione la modalidad de entrega: ");
                    int opcionModalidad = sc.nextInt();
                    sc.nextLine();

                    ModalidadEntrega modalidadPedido;

                    if (opcionModalidad == 1) {
                        modalidadPedido = ModalidadEntrega.RESTAURANTE;
                    } else if (opcionModalidad == 2) {
                        modalidadPedido = ModalidadEntrega.DOMICILIO;
                    } else {
                        System.out.println("Modalidad no válida.");
                        break;
                    }

                    Pedido nuevoPedido = new Pedido(codigoPedido, LocalDate.now(),
                            clientePedido, modalidadPedido);
                    restaurante.registrarPedido(nuevoPedido);

                    String codigoProductoPedido;

                    do {
                        System.out.print("Código del producto (0 para terminar): ");
                        codigoProductoPedido = sc.nextLine();

                        if (!codigoProductoPedido.equals("0")) {
                            Producto productoPedido =
                                    restaurante.buscarProducto(codigoProductoPedido);

                            if (productoPedido == null) {
                                System.out.println("El producto no existe en el menú.");
                            } else {
                                System.out.print("Cantidad: ");
                                int cantidadPedido = sc.nextInt();
                                sc.nextLine();

                                if (cantidadPedido > 0) {
                                    nuevoPedido.agregarProducto(productoPedido, cantidadPedido);
                                    System.out.println("Producto agregado al pedido.");
                                } else {
                                    System.out.println("La cantidad debe ser mayor a 0.");
                                }
                            }
                        }
                    } while (!codigoProductoPedido.equals("0"));

                    System.out.println("Pedido registrado en estado PENDIENTE.");
                    break;

                case 7:
                    System.out.println("\n------ Pedidos de un cliente ------");

                    System.out.print("Documento del cliente: ");
                    String documentoHistorial = sc.nextLine();

                    Cliente clienteHistorial = restaurante.buscarCliente(documentoHistorial);

                    if (clienteHistorial == null) {
                        System.out.println("El cliente no está registrado.");
                        break;
                    }

                    List<Pedido> pedidosCliente =
                            restaurante.consultarPedidosCliente(clienteHistorial);

                    if (pedidosCliente.isEmpty()) {
                        System.out.println("El cliente no tiene pedidos.");
                    } else {
                        for (Pedido ped : pedidosCliente) {
                            System.out.println("\nPedido: " + ped.getCodigo());
                            System.out.println("Fecha: " + ped.getFecha());
                            System.out.println("Estado: " + ped.getEstadoPedido());

                            for (DetallePedido det : ped.getListaDetallePedido()) {
                                System.out.println("  - " + det.getProducto().getNombre()
                                        + " | Cantidad: " + det.getCantidad()
                                        + " | Precio: " + det.getPrecioUnitario()
                                        + " | Subtotal: " + det.calcularSubtotal());
                            }

                            System.out.println("Total: " + ped.calcularTotal());
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                case 8:
                    System.out.println("\n------ Gestionar domicilio ------");

                    System.out.print("Código del pedido: ");
                    Pedido pedidoDomicilio = restaurante.buscarPedido(sc.nextLine());

                    if (pedidoDomicilio == null) {
                        System.out.println("El pedido no existe.");
                        break;
                    }

                    if (pedidoDomicilio.getModalidadEntrega() != ModalidadEntrega.DOMICILIO) {
                        System.out.println("El pedido no es a domicilio.");
                        break;
                    }

                    if (pedidoDomicilio.getEstadoPedido() != EstadoPedido.PENDIENTE) {
                        System.out.println("Solo se puede asignar domicilio a pedidos pendientes.");
                        break;
                    }

                    System.out.println("1. RapidoExpress");
                    System.out.println("2. EntregaSegura");
                    System.out.print("Seleccione la empresa: ");
                    int opcionEmpresa = sc.nextInt();
                    sc.nextLine();

                    EmpresaDomicilio empresa;

                    if (opcionEmpresa == 1) {
                        empresa = new RapidoExpress(3000, 1200, 15);
                    } else if (opcionEmpresa == 2) {
                        empresa = new EntregaSegura(4000, 1000, 20, 2500, 10);
                    } else {
                        System.out.println("Empresa no válida.");
                        break;
                    }

                    System.out.print("Distancia en km: ");
                    double distanciaDomicilio = sc.nextDouble();
                    sc.nextLine();

                    if (!empresa.aceptarServicio(distanciaDomicilio)) {
                        System.out.println("La empresa no presta el servicio para esa distancia (máximo "
                                + empresa.getDistanciaMaxima() + " km).");
                        break;
                    }

                    pedidoDomicilio.asignarEmpresaDomicilio(empresa, distanciaDomicilio);
                    System.out.println("Domicilio asignado. Costo: "
                            + pedidoDomicilio.getCostoDomicilio());
                    break;

                case 9:
                    System.out.println("\n------ Confirmar pedido ------");

                    System.out.print("Código del pedido: ");
                    Pedido pedidoConfirmar = restaurante.buscarPedido(sc.nextLine());

                    if (pedidoConfirmar == null) {
                        System.out.println("El pedido no existe.");
                        break;
                    }

                    if (pedidoConfirmar.getEstadoPedido() != EstadoPedido.PENDIENTE) {
                        System.out.println("Solo se pueden confirmar pedidos pendientes.");
                        break;
                    }

                    boolean confirmable = true;

                    if (restaurante.buscarCliente(
                            pedidoConfirmar.getCliente().getDocumentoIdentidad()) == null) {
                        System.out.println("El cliente no está registrado.");
                        confirmable = false;
                    }

                    if (pedidoConfirmar.getListaDetallePedido().isEmpty()) {
                        System.out.println("El pedido no tiene productos.");
                        confirmable = false;
                    }

                    for (DetallePedido det : pedidoConfirmar.getListaDetallePedido()) {
                        if (!restaurante.getListaProductos().contains(det.getProducto())) {
                            System.out.println(det.getProducto().getNombre()
                                    + ": no pertenece al menú.");
                            confirmable = false;
                        }
                        if (det.getCantidad() <= 0) {
                            System.out.println(det.getProducto().getNombre()
                                    + ": cantidad no válida.");
                            confirmable = false;
                        }
                        if (!det.getProducto().validarCalidad()) {
                            System.out.println(det.getProducto().getNombre()
                                    + ": no cumple las condiciones de calidad.");
                            confirmable = false;
                        }
                    }

                    if (pedidoConfirmar.getModalidadEntrega() == ModalidadEntrega.DOMICILIO
                            && pedidoConfirmar.getEmpresaDomicilio() == null) {
                        System.out.println("Falta asignar la empresa de domicilio (opción 8).");
                        confirmable = false;
                    }

                    if (confirmable) {
                        pedidoConfirmar.confirmar();
                        System.out.println("Pedido confirmado correctamente.");
                    }
                    break;

                case 10:
                    System.out.println("\n------ Calcular total del pedido ------");

                    System.out.print("Código del pedido: ");
                    Pedido pedidoTotal = restaurante.buscarPedido(sc.nextLine());

                    if (pedidoTotal == null) {
                        System.out.println("El pedido no existe.");
                        break;
                    }

                    System.out.println("Subtotal: " + pedidoTotal.calcularSubtotal());
                    System.out.println("Domicilio: " + pedidoTotal.getCostoDomicilio());
                    System.out.println("Total: " + pedidoTotal.calcularTotal());
                    break;

                case 11:
                    System.out.println("\n------ Actualizar estado ------");

                    System.out.print("Código del pedido: ");
                    Pedido pedidoEstado = restaurante.buscarPedido(sc.nextLine());

                    if (pedidoEstado == null) {
                        System.out.println("El pedido no existe.");
                        break;
                    }

                    System.out.println("Estado actual: " + pedidoEstado.getEstadoPedido());
                    System.out.println("1. Marcar como entregado");
                    System.out.println("2. Cancelar pedido");
                    System.out.print("Seleccione la opción: ");
                    int opcionEstado = sc.nextInt();
                    sc.nextLine();

                    if (opcionEstado == 1) {
                        if (pedidoEstado.getEstadoPedido() == EstadoPedido.CONFIRMADO) {
                            pedidoEstado.marcarEntregado();
                            System.out.println("Pedido entregado.");
                        } else {
                            System.out.println("Solo se puede entregar un pedido confirmado.");
                        }
                    } else if (opcionEstado == 2) {
                        if (pedidoEstado.getEstadoPedido() == EstadoPedido.ENTREGADO
                                || pedidoEstado.getEstadoPedido() == EstadoPedido.CANCELADO) {
                            System.out.println("No se puede cancelar un pedido entregado o ya cancelado.");
                        } else {
                            pedidoEstado.cancelar();
                            System.out.println("Pedido cancelado.");
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 12:
                    System.out.println("\n------ Consultar estado ------");
                    System.out.println("1. Por código de pedido");
                    System.out.println("2. Por estado");
                    System.out.print("Seleccione la opción: ");
                    int opcionConsulta = sc.nextInt();
                    sc.nextLine();

                    if (opcionConsulta == 1) {
                        System.out.print("Código del pedido: ");
                        Pedido pedidoConsulta = restaurante.buscarPedido(sc.nextLine());

                        if (pedidoConsulta == null) {
                            System.out.println("El pedido no existe.");
                        } else {
                            System.out.println("Estado del pedido " + pedidoConsulta.getCodigo()
                                    + ": " + pedidoConsulta.getEstadoPedido());
                        }
                    } else if (opcionConsulta == 2) {
                        EstadoPedido[] estados = EstadoPedido.values();

                        for (int i = 0; i < estados.length; i++) {
                            System.out.println((i + 1) + ". " + estados[i]);
                        }

                        System.out.print("Seleccione el estado: ");
                        int opcionEstadoConsulta = sc.nextInt();
                        sc.nextLine();

                        if (opcionEstadoConsulta < 1 || opcionEstadoConsulta > estados.length) {
                            System.out.println("Estado no válido.");
                        } else {
                            List<Pedido> pedidosPorEstado = restaurante.consultarPedidosPorEstado(
                                    estados[opcionEstadoConsulta - 1]);

                            if (pedidosPorEstado.isEmpty()) {
                                System.out.println("No hay pedidos en ese estado.");
                            } else {
                                for (Pedido ped : pedidosPorEstado) {
                                    System.out.println(ped.getCodigo()
                                            + " - Cliente: " + ped.getCliente().getNombreCompleto()
                                            + " - Total: " + ped.calcularTotal());
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 13:
                    System.out.println("\n------ Reportes de ventas ------");

                    ReporteVentas reporte = new ReporteVentas(restaurante);

                    double ingresosBebidas = reporte.calcularIngresosPorCategoria("Bebida");
                    double ingresosPlatos = reporte.calcularIngresosPorCategoria("PlatoFuerte");
                    double ingresosPostres = reporte.calcularIngresosPorCategoria("Postre");

                    System.out.println("Ingresos del restaurante (sin domicilios): "
                            + reporte.calcularIngresosRestaurante());
                    System.out.println("Ingresos de bebidas: " + ingresosBebidas);
                    System.out.println("Ingresos de platos fuertes: " + ingresosPlatos);
                    System.out.println("Ingresos de postres: " + ingresosPostres);

                    Producto masVendido = reporte.obtenerProductoMasVendido();

                    if (masVendido == null) {
                        System.out.println("No hay ventas registradas.");
                    } else {
                        System.out.println("Producto más vendido: " + masVendido.getNombre()
                                + " (" + reporte.obtenerUnidadesVendidas(masVendido) + " unidades)");

                        String categoriaMayor;
                        if (ingresosBebidas >= ingresosPlatos && ingresosBebidas >= ingresosPostres) {
                            categoriaMayor = "Bebidas";
                        } else if (ingresosPlatos >= ingresosPostres) {
                            categoriaMayor = "Platos fuertes";
                        } else {
                            categoriaMayor = "Postres";
                        }
                        System.out.println("Categoría con mayores ingresos: " + categoriaMayor);
                    }

                    System.out.println("Ingresos por domicilios (aparte): "
                            + reporte.consultarIngresosDomicilios());
                    break;

                case 0:
                    System.out.println("Gracias por visitar Sabor & Tradición.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}



