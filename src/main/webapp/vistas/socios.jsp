<%-- 
    Document   : socios
    Created on : 15 dic. 2022, 00:56:59
    Author     : Sol
--%>

<%@page import="modelo.SociosDAO"%>
<%@page import="modelo.Socios"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Socios</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- CSS only copiado desde bootstrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper copiado desde bootstrap-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
        <!-- script para fontawersome -->
        <script src="https://kit.fontawesome.com/d3abc30a8e.js" crossorigin="anonymous"></script>
        <!-- goolge fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Arimo:ital,wght@1,600&family=Merriweather+Sans:wght@400;800&display=swap" rel="stylesheet">
        <link href="vistas/css/style.css" rel="stylesheet" type="text/css">
    </head>

    <body>

        <h1 class="text-center py-4 mb-4">Listado de Socios</h1>
        <div class="container text-center">

            <div class="row">

                <div class="table-responsive rounded-4">
                    <table class="table table-primary">
                        
                        <!-- --------- ENCABEZADOS DE LA TABLA ---------  -->
                        <thead>
                        <th>Id</th> <!-- encabezado de ID SOCIO -->
                        <th>Nombre</th> <!-- encabezado de NOMBRE SOCIO -->
                        <th>Apellido</th> <!-- encabezado de APELLIDO SOCIO -->
                        <th>Localidad</th> <!-- encabezado de LOCALIDAD SOCIO -->
                        <th>Direccion</th> <!-- encabezado de DIRECCION SOCIO -->
                        <th>Fecha de Nacimiento</th> <!-- encabezado de Fecha de Nacimiento -->
                        <th>Email</th> <!-- encabezado de EMAIL SOCIO -->
                        <th>Telefono</th> <!-- encabezado de TELEFONO SOCIO -->
                        <th>Estado</th> <!-- encabezado de Estado del SOCIO -->
                        <th>Eliminar</th> <!-- encabezado de BOTON ELIMINAR SOCIO -->
                        <th>Modificar</th> <!-- encabezado de BOTON MODIFICAR SOCIO -->  
                        </thead>

                        <!-- --------- COMIENZO CODIGO DE JAVASCRIP ---------  -->
                        <!-- en la variable resultado guardo toda la info de la lista de socios -->

                        <%
                            List<Socios> resultado = null;
                            SociosDAO soc = new SociosDAO();
                            resultado = soc.listaSocios();

                            for (int i = 0; i < resultado.size(); i++) {
                                String rutaMod = "SociosController?accion=modificar&id=" + resultado.get(i).getIdSocio();
                                String rutaElim = "SociosController?accion=eliminar&idSocio=" + resultado.get(i).getIdSocio();
                        %> 

                        <!-- --------- FINAL DE CODIGO JAVASCRIP ---------  -->

                        <!-- --------- relleno DE LA TABLA ---------  -->
                        <tr>
                            <td class="fw-bold"><%=resultado.get(i).getIdSocio()%></td>
                            <td><%=resultado.get(i).getNombre()%></td>
                            <td><%=resultado.get(i).getApellido()%></td>
                            <td><%=resultado.get(i).getLocalidad()%></td>
                            <td><%=resultado.get(i).getDireccion()%></td>
                            <td><%=resultado.get(i).getFechaNac()%></td>
                            <td><%=resultado.get(i).getEmail()%></td>
                            <td><%=resultado.get(i).getTelefono()%></td>
                            <td> <%=resultado.get(i).isActivo()%> </td>
                            <td class="text-center"><a href=<%=rutaElim%>> <i class="fa-solid fa-xmark"></i> </a></td>
                            <td class="text-center"><a href=<%=rutaMod%>> <i class="fa-solid fa-pen"></i> </a></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>                
            </div>
            <a class="btn btn-warning col-4 my-2 rounded-4" href="SociosController?accion=nuevo">Agregar Socio Nuevo</a>
        </div>
    </body>

</html>
