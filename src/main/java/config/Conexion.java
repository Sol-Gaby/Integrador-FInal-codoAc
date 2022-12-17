
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion 
{
    
    public String driver = "com.mysql.jdbc.Driver";
    
    public Connection getConnection()
    {
        Connection conexion = null;
        
        try 
        {
            Class.forName(driver);
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud22548", "root", "");
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            System.out.println(e);
        } 
        return conexion;
    }
    
    public static void main(String[] args) throws SQLException 
    {
        
        Connection conexion = null; // variable del tipo connectin
        Conexion conect = new Conexion(); //objeto que pertenece a la clase desarrollada arriba
        conexion = conect.getConnection(); //
        
        //un preparedstatment es una consulta sql pre-compilada, permite precompilar la consulta asi me mantiene asi y las consultas se vuelven mas rapidas
        // resultsert es un tipo de dato que guarda bloques de informacion provenientes de la consulta sql, como registros.
        PreparedStatement prepSt;
        ResultSet resultSet;
        
        prepSt = conexion.prepareStatement("select * from socios");
        
        resultSet = prepSt.executeQuery();
        
        while (resultSet.next()) 
        {
            int id = resultSet.getInt("idSocio");
            boolean estado = resultSet.getBoolean("activo");
            
            System.out.println("ID: " + id + ", Estado: " + estado+"." );
        }
                
    }
    
}

/**
 *
 * @author Sol
 */