package Utn;

import Utn.classes.Conectar;
import Utn.classes.Jugador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Jugador jugador = new Jugador("Cristian", 20);
        Jugador jugador2 = new Jugador("Mauri",20);

        jugador.start();
        jugador2.start();
    }
}
