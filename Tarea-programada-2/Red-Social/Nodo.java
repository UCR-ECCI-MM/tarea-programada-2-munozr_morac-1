
/**
 * Write a description of class Nodo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Nodo
{
    private Persona persona;
    private Nodo siguiente;
    private Nodo anterior;
    
    /**
     * Constructor de la clase Nodo.
     */
    public Nodo(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Nodo getAnterior() {
        return anterior;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public String toString() {
        return persona.toString();
    }
}
