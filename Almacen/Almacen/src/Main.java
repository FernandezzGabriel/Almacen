import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        int opcion;

        do {
            System.out.println("\n===== ALMACEN =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Ver inventario");
            System.out.println("4. Ver stock critico");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerNumero(scanner);

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Cantidad recibida: ");
                    int cantidad = leerNumero(scanner);
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser un numero mayor a 0.");
                        break;
                    }

                    if (inventario.registrarProducto(nombre, cantidad)) {
                        System.out.println("Operacion realizada.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del producto: ");
                    nombre = scanner.nextLine();

                    Producto producto = inventario.buscarProducto(nombre);
                    if (producto == null) {
                        System.out.println("El producto no existe.");
                        break;
                    }

                    System.out.print("Cantidad a vender: ");
                    cantidad = leerNumero(scanner);
                    if (cantidad <= 0) {
                        System.out.println("La cantidad debe ser un numero mayor a 0.");
                        break;
                    }

                    if (inventario.venderProducto(nombre, cantidad)) {
                        System.out.println("Venta realizada correctamente.");
                    } else {
                        System.out.println("No hay stock suficiente. Stock actual: " + producto.getStock());
                    }
                    break;

                case 3:
                    System.out.println("\n--- INVENTARIO ---");
                    inventario.mostrarInventario();
                    break;

                case 4:
                    System.out.println("\n--- STOCK CRITICO ---");
                    inventario.mostrarStockCritico();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static int leerNumero(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
