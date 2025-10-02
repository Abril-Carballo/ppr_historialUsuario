import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Distribuidora
{
    ArrayList<Articulo> listaArticulos;
    ArrayList<Cliente> listaClientes;
    
    public Distribuidora()
    {
        this.listaArticulos = new ArrayList();
        this.listaClientes = new ArrayList();
    }

    public void iniciar(){
        listaClientes.add(new Cliente(1,"Consumidor Final"));
        listaClientes.add(new Cliente(2,"Ruleta"));   
        listaClientes.add(new Cliente(3,"Perez Ana"));
    }
    
    
    private Articulo getArticuloSeleccionado(int codigo){
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
        return clienteSeleccionado; // retorna el cliente con el código indicado, o null si no existe.
    }
    
    public void registrarVenta(){
        Venta venta = null;
        int codigoArticulo = 0; // arranca el recorrido de articulos 
        Scanner sc = new Scanner(System.in); //Lee la entrada del usuario
        
        System.out.println(listaClientes);
        Collections.sort(listaClientes); // llamo al metodo para ordenar alfabeticamente 
        System.out.println(listaClientes);
        
        //HU 08: Validacion del cliente
        Cliente clienteSeleccionado = null;
        do {
            System.out.println("Lista de clientes disponibles: " + listaClientes);
            System.out.print("Ingrese el código del cliente: ");
            int codigoCliente = sc.nextInt(); //Lee un numero entero y lo guarda en la variable "codigoCliente"
            clienteSeleccionado = getClienteSeleccionado(codigoCliente); // obtiene el cliente con el código dado y lo guarda en una variable para usarlo después
            
            if (clienteSeleccionado == null) {
                System.out.println("Cliente no encontrado. Intente nuevamente");
            }
        } while (clienteSeleccionado == null);

        //Si llega aca es porque encontro un cliente valido
        venta = new Venta(clienteSeleccionado);
        
        // imprimo la lista antes y despues de ordenarla
        System.out.println(listaArticulos);
        Collections.sort(listaArticulos);
        System.out.println(listaArticulos);
        
        do {
            codigoArticulo += 1;
            System.out.println("Seleccione un artículo (0 para finalizar):");
            Articulo articuloSeleccionado = getArticuloSeleccionado(codigoArticulo);
        
            if (articuloSeleccionado != null) {
                int cantidad = 10; // cantidad especifica 

                //  llamar al metodo que controle lo que me pide el item 4
                // si artiuclo seleccionado completa el pack y de cuanto es el pack 


                venta.agregarDetalle(new DetalleVenta(articuloSeleccionado, cantidad));
                System.out.println("Detalle agregado OK");
                 
            } else {
                System.out.println("Código de artículo inválido.");
            }
        } 
        while (codigoArticulo < 3 ); // Repite mientras
        
        if (venta.calcularTotal() > 0) {
            System.out.println("✅ Venta registrada correctamente:");
            System.out.println(venta);
        } else {
            System.out.println("⚠️ No se registró ningún detalle de venta.");
        }
    }
}