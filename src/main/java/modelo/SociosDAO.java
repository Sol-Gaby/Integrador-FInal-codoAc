package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SociosDAO 
{

    Connection conexion;

    public SociosDAO() throws ClassNotFoundException
    {
        Conexion conect = new Conexion();
        conexion = conect.getConnection();

    }//----------------------------- LISTADO DE LOS SOCIO ---------------------------------//

    public List<Socios> ListarSocios() 
    {
        
        // siempre poner el mismo nombre
        PreparedStatement prepSt;
        // me devuelve los datos y los guarde en resulset
        ResultSet resultS;
        //lista para socios que necesitamos
        List<Socios> lista = new ArrayList<>();

        // siempre que querramos invocar un comando que ejecute una accion sobre una base de datos, necesitamos un try cach
        try {
            prepSt = conexion.prepareStatement("select * from socios");
            resultS = prepSt.executeQuery(); // aca ponemos la variable que almacena todo lo de la consulta anterior

            while (resultS.next()) 
            {
                int id = resultS.getInt("idSocio");
                String nombre = resultS.getString("nombre");
                String apellido = resultS.getString("apellido");
                String direccion = resultS.getString("direccion");
                String localidad = resultS.getString("localidad");
                LocalDate fechaNac = resultS.getDate("fechaNac").toLocalDate();
                String telefono = resultS.getString("telefono");
                String email = resultS.getString("email");
                boolean activo = resultS.getBoolean("activo");

                Socios soc = new 
                Socios(id, nombre, apellido, direccion, localidad, fechaNac, email, telefono, activo);
                        lista.add(soc);
            }

        } 
        catch (SQLException e) 
        {

            System.out.println(e);
        }

        return lista;
    }

    //----------------------------- METODO PARA MOSTRAR UN SOCIO -----------------------------------//
    
    public Socios MostrarSocio(int _id) 
    {
        PreparedStatement prepSt;
        ResultSet resultS;
        Socios soc1 = null;

        // siempre que querramos invocar un comando que ejecute una accion sobre una base de datos, necesitamos un try cach
        try 
        {
            prepSt = conexion.prepareStatement("select * from socios where idSocio=?"); //el preparedSt(consulta precompilada), nos permite que al momento de la ejecucion se reemplase el signo de pregunta por un dato (que le tenemos que sumistrar)
            prepSt.setInt(1, _id); // necesita dos parametros, la ubicacion y el dato en si (el argumento que trae el metodo y eso es lo que va a reemplazar en el signo de pregunta anterior)
            resultS = prepSt.executeQuery(); // aca ponemos la variable que almacena todo lo de la consulta anterior

            while (resultS.next()) 
            {
                int id = resultS.getInt("idSocio");
                String nombre = resultS.getString("nombre");
                String apellido = resultS.getString("apellido");
                String direccion = resultS.getString("direccion");
                String localidad = resultS.getString("localidad");
                LocalDate fechaNac = resultS.getDate("fechaNac").toLocalDate();
                String telefono = resultS.getString("telefono");
                String email = resultS.getString("email");
                boolean activo = resultS.getBoolean("activo");

                soc1 = new 
                Socios(id, nombre, apellido, direccion, localidad, fechaNac, email, telefono, activo);
            }
            return soc1;

        } 
            catch (SQLException e) 
        {

            System.out.println(e);
            return null;
        }

    }

    //----------------------------- METODO PARA INSERTAR UN SOCIO -----------------------------------//
    
    //soc1 es un nombre puede ser cualquier cosa
    public boolean InsertarSocios(Socios soc) 
    {
        PreparedStatement prepSt;

        try 
        {
            prepSt = conexion.prepareStatement("insert into socios (nombre,apellido,direccion,localidad,fechaNac,email,telefono,activo) value (?,?,?,?,?,?,?,?)");
            prepSt.setString(1, soc.getNombre());
            prepSt.setString(2, soc.getApellido());
            prepSt.setString(3, soc.getDireccion());
            prepSt.setString(4, soc.getLocalidad());
            prepSt.setObject(5, soc.getFechaNac());
            prepSt.setString(6, soc.getEmail());
            prepSt.setString(7, soc.getTelefono());
            prepSt.setBoolean(8, true);
            prepSt.execute();

            return true;

        } 
        catch (SQLException e) 
        {

            System.out.println(e);
            return false;
        }

    }

    //----------------------------- METODO PARA ACTUALIZAR UN SOCIO -----------------------------------//
    public boolean ActualizarSocios(Socios soc) {

        PreparedStatement prepSt;

        try 
        {
            prepSt = conexion.prepareStatement("update socios set nombre=?,apellido=?,direccion=?,localidad=?,fechaNac=?,email=?,telefono=?,activo=?");
            prepSt.setString(1, soc.getNombre());
            prepSt.setString(2, soc.getApellido());
            prepSt.setString(3, soc.getDireccion());
            prepSt.setString(4, soc.getLocalidad());
            prepSt.setObject(5, soc.getFechaNac());
            prepSt.setString(6, soc.getEmail());
            prepSt.setString(7, soc.getTelefono());
            prepSt.setBoolean(8, soc.isActivo());
            prepSt.setInt(9, soc.getIdSocio());
            prepSt.execute();

            return true;

        } 
        catch (SQLException e) 
        {

            System.out.println(e);
            
            return false;
        }

    }

    //---------------------- METODO PARA ELIMINAR LOS SOCIOS ------------------------------//
    public boolean EliminarSocios(int _id) {
        
        PreparedStatement prepSt;

        try 
        {            
            prepSt = conexion.prepareStatement("delect * from socios where idSocio=?");
            prepSt.setInt(1, _id);
            prepSt.execute();            

            return true;

        } 
        catch (SQLException e) 
        {
            System.out.println(e);
            
            return false;
        }

    }

}
/**
 *
 * @author Sol
 */
