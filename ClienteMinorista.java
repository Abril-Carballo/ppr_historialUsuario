import java.util.ArrayList;

public class ClienteMinorista extends Cliente {
    public ClienteMinorista(int codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public double calcularTotal(ArrayList<DetalleVenta> detalles) {
        return super.calcularTotal(detalles); // No tiene descuento
    }
}
