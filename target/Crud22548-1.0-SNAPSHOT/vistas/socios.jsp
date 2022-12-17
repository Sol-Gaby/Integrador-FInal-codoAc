<%-- 
    Document   : socios
    Created on : 15 dic. 2022, 00:56:59
    Author     : Sol
--%>

<%@page import="modelo.SociosDAO"%>
<%@page import="modelo.Socios"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Socios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only copiado desde bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper copiado desde bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <!-- script para fontawersome -->
        <script src="https://kit.fontawesome.com/d3abc30a8e.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Listado de Socios del Gym</h1>

        <div class="container">
            <div class="row">
                <a class="btn btn-primary col-4 m-4"> Agregar socio </a>
                <table class="table table-primary">

                    <!-- --------- ENCABEZADOS DE LA TABLA ---------  -->
                    <thead>                        
                    <th>Id</th> <!-- encabezado de ID SOCIO -->
                    <th>Nombre</th> <!-- encabezado de NOMBRE SOCIO -->
                    <th>Apellido</th> <!-- encabezado de APELLIDO SOCIO -->
                    <th>Direccion</th> <!-- encabezado de DIRECCION SOCIO -->
                    <th>Localidad</th> <!-- encabezado de LOCALIDAD SOCIO -->
                    <th>Email</th> <!-- encabezado de EMAIL SOCIO -->
                    <th>Telefono</th> <!-- encabezado de TELEFONO SOCIO -->
                    <th>Eliminar</th> <!-- encabezado de BOTON ELIMINAR SOCIO -->
                    <th>Modificar</th> <!-- encabezado de BOTON MODIFICAR SOCIO -->        
                    </thead>

                    <!-- --------- COMIENZO CODIGO DE JAVASCRIP ---------  -->
                    <!-- en la variable resultado guardo toda la info de la lista de socios -->

                    <%
                        List<Socios> resultado = null;
                        SociosDAO soc1 = new SociosDAO();
                        resultado = soc1.listarSocios();

                        for (int i = 0; i < resultado.size() ; i++) 
                        {
                            String rutaMod = "SociosController?accion=modificar&id=" + resultado.get(i).getIdSocio();
                            String rutaElim = "SociosController?accion=eliminar&id=" + resultado.get(i).getIdSocio();
                    %> 

                    <!-- --------- FINAL DE CODIGO JAVASCRIP ---------  -->

                    <!-- --------- relleno DE LA TABLA ---------  -->

                    <tr>
                        <!-- persona de prueba hasta conectar con la base de datos que traiga a los socios -->
                        <td><%=resultado.get(i).getIdSocio()%></td>
                        <td><%=resultado.get(i).getNombre()%></td>
                        <td><%=resultado.get(i).getApellido()%></td>
                        <td><%=resultado.get(i).getLocalidad()%></td>
                        <td><%=resultado.get(i).getDireccion()%></td>
                        <td><%=resultado.get(i).getEmail()%></td>
                        <td><%=resultado.get(i).getTelefono()%></td>
                        <td> <a href="<%=rutaMod%>"><i class="fa-solid fa-xmark"></i></a> </td>
                        <td> <a href="<%=rutaElim%>"><i class="fa-solid fa-pen"></i></a> </td>                 
                    </tr>

                    <% 
                        }
                    %>

                </table>
            </div>
        </div>
    </body>
</html>
