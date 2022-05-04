/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_url = "jdbc:mysql://localhost:3306/pruebas_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_user = "root";
    private static final String JDBC_pass = "";

    public static DataSource getDataSource(){
        
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_url);
        ds.setUsername(JDBC_user);
        ds.setPassword(JDBC_pass);
        //tamaño inicial del pool
        ds.setInitialSize(5);
        
        return ds;
        
    }
    
    
    public static Connection conectar() throws SQLException {

        return getDataSource().getConnection();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement st) throws SQLException {
        st.close();
    }

    public static void close(PreparedStatement pst) throws SQLException {
        pst.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
