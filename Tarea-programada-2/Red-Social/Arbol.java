
/**
 * Write a description of class Arbol here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arbol
{
    private NodoArbol raiz;
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Arbol() {
        raiz = null;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public NodoArbol getRaiz() {
        return raiz;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setRaiz(NodoArbol raiz) {
        raiz = raiz;
    }
    
    public boolean estarVacio() 
    {
        boolean vacio = false;
        if (raiz == null) {
            vacio = true;
        }

        return vacio;
    }
    
    public boolean serHoja() {
        boolean resultado = true;
        if(raiz != null) {
            if(raiz.getArbolDerecho() != null || raiz.getArbolIzquierdo() != null){
                resultado = false;
            }
        }
        return resultado;
    }
    
    /**
     * Verifica si el nombre digitado por el usuario se encuentra dentro de la lista.
     * 
     * @param nombre Nombre de la persona a buscar en la lista que digita el usuario.
     * @return true si el nombre digitado se encuentra dentro de la lista o false en caso contrario.
     */
    public boolean verificarExistencia(String nombre) {
        boolean existe = false;
        
        if (raiz != null) {
            if (raiz.getPersona().getNombre().equals(nombre)) {
                existe = true;
            } else {
                if (nombre.compareTo(raiz.getPersona().getNombre()) < 0) {
                    existe = raiz.getArbolIzquierdo().verificarExistencia(nombre);
                } else {
                    existe = raiz.getArbolDerecho().verificarExistencia(nombre);
                }
            }
        }
        
        return existe;
    }
    
    public boolean agregarAmigo(Persona nuevoAmigo) {
        boolean agregado = true;
        
        if (verificarExistencia(nuevoAmigo.getNombre()) == false) {
            if (raiz == null) {
                NodoArbol nodoNuevo = new NodoArbol(nuevoAmigo);
                raiz = nodoNuevo;
            } else {
                if (nuevoAmigo.getNombre().compareTo(raiz.getPersona().getNombre()) < 0) {
                    raiz.getArbolIzquierdo().agregarAmigo(nuevoAmigo);
                } else {
                    raiz.getArbolDerecho().agregarAmigo(nuevoAmigo);
                }
            }
        }
        
        return agregado;
    }
}
