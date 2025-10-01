public class PagoEfectivo extends MetodosPago {
    private int recibido;
    private int vuelto;
    private boolean confirmado;

    // Constructor mínimo
    public PagoEfectivo(int monto) {
        super(monto);
        this.recibido = 0;
        this.vuelto = 0;
        this.confirmado = false;
    }

    // Constructor con efectivo entregado
    public PagoEfectivo(int monto, int recibido) {
        super(monto);
        entregarEfectivo(recibido);
        this.vuelto = 0;
        this.confirmado = false;
    }

    // Registrar efectivo entregado con validación
    public void entregarEfectivo(int recibido) {
        if (recibido < 0) {
            throw new IllegalArgumentException("El monto recibido no puede ser negativo.");
        }
        this.recibido = recibido;
    }

    // Procesar el pago
    public void procesarPago() {
        System.out.println("=================================");
        System.out.println("   Procesando pago en EFECTIVO");
        System.out.println("   Monto:    $" + getMonto());

        if (recibido <= 0) {
            System.out.println("   Error: no se recibió efectivo. Use entregarEfectivo(...).");
            System.out.println("=================================");
            return;
        }

        System.out.println("   Recibido: $" + recibido);

        if (recibido >= getMonto()) {
            vuelto = recibido - getMonto();
            confirmado = true;
            System.out.println("   Vuelto:   $" + vuelto);
            System.out.println("   Estado:   CONFIRMADO ✅");
        } else {
            int faltante = getMonto() - recibido;
            confirmado = false;
            System.out.println("   Falta:    $" + faltante);
            System.out.println("   Estado:   RECHAZADO ❌ (dinero insuficiente)");
        }

        System.out.println("=================================");
    }

    // Reiniciar el estado del pago
    public void reiniciarPago() {
        this.recibido = 0;
        this.vuelto = 0;
        this.confirmado = false;
    }

    // Obtener estado como texto
    public String getEstado() {
        if (confirmado) {
            return "CONFIRMADO";
        } else {
            return "RECHAZADO";
        }
    }

    // Getters
    public int getRecibido() { return recibido; }
    public int getVuelto() { return vuelto; }
    public boolean isConfirmado() { return confirmado; }
}