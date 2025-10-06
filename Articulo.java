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
            System.out.println("El tamaño del pack debe ser mayor a 0");
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

    // 04 MÉTODO verificar si una cantidad de artículos forma packs completos sin que sobren unidades.
    public boolean esPackCerrado(int cantidad) {
        return cantidad % this.tamanioPack == 0; // Calcula el resto y si es 0 devuelve true
    }

    // MÉTODO para saber la cantidad de packs que puedo formar.
    public int cantidadPacks(int cantidad) {
        return cantidad / tamanioPack;
    }

    /* 05 MÉTODO para saber la cantidad de packs que puedo formar. */
    public int sugerirCantidadValida(int cantidad) {
        if (cantidad % tamanioPack == 0) {
            return cantidad; // si ya es múltiplo exacto, no hace falta sugerir
        }

        int multiploInferior = (cantidad / tamanioPack) * tamanioPack;
    
        // se suma 1 para que el resultado sea múltiplo de tamanioPack
        int multiploSuperior = ((cantidad / tamanioPack) + 1) * tamanioPack;

        // elegimos el que esté más cerca
        if (cantidad - multiploInferior <= multiploSuperior - cantidad) {
            return multiploInferior;
        } else {
            return multiploSuperior;
        }
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
    public int getTamanioPack() {   return tamanioPack; }

}