import java.io.File; //
import java.io.FileReader; //
import java.io.BufferedReader; //
import java.io.IOException;//
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
    private Arbol arbol;
    private File archivoDatos; //
    private String nombreArchivo = "datosRedSocial.txt";

    private final String[] OPCIONES = {"Agregar persona", "Registrar amistad",  "Borrar amistad", "Eliminar persona","Mostrar Amigos", "Cumpleaños más cercano"};
    private final String MENSAJE = "Seleccione la acción que desea realizar: "; 
    private final String GUARDADO = "“La información se ha guardado de forma exitosa.” ";

    /**
     * Constructor de la clase Controlador.
     */
    public ControladorTemporal() {
        interfaz = new Interfaz("Red social");
        lista = new Lista();
        arbol = new Arbol();
        archivoDatos = null; //

    }
    /**
     * Descripción
     * 
     * @param
     * @return
     */
    public void iniciar() {
        archivoDatos = new File(nombreArchivo); //
        this.abrirBaseDatos();
        int opcionMenu = 0;
        while (opcionMenu != -1) {
            opcionMenu = interfaz.pedirOpcion(OPCIONES, MENSAJE);

            switch (opcionMenu) {
                case 0:
                    this.agregarPersona();
                    break;
                case 1:
                    this.registrarAmistad();
                    break;
                case 2:
                    this.borrarAmistad();
                    break;
                case 3:
                    this.eliminarPersona();
                    break;

                case 4:
                    this.mostrarListaAmigos();

                    break;
                case 5:
                    this.mostrarCumpleanosCercano();
                    break;

                default:
                    interfaz.mostrarMensaje(GUARDADO);

            }
        }
    }

    public void agregarPersona() { //Nada más pedir el nombre, dia y mes de la persona que se va a agregar

    }

    public void registrarAmistad() { // Aquí hay que solicitar el nombre de ambas personas

    }

    public void borrarAmistad(){  // Aquí hay que solicitar el nombre de ambas personas

    }

    public void eliminarPersona(){
        String personaEliminada = null;
        Persona personaBuscada = null;
        personaEliminada = interfaz.pedirHilera("Introduzca el nombre de la persona de que desea eliminar del sistema.  ");
        if(personaEliminada != null) {
            personaBuscada = lista.buscarPersona(personaEliminada);

            if(personaBuscada != null) {
                personaBuscada.getArbolAmigos().llamarEliminar(personaEliminada);
                lista.eliminarPersona(personaEliminada);
                interfaz.mostrarMensaje("La persona se ha eliminado exitosamente.");
            } else {
                interfaz.mostrarMensaje("Error: La persona indicada no se encuentra registrada en el sistema.");
            }
        }
    }

    public void mostrarListaAmigos(){

    }

    public void mostrarCumpleanosCercano(){
        Persona personaBuscada = null;
        String nombrePersona = interfaz.pedirHilera ("Introduzca el nombre de la persona para la cual desea saber el amigo con la fecha más cercana.");
        if(nombrePersona != null) {
            personaBuscada = lista.buscarPersona(nombrePersona);
            if(personaBuscada != null) {
                personaBuscada.getArbolAmigos().avisarCumpleanos();
            }
        }
        
    }
    public void abrirBaseDatos(){ // Todavia falta lo de pedir el nombre del archivo 
        BufferedReader lector;
        int contador = 0;
        String nombrePersona = "";
        int diaCumpleanos = 0;
        int mesCumpleanos = 0; 
        try {
            lector = new BufferedReader(new FileReader(archivoDatos));
            String renglon = lector.readLine();
            while(renglon != null ) {
                while((renglon.equals("fin") == false )){

                    if (contador == 0) {
                        nombrePersona = renglon;

                    } else {
                        if (contador == 1){
                            diaCumpleanos = Integer.parseInt(renglon);
                        } else {
                            if(contador == 2) {
                                mesCumpleanos = Integer.parseInt(renglon);
                            }
                        }
                    }
                    renglon = lector.readLine();
                    contador += 1 ; 
                }
                contador = 0;
                renglon = lector.readLine();
                lista.agregarPersona(new Persona (nombrePersona, diaCumpleanos, mesCumpleanos));

            }
            lector.close();
        }catch(IOException error) {
            interfaz.mostrarMensaje("Error en la lectura de la base de datos.");
        }        

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
