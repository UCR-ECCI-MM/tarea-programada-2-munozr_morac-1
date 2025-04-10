
/**
 * Esta clase representa una persona. 
 * 
 * @author Kyara Vannesa Muñoz Ramírez (C15380)
 * @author Jose Pablo Mora Cubillo (B75044)
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
     * Retorna el nombre de la persona.  
     * 
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

     /**
     * Sobrescribe el nombre de la persona.  
     * 
     * @param nombre Nuevo nombre de la persona. 
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el día de cumpleaños de cumpleaños de la persona.
     * 
     * @return Día de cumpleaños de la persona. 
     */

    public int getDia() {
        return dia;
    }

    /**
     * Sobrescribe el día de cumpleaños de la persona. 
     * 
     * @param dia Nuevo día de cumpleaños. 
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Retorna el mes de cumpleaños de la persona. 
     * 
     * @return Mes de cumpleaños de la persona. 
     */
    public int getMes() {
        return mes;
    }

    /**
     * Sobrescribe el mes de cumpleaños de la persona. 
     * 
     * @param mes Mes de cumpleaños. 
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Retorna el árbol de amigos de la persona. 
     * 
     * @return Árbol de amigos. 
     */
    public Arbol getArbolAmigos() {
        return arbolAmigos;
    }

    /**
     * Sobrescribe el árbol de amigos de la persona. 
     * 
     * @param arbolAmigos Nuevo árbol de amigos. 
     */
    public void setArbolAmigos(Arbol arbolAmigos) {
        this.arbolAmigos = arbolAmigos;
    }

    /**
     * Agrega un nuevo amigo al árbol de amigos.  
     * 
     * @param Nueva persona a agregar en el árbol de amigos.   
     */
    public void agregarAmigo(Persona nuevoAmigo) {
        arbolAmigos.agregarAmigo(nuevoAmigo);
    }
    
    /**
     * Verifica la existencia de una persona en el árbol de amigos.  
     *  
     * @return True si la persona se encuentra en el árbol de amigos, false en caso cotrario.  
     */
    public boolean verficarExistenciaAmigo(Persona nuevoAmigo) {
        return arbolAmigos.verificarExistencia(nuevoAmigo.getNombre());
    }
    
    /**
     * Elimina el amigo indicado del árbol de amigos.  
     * 
     * @return nombreAmigo Nombre del amigo a eliminar. 
     */
    public boolean eliminarAmigo(String nombreAmigo) {
        return arbolAmigos.eliminarAmigo(nombreAmigo);
    }

    /**
     * Retorna en una hilera el nombre de la persona, así como el mes y día de cumpleaños. 
     * 
     * @return String con el nombre de la persona, mes y día de cumpleaños. 
     */
    public String toString() {
        return nombre + ", " + dia + "/" + mes + "\n  Amigos:\n" + arbolAmigos.toString();
    }
    
    /**
     * Retorna en una hilera el nombre de la persona, mes de cumpleaños, día de cumpleaños y el nombre de los amigos en el árbol de amigos.  
     * 
     * @return String con nombre de la persona, mes de cumpleaños, día de cumpleaños y el nombre de los amigos.  
     */
    public String toStringArchivo() {
        return nombre + "\n" + dia + "\n" + mes + "\n" + arbolAmigos.toStringArchivo() + "fin";
    }

    /**
     * Convierte el mes y día de cumpleaños en un entero que respeta el orden de las fechas. Posteriormente se puede usar para comparar fechas.
     *  
     * @return Entero generado a partir de la unión del mes y día de cumpleaños. 
     */
    public int unirCumpleanos() {
        int cumpleanosUnido = 0;
        
        if (dia < 10) {
            cumpleanosUnido = Integer.parseInt (Integer.toString(mes) + "0" + Integer.toString(dia));
        } else {
            cumpleanosUnido = Integer.parseInt (Integer.toString(mes) + Integer.toString(dia));
        }   

        return cumpleanosUnido;
    }
}