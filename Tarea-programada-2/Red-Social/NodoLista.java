
/**
 * Esta clase representa un nodo de la lista.
 *
 * @author Kyara Vannesa Muñoz Ramírez (C15380)
 * @author Jose Pablo Mora Cubillo (B75044)
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
     * Devuelve la persona asociada al nodo de la lista.     
     * 
     * @return Persona asociada al nodo de la lista. 
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Sobreescribe la persona asociada al nodo de la lista. 
     * 
     * @param persona Nueva persona asociada al nodo de la lista. 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Retorna el siguiente nodo de la lista. 
     * 
     * @return Nodo siguiente. 
     */
    public NodoLista getSiguiente() {
        return siguiente;
    }
    
    /**
     * Sobrescribe el nodo siguiente de la lista. 
     * 
     * @param siguiente Nuevo nodo siguiente. 
     */
    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Retorna el nodo anterior de la lista.
     * 
     * @return Nodo anterior. 
     */
    public NodoLista getAnterior() {
        return anterior;
    }
    
    /**
     * Sobrescribe el nodo anterior de la lista. 
     * 
     * @param anterior Nuevo nodo anterior.
     */
    public void setAnterior(NodoLista anterior) {
        this.anterior = anterior;
    }
    
    /**
     * Retorna en una hilera el nombre de la persona, así como el mes y día de cumpleaños. 
     * 
     * @return String con el nombre de la persona, mes y día de cumpleaños. 
     */
    public String toString() {
        return persona.toString();
    }
}
