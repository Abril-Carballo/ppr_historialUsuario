import java.util.ArrayList;

// Historia de usuario #07
public class ClienteMayorista extends Cliente {
    public ClienteMayorista(int codigo, String nombre) {
        super(codigo, nombre);
    }

    @Override
    public double calcularTotal(ArrayList<DetalleVenta> detalles) {
        double total = super.calcularTotal(detalles);
<<<<<<< HEAD
        return total * 0.9; // 10% de descuento
=======
        return total * 0.90; // Aplicar 10% de descuento
>>>>>>> 2f8e726ae27d8059f0ea89e50cfb0c61f938d70d
    }


}

