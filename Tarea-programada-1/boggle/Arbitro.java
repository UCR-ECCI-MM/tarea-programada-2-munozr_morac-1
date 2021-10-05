
/**
 * Se encarga de considerar las reglas del juego y evaluar la partida. 
 *
 * @author Kyara Muñoz
 * @author Pablo Mora
 */
public class Arbitro
{
    //Atributos de la clase
    private final String TITULO_VENTANA = "Boggle";
    private final String NOMBRE_IMAGEN = "dado.png";
    private final String MENSAJE = "Escoja una opción:"; 
    private final String[] OPCIONES = {"Realizar turno","Revolver tablero", "Terminar partida"};
    private final String ERROR_MENU = "Opción inválida, vuelva a escoger.";
    private Tablero tablero;
    private Interfaz interfaz;
    private int[] posicionesUsadas;
    private int contadorPosicionesUsadas;

    /**
     * Contructor de la clase Arbitro.
     * @param tablero El objeto de la clase tablero.  
     */
    public Arbitro(Tablero tablero)
    {
        this.tablero = tablero;
        interfaz = new Interfaz(TITULO_VENTANA, NOMBRE_IMAGEN);
        posicionesUsadas = new int[32]; // 16 posiciones máximas *2 números cada posición
    }

    /**
     * Método que muestra el menú del juego. 
     */
    public void jugar() {
        int opcionMenu = 0;
        String registroPalabras = "";
        while (opcionMenu != 2) {
            opcionMenu = interfaz.pedirOpcion(OPCIONES, MENSAJE);
            String hileraPosicionesLimpia;

            switch (opcionMenu) {
                case 0:
                    String hileraPosiciones = interfaz.pedirHilera(tablero.toString() + "\n\n\nDigite las posiciones de las letras que desea evaluar:");

                    if (esHileraNula(hileraPosiciones) == true) {
                        interfaz.decirMensaje("No digitó ninguna posición, presionó la X o Cancelar");
                    } else {
                        if (esHileraVacia(hileraPosiciones) == true) {
                            interfaz.decirMensaje("No digitó ninguna posición");
                        } else {
                            hileraPosicionesLimpia = limpiarHilera(hileraPosiciones);
                            if (hileraPosicionesLimpia == null) {
                                interfaz.decirMensaje("Digitó una posición inválida. Debe digitar posiciones entre 0 y 3");
                            } else {
                                if (esLargoInvalido(hileraPosicionesLimpia) == true) {
                                    interfaz.decirMensaje("La cantidad de posiciones es inválida. Debe digitar una cantidad de posiciones par, entre 4 y 16");
                                } else {
                                    if (esLargoInvalido(hileraPosicionesLimpia) == true) { //Se está llamando dos veces. 
                                        interfaz.decirMensaje("La cantidad de posiciones es inválida. Debe digitar una cantidad de posiciones par, entre 4 y 16");
                                    } else {
                                        int[] vectorPosiciones = convertirHileraAVector(hileraPosicionesLimpia);
                                        if(revisarPosicionesEnPalabra(vectorPosiciones) == false) {
                                            interfaz.decirMensaje("Su palabra presenta posiciones repetidas ");
                                        } else {
                                            if (revisarPosicionesUsadas(vectorPosiciones) == false) {
                                                interfaz.decirMensaje("Una de las posiciones digitadas ya ha sido utilizada en otra palabra");
                                            } else {
                                                if (evaluarPosicionesContinuas(vectorPosiciones) == false) {
                                                    interfaz.decirMensaje("Las posiciones digitadas no están continuas");
                                                } else {
                                                    agregarPosicionesUsadas(vectorPosiciones);
                                                    String palabra = tablero.obtenerPalabra(vectorPosiciones);
                                                    int puntajePalabra = tablero.obtenerPuntajePalabra(palabra);
                                                    
                                                    registroPalabras = registroPalabras + palabra + ":" + " " + 
                                                        puntajePalabra + " pts" + "\n";
                                                        
                                                    interfaz.decirMensaje(tablero.toString() + "\nLa palabra " +
                                                        palabra + " es correcta.\n\n" + 
                                                        "\nPalabras: \n " + registroPalabras + 
                                                        "\nPuntaje total: " + tablero.getPuntajeTotalJuego(puntajePalabra));
                                                } 
                                            } 
                                        } 
                                    } 
                                }                            
                            }
                        }
                    }
                    break;
                case 1:
                    tablero.agitarTablero();
                    interfaz.decirMensaje(tablero.toString() + "\n\n\nEl tablero se revolvió correctamente.");
                    break;
                case 2:
                    interfaz.decirMensaje("La partida ha finalizado. ");
                    break;
                default:
                    interfaz.decirMensaje(ERROR_MENU);
            }
        }
    }

    /**
     * Evalúa si el usuario digita algún caracter.
     * 
     * @param hileraPosiciones la hilera que digitó el usuario
     * @return true Si el usuario no digita nada o presiona X o Cancelar.
     * @return false Si el usuario digitó algún caracter.
     */
    public boolean esHileraNula(String hileraPosiciones) {
        if (hileraPosiciones == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Evalúa si el usuario digita una posición de un dado del tablero. 
     * 
     * @param hileraPosiciones la hilera que digitó el usuario.
     * @return true si el usuario no digita ninguna posición pero sí una hilera vacía.
     * @return false si el usuario digitó alguna posición de un dado del tablero.
     */
    public boolean esHileraVacia(String hileraPosiciones) {
        if (hileraPosiciones.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Evalúa si cada posición de la hilera contiene caracteres válidos. Si encuentra alguno inválido, lo ignora y pasa a la 
     * siguiente posición de la hilera.
     * 
     * @param hileraPosiciones la hilera que digitó el usuario.
     * @return hileraLimpia la hilera completa con los caracteres válidos a evaluar.
     */
    public String limpiarHilera(String hileraPosiciones) {
        boolean valido = true;
        String hileraLimpia = "";
        int[] arregloPosiciones;
        char caracterActual;
        int indice = 0;

        while (indice < hileraPosiciones.length() && valido == true) {
            caracterActual = hileraPosiciones.charAt(indice);            

            if (caracterActual == ' ' || caracterActual == ';' || caracterActual == ',' || caracterActual == '(' || caracterActual == ')') {
                indice++;
            } else {
                if(caracterActual == '0' || caracterActual == '1' || caracterActual == '2' || caracterActual == '3') {
                    hileraLimpia = hileraLimpia + caracterActual;
                    indice++;
                } else {
                    valido = false; 
                }
            }
        }

        if (valido == false){
            hileraLimpia = null;
        }
        return hileraLimpia;

    }

    /**
     * Método.
     * 
     * @param hileraPosiciones la hilera que digitó el usuario.
     * @return true
     * @return false
     */
    public boolean esLargoInvalido(String hileraPosiciones) {
        if (hileraPosiciones.length() < 4 || hileraPosiciones.length() > 16 || hileraPosiciones.length() % 2 != 0) {
            int asd = hileraPosiciones.length();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método.
     * 
     * @param hileraPosiciones la hilera que digitó el usuario.
     * @return vectorPosiciones
     */
    public int[] convertirHileraAVector(String hileraPosiciones) {
        char caracterActual;
        int[] vectorPosiciones = new int[hileraPosiciones.length()];

        for(int indice = 0; indice < hileraPosiciones.length(); indice++){
            caracterActual = hileraPosiciones.charAt(indice);
            vectorPosiciones[indice] = caracterActual - 48; //pasa el caracter al valor entero, por ejemplo: el valor ascii del caracter 1 es 49, menos 48 queda el número 1
        }

        return vectorPosiciones;
    }

    /**
     * Método.
     * 
     * @param vectorPosiciones
     * @return valido
     */
    public boolean revisarPosicionesEnPalabra(int [] vectorPosiciones) {
        boolean valido = true;  

        for (int indice = 0; (indice < vectorPosiciones.length -2) && valido == true; indice += 2) { // Avanza cada dos números porque una posición tiene dos números
            for (int indice2 = indice + 2; indice2 < vectorPosiciones.length && valido == true; indice2 += 2) {
                if (vectorPosiciones[indice] == vectorPosiciones[indice2] && vectorPosiciones[indice + 1] == vectorPosiciones[indice2 + 1]) {
                    valido = false; 
                }
            }
        }
        
        return valido;
    }

    /**
     * Método.
     * 
     * @param vectorPosiciones
     * @return valido
     */
    public boolean revisarPosicionesUsadas(int[] vectorPosiciones) {
        boolean valido = true;

        for (int indice = 0; indice < vectorPosiciones.length && valido == true; indice += 2) { // Avanza cada dos números porque una posición tiene dos números
            for (int indice2 = 0; indice2 < contadorPosicionesUsadas && valido == true; indice2 += 2) {
                if (vectorPosiciones[indice] == posicionesUsadas[indice2] && vectorPosiciones[indice + 1] == posicionesUsadas[indice2 + 1]) {
                    valido = false; 
                }
            }
        }
        return valido;
    }

    /**
     * Método.
     * 
     * @param vectorPosiciones
     */
    public void agregarPosicionesUsadas (int[] vectorPosiciones) {
        for (int indice = 0; indice < vectorPosiciones.length; indice++) {
            posicionesUsadas[contadorPosicionesUsadas] = vectorPosiciones[indice];
            contadorPosicionesUsadas ++; 
        }
    }
    
    /**
     * Evalúa si las posiciones ingresadas por el usuario están continuas vertical, horizontal o diagonalmente.
     * @param vectorPosiciones vector de enteros con las posiciones ingresadas por el usuario.
     * @return hilera con la palabra formada por las posiciones ingresadas por el usuario si las posiciones están continuas.
     * En caso contrario genera un mensaje de error.
     */
    public boolean evaluarPosicionesContinuas(int[] vectorPosiciones) { 
        boolean vectorValido = true;
        int indice = 0;
        int filaMayor = 3;
        while (indice < (vectorPosiciones.length-2) && vectorValido == true) {
            int fila = vectorPosiciones[indice];
            int columna = vectorPosiciones[indice + 1];
            int filaSiguiente = vectorPosiciones[indice + 2];
            int columnaSiguiente = vectorPosiciones[indice + 3];

            if (fila == 0) {
                if (columna==0){
                    if(!(filaSiguiente <= fila +1 && columnaSiguiente <= columna +1) ){  
                        vectorValido = false; 
                        // Funciona porque previamente se verifico que los valores estuvieran entre 0 y la longitud de la matriz.
                        // Por lo estamos seguros de que no va a haber valores negativos. 
                    } else {
                        if (columna == filaMayor) {
                            if (!(filaSiguiente <= fila+1 && columnaSiguiente >= columna-1)){
                                vectorValido = false; 
                            }
                        } else  {
                            if(!((filaSiguiente >= fila-1 && filaSiguiente <= fila+1) && columnaSiguiente <= columna +1)) {
                                vectorValido = false;
                            }
                        }
                    }
                } 
            }else { 
                if (fila == filaMayor) {
                    if(columna==0) {
                        if(!(filaSiguiente >= fila-1 && columnaSiguiente <= columna +1)){
                            vectorValido = false;
                        }
                    } else {
                        if (columna == filaMayor){
                            if(!(filaSiguiente >= fila-1 && columnaSiguiente >= columna-1)){
                                vectorValido = false; 
                            }
                        } else {
                            if(!((filaSiguiente >= fila-1 && filaSiguiente <= fila+1) && columnaSiguiente >= columna -1)) {
                                vectorValido = false;
                            } 
                        }
                    }
                } else {
                    if (columna == 0) {
                        if(!((filaSiguiente >= fila -1 && filaSiguiente <= fila +1) && columnaSiguiente <= columna +1)){
                            vectorValido = false;
                        }
                    } else {
                        if (columna == filaMayor) {
                            if(!((filaSiguiente >= fila -1 && filaSiguiente <= fila +1) && columnaSiguiente >= columna -1)){
                                vectorValido = false;
                            }
                        } else {
                            if(!((filaSiguiente >= fila -1 && filaSiguiente <= fila +1) && (columnaSiguiente >= columna -1 &&  columnaSiguiente <= columna +1))) {
                                vectorValido = false;
                            }
                        }
                    }
                }
            }
            indice= indice + 2;
        }

        return vectorValido;
    }
}
