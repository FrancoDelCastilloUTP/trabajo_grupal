<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Buscar Empleado</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
        
    </head>
        
    <body >
        <c:if test="${sessionScope.usuario == null}">
            <c:redirect url = "index.jsp"/>
        </c:if>
        <div id="wrapper">
            <%@include file="includes/Navbar.jsp" %>
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" style="background-color: white">
                <div class="header" style="opacity: 0; height: 5px"> 
                    <h4 class="page-header">
                        Módulo  <small><i class="fa fa-angle-double-right"></i> Buscar Empleado</small>
                    </h4>
                </div>

                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Buscador de Empleado
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="ControlEmpleado" method="post">
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <div class="form-group">
                                                    <img src="img/asistencia-img.webp" width="100%"/>
                                                </div>

                                            </div>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >N°-Documento </label>
                                                            <input  type="text"  class="form-control" id="documento" name="documento"  value="<c:out value = "${documento}"/>" maxlength="12" r>
                                                        </div>
                                                    </div>
                                                    <c:if test="${sessionScope.usuario.descripTipoUsuario =='Administrador'}">
                                                        <div class="col-sm-6">
                                                            <div class="form-group text-right">
                                                                <br>
                                                                    <a href="ControlEmpleado?accion=nuevo" class="btn asistencia-boton"><i class="fa fa-plus"></i>Nuevo Empleado</a>
                                                            </div>
                                                        </div>
                                                    </c:if>


                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input type="hidden" name="accion" value="consulta_03" />
                                                            <input type="submit" value="Consultar" class="btn asistencia-boton">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <c:if test = "${mensaje_error !=null}">
                                                        <div class="alert alert-danger">
                                                            <strong>Mensaje! </strong><c:out value = "${mensaje_error}"/>
                                                        </div>
                                                    </c:if>

                                                    <c:if test = "${mensaje_success !=null}">
                                                        <div class="alert alert-success">
                                                            <strong>Mensaje! </strong><c:out value = "${mensaje_success}"/>
                                                        </div>
                                                    </c:if>

                                                    <table class="table table-responsive table-striped table-bordered text-center">
                                                        <thead>
                                                            <tr>
                                                                <th class="text-center">Tipo Documento</th>
                                                                <th class="text-center">Nombre</th>
                                                                <th class="text-center">Telefono</th>
                                                                <th class="text-center">Correo</th>
                                                                <th class="text-center">Fecha Nacimiento</th>
                                                                <th class="text-center">Cargo</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="dato" items="${lista}" >
                                                                <tr>
                                                                    <td>${dato.nroDocumento }</td>
                                                                    <td>${dato.nomCompletos() }</td>
                                                                    <td>${dato.telefono }</td>
                                                                    <td>${dato.correoElectronico }</td>
                                                                    <td>${dato.fechaNacimiento }</td>
                                                                    <td>${dato.nomCargo }</td>
                                                                </tr>
                                                            </c:forEach>
                                                            <c:if test="${lista.size() == 0 or lista == null}">
                                                                <tr>
                                                                    <td colspan="5">No se encontraron datos</td>
                                                                </tr>
                                                            </c:if>

                                                        </tbody>
                                                    </table>

                                                </div>
                                            </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%@include file="includes/Footer.jsp" %>
                </div>
            </div>
        </div>

    </body>
</html>
