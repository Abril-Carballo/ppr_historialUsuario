import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DistribuidoraGUI extends JFrame {
    private JPanel pnlVenta;
    private JComboBox<Cliente> cmbClientes;
    private JComboBox<Articulo> cmbArticulos;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnConfirmar;
    private JLabel lblMensaje;
    private JTextArea txtDetalle;

    private Distribuidora distribuidora;
    private Venta ventaActual;

    public DistribuidoraGUI() {
        setTitle("Distribuidora - Registro de Venta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        // --- Panel superior: selección de cliente ---
        JPanel pnlCliente = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        pnlCliente.setBackground(Color.WHITE);
        JLabel lblCliente = new JLabel("Cliente:");
        lblCliente.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlCliente.add(lblCliente);
        cmbClientes = new JComboBox<>();
        cmbClientes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cmbClientes.setBackground(Color.WHITE);
        pnlCliente.add(cmbClientes);
        add(pnlCliente, BorderLayout.NORTH);

        // --- Panel central: artículos, cantidad, botones ---
        pnlVenta = new JPanel(new GridBagLayout());
        pnlVenta.setBackground(Color.WHITE);
        pnlVenta.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblArticulo = new JLabel("Artículo:");
        lblArticulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlVenta.add(lblArticulo, gbc);

        gbc.gridx = 1;
        cmbArticulos = new JComboBox<>();
        cmbArticulos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlVenta.add(cmbArticulos, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlVenta.add(lblCantidad, gbc);

        gbc.gridx = 1;
        txtCantidad = new JTextField(10);
        txtCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnlVenta.add(txtCantidad, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        btnAgregar = new JButton("Agregar detalle");
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnAgregar.setBackground(new Color(52, 152, 219));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        pnlVenta.add(btnAgregar, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        lblMensaje = new JLabel(" ");
        lblMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        pnlVenta.add(lblMensaje, gbc);

        add(pnlVenta, BorderLayout.CENTER);

        // --- Panel inferior: detalles de venta y confirmación ---
        JPanel pnlInferior = new JPanel(new BorderLayout(10, 10));
        pnlInferior.setBackground(Color.WHITE);
        pnlInferior.setBorder(new EmptyBorder(10, 15, 10, 15));

        txtDetalle = new JTextArea(10, 40);
        txtDetalle.setEditable(false);
        txtDetalle.setFont(new Font("Consolas", Font.PLAIN, 13));
        txtDetalle.setLineWrap(true);
        txtDetalle.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtDetalle);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        pnlInferior.add(scroll, BorderLayout.CENTER);

        btnConfirmar = new JButton("Confirmar venta");
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirmar.setBackground(new Color(46, 204, 113));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        pnlInferior.add(btnConfirmar, BorderLayout.SOUTH);

        add(pnlInferior, BorderLayout.SOUTH);

        // --- Inicialización de la distribuidora ---
        distribuidora = new Distribuidora();
        distribuidora.iniciar();

        // Cargar clientes y artículos en los combos
        for (Cliente c : distribuidora.listaClientes) {
            cmbClientes.addItem(c);
        }
        for (Articulo a : distribuidora.listaArticulos) {
            cmbArticulos.addItem(a);
        }

        // --- Acción: selección de cliente ---
        cmbClientes.addActionListener(e -> {
            Cliente clienteSeleccionado = (Cliente) cmbClientes.getSelectedItem();
            if (clienteSeleccionado != null) {
                ventaActual = new Venta(clienteSeleccionado);
                txtDetalle.setText("Nueva venta iniciada para: " + clienteSeleccionado + "\n");
            }
        });

        // --- Acción: agregar detalle ---
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ventaActual == null) {
                    lblMensaje.setForeground(Color.RED);
                    lblMensaje.setText("Seleccione un cliente antes de agregar artículos.");
                    return;
                }

                Articulo articulo = (Articulo) cmbArticulos.getSelectedItem();
                if (articulo == null) return;

                try {
                    int cantidad = Integer.parseInt(txtCantidad.getText());
                    if (cantidad <= 0) throw new NumberFormatException();

                    if (articulo.esPackCerrado(cantidad)) {
                        int packs = articulo.cantidadPacks(cantidad);
                        ventaActual.agregarDetalle(new DetalleVenta(articulo, packs));
                        lblMensaje.setForeground(new Color(0, 128, 0));
                        lblMensaje.setText("Artículo agregado correctamente.");
                        txtDetalle.append("- " + articulo.getDenominacion() +
                                " | Cantidad: " + cantidad +
                                " | Total: $" + (packs * articulo.getPrecio() * articulo.getTamanioPack()) + "\n");
                    } else {
                        int sugerida = articulo.sugerirCantidadValida(cantidad);
                        lblMensaje.setForeground(Color.RED);
                        lblMensaje.setText("Cantidad mínima requerida: " +
                                articulo.getTamanioPack() + " unidades. Sugerida: " + sugerida);
                    }
                } catch (NumberFormatException ex) {
                    lblMensaje.setForeground(Color.RED);
                    lblMensaje.setText("Ingrese una cantidad numérica válida.");
                }
            }
        });
        // --- Acción: confirmar venta ---
        btnConfirmar.addActionListener(e -> {
            if (ventaActual == null || ventaActual.calcularTotal() == 0) {
                lblMensaje.setForeground(Color.RED);
                lblMensaje.setText("No hay detalles de venta para confirmar.");
            } else {
                double total = ventaActual.calcularTotal(); // ya aplica descuento si es mayorista
                lblMensaje.setForeground(new Color(0, 128, 0));

                String mensaje = "Venta confirmada. TOTAL: $" + total;
                if (ventaActual.getCliente().esMayorista()) {
                    mensaje += " (descuento mayorista aplicado)";
                }
                lblMensaje.setText(mensaje);

                txtDetalle.append("\n✅ Venta confirmada.\nTOTAL: $" + total);
                if (ventaActual.getCliente().esMayorista()) {
                    txtDetalle.append(" (descuento mayorista aplicado)");
                }
                txtDetalle.append("\n");
            }
        });
        }
        
    // --- MAIN ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DistribuidoraGUI().setVisible(true));
    }
}
