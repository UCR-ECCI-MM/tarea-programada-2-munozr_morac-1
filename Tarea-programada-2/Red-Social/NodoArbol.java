
/**
 * Esta clase representa un nodo del árbol. 
 * 
 * @author Kyara Vannesa Muñoz Ramírez (C15380)
 * @author Jose Pablo Mora Cubillo (B75044)
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
     * Determina si el árbol izquierdo está vacío.   
     *  
     * @return True si el árbol izquierdo está vacío o false en caso contrario. 
     */
    public boolean estarVacioIzquierdo(){
        boolean vacio = true;
        if(this.getArbolIzquierdo().getRaiz() != null){
            vacio = false;
        }

        return vacio;
    }

    /**
     * Determina si el árbol derecho está vacío.
     *  
     * @return True si el árbol derecho está vacío o false en caso contrario. 
     */ 
    public boolean estarVacioDerecho(){
        boolean vacio = true;
        if(this.getArbolDerecho().getRaiz() != null){
            vacio = false;
        }

        return vacio;
    }

    /**
     * Retorna la persona asociada al nodo del árbol. 
     *
     * @return Persona asociada al nodo. 
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Sobrescribe la persona asociada al nodo. 
     * 
     * @param persona Nueva persona asociada al nodo. 
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve el árbol izquierdo asociado al nodo.
     * 
     * @return Árbol izquierdo. 
     */
    public Arbol getArbolIzquierdo() {
        return arbolIzquierdo;
    }

    /**
     * Sobrescribe el árbol izquierdo asociado al nodo. 
     * 
     * @param arbolIzquierdo Nuevo árbol izquierdo. 
     */
    public void setArbolIzquierdo(Arbol arbolIzquierdo) {
        this.arbolIzquierdo = arbolIzquierdo;
    }

    /**
     * Devuelve el árbol derecho asociado al nodo. 
     * 
     * @return Árbol derecho. 
     */
    public Arbol getArbolDerecho() {
        return arbolDerecho;
    }

    /**
     * Sobrescribe el árbol derecho asociado al nodo. 
     * 
     * @param arbolIzquierdo Nuevo árbol derecho. 
     */
    public void setArbolDerecho(Arbol arbolDerecho) {
        this.arbolDerecho = arbolDerecho;
    }
}
