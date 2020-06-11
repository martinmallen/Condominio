<%-- 
    Document   : viewusers
    Created on : 07-05-2020, 20:33:45
    Author     : Cartajena-Solar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                    <jsp:include page="nav.jsp" />
                </div>
                <div class="col s6 offset-s3">
                    <table class="centered bordered amber accent-1">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Usuario</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${applicationScope.lstUsers}" var="u">
                                <tr>
                                    <td>${u.nombre}</td>
                                    <td>${u.apellido}</td>
                                    <td>${u.user}</td>
                                    <td>${u.pass}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
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
