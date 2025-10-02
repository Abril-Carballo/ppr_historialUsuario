import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();
        distribuidora.iniciar();        // carga inicial de clientes y artículos
        distribuidora.registrarVenta(); // se ejecuta la venta interactiva
    }
}
