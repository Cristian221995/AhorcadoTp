package Utn.classes;

import java.util.ArrayList;
import java.util.List;

public final class Juego {
    static List<String> palabraSeparada;
    static List<String> arrayGanador;
    static String palabraBuscada;
    static boolean ejecucion = true;
    static boolean ganador = true;

    public static boolean getEjecucion() {
        return ejecucion;
    }

    public static void setEjecucion(boolean ejecucion) {
        Juego.ejecucion = ejecucion;
    }

    public static boolean getGanador() {
        return ganador;
    }

    public static void setGanador(boolean ganador) {
        Juego.ganador = ganador;
    }

    public static String getPalabraBuscada() {
        return palabraBuscada;
    }

    public static void setPalabraBuscada(String palabraBuscada) {
        Juego.palabraBuscada = palabraBuscada;
    }

    /**
     * Analiza si la letra generada por el jugador existe en la palabra traida de la base de datos, retorna 0 si la letra no existe en la palabra,
     * 1 si la letra exisre en la palabra, y 2 si el jugador gano
     * @param palabra
     * @param letra
     * @return
     */
    public static int jugar(String palabra, String letra){
        if (palabraSeparada == null){
            palabraSeparada = separarPalabra(palabra);
        }

        if(palabraSeparada.contains(letra)){
            for(int i = 0; i<palabraSeparada.size(); i++){
                if(palabraSeparada.get(i).equals(letra)){
                    arrayGanador.set(i,letra);
                }
            }

            if (palabraSeparada.equals(arrayGanador)){
                ganador = false;
                return 2;
            }
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * Genera una palabra random de la base de datos
     */
    public static void getPalabraRandom(){
        int indice = Conectar.getCantidadPalabras();
        palabraBuscada = Conectar.getPalabra((int) (Math.random() * indice) + 1);
    }

    /**
     * Toma el String de la palabra y lo convierte en un array, separandolo letra por letra
     * @param palabra
     * @return
     */
    public static List separarPalabra(String palabra){
        List<String> palabraSeparada = new ArrayList<>();

        for (int i = 0; i < palabra.length(); i++){
            String letra = String.valueOf(palabra.charAt(i));

            palabraSeparada.add(letra);

        }
        return palabraSeparada;
    }

    /**
     * Genera un array con los espacios equivalentes a las letras de la palabra traida de la base de datos
     */
    public static void getArrayGanador(){
        arrayGanador = new ArrayList<>();

        for(int i = 0; i < palabraBuscada.length(); i ++ ) {
            arrayGanador.add(" _ ");
        }
    }
}
