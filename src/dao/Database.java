package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author renan
 */
public class Database {
   String user = "postgres";
    String password = "postgres";
    String database = "biblioteca";
    String url = "jdbc:postgresql://localhost:5432/"+database;
   
    
    public Connection connecta() throws ClassNotFoundException{
        try {
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            return connect;
 
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Não foi possível conectar");
        }
        return null;
      
    }
    
    
}
