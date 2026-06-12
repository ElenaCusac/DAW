package daw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de
 * variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {

    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        // Datos de prueba iniciales
        Ropa producto1 = new Ropa("Camiseta", 15.0, 10);
        Ropa producto2 = new Ropa("Pantalón", 30.0, 5);
        Ropa producto3 = new Ropa("Zapatos", 45.0, 2);

        // Añadir los datos de prueba al inventario
        InventarioRopa inventario = new InventarioRopa();
        inventario.guardar(producto1);
        inventario.guardar(producto2);
        inventario.guardar(producto3);

        boolean seguir = true;
        String menu = """
                \n --- TIENDA ---

                Seleccione el número de la opción que quiere elegir:

                1. Añadir producto.
                2. Mostrar inventario.
                3. Realizar venta.
                4. Salir

                """;

        while (seguir) {
            System.out.println(menu);

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nombre del producto: ");
                    String nombre = teclado.next();
                    System.out.print("Introduzca el precio del producto: ");
                    double precio = teclado.nextDouble();
                    System.out.print("Stock inicial: ");
                    int stock = teclado.nextInt();

                    Ropa producto = new Ropa(nombre, precio, stock);
                    inventario.guardar(producto);

                    System.out.println("Producto añadido correctamente.");
                    break;
                    
                case 2:
                    inventario.mostrar();
                    break;
                case 3:
                    System.out.println("\n--- VENTA ---");
                    System.out.print("Introduzca nombre del producto a vender: ");
                    String prod = teclado.next();

                    int pos = inventario.devolverPosicion(prod);

                    if (pos != -1) {
                        
                        System.out.println("Producto encontrado: " + inventario.devolverProducto(pos));
                        System.out.println("Precio: " + inventario.devolverPrecio(pos) + "€ | Stock: " + inventario.devolverStock(pos));
                        System.out.print("Cantidad a comprar: ");
                        int cantidad = teclado.nextInt();

                        if (inventario.devolverStock(pos) >= cantidad) {
                            double total = cantidad * inventario.devolverPrecio(pos);

                            // Hay números fijos que se utilizan en el código
                            if (total > 50) {
                                System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                                total = total * 0.90;
                            }

                            inventario.devolverProducto(pos).setStock(inventario.devolverStock(pos) - cantidad); // Actualizar stock
                            System.out.println("Venta realizada. Total a pagar: " + total + "€");

                            // Lógica de registro de venta
                            Singleton logger = Singleton.getInstance();
                            logger.log("Venta de " + cantidad + " x " + inventario.devolverProducto(pos) + " registrada.");
                            if (inventario.devolverStock(pos) < 3) {
                                logger.log("ALERTA DE STOCK BAJO para " + inventario.devolverProducto(pos));
                            }

                        } else {
                            System.out.println("Error: No hay suficiente stock.");
                        }
                    } else {
                        System.out.println("Error: Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    seguir = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        teclado.close();
    }
}
