public class DetalleVenta
{
    private Articulo articulo;
    private int cantidad;
    private double precio;

    public DetalleVenta(Articulo articulo, int cantidad) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = articulo.getPrecio();
    }

    public double getSubtotal() { 
        return this.precio * cantidad;
    }

    public String toString() {
        return articulo.getCodigo() + " x " + cantidad + " = $" + getSubtotal();
    }
}
