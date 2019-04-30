package Utn;

import Utn.classes.Conectar;
import Utn.classes.Juego;
import Utn.classes.Jugador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Jugador jugador = new Jugador("Cristian", 10);
        Jugador jugador2 = new Jugador("Mauri",10);
        Juego.getPalabraRandom();
        Juego.getArrayGanador();
        jugador.start();
        jugador2.start();
    }
}
