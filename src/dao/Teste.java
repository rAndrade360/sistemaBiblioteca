package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author renan
 */
public class Teste{
  
   
    
    public static Connection connect() throws ClassNotFoundException{
        try {
        String user = "ehskmnxg";
        String password = "6LaeqEe4PfrbDy0vvRfUtM-3SzHmAncm";
        String database = "ehskmnxg";
        String url = "jdbc:postgresql://satao.db.elephantsql.com:5432/"+database;
            Class.forName("org.postgresql.Driver");
            Connection connect = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Conectado com sucesso!");
            return connect;
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! " + ex);
        }
        return null;
      
    }
    
    public static void main(String[] args) throws ClassNotFoundException{
        Connection conn = connect();
    }
    
    
}
