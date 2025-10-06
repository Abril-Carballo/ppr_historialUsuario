import java.util.ArrayList;
import java.util.Scanner;

public class Distribuidora {
    ArrayList<Articulo> listaArticulos;
    ArrayList<Cliente> listaClientes;
    
    public Distribuidora() {
        this.listaArticulos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
    }

    // inicia agregando articulos y clientes
    public void iniciar(){
        listaClientes.add(new ClienteMayorista(1,"Carlos Lopez"));
        listaClientes.add(new ClienteMinorista(2,"Marta Suarez"));   
        listaClientes.add(new ClienteMinorista(3,"Ana Perez"));

        listaArticulos.add(new Articulo(1,"Botella de agua", 10.0, 10));
        listaArticulos.add(new Articulo(2,"Jugo de limón", 20.0, 10));
        listaArticulos.add(new Articulo(3,"Jugo de naranja", 22.5, 10));
    }

    // Método privado que recibe un código y devuelve el artículo que tenga ese código
    private Articulo getArticuloSeleccionado(int codigo) {
        Articulo articuloSeleccionado = null;
        for (Articulo a : listaArticulos) {
            if (a.getCodigo() == codigo) {
                articuloSeleccionado = a;
            }
        }
        return articuloSeleccionado;
    }

    // busca un cliente dentro de listaClientes cuyo código coincida con el pasado por parámetro
    private Cliente getClienteSeleccionado(int codigo){
        Cliente clienteSeleccionado = null;
        for (Cliente c : listaClientes) {
            if (c.getCodigo() == codigo) {
                clienteSeleccionado = c;
            }
        }
        return clienteSeleccionado;
    }
    
    public void registrarVenta(){        
        Scanner sc = new Scanner(System.in);
        Venta venta = null;
        
        // --- Selección del cliente ---
        System.out.println("Lista de clientes: " + listaClientes);
        System.out.print("Ingrese código de cliente: ");
        int codigoCliente = sc.nextInt();

        Cliente clienteSeleccionado = getClienteSeleccionado(codigoCliente);
        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        } else {
            venta = new Venta(clienteSeleccionado);
        }

        // --- Selección de artículos ---
        int codigoArticulo;
        do {
            System.out.println("Lista de artículos: " + listaArticulos);
            System.out.println("--------------------");
            System.out.print("Ingrese código de artículo (0 para finalizar): ");
            codigoArticulo = sc.nextInt();
            
            if (codigoArticulo == 0) break; // salir si ingresa 0

            Articulo articuloSeleccionado = getArticuloSeleccionado(codigoArticulo);
            if (articuloSeleccionado != null) {
                System.out.println("----- DETALLE DE VENTA -----");
                System.out.print("Ingrese cantidad: ");
                int cantidad = sc.nextInt();

                /* 04 LLAMADA AL METODO Y VERIFICACIONES */
                if (articuloSeleccionado.esPackCerrado(cantidad)) {
                    int packs = articuloSeleccionado.cantidadPacks(cantidad);
                    System.out.println("El pack es completo. Cantidad registrada: " + packs);
                    venta.agregarDetalle(new DetalleVenta(articuloSeleccionado, packs));
                    System.out.println("Detalle agregado OK");
                } else {
                    // --- 05 Mensaje explícito si no es múltiplo de pack ---
                    int sugerida = articuloSeleccionado.sugerirCantidadValida(cantidad);

                    System.out.println("El pack no es completo.");
                    System.out.println("Ingresaste: " + cantidad + " unidades.");
                    System.out.println("Cantidad más cercana sugerida: " + sugerida + " unidades.");
                    System.out.println("El detalle NO se registró, debe ingresar una cantidad válida.");
                }

            } else {
                System.out.println("Código de artículo inválido.");
            }
        } while (true);

        // --- Finalización ---
        if (venta.calcularTotal() > 0) {
            System.out.println("--------------------");
            System.out.println("VENTA REGISTRADA CORRECTAMENTE");
            System.out.println(venta);
        } else {
            System.out.println("No se registró ningún detalle de venta.");
        }
    }
}
