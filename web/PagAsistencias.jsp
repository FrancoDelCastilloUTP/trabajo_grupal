<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mi Asistencia</title>
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
                        Módulo  <small><i class="fa fa-angle-double-right"></i> Mi asistencia</small>
                    </h4>
                </div>

                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Asitencia Empleado
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="ControlAsistencia" method="post">
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
                                                            <input  type="text"  class="form-control" id="documento" name="documento" value="<c:out value = "${documento}"/>" maxlength="12" required=""/>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input type="hidden" name="accion" value="consulta_01">
                                                                <input type="submit" value="Consultar" class="btn asistencia-boton" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <c:if test = "${mensaje_success !=null}">
                                            <div class="alert alert-success">
                                                <strong>Mensaje! </strong><c:out value = "${mensaje_success}"/>
                                            </div>
                                        </c:if>
                                                        
                                        <c:if test = "${mensaje_error !=null}">
                                            <div class="alert alert-danger">
                                                <strong>Mensaje! </strong><c:out value = "${mensaje_error}"/>
                                            </div>
                                        </c:if>



                                        <hr>
                                            <div class="row">
                                                <c:if test = "${lista.size() >0}">
                                                    <div class="col-sm-5">
                                                        <table class="table table-striped table-bordered">
                                                            <thead>
                                                                <tr class="bg-primary" >
                                                                    <th class="text-center">Empleado</th>
                                                                </tr>
                                                            </thead>

                                                            <tbody>
                                                                <tr >
                                                                    <td class="text-center"><c:out value = "${emp.nomCompletos()}"/></td>
                                                                </tr>
                                                            </tbody>
                                                        </table>

                                                    </div>
                                                </c:if>


                                                <div class="col-sm-12">

                                                    <table class="table table-responsive table-striped table-bordered text-center">
                                                        <thead>
                                                            <tr>
                                                                <th class="text-center">#</th>
                                                                <th class="text-center">Fecha Entrada</th>
                                                                <th  class="text-center">Hora Entrada</th>
                                                                <th class="text-center">Fecha Salida</th>
                                                                <th class="text-center">Hora Salida</th>

                                                                <c:if test="${sessionScope.usuario.descripTipoUsuario =='Administrador'}">
                                                                    <th class="text-center">Accion</th>
                                                                    </c:if>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="dato" items="${lista}"  varStatus="loop">
                                                                <tr>
                                                                    <td>${loop.index + 1}</td>
                                                                    <td>${dato.fechaEntrada }</td>
                                                                    <td>${dato.horaEntrada }</td>

                                                                    <c:choose>
                                                                        <c:when test="${empty dato.fechaSalida}">
                                                                            <td>Sin marcación</td>
                                                                            <td>Sin marcación</td>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <td>${dato.fechaSalida }</td>
                                                                            <td>${dato.horaSalida }</td>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <c:if test="${sessionScope.usuario.descripTipoUsuario =='Administrador'}">
                                                                        <td>
                                                                            <a href="javascript:Eliminar(${dato.idAsistencia })"   class="btn btn-danger">
                                                                                <i class="fa fa-trash-o" ></i>
                                                                            </a>
                                                                        </td>
                                                                    </c:if>

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
    <script type="text/javascript">
        function Eliminar(id) {
            if (confirm("¿Está seguro que desea eliminar la asistencia?")) {
                var documento = document.getElementById("documento").value;
                window.location.href = "ControlAsistencia?accion=eliminar&documento=" + documento + "&id=" + id;

            }
        }
    </script>
</html>
