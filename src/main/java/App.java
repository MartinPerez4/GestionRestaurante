import java.util.List;
import java.util.Scanner;

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
                    }

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
                case 0:
                    System.out.println("Gracias por visitar Sabor & Tradición.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }
}



