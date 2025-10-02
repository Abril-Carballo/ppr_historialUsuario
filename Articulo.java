public class Articulo implements Comparable
{
    private int codigo;
    private String denominacion;
    private double precio;
    private int tamanioPack;

    public Articulo()
    {
        
    }

   /** 03 CONSTRUCTOR con validación de la cant de pack  */
    public Articulo(int codigo, String nombre, double precio, int tamanioPack) {
        if (tamanioPack <= 0) {
            System.out.println("El tamaño del pack debe ser mayor a 00");
            throw new IllegalArgumentException("'El tamaño del pack debe ser mayor a 0'");
        }
        this.codigo = codigo;
        this.denominacion = nombre;
        this.precio = precio;
        this.tamanioPack = tamanioPack; 
    }
    
    
     public String toString(){
        return this.codigo +" - "+ this.denominacion;
    }
    
    // Sirve para definir un criterio de ordenamiento natural de los objetos de una clase.
     public int compareTo(Object o){
        Articulo c = (Articulo) o; // recibo un objeto y lo casteo a articulo
        return this.denominacion.compareTo(c.getDenominacion()); // compara cadenas alfabeticamente 
    }
    
    // Metodos getters
    public double getPrecio(){ return precio; }
    public int getCodigo(){ return codigo; } 
    public String getDenominacion(){ return denominacion; }  
}
