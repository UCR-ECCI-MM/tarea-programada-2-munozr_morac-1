import java.time.LocalDate;
/**
 * Esta clase representa un árbol binario ordenado de persona.
 *
 * @author Kyara Vannesa Muñoz Ramírez (C15380)
 * @author Jose Pablo Mora Cubillo (B75044)
 */
public class Arbol
{
    private NodoArbol raiz;

    /**
     * Constructor de la clase Persona.
     */
    public Arbol() {
        raiz = null;
    }

    /**
     * Retorna el NodoArbol que corresponde a la raíz del árbol. 
     * 
     * @return Raíz del árbol. 
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    /**
     * Sobrescribe la raíz del árbol. 
     * 
     * @param raiz Nuevo NodoArbol asignado como raíz. 
     */
    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    /**
     * Determina si el árbol está vacío. 
     * 
     * @return True si el árbol está vacío o false en caso contrario. 
     */
    public boolean estarVacio() 
    {
        boolean vacio = false;
        if (raiz == null) {
            vacio = true;
        }
        return vacio;
    }

    /**
     * Determina si el árbol es una hoja (el nodo raíz no tiene árbol izquierdo y derecho).
     * 
     * @return True si el árbol es una hoja o false en caso contrario. 
     */
    public boolean serHoja() {
        boolean resultado = true;
        if (raiz != null) {
            if (raiz.getArbolDerecho().estarVacio() == false || raiz.getArbolIzquierdo().estarVacio() == false) {
                resultado = false;
            }
        }
        return resultado;
    }

    /**
     * Devuelve la persona menor (la primera en orden alfabético). 
     * 
     * @return La persona menor. 
     */
    public Persona buscarMenor(){
        Persona menor = null;

        if(raiz.getArbolIzquierdo().getRaiz() == null){
            menor = raiz.getPersona();
        }else {
            menor = raiz.getArbolIzquierdo().buscarMenor();
        }

        return  menor;
    }

    /**
     * Devuelve la persona mayor (la ultima en orden alfabético). 
     * 
     * @return La persona mayor. 
     */
    public Persona buscarMayor(){
        Persona mayor = null;
        if(raiz.getArbolDerecho().getRaiz() == null){
            mayor = raiz.getPersona();
        }else {
            mayor = raiz.getArbolDerecho().buscarMayor();
        }

        return mayor;
    }

    /**
     * Verifica si el nombre digitado por el usuario se encuentra dentro de la lista.
     * 
     * @param nombre Nombre de la persona a buscar en la lista que digita el usuario.
     * @return True si el nombre digitado se encuentra dentro de la lista o false en caso contrario.
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

    /**
     * Agregar una nueva persona al árbol. 
     * 
     * @param nuevoAmigo Nueva persona que se va a agregar al árbol. 
     */
    public void agregarAmigo(Persona nuevoAmigo) {
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

    /**
     * Retorna una hilera con el nombre de todas las personas registradas en el árbol. 
     * 
     * @return Hilera con el nombre de todas las personas en el árbol. 
     */
    public String toString() {
        String hilera = "";

        if (raiz != null) {
            hilera += raiz.getArbolIzquierdo().toString();
            hilera += "    " + raiz.getPersona().getNombre() + ". ";
            hilera += raiz.getArbolDerecho().toString();
        }

        return hilera;
    }

    /**
     * Retorna una hilera con todas las personas del árbol, sigue el formato necesario para el archivo de guardado. 
     * 
     * @return Hilera con todas las personas en el árbol. 
     */
    public String toStringArchivo() {
        String hilera = "";

        if (raiz != null) {
            hilera += raiz.getArbolIzquierdo().toStringArchivo();
            hilera += raiz.getPersona().getNombre() + "\n";
            hilera += raiz.getArbolDerecho().toStringArchivo();
        }

        return hilera;
    }

    /**
     * Elimina una persona del árbol a partir de su nombre.  
     * 
     * @param personaEliminar Nombre de la persona a eliminar.
     * @return True si se eliminó la persona o false en caso contrario. 
     */
    public boolean eliminarAmigo(String personaEliminar) {
        boolean eliminado = false;
        if (this.estarVacio() != true) {
            if (this.serHoja() == true && personaEliminar.equals(raiz.getPersona().getNombre())) {
                this.setRaiz(null);
                eliminado = true;
            } else {
                if (this.serHoja() == false && personaEliminar.equals(raiz.getPersona().getNombre())) {
                    Persona personaSustituta = null; 
                    if (raiz.estarVacioIzquierdo() == false) {
                        personaSustituta = raiz.getArbolIzquierdo().buscarMayor();
                        raiz.setPersona(personaSustituta);
                        raiz.getArbolIzquierdo().eliminarAmigo(personaSustituta.getNombre());
                        eliminado = true;
                    } else {
                        personaSustituta = raiz.getArbolDerecho().buscarMenor();
                        raiz.setPersona(personaSustituta);
                        raiz.getArbolDerecho().eliminarAmigo(personaSustituta.getNombre());
                        eliminado = true;
                    }
                } else {
                    if (personaEliminar.compareToIgnoreCase(raiz.getPersona().getNombre()) <= 0) {
                        eliminado = raiz.getArbolIzquierdo().eliminarAmigo(personaEliminar);
                    } else {
                        eliminado = raiz.getArbolDerecho().eliminarAmigo(personaEliminar); 
                    }
                }
            }
        }

        return eliminado;
    }

    /**
     * Retorna la persona con el cumpleaños más cercano a partir de la fecha del sistema.  
     * 
     * @return Persona con el cumpleaños más cercano, 
     */
    public Persona avisarCumpleanos() {  
        Persona proximoCumpleanos = null;
        LocalDate fecha = LocalDate.now();
        int fechaActual;
        if(fecha.getDayOfMonth() < 10) {
            fechaActual = Integer.parseInt (Integer.toString(fecha.getMonth().getValue()) + "0" + Integer.toString(fecha.getDayOfMonth()));
        } else {
            fechaActual = Integer.parseInt (Integer.toString(fecha.getMonth().getValue()) + Integer.toString(fecha.getDayOfMonth()));
        }

        if(this.estarVacio() == false) {
            int fechaCumpleanos = raiz.getPersona().unirCumpleanos();

            if(this.serHoja() == false) {
                Persona cumpleanosIzquierdo = raiz.getArbolIzquierdo().avisarCumpleanos();
                Persona cumpleanosDerecho = raiz.getArbolDerecho().avisarCumpleanos();

                if(cumpleanosIzquierdo != null && cumpleanosDerecho != null){
                    int fechaCumpleanosIzquierdo = cumpleanosIzquierdo.unirCumpleanos();
                    int fechaCumpleanosDerecho = cumpleanosDerecho.unirCumpleanos();
                    if(fechaCumpleanosIzquierdo <= fechaCumpleanosDerecho) {
                        proximoCumpleanos = cumpleanosIzquierdo;
                    } else {
                        proximoCumpleanos = cumpleanosDerecho;
                    }
                } else {
                    if(cumpleanosIzquierdo != null){
                        proximoCumpleanos = cumpleanosIzquierdo;
                    } else {
                        if(cumpleanosDerecho != null) {
                            proximoCumpleanos = cumpleanosDerecho;
                        }
                    }
                }
            }

            if(fechaCumpleanos > fechaActual) {
                if(proximoCumpleanos != null){
                    if(fechaCumpleanos < proximoCumpleanos.unirCumpleanos()){
                        proximoCumpleanos = raiz.getPersona();
                    }
                } else {
                    proximoCumpleanos = raiz.getPersona();
                }
            }
        }
        return proximoCumpleanos;
    }
    
    /** 
     * Retorna la persona con el primer cumpleaño del año. 
     * 
     * @return Persona con el primera cumpleaños del año.
     */
    public Persona avisarPrimerCumpleanos() {  
        Persona primerCumpleanos = null; 
        if (this.estarVacio() == false) {
            if(this.serHoja() == false) {
                Persona cumpleanosIzquierdo = raiz.getArbolIzquierdo().avisarPrimerCumpleanos();
                Persona cumpleanosDerecho = raiz.getArbolDerecho().avisarPrimerCumpleanos();

                if(cumpleanosIzquierdo != null && cumpleanosDerecho != null){
                    int fechaCumpleanosIzquierdo = cumpleanosIzquierdo.unirCumpleanos();
                    int fechaCumpleanosDerecho = cumpleanosDerecho.unirCumpleanos();
                    if(fechaCumpleanosIzquierdo <= fechaCumpleanosDerecho) {
                        primerCumpleanos = cumpleanosIzquierdo;
                    } else {
                        primerCumpleanos = cumpleanosDerecho;
                    }
                } else {
                    if(cumpleanosIzquierdo != null){
                        primerCumpleanos = cumpleanosIzquierdo;
                    } else {
                        if(cumpleanosDerecho != null) {
                            primerCumpleanos = cumpleanosDerecho;
                        }
                    }
                }
            } 

            if(primerCumpleanos != null) {
                if(raiz.getPersona().unirCumpleanos() < primerCumpleanos.unirCumpleanos()) {
                    primerCumpleanos = raiz.getPersona();
                }
            } else {
                primerCumpleanos = raiz.getPersona();
            }
        }

        return primerCumpleanos;
    }

    /**
     * Para cada una de las personas pertenecientes al árbol, elimina la persona indicada del árbol de amigos.  Diseñado para 
     * ser llamado desde el árbol de amigos de la persona que se desea eliminar.   
     * 
     * @param personaEliminada Nombre de la persona que se va a eliminar. 
     */
    public void llamarEliminar(String personaEliminada){
        if(this.estarVacio() == false) {
            raiz.getPersona().getArbolAmigos().eliminarAmigo(personaEliminada);

            if(raiz.estarVacioIzquierdo() == false) {
                raiz.getArbolIzquierdo().llamarEliminar(personaEliminada);
            }

            if(raiz.estarVacioDerecho() == false) {
                raiz.getArbolDerecho().llamarEliminar(personaEliminada);
            }
        }
    }
}
