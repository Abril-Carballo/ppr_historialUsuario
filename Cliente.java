public class Cliente implements Comparable
{
    private int codigo;
    private String nombre;

    public Cliente()
    {
        
    }

    public Cliente(int codigo, String nombre)
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        return this.codigo +" - "+ this.nombre;
    }
    
    // Metodo para ordenar alfabeticamente 
    public int compareTo(Object o){
        Cliente c= (Cliente) o;
        return this.nombre.compareTo(c.getNombre());
    }    
    
    // Metodos getters
    public int getCodigo(){ return codigo; }
}
