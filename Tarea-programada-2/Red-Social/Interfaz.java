import javax.swing.JOptionPane;
/**
 * Esta clase se encarga de mostrar mensajes, pedir datos e interactuar con el usuario.
 *
 * @author Kyara Vannesa Muñoz Ramírez (C15380)
 * @author Jose Pablo Mora Cubillo (B75044)
 */
public class Interfaz extends JOptionPane
{
    private final String TITULO;

    /**
     * Constructor de la clase Interfaz. 
     */
    public Interfaz(String elTitulo)
    {
        TITULO = elTitulo;
    }
    
    /**  
     * Le pide al usuario una hilera y la retorna.
     * 
     * @param  mensaje el mensaje que se le desea mostrar al usuario.
     * @return la hilera introducida por el usuario. 
     */
    public String pedirHilera(String mensaje)
    {
        String hilera; 
        hilera = this.showInputDialog(null, mensaje);
        return hilera;
    }
    
    /**
     * Solicita un número entero al usuario.  
     *  
     * @param mensaje el mensaje que se le desea mostrar al usuario.
     * @return el número digitado por el usuario.
     */
    public int pedirNumeroEntero(String mensaje)
    {
        String hileraNumero = this.showInputDialog(null, mensaje);
        int numero = Integer.parseInt(hileraNumero);
        return numero;
    }
    
    /**
     * Muestra un mensaje al usuario.  
     *  
     * @param mensaje el mensaje que se le desea mostrar al usuario.
     */
    public void mostrarMensaje(String mensaje) 
    {
        this.showMessageDialog(null, mensaje);
    }
    
    /**
     * Le permite al usuario escoger entre varias opciones y retorna la opción escogida.  
     *  
     * @param opciones arreglo que contiene las opciones que se le va a mostrar al usuario.     
     * @param mensaje el mensaje que se le desea mostrar al usuario.
     * @return la opción escogida por el usuario.
     */
    public int pedirOpcion(String[] opciones, String mensaje)
    {
        int opcionSelecionada;
        opcionSelecionada = this.showOptionDialog(null, mensaje, TITULO, DEFAULT_OPTION, PLAIN_MESSAGE, null, opciones, null);
        return opcionSelecionada;
    }
}
