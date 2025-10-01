import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Distribuidora distribu1 = new Distribuidora();
        distribu1.iniciar();

        System.out.println(distribu1.listaArticulos);

        // Crear la ventana
        JFrame frame = new JFrame("Paradigma 2015");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas
        JLabel label = new JLabel("Codigo");
        label.setBounds(20, 20, 150, 25);
        frame.add(label);

        JLabel labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(20, 50, 150, 25);
        frame.add(labelNombre);

        JLabel labelPrecio = new JLabel("Precio");
        labelPrecio.setBounds(20, 80, 150, 25); // corregido
        frame.add(labelPrecio);

        // Campos de texto
        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(170, 20, 150, 25);
        frame.add(txtCodigo);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(170, 50, 150, 25);
        frame.add(txtNombre);

        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(170, 80, 150, 25); // corregido
        frame.add(txtPrecio);

        // Botón
        JButton buttonGuardar = new JButton("Aceptar");
        buttonGuardar.setBounds(150, 120, 100, 30);
        frame.add(buttonGuardar);


        // ComboBox para los clientes
        JComboBox<Articulo> comboArticulo = new JComboBox<>();
        comboArticulo.setBounds(20, 160, 320, 25);
        frame.add(comboArticulo);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 120, 300, 25);      
        
        for (Articulo articulo : distribu1.listaArticulos) {
            comboArticulo.addItem(articulo);
        }
        
        frame.add(resultLabel);


        // Acción del botón
        buttonGuardar.addActionListener(e -> {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());

            System.out.println("Codigo: " + codigo + " Nombre: " + nombre + " Precio: " + precio);

            Articulo articulo = new Articulo(codigo, nombre, precio, 1);
            distribu1.listaArticulos.add(articulo);
            System.out.println(distribu1.listaArticulos);

            // agrego el articulo al combobox
            comboArticulo.addItem(articulo);
        });

        // Mostrar ventana al final
        frame.setVisible(true);

    }
}
