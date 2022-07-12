<%

    String URL = request.getRequestURL().toString();
%>

<nav class="navbar navbar-default top-navbar" role="navigation" >
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse" >
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <a href="ControlEmpleado?accion=datos" >
            <h1 class="titulo" style="font-size: 2rem;"> <strong> MedCenter +</strong></h1>
        </a>
    </div>

    <ul class="nav navbar-top-links navbar-right" >
        <li>
            <b style="color: white;">
                <span style="font-size: 15px;">
                    Bienvenido: 
                </span>
                <span style="font-size: 19px;">
                    <c:out value = "${sessionScope.usuario.nomCompletos()}"/> &nbsp;&nbsp;
                </span>
            </b>
        </li>
        <li>

            <form action="ControlUsuario">
                <input type="hidden" name="accion" value="logout">
                <button type="submit" class="btn asistencia-boton" style="  border-radius: 10%;">Cerrar Sesión
                </button>
            </form>
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
            </a>
        </li>
    </ul>
</nav>
<!--/. NAV TOP  -->
<nav class="navbar-default navbar-side" role="navigation" style="background-color: #41DCD3" >
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="divider"></li>
            <li>
                <a href="ControlEmpleado?accion=datos" class=<%= URL.contains("PagMisDatos") ? "active-menu" : ""%>><i class="fa fa-dashboard"></i> Mis datos</a>
            </li>
            <li>
                <a href="PagMiAsistencia.jsp" class=<%= URL.contains("PagMiAsistencia") ? "active-menu" : ""%>><i class="fa fa-desktop"></i>Mi asistencia</a>
            </li>
            <li>
                <a href="PagBuscarEmpleado.jsp" class=<%= URL.contains("PagBuscarEmpleado") ? "active-menu" : ""%>><i class="fa fa-bar-chart-o"></i>Empleados</a>
            </li>

            <c:if test="${sessionScope.usuario.descripTipoUsuario =='Administrador'}">
                <li>
                    <a href="PagAsistencias.jsp" class=<%= URL.contains("PagAsistencias") ? "active-menu" : ""%>><i class="fa fa-qrcode"></i> Asistencia</a>
                </li>
            </c:if>

        </ul>
    </div>
</nav>