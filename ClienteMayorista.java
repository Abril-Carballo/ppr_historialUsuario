import java.util.ArrayList;

// Historia de usuario #07
public class ClienteMayorista extends Cliente {
    public ClienteMayorista(int codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public double calcularTotal(ArrayList<DetalleVenta> detalles) {
        double total = super.calcularTotal(detalles);
        return total * 0.85; // Aplicar 15% de descuento
    }
}
