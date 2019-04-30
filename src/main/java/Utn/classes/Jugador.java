package Utn.classes;

import java.util.ArrayList;
import java.util.List;

public class Jugador extends Thread {
    private String nombre;
    private Integer vidas;
    static List<String> letrasUsadas = new ArrayList<>();
    private static boolean permiso = true;

    public Jugador(String nombre, Integer vidas) {
        this.nombre = nombre;
        this.vidas = vidas;
    }

    public static List<String> getLetrasUsadas() {
        return letrasUsadas;
    }

    public static void setLetrasUsadas(List<String> letrasUsadas) {
        Jugador.letrasUsadas = letrasUsadas;
    }

    public static boolean getPermiso() {
        return permiso;
    }

    public static void setPermiso(boolean permiso) {
        Jugador.permiso = permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVidas() {

        return vidas;
    }

    public void setVidas(Integer vidas) {

        this.vidas = vidas;
    }

    /**
     * Genera una letra random
     * @return
     */
    public String getLetraRandom(){
        String array []= {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String letra = array[(int)(Math.random()*25)];
        return letra;
    }

    /**
     * Segun lo retornado por el metodo jugar() de la clase juego, lanza los print con el avance del juego
     */
    public synchronized void intentar(){
        if(!Juego.getEjecucion()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            Juego.setEjecucion(false);

            String letra = this.getLetraRandom();

            if(letrasUsadas.contains(letra)){
                while(letrasUsadas.contains(letra)){
                    letra = this.getLetraRandom();
                }
            }else{
                System.out.println("\n-------Palabra: " + Juego.getPalabraBuscada() + "-------");
                int resultado = Juego.jugar(Juego.getPalabraBuscada(), letra);
                if(resultado == 0){
                    System.out.println(this.getNombre() + " no acerto la letra " + letra);
                    this.vidas --;
                }else if(resultado == 1){
                    System.out.println(this.getNombre() + " acerto la letra " + letra);
                }else if(resultado == 2){
                    System.out.println(this.getNombre() + " acerto la letra " + letra + " y adivino la palabra, gano el juego!!");
                    this.vidas = 0;
                    Conectar.setGanador(this.nombre,Juego.getPalabraBuscada());
                }
                letrasUsadas.add(letra);
                System.out.println("Letras encontradas: " + Juego.arrayGanador);
                System.out.println("Letras usadas: " + letrasUsadas);
            }
            Juego.setEjecucion(true);

        }
        notifyAll();
    }

    @Override
    public void run() {

        while (vidas>0 && Juego.getGanador()){
            synchronized (this){
                this.intentar();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
