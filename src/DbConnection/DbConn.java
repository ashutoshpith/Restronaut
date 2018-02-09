package DbConnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ashutosh
 */
public class DbConn {

    public static Connection getConnect(){
        String user="root";
        String pass="root";
        String url="jdbc:mysql://localhost:3306/a";

        try{


            return DriverManager.getConnection(url,user,pass);

        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }


}
