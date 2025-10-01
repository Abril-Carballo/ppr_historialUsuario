public abstract class MetodosPago {
    private int monto;
    private Cliente cliente;
    
    public MetodosPago(int monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();  // Método abstracto para que cada hijo lo implemente

    public int getMonto() { return monto; }
}