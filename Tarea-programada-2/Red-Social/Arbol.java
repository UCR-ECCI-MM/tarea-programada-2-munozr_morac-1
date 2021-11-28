import java.time.LocalDate;

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
        this.raiz = raiz;
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
            if(raiz.getArbolDerecho().estarVacio() == false || raiz.getArbolIzquierdo().estarVacio() == false ){
                resultado = false;
            }
        }
        return resultado;
    }

    public Persona buscarMenor(){
        Persona menor = null;

        if(raiz.getArbolIzquierdo().getRaiz() == null){
            menor = raiz.getPersona();
        }else {
            menor = raiz.getArbolIzquierdo().buscarMenor();
        }

        return  menor;
    }

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

    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public String toString() {
        String hilera = "";

        if (raiz != null) {
            hilera += raiz.getArbolIzquierdo().toString();
            hilera += "    " + raiz.getPersona().getNombre() + "\n";
            hilera += raiz.getArbolDerecho().toString();
        }

        return hilera;
    }

    public boolean eliminar(String personaEliminar){
        boolean eliminado = false;
        if (this.estarVacio() != true){
            if(this.serHoja() == true && personaEliminar.equals(raiz.getPersona().getNombre())){
                this.setRaiz(null);
                eliminado = true;
            } else {
                if(this.serHoja() == false && personaEliminar.equals(raiz.getPersona().getNombre())){
                    Persona personaSustituta = null; 
                    if(raiz.estarVacioIzquierdo() == false) {
                        personaSustituta = raiz.getArbolIzquierdo().buscarMayor();
                        raiz.setPersona(personaSustituta);
                        raiz.getArbolIzquierdo().eliminar(personaSustituta.getNombre());
                        eliminado = true;
                    } else {
                        personaSustituta = raiz.getArbolDerecho().buscarMenor();
                        raiz.setPersona(personaSustituta);
                        raiz.getArbolDerecho().eliminar(personaSustituta.getNombre());
                        eliminado = true;
                    }
                } else {
                    if (personaEliminar.compareToIgnoreCase(raiz.getPersona().getNombre()) <= 0) {
                        eliminado = raiz.getArbolIzquierdo().eliminar(personaEliminar);
                    } else {
                        eliminado = raiz.getArbolDerecho().eliminar(personaEliminar); 
                    }
                }
            }
        }

        return eliminado;
    }

    public Persona avisarCumpleanos() {  //Hacer un metodo en personas "unirCumpleanos" para reducir tamaño de codigo. 
        Persona proximoCumpleanos = null;
        LocalDate fecha = LocalDate.now();
        int fechaActual = Integer.parseInt (Integer.toString(fecha.getMonth().getValue()) + Integer.toString(fecha.getDayOfMonth()));
        int fechaCumpleanos = Integer.parseInt (Integer.toString(raiz.getPersona().getMes()) + Integer.toString(raiz.getPersona().getDia()));

        if(this.serHoja() == false) {
            Persona cumpleanosIzquierdo = raiz.getArbolIzquierdo().avisarCumpleanos();
            Persona cumpleanosDerecho = raiz.getArbolDerecho().avisarCumpleanos();

            if(cumpleanosIzquierdo != null && cumpleanosDerecho != null){
                int fechaCumpleanosIzquierdo = Integer.parseInt (Integer.toString(cumpleanosIzquierdo.getMes()) + Integer.toString(cumpleanosDerecho.getDia()));
                int fechaCumpleanosDerecho = Integer.parseInt (Integer.toString(cumpleanosDerecho.getMes()) + Integer.toString(cumpleanosIzquierdo.getDia()));
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
                if(fechaCumpleanos < Integer.parseInt (Integer.toString(proximoCumpleanos.getMes()) + Integer.toString(proximoCumpleanos.getDia()))){
                    proximoCumpleanos = raiz.getPersona();
                }
            } else {
                proximoCumpleanos = raiz.getPersona();
            }
        }
        return proximoCumpleanos;
    }
}
