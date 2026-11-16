import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public Producto buscarProducto(String nombre) {

        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public boolean registrarProducto(String nombre, int cantidad) {

        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacio.");
            return false;
        }

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return false;
        }

        Producto existente = buscarProducto(nombre.trim());

        if (existente != null) {
            existente.agregarStock(cantidad);
        } else {
            productos.add(new Producto(nombre.trim(), cantidad));
        }
        return true;
    }

    public boolean venderProducto(String nombre, int cantidad) {

        Producto producto = buscarProducto(nombre);

        if (producto == null) {
            return false;
        }
        return producto.descontarStock(cantidad);
    }

    public ArrayList<Producto> obtenerStockCritico() {

        ArrayList<Producto> criticos = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getStock() <= 5) {
                criticos.add(producto);
            }
        }
        return criticos;
    }

    public void mostrarInventario() {

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            System.out.println(p.getNombre() + " - Stock: " + p.getStock());
        }
    }

    public void mostrarStockCritico() {

        ArrayList<Producto> criticos = obtenerStockCritico();

        if (criticos.isEmpty()) {
            System.out.println("No hay productos con stock critico.");
            return;
        }

        for (Producto producto : criticos) {
            System.out.println(
                producto.getNombre() + " - Stock: " + producto.getStock()
            );
        }
    }
}
