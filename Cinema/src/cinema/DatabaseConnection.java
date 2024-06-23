/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinema;


import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Kheang
 */
public class DatabaseConnection {

    /**
     * @return the user
     */
    public static String getUser() {
        return username;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(String aUser) {
        username = aUser;
    }
    private static Connection dataCon;

    private static String username;
    public static Connection getDatacon() {
        return dataCon;
    }

    public static void setDatacon(Connection aDatacon) {
        dataCon = aDatacon;
    }
    public static void connectionDB(String ip, String dbname, String user, String password) throws Exception
    {
         Class.forName("com.mysql.cj.jdbc.Driver");
         setDatacon(dataCon= DriverManager.getConnection("jdbc:mysql://"+ip+"/"+dbname+"?allowPublicKeyRetrieval=true&useSSL=false",user,password));
         setUser(user);
    }
}
