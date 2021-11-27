
/**
 * Write a description of class Usuario here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Persona
{
    private String nombre;
    private int dia;
    private int mes;
    private Arbol arbolAmigos;
    
    /**
     * Constructor de la clase Persona.
     */
    public Persona(String nombre, int dia, int mes) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.arbolAmigos = new Arbol();
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public int getDia() {
        return dia;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public int getMes() {
        return mes;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Arbol getArbolAmigos() {
        return arbolAmigos;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setArbolAmigos(Arbol arbolAmigos) {
        this.arbolAmigos = arbolAmigos;
    }
    
    public boolean agregarAmigo(Persona nuevoAmigo) {
        return arbolAmigos.agregarAmigo(nuevoAmigo);
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public String toString() {
        return nombre + ", " + dia + "/" + mes + "\n  Amigos:\n" + arbolAmigos.toString();
    }
}