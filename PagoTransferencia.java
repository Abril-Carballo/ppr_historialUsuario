public class PagoTransferencia extends MetodosPago {
    private String cuentaOrigen;

    public PagoTransferencia(int monto, String cuentaOrigen) {
        super(monto);              // llama al constructor de la clase padre y le pasa "monto"
        this.cuentaOrigen = cuentaOrigen; // inicializa el atributo propio de esta clase
    }

    public void procesarPago() {
        System.out.println("=================================");
        System.out.println("   Procesando pago por transferencia");
        System.out.println("   Monto: $" + getMonto());
        System.out.println("   Cuenta origen: " + cuentaOrigen);
        System.out.println("   Estado: CONFIRMADO ✅");
        System.out.println("=================================");
    }

    public String getCuentaOrigen() { return cuentaOrigen; }
}