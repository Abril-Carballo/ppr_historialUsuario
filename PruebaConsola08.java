import java.util.Scanner;

public class PruebaConsola08 {

public static void main(String[] args) {
    Distribuidora distribu1 = new Distribuidora();

    // Inicializamos clientes y algunos articulos de prueba
    distribu1.iniciar();
    distribu1.listaArticulos.add(new Articulo(1, "Leche", 200, 1));
    distribu1.listaArticulos.add(new Articulo(2, "Pan", 100, 1));
    distribu1.listaArticulos.add(new Articulo(3, "Queso", 500, 1));

    System.out.println("Lista inicial de clientes");
    System.out.println(distribu1.listaClientes);

    System.out.println("\nLista inicial de artículos");
    System.out.println(distribu1.listaArticulos);

    System.out.println("\nValidacion de cliente");

    // Llamamos al metodo registrarVenta que ya tiene la validacion
    distribu1.registrarVenta();

    }
}