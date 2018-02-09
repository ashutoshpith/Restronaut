package Admin;

import java.sql.Connection;
import DbConnection.DbConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ashutosh
 */
public class adminLoginId {
    Connection con;
    public adminLoginId(){
        try {
            this.con=DbConn.getConnect();

        } catch (Exception e) {
            System.out.println(e);
        }
        if(this.con==null){
            System.exit(1);
        }
    }

    public boolean isDatabaseConnected(){
        return this.con!=null;
    }

    public boolean isLogin(String user,String password) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT * FROM A.LOGIN where u = ? and p = ?";
        try{
            Connection c=DbConn.getConnect();
            ps=c.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }
            return false;

        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }





}
