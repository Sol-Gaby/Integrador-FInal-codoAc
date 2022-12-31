package controlador;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Socios;
import modelo.SociosDAO;

@WebServlet (name = "SociosController",urlPatterns = {"/SociosController"})
public class SociosController extends HttpServlet 
{
    
    public SociosController()
    {
        super(); //instruccion super, con este hago un super constructor, osea un coinstructor global
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
       SociosDAO sociosDAO=null;
        
            try
            {
            sociosDAO=new SociosDAO();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }      
          
        String accion;
        // dispacher, es una interaz que ayuda al intercambio de informacion entre el servlet y el html
        RequestDispatcher dispatcher=null; 
        //"accion" es una variable la cual pasa por la url para capturar/almacenar las acciones que vamos a hacer (modificar, nuevo, insertar, etc)
        accion=request.getParameter("accion");
        // el if va a capturar dos posibles casos que se nos van a presentar              
        if (accion==null||accion.isEmpty())
        { 
            dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
        }
            else if (accion.equals("modificar"))
            {
                dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");
            }
            else if (accion.equals("actualizar"))
            {
                int id = Integer.parseInt(request.getParameter("idSocio"));
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                String direccion=request.getParameter("direccion");
                String localidad=request.getParameter("localidad");
                LocalDate fechaNac=LocalDate.parse(request.getParameter("fechaNac"));
                String email=request.getParameter("email");
                String telefono=request.getParameter("telefono");
            
                 Socios soc=new Socios(id, nombre, apellido, direccion, localidad, fechaNac, email, telefono, true);
                 sociosDAO.ActualizarSocios(soc);
                dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
            }
            else if (accion.equals("eliminar"))
            {
                int id = Integer.parseInt(request.getParameter("id"));
                sociosDAO.EliminarSocios(id);
                dispatcher=request.getRequestDispatcher("vistas/socios.jsp");           
            }
            else if (accion.equals("nuevo"))
            {
                dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");
            }
            else if (accion.equals("insert"))
            {
                String nombre=request.getParameter("nombre");
                String apellido=request.getParameter("apellido");
                String direccion=request.getParameter("direccion");
                String localidad=request.getParameter("localidad");
                LocalDate fechaNac=LocalDate.parse(request.getParameter("fechaNac"));
                String email=request.getParameter("email");
                String telefono=request.getParameter("telefono");
            
                Socios soc=new Socios(0, nombre, apellido, direccion, localidad, fechaNac, email, telefono, true);
                //el 0 es un numero aleatorio que le damos ya que al id no se lo insertamos nosotros, eso solo paera rellenar
                sociosDAO.insertSocios(soc);
                dispatcher=request.getRequestDispatcher("vistas/socios.jsp");
                //me recarga la vistasi la insercion se hizo bien, igual pasa con los dispatcher anteriores
            }            
         
            dispatcher.forward(request, response); 
            //a cada requerimiento que me haga la url le paso una respuesta
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        doGet(request, response);
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}

/**
 *
 * @author Sol
 */
