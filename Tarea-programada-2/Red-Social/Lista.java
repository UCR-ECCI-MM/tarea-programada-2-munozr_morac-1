
/**
 * Write a description of class Lista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lista
{
    private Nodo primero;
    private Nodo ultimo;
    
    /**
     * Constructor de la clase Lista
     */
    public Lista() {
        primero = null;
        ultimo = null;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Nodo getPrimero() {
        return primero;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public Nodo getUltimo() {
        return ultimo;
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    
    /**
     * Verifica si el nombre digitado por el usuario se encuentra dentro de la lista.
     * 
     * @param nombre Nombre de la persona a buscar en la lista que digita el usuario.
     * @return true si el nombre digitado se encuentra dentro de la lista o false en caso contrario.
     */
    public boolean verificarExistencia(String nombre) {
        Nodo nodoAuxiliar = primero;
        boolean existe = false;
        
        while (nodoAuxiliar != null) {
            if (nombre.compareTo(nodoAuxiliar.getPersona().getNombre()) == 0) {
                existe = true;
                nodoAuxiliar = null;
            }
        }
        
        return existe;
    }
    
    /**
     * Agrega una persona a la lista en la posición que le corresponde a partir del orden alfabético de los nombres.
     * 
     * @param nuevaPersona La nueva persona que se desea agregar a la lista.
     * @return true si la persona se pudo agregar correctamente o false en caso contrario.
     */
    public boolean agregarPersona(Persona nuevaPersona) {
        boolean agregado = false;
        
        if (verificarExistencia(nuevaPersona.getNombre()) == false) {
            agregado = true;
            Nodo nodoNuevo = new Nodo(nuevaPersona);
        
            if (primero == null) {
                primero = nodoNuevo;
                ultimo = nodoNuevo;
            } else {
                if (nodoNuevo.getPersona().getNombre().compareTo(primero.getPersona().getNombre()) < 0) {
                    primero.setAnterior(nodoNuevo);
                    nodoNuevo.setSiguiente(primero);
                    primero = nodoNuevo;
                } else {
                    if (nodoNuevo.getPersona().getNombre().compareTo(ultimo.getPersona().getNombre()) > 0) {
                        ultimo.setSiguiente(nodoNuevo);
                        nodoNuevo.setAnterior(ultimo);
                        ultimo = nodoNuevo;
                    } else {
                        Nodo nodoAuxiliar = primero;
                
                        while (nodoAuxiliar != ultimo) {
                            if (nodoAuxiliar.getPersona().getNombre().compareTo(nodoNuevo.getPersona().getNombre()) < 0 
                            && nodoNuevo.getPersona().getNombre().compareTo(nodoAuxiliar.getSiguiente().getPersona().getNombre()) < 0) {
                                nodoNuevo.setAnterior(nodoAuxiliar);
                                nodoNuevo.setSiguiente(nodoAuxiliar.getSiguiente());
                                nodoAuxiliar.setSiguiente(nodoNuevo);
                                nodoAuxiliar.getSiguiente().setAnterior(nodoNuevo);
                                nodoAuxiliar = ultimo;
                            } else {
                                nodoAuxiliar = nodoAuxiliar.getSiguiente();
                            }
                        }
                    }
                }
            }
        }
        
        return agregado;
    }
    
    /**
     * Elimina la persona en la lista que el usuario desee y su respectivo árbol.
     * 
     * @param nombre Nombre de la persona a eliminar en la lista.
     * @return true si fue eliminado correctamente o false en caso contrario.
     */
    public boolean eliminarPersona(String nombre) {
        boolean eliminado = true;
        boolean encontrado = false;
        
        if (primero == null) {
            eliminado = false;
        } else {
            if (primero.getPersona().getNombre().equals(nombre)) {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            } else {
                if (ultimo.getPersona().getNombre().equals(nombre)) {
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(null);
                } else {
                    Nodo nodoAuxiliar = primero.getSiguiente();
                
                    while (nodoAuxiliar != ultimo && encontrado != true) {
                        if (nodoAuxiliar.getPersona().getNombre().equals(nombre)) {
                            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
                            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
                            encontrado = true;
                        } else {
                            nodoAuxiliar = nodoAuxiliar.getSiguiente();
                        }
                    }
                    
                    if (encontrado == false) {
                        eliminado = false;
                    }
                }
            }
        }
        
        return eliminado;
    }
    
    /**
     * toString de la clase Lista.
     * 
     * @return una hilera que contenga a todas las personas en la lista con sus respectivos datos.
     */
    public String toString() {
        Nodo nodoAuxiliar = primero;
        String hilera = "";
        
        while (nodoAuxiliar != null) {
            hilera += nodoAuxiliar.getPersona().toString() + "\n";
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        return hilera;
    }
}
