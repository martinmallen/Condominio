<%-- 
    Document   : detalle
    Created on : 14-05-2020, 20:19:51
    Author     : Cartajena-Solar
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cl.inacap.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Compra de Productos</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <jsp:include page="navprod.jsp" />
                </div>
            </div>
            <%
              //Obtener el parámetro desde la petición
              //(código del producto)
              int codigo = Integer.parseInt(request.getParameter("codigo"));
              //SE RECUPERA LA LISTA de productos 
              //DESDE LA AMBITO DE LA APLICACIÓN.
              ArrayList<Producto> listaP 
                      = (ArrayList) application.getAttribute("lstProds");
              //Buscar el producto en la lista.
              Producto producto = null;
              for (Producto pro : listaP) {
                      if(pro.getCodigo() == codigo ){
                          producto = pro;
                          break;
                      }
                  }
            %>
            <div class="row">
                <div class="col s12">
                    <h2 class="center-align">Detalle de Productos</h2>
                    <div class="col s6 offset-s3">
                        <form action="agregar.do" method="get" class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="codigo" type="text" class="validate"
                                           name="txtCodigo" readonly="readonly"
                                           value="<%= producto.getCodigo()%>" />
                                    <label for="codigo">Código</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="descripcion" type="text" class="validate"
                                           name="txtDescripcion" readonly="readonly"
                                           value="<%= producto.getDescripcion()%>" />
                                    <label for="descripcion">Descripción</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input id="precio" type="text" class="validate"
                                           name="txtPrecio" readonly="readonly"
                                           value="<%= producto.getPrecio()%>">
                                    <label for="precio">Precio</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="cboCantidad" id="cantidad">
                                        <% for (int i = 1; i <= producto.getStock(); i++) {%>
                                        <option><%= i%></option>
                                        <% }%>
                                    </select>
                                    <label for="cantidad">Cantidad</label>
                                </div>
                            </div>
                            <div class="row">
                                <c:set var="cantidad" scope="page" value="<%= producto.getStock() %>"/>
                                <!--c:out value = ""/-->
                                <c:if test="${cantidad > 0}">
                                <button class="btn orange darken-3" type="submit" name="action">
                                    Añadir
                                    <i class="material-icons right">
                                        shopping_cart
                                    </i>
                                </button>
                                </c:if>    
                                <a href="productos.jsp" class=" orange-text darken-3">
                                    <strong>&nbsp;&nbsp;&nbsp;Volver</strong>
                                </a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(function () {
                $(".button-collapse").sideNav();
                $("select").material_select();
            });
        </script>
    </body>
</html>
