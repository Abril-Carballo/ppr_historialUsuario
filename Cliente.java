import java.util.ArrayList;

public class Cliente implements Comparable
{
    private int codigo;
    private String nombre;
    private boolean mayorista; 

    public Cliente()
    { }

    public Cliente(int codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre; }
    
    public String getNombre(){
        return nombre;  }
    
    public String toString(){
        return this.codigo +" - "+ this.nombre; }
    
    //Metodo para ordenar alfabeticamente 
    public int compareTo(Object o){
        Cliente c= (Cliente) o;
        return this.nombre.compareTo(c.getNombre()); }    
    
    // Metodos getters
    public int getCodigo(){ return codigo; }
   
    //MÉTODO PARA CALCULAR EL TOTAL DE UNA VENTA #07  
    public double calcularTotal(ArrayList<DetalleVenta> detalles) {
        double total = 0;
        for (DetalleVenta d : detalles) {
            total += d.getSubtotal(); }
            return total;
    }

    
    public boolean esMayorista() {
        return mayorista;
    }
}