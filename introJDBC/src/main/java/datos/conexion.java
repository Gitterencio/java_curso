
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    private static final String JDBC_url ="jdbc:mysql://localhost:3306/pruebas_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_user= "root";
    private static final String JDBC_pass="";
    
    public static Connection conectar() throws SQLException{
         
        return  DriverManager.getConnection(JDBC_url,JDBC_user,JDBC_pass);
    }
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement st) throws SQLException{
        st.close();
    }
    
    public static void close(PreparedStatement pst) throws SQLException{
        pst.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
