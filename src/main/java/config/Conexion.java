package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
 public String driver="com.mysql.jdbc.Driver";
    
    
    public Connection getConnection()
    {
        Connection conexion=null;
        
        try
        {
            Class.forName(driver);
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud22548","root","");
  
        }
        catch(ClassNotFoundException|SQLException e)
        {
            System.out.println(e);
        }       
        return conexion;
    }
    
//    este metodo main es solo para probar la base de datos y ver que funcione
            
    public static void main(String[] args) throws SQLException 
    {
        Connection conexion=null;
        Conexion con=new Conexion();
        conexion=con.getConnection();
        
        
        PreparedStatement ps;
        ResultSet rs;
        
        ps=conexion.prepareStatement("select * from socios");
        
        rs=ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("idSocio");
            String nom = rs.getString("nombre");
            String ape = rs.getString("apellido");
            String dire = rs.getString("direccion");
            String loc= rs.getString("localidad");
            String em = rs.getString("email");
            String tel = rs.getString("telefono");
            boolean estado = rs.getBoolean("activo");

            System.out.println("ID: "+id+", Nombre: "+nom+", Apellido: "+ape+", Direccion: "+dire+", Localidad: "+loc+", Email: "+em+", Telefono: "+tel+", Estado: "+estado);
        }

    }

}

/**
 *
 * @author Sol
 */
