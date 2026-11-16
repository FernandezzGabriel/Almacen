import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventarioTest {

    private Inventario inventario;

    @BeforeEach
    void setUp() {
        inventario = new Inventario();
        inventario.registrarProducto("Bebida 3L", 10);
    }

    @Test
    void agregarStock() {
        inventario.registrarProducto("Bebida 3L", 4);
        assertEquals(15, inventario.buscarProducto("Bebida 3L").getStock());
    }

    @Test
    void restarStock() {
        boolean vendido = inventario.venderProducto("Bebida 3L", 2);
        assertTrue(vendido);
        assertEquals(8, inventario.buscarProducto("Bebida 3L").getStock());
    }

    @Test
    void noVenderMasQueElStock() {
        boolean vendido = inventario.venderProducto("Bebida 3L", 20);
        assertFalse(vendido);
        assertEquals(10, inventario.buscarProducto("Bebida 3L").getStock());
    }

    @Test
    void venderProductoQueNoExiste() {
        assertFalse(inventario.venderProducto("Pan", 1));
    }

    @Test
    void stockCritico() {
        inventario.registrarProducto("Arroz", 3);
        inventario.registrarProducto("Aceite", 5);

        assertEquals(2, inventario.obtenerStockCritico().size());
    }
}
