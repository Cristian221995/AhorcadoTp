package Utn.classes;

import java.sql.*;

public class Conectar {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static Connection conn = null;
    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "ahorcado";
    static String user = "root";
    static String pass = "";

    /**
     * Muestra todas las palabras cargadas en la base de datos
     * @param query
     */
    public static void mostrarPalabras(String query) {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbName, user, pass);
            PreparedStatement stt = null;
            stt = conn.prepareStatement(query);
            ResultSet rs = stt.executeQuery();
            System.out.println("-----PALABRAS:-----");
            while (rs.next()) {
                System.out.println(rs.getString("palabra"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trae una palabra de la base de datos segun un indice
     * @param indice
     * @return
     */
    public static String getPalabra(int indice){
        String word = null;
        try{
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from palabras where id_palabra = "+indice);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                word = rs.getString("palabra");
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return word;
    }

    /**
     * Trae la cantidad de palabras cargadas en la base de datos par luego hacer un rand de ese numero y traer una palabra random
     * @return
     */
    public static int getCantidadPalabras(){
        int cantidad = 0;
        try {
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select count(*) as cantidad from palabras");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cantidad = rs.getInt("cantidad");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return cantidad;
    }

    /**
     * Carga un ganador en la base de datos
     * @param nombre
     * @param palabra
     */
    public static void setGanador(String nombre, String palabra){
        try {
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            int id = getId(palabra);
            String query = "insert into ganadores (nombre, fecha, id_palabra) values ('"+nombre+"',now(),"+id+");";
            Statement st = null;
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna el id de una palabra, que luego se usa para guardar en la tabla ganadores
     * @param palabraBuscada
     * @return
     */
    private static int getId(String palabraBuscada){
        int id = 0;
        try {
            conn = DriverManager.getConnection(url + dbName, user, pass);
            Class.forName(driver);
            PreparedStatement ps = null;
            ps = conn.prepareStatement("select * from palabras where palabra = '"+palabraBuscada+"';");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("id_palabra");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return id;
    }

}
