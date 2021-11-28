import javax.swing.JOptionPane;
/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControladorTemporal
{
    private JOptionPane interfaz;
    private Lista lista;
    
    /**
     * Constructor de la clase Controlador.
     */
    public ControladorTemporal() {
        interfaz = new JOptionPane();
        lista = new Lista();
    }

    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void iniciar() {
        
    }
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
