import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorProductos gestor = new GestorProductos();
        int opcion;

        do {
            System.out.println("\n===== MENU DE PRODUCTOS =====");
            System.out.println("1. Crear un producto");
            System.out.println("2. Ver todos los productos");
            System.out.println("3. Actualizar precio de un producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Ingrese un numero psra elegir una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearProducto(sc, gestor);
                    break;

                case 2:
                    gestor.mostrarProductos();
                    break;

                case 3:
                    actualizarProducto(sc, gestor);
                    break;

                case 4:
                    eliminarProducto(sc, gestor);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }

    private static void crearProducto(Scanner sc, GestorProductos gestor) {
        System.out.print("ID del producto : ");
        int id = sc.nextInt();
        if (id == 5) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        sc.nextLine();

        System.out.print("Nombre (o escribe 5 para cancelar): ");
        String nombre = sc.nextLine();
        if (nombre.equals("5")) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        System.out.print("Precio (o 5 para cancelar): ");
        double precio = sc.nextDouble();
        if (precio == 5) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        gestor.agregarProducto(new Producto(id, nombre, precio));
        System.out.println("Producto creado con exito.");
    }

    private static void actualizarProducto(Scanner sc, GestorProductos gestor) {
        System.out.print("ID del producto a actualizar : ");
        int id = sc.nextInt();
        if (id == 5) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        System.out.print("Nuevo precio (o 5 para cancelar): ");
        double nuevoPrecio = sc.nextDouble();
        if (nuevoPrecio == 5) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        if (gestor.actualizarProducto(id, nuevoPrecio)) {
            System.out.println("Precio actualizado.");
        } else {
            System.out.println("No existe un producto con ese ID.");
        }
    }

    private static void eliminarProducto(Scanner sc, GestorProductos gestor) {
        System.out.print("ID del producto a eliminar : ");
        int id = sc.nextInt();
        if (id == 5) {
            System.out.println("Operacion cancelada, volviendo al menu.");
            return;
        }

        if (gestor.eliminarProducto(id)) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No existe un producto con ese ID.");
        }
    }
}
