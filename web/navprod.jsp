<%-- 
    Document   : navprod
    Created on : 14-05-2020, 19:12:50
    Author     : Cartajena-Solar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.carro}">
    <c:set var="cantidad" scope="session" value="${0}" />
    <c:forEach items="${sessionScope.carro}" var="p">
        <c:set var="cantidad" value="${cantidad + p.stock}" />
    </c:forEach>
</c:if>
<nav>
    <div class="nav-wrapper orange darken-3">
        <a href="#!" class="brand-logo">&nbsp;&nbsp;¡Bienvenido ${sessionScope.user.nombre}!</a>
        <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
            <li><a href="productos.jsp">Productos</a></li>
                <c:if test="${not empty sessionScope.carro}">
                <li>
                    <a href="carro.jsp">
                        Carro
                        <i class="material-icons right">
                            shopping_cart
                        </i>
                        (${cantidad})
                    </a>
                </li>
            </c:if>
            <c:if test="${empty sessionScope.carro}">
                <li><a href="carro.jsp">Carro</a></li>
                </c:if>
            <li><a href="cerrar.jsp">Cerrar Sesión</a></li>
        </ul>
        <ul class="side-nav" id="mobile-demo">
            <li><a href="productos.jsp">Productos</a></li>
            <li><a href="carro.jsp">Carro</a></li>
            <li><a href="cerrar.jsp">Cerrar Sesión</a></li>
        </ul>
        <a href="carro.jsp"></a>
    </div>
</nav>