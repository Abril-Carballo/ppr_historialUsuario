import java.util.ArrayList;

public class Venta
{
    private Cliente cliente;
    private ArrayList<DetalleVenta> detalles;

    public Venta() {
        
    }
    
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total = 0;
        for (DetalleVenta d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    public String toString() {
        System.out.println("--------------------");
        String s = "Cliente: " + cliente.getNombre() + "\n";
        for (DetalleVenta d : detalles) {
            s += d + "\n";
        }
        s += "Total: $" + calcularTotal();
        return s;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
