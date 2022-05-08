/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class Conexion {

    private static final String JDBC_url = "jdbc:postgresql://localhost:5432/pruebas_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_user = "postgres";
    private static final String JDBC_pass = "asd.456";

   /* public static DataSource getDataSource(){
        
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_url);
        ds.setUsername(JDBC_user);
        ds.setPassword(JDBC_pass);
        //tamaño inicial del pool
        ds.setInitialSize(5);
        
        return ds;
        
    }*/
    
    
    public static Connection conectar() throws SQLException, ClassNotFoundException {

        return DriverManager.getConnection(JDBC_url, JDBC_user, JDBC_pass);
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
