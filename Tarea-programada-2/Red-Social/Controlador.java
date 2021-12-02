import java.io.File; //
import java.io.FileWriter; //
import java.io.FileReader; //
import java.io.BufferedReader; //
import java.io.IOException; //
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Write a description of class Controlador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controlador
{
    private Interfaz interfaz;
    private Lista lista;
    private File archivoDatos; //
    private String nombreArchivo = "archivoDefaultRedSocial.txt";

    private final String[] OPCIONES = {"Agregar persona", "Registrar amistad",  "Borrar amistad", "Eliminar persona","Mostrar Amigos", "Cumpleaños más cercano"};
    private final String MENSAJE = "Seleccione la acción que desea realizar: "; 
    private final String GUARDADO = "“La información se ha guardado de forma exitosa.” ";

    /**
     * Constructor de la clase Controlador.
     */
    public Controlador() {
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
        archivoDatos = this.abrirArchivo();
        
        if (archivoDatos != null) {
            this.leerArchivo();
        } else {
            interfaz.mostrarMensaje("Archivo no seleccionado");
        }
        
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
                    if (archivoDatos == null) {
                        archivoDatos = new File(nombreArchivo);
                    }
                    this.escribirArchivo();
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
        Persona personaCumpleanos = null;
        String nombrePersona = interfaz.pedirHilera ("Introduzca el nombre de la persona para la cual desea saber el amigo con la fecha más cercana.");
        if(nombrePersona != null) {
            personaBuscada = lista.buscarPersona(nombrePersona);
            if(personaBuscada != null) {
                personaCumpleanos: personaBuscada.getArbolAmigos().avisarCumpleanos();
                interfaz.mostrarMensaje("La persona con el cumpleaños más cercano es " + personaCumpleanos.getNombre() + "\n Mes de Cumpleaños: " + 
                                        personaCumpleanos.getMes() + "\n Día Cumpleaños: " + personaCumpleanos.getDia());
            } else {
                interfaz.mostrarMensaje("Error: La persona indicada no se encuentra registrada en el sistema.");
            }
        }
    }
    
    public File abrirArchivo() {
        JFileChooser ventana = new JFileChooser(".");
        ventana.setDialogTitle("Seleccione el archivo de datos de entrada");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
        ventana.setFileFilter(filtro);
        ventana.showOpenDialog(null);
        File archivo = ventana.getSelectedFile();
        return archivo;
    }

    public void leerArchivo() { 
        BufferedReader lector;
        try {
            lector = new BufferedReader(new FileReader(archivoDatos));
            String hileraDia = "";
            String hileraMes = "";
            String nombreAmigo = "";
            int dia = 0;
            int mes = 0;
            Persona persona = null;
            Persona amigo = null;
            String nombre = lector.readLine();
            
            while (nombre != null) {
                hileraDia = lector.readLine();
                hileraMes = lector.readLine();
                dia = Integer.parseInt(hileraDia);
                mes = Integer.parseInt(hileraMes);
                persona = new Persona(nombre, dia, mes);
                lista.agregarPersona(persona);
                nombreAmigo = lector.readLine();
                
                while (nombreAmigo != null && nombreAmigo.equals("fin") == false) {
                    nombreAmigo = lector.readLine();
                }
                
                nombre = lector.readLine();
            }

            lector.close();
            
            
            lector = new BufferedReader(new FileReader(archivoDatos));
            nombre = lector.readLine();
            
            while (nombre != null) {
                hileraDia = lector.readLine();
                hileraMes = lector.readLine();
                persona = lista.buscarPersona(nombre);
                nombreAmigo = lector.readLine();
                
                while (nombreAmigo != null && nombreAmigo.equals("fin") == false) {
                    amigo = lista.buscarPersona(nombreAmigo);
                    persona.agregarAmigo(amigo);
                    nombreAmigo = lector.readLine();
                }
                
                nombre = lector.readLine();
            }

            lector.close();
            
            System.out.println(lista.toString());
        } catch (IOException error) {
            interfaz.mostrarMensaje("Error en la lectura de la base de datos.");
        }
    }

    public void escribirArchivo(){
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(archivoDatos);
            escritor.write(lista.toStringArchivo());
            escritor.close();
        } catch (IOException error) {
            System.out.println("Error en la escritura del archivo");
        }
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
