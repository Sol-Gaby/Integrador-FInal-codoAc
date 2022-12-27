<%-- 
    Document   : modificar
    Created on : 15 dic. 2022, 00:58:50
    Author     : Sol
--%>

<%@page import="modelo.SociosDAO"%>
<%@page import="modelo.Socios"%>
<%@page import="java.util.List"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--//todo lo que este dentro de estos corchangulos es codigo javascrip-->

<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Socio</title>
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

        <h1 class="text-center py-5">Modificar Socio</h1>

        <div class="container text-center bg-info">           
            <div class="row px-4">
<!--                //aca obtenemos el id del socio-->
                        <%
                                String id=request.getParameter("id");
                                int mid; 
                                mid=Integer.parseInt(id);
                                Socios resultado=null;
                                SociosDAO socio=new SociosDAO();
                                resultado=socio.mostrarSocio(mid);

                        %>
                        
<!--                        mid, eata variable almacena un objeto de tipo socio y es con la que invocamos el metod de modificar -->

                <form class="p-3" method="POST" action="SociosController?accion=actualizar">

                    <div class="row g-3">

                        <!-- ---------------------- FILA 1 ---------------------- -->

                        <!-- label para id -->                        
                        <div class="col mb-3">
                            <label for="id" class="form-label fw-bold">Id</label>
                            <input type="text" class="form-control" name="id" id="id" redonly="true" value="<%=resultado.getIdSocio() %>">                        
                        </div>                        
                        <!-- label para nombre -->                        
                        <div class="col mb-3">
                            <label for="nombre" class="form-label fw-bold">Nombre</label>
                            <input type="text" class="form-control" name="nombre" id="nombre" required placeholder="Ingrese nombre del socio" value="<%=resultado.getNombre() %>">                        
                        </div>
                        <!-- label para apelllio -->
                        <div class="col mb-3">
                            <label for="apellido" class="form-label fw-bold">Apellido</label>
                            <input type="text" class="form-control" name="apellido" id="apellido" required placeholder="Ingrese apellido del socio" value="<%=resultado.getApellido() %>">                        
                        </div>
                    </div>

                    <!-- ---------------------- FILA 2 ---------------------- -->

                    <div class="row g-3">                        
                        <!-- label para direccion -->
                        <div class="col mb-3">
                            <label for="direccion" class="form-label fw-bold">Direccion</label>
                            <input type="text" class="form-control" name="direccion" id="direccion" required placeholder="Ingrese una direccion" value="<%=resultado.getDireccion() %>">                        
                        </div>
                        <!-- label localidad -->
                        <div class="col mb-3">
                            <label for="localidad" class="form-label fw-bold">Localidad</label>
                            <input type="text" class="form-control" name="localidad" id="localidad" required placeholder="Ingrese una localidad" value="<%=resultado.getLocalidad() %>">                        
                        </div>
                    </div>

                    <!-- ---------------------- FILA 3 ---------------------- -->

                    <div class="row g-3">
                        <!-- label para fecha de nacimiento -->
                        <div class="col mb-3">
                            <label for="fechaNac" class="form-label fw-bold" >Fecha Nacimiento</label>
                            <input type="date" class="form-control" id="fechaNac" name="fechaNac" value="<%=resultado.getFechaNac() %>">                          
                        </div> 

                        <div class="col mb-3">
                            <label for="email" class="form-label fw-bold">Email</label>
                            <input type="text" class="form-control" name="email" id="email" required value="<%=resultado.getEmail() %>">                        
                        </div>
                    </div>

                    <!-- ---------------------- FILA 4 ---------------------- -->

                    <div class="row g-3">
                        <!-- telefono -->
                        <div class="col mb-3">
                            <label for="telefono" class="form-label fw-bold">Telefono</label>
                            <input type="text" class="form-control" name="telefono" id="telefono" required value="<%=resultado.getTelefono() %>">                        
                        </div>
                        <!-- lebel activo -->                   
                        <div class="col mb-3">
                            <label for="activo" class="form-label fw-bold">Activo</label>
                            <select id="inputState" class="form-select">
                                <option selected>Seleccionar</option>
                                <option>activo</option>
                                <option>baja</option>
                            </select>
                        </div>

                        <!-- ---------------------- BOTON DE MODIFICAR ---------------------- -->

                        <div class="row">
                            <div class="col mb-6 pt-5">
                                <button type="submit" class="btn btn-warning" >Modificar</button>
                            </div>

                        </div>


                </form>

            </div>

        </div>
    </body>
</html>
