import javax.swing.JOptionPane;
/**
 * Write a description of class Interfaz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Interfaz extends JOptionPane
{
    
    
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
}
