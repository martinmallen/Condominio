<%-- 
    Document   : cerrar
    Created on : 14-05-2020, 20:11:05
    Author     : Cartajena-Solar
--%>
<%
    //Se preocede a cerrar la sesion
    session.invalidate();
    //Redireccionar hacia el login
    response.sendRedirect("login.jsp");
%>


