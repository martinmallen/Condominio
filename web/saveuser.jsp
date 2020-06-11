<%-- 
    Document   : saveuser
    Created on : 07-05-2020, 21:05:44
    Author     : Cartajena-Solar
--%>

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
                <div class="col s6 offset-s3 ">
                    <h5 class="center-align">Registro de Usuario</h5>
                    <form class="col s12" action="registro.do" method="post">
                        <div class="row">
                            <div class="input-field col s12">
                                <i class="material-icons prefix">account_circle</i>
                                <input name="txtNombre" id="nombre" 
                                       type="text" value="${param.txtNombre}"
                                       class="validate">
                                <label for="nombre">Nombre</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">account_circle</i>
                                <input name="txtApellido" id="apellido" 
                                       value="${param.txtApellido}"
                                       type="text" class="validate">
                                <label for="apellido">Apellido</label>
                            </div>
                            <div class="input-field col s12">
                                <i class="material-icons prefix">account_circle</i>
                                <input name="txtUser" id="user" 
                                       value="${param.txtUser}"
                                       type="text" class="validate">
                                <label for="user">User</label>
                            </div>
                            <div class="input-field col s12 ">
                                <i class="material-icons prefix">lock</i>
                                <input name="txtPass" id="pass" 
                                       value="${param.txtPass}"
                                       type="password" class="validate">
                                <label for="pass">Password</label>
                            </div>
                            <div class="row center-align">
                                <button class="btn waves-effect waves-light orange darken-3" type="submit" name="action">
                                    Enviar <i class="material-icons right">send</i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="red-text center-align">
                        ${requestScope.msgError}
                    </div>
                    <div class="green-text center-align">
                        ${requestScope.msgExito}
                    </div>
                </div>

            </div>
        </div>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
            $(function(){
                $(".button-collapse").sideNav();
            });
        </script>
    </body>
</html>