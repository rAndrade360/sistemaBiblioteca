package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author renan
 */
public class Database {
  
   
    
    public static Connection connect() throws ClassNotFoundException{
        try {
        String user = "postgres";
        String password = "postgres";
        String database = "biblioteca";
        String url = "jdbc:postgresql://localhost:5432/"+database;
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
            return connect;
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + ex);
        }
        return null;
      
    }
    
    
}
