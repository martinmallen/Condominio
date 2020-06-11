<%-- 
    Document   : carro
    Created on : 20-05-2020, 19:32:44
    Author     : Cartajena-Solar
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:if test="${not empty sessionScope.user}">
            <div class="row">
                <div class="col s12">
                    <jsp:include page="navprod.jsp" />
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <h2 class="center-align">Productos en el Carro</h2>
                    <div class="col s6 offset-s3">
                    <table class="bordered centered">
                        <thead>
                            <tr>
                                <th>Descripción</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${sessionScope.carro}" var="p" >
                                <tr>
                                    <td>${p.descripcion}</td>
                                    <td>${p.stock}</td>
                                    <td>${p.precio}</td>
                                    <td>${p.precio * p.stock}</td>
                                </tr>
                            </c:forEach>   
                        </tbody>
                    </table>
                </div>
                </div>
            </div>
            </c:if>
            <c:if test="${empty sessionScope.user}">
                <div class="row">
                <div class="col s12">
                    <h3>Debe iniciar sesión para acceder a los contenidos</h3>
                    <a href="login.jsp">Ir al login</a>
                </div>
            </div>
            </c:if>
        </div> 
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(function () {
                $(".button-collapse").sideNav();
            });
        </script>
    </body>
</html>