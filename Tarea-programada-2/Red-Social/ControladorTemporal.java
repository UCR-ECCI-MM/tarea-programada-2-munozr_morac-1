//import javax.swing.JOptionPane;
/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ControladorTemporal
{
    private Interfaz interfaz;
    private Lista lista;
    private final String[] OPCIONES = {"Agregar persona", "Registrar amistad",  "Borrar amistad", "Eliminar persona","Mostrar Amigos", "Cumpleaños más cercano"};
    private final String MENSAJE = "Seleccione la acción que desea realizar: "; 
    private final String GUARDADO = "“La información se ha guardado de forma exitosa.” ";
    /**
     * Constructor de la clase Controlador.
     */
    public ControladorTemporal() {
        interfaz = new Interfaz("Red social");
        lista = new Lista();
        
        
        
                                            
                                
    }

    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void iniciar() {
        int opcionMenu = 0;
        
        while (opcionMenu != -1) {
            opcionMenu = interfaz.pedirOpcion(OPCIONES, MENSAJE);
            
            switch (opcionMenu) {
                case 0:
                    
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                
                case 4:
                    
                    break;
                case 5:
                    
                    break;
      
                default:
                    interfaz.mostrarMensaje(GUARDADO);
                    
            }
        }
    }
    
    public void agregarPersona() {
        
    }
    
    public void registrarAmistad() {
        
    }
    
    public void borrarAmistad(){
        
    }
    
    public void EliminarPersona(){
        
    }
    
    public void mostrarListaAmigos(){
        
    }
    
    public void mostrarCumpleanosCercano(){
        
    }
    
    public void abrirArchivo(){
        
    }
    
    public void guardarArchivo(){
        
    }
    
    
    
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public static void main(String[] args) {
        ControladorTemporal controlador = new ControladorTemporal();
        controlador.iniciar();
    }
}
