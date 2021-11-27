
/**
 * Write a description of class NodoArbol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodoArbol
{
    private Persona persona;
    private Arbol arbolIzquierdo;
    private Arbol arbolDerecho;
    
    /**
     * Constructor de la clase NodoArbol.
     */
    public NodoArbol(Persona persona) {
        this.persona = persona;
        this.arbolIzquierdo = new Arbol();
        this.arbolDerecho = new Arbol();
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
    public Arbol getArbolIzquierdo() {
        return arbolIzquierdo;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setArbolIzquierdo(Arbol arbolIzquierdo) {
        this.arbolIzquierdo = arbolIzquierdo;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Arbol getArbolDerecho() {
        return arbolDerecho;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setArbolDerecho(Arbol arbolDerecho) {
        this.arbolDerecho = arbolDerecho;
    }
}
