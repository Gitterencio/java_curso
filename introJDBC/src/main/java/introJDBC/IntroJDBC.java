

package introJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class IntroJDBC {

    public static void main(String[] args) {
        System.out.println("Hello World!");
       String url= "jdbc:mysql://localhost:3306/pruebas_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String user= "root";
       String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
            Connection conn =  DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM tabla_1");

            while(rs.next()){
                System.out.println(rs.getString(2)+" "+rs.getInt(3));
            }
        } catch (Exception e) {
        }
    }
}
