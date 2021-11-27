import javax.swing.JOptionPane;
/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controlador
{
    private JOptionPane interfaz;
    private Lista lista;
    
    /**
     * Constructor de la clase Controlador.
     */
    public Controlador() {
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
        Persona p1 = new Persona("xa", 17, 05);
        Persona p2 = new Persona("lm", 17, 05);
        Persona p3 = new Persona("bt", 17, 05);
        Persona p4 = new Persona("aa", 17, 05);
        Persona p5 = new Persona("ef", 17, 05);
        lista.agregarPersona(p1);
        lista.agregarPersona(p2);
        lista.agregarPersona(p3);
        lista.agregarPersona(p4);
        lista.agregarPersona(p5);
        System.out.print(lista);
    }
    
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }
}
