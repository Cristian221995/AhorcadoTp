package Utn.classes;

import java.util.ArrayList;
import java.util.List;

public final class Juego {
    private static List<String> palabraSeparada;
    private static boolean ejecucion = true;
    private static boolean ganador = true;

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

    public static int jugar(String palabra, String letra){
        if (palabraSeparada == null){
            palabraSeparada = separarPalabra(palabra);
        }

        if(palabraSeparada.contains(letra)){
            palabraSeparada.remove(letra);

            if (palabraSeparada.isEmpty()){
                ganador = false;
                return 2;
            }
            return 1;
        }else {
            return 0;
        }
    }

    public static List separarPalabra(String palabra){
        List<String> palabraSeparada = new ArrayList<>();

        for (int i = 0; i < palabra.length(); i++){
            String letra = String.valueOf(palabra.charAt(i));
            if(!palabraSeparada.contains(letra)){
                palabraSeparada.add(letra);
            }
        }
        return palabraSeparada;
    }
}
