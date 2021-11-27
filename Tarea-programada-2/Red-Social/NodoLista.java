
/**
 * Write a description of class Nodo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodoLista
{
    private Persona persona;
    private NodoLista siguiente;
    private NodoLista anterior;
    
    /**
     * Constructor de la clase NodoLista.
     */
    public NodoLista(Persona persona) {
        this.persona = persona;
        this.siguiente = null;
        this.anterior = null;
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
    public NodoLista getSiguiente() {
        return siguiente;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public NodoLista getAnterior() {
        return anterior;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setAnterior(NodoLista anterior) {
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
