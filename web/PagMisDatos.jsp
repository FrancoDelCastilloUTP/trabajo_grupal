<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mis Datos</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
    </head>
            
    <body style="background-color: white;">
        <c:if test="${sessionScope.usuario == null}">
            <c:redirect url = "index.jsp"/>
        </c:if>


        <div id="wrapper">
            <%@include file="includes/Navbar.jsp" %>
            <div id="page-wrapper" style="background-color: white">
                <div class="header" style="opacity: 0; height: 5px"> 
                    <h4 class="page-header">
                        Módulo  <small><i class="fa fa-angle-double-right"></i> Mis datos</small>
                    </h4>
                </div>

                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Mis datos
                                </div>
                                <div class="panel-body">
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

                                    <form role="form" action="ControlEmpleado" method="post">
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <div class="form-group"> 
                                                    <img src="img/asistencia-img.webp" width="600px" class="img-form"/>
                                                </div>

                                            </div>
                                            <div class="col-sm-10">
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Nombres </label>
                                                            <input  type="text"  class="form-control" id="nombres" name="nombres"  value="<c:out value="${emp.nombres}"/>" >
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Apellido Paterno </label>
                                                            <input  type="text"  class="form-control" id="paterno" name="paterno" maxlength="30" value="<c:out value="${emp.apellidoPaterno}"/>">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Apellido Materno </label>
                                                            <input type="text" class="form-control" id="materno" name="materno"  maxlength="30" value="<c:out value="${emp.apellidoMaterno}"/>">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Documento </label>
                                                            <input  type="text"  class="form-control" id="documento" name="documento" maxlength="12" value="<c:out value="${emp.nroDocumento}"/>">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Fecha Nacimiento </label>
                                                            <input type="date" class="form-control" id="fecha" name="fecha"  value="<c:out value="${emp.fechaNacimiento}"/>">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                        <div class="form-group">
                                                            <label >Dirección </label>
                                                            <input  type="text"  class="form-control" id="direccion" name="direccion" maxlength="60" value="<c:out value="${emp.direccion}"/>">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Correo </label>
                                                            <input  type="hidden"   class="form-control" id="correo" name="correo" maxlength="30" value="<c:out value="${emp.correoElectronico}"/>">
                                                                <label class="form-control"><c:out value="${emp.correoElectronico}"/></label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <label >Contraseña </label>
                                                            <input type="password" class="form-control" id="pass" name="pass"  maxlength="30" value="<c:out value="${emp.pass}"/>">
                                                        </div>
                                                    </div>
                                                </div>

                                                <input type="hidden" name="id_emp" value="<c:out value="${emp.idEmpleado}"/>" />
                                                <input type="hidden" name="id_usuario" value="<c:out value="${emp.idUsuario}"/>" />

                                                <input type="hidden" name="accion" value="guardar_cambios">
                                                    <button type="submit" class="btn asistencia-boton">Guardar Cambios</button>
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
