public class PagoTarjeta extends MetodosPago {
    private String titular;
    private String dni;

    // Constructor
    public PagoTarjeta(int monto, String titular, String dni) {
        super(monto);
        this.titular = titular;
        this.dni = dni;
    }

    // Procesar el pago
    public void procesarPago() {
        System.out.println("=================================");
        System.out.println("   Procesando pago con TARJETA");
        System.out.println("   Monto:    $" + getMonto());
        System.out.println("   Titular:  " + titular);
        System.out.println("   DNI:      " + dni);
        System.out.println("   Estado:   TARJETA ACEPTADA ✅");
        System.out.println("=================================");
    }

    // Getters
    public String getTitular() { return titular; }
    public String getDni() { return dni; }
}