<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Nuevo Empleado</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
    </head>
        

    <body onload="CargarCargos()">
        <c:if test="${sessionScope.usuario == null}">
            <c:redirect url = "index.jsp"/>
        </c:if>

        <c:if test="${sessionScope.usuario.descripTipoUsuario !='Administrador'}">
           <c:redirect url = "PagLogin.jsp"/>
        </c:if>

        <div id="wrapper">
            <%@include file="includes/Navbar.jsp" %>
            <div id="page-wrapper" style="background-color: white">
                <div class="header" style="opacity: 0; height: 5px"> 
                    <h4 class="page-header">
                        Módulo  <small><i class="fa fa-angle-double-right"></i> Nuevo Empleado</small>
                    </h4>
                </div>

                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Nuevo Empleado
                                </div>
                                <div class="panel-body">
                                    <form role="form" action="ControlEmpleado" method="post">
                                        <h5 style="text-decoration: underline;">Datos personales</h5>
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
                                                </div>

                                                <div class="col-sm-10">
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <label >Tipo Documento </label>
                                                                <select class="form-control" name="tipo_documento" id="tipo_documento"  >
                                                                    <c:forEach var="dato" items="${tipos_documentos}" >
                                                                        <option value="${dato.idTipoDocumento}" ${emp.idTipoDocumento == dato.idTipoDocumento ? 'selected' : ''}>${dato.descDocumento }</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="form-group">
                                                                <label >Numero Documento </label>
                                                                <input  type="text"  class="form-control" id="documento" name="documento"  value="<c:out value = "${emp.nroDocumento}"/>" maxlength="15" required=""/>
                                                            </div>
                                                            <div class="form-group">
                                                                <label >Nombres </label>
                                                                <input  type="text"  class="form-control" id="nombres" name="nombres"  value="<c:out value = "${emp.nombres}"/>" maxlength="30" required=""/>
                                                            </div>
                                                        </div>


                                                        <div class="col-sm-2">
                                                            <div class="form-group">
                                                                <img src="img/nuevo-img.webp" width="300px"/>
                                                            </div>

                                                        </div>
                                                    </div>

                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <label >Apellido Paterno </label>
                                                                <input  type="text"  class="form-control" id="paterno" name="paterno"  value="<c:out value = "${emp.apellidoPaterno}"/>" maxlength="30" required=""/>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <label >Apellido Materno </label>
                                                                <input  type="text"  class="form-control" id="materno" name="materno"  value="<c:out value = "${emp.apellidoMaterno}"/>" maxlength="30" required=""/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <label >Genero </label>
                                                                <select class="form-control" name="genero" id="genero"  value="<c:out value = "${emp.genero}"/>">
                                                                    <option value="Femenino" ${emp.genero == "Femenino" ? 'selected' : ''}>Femenino</option>
                                                                    <option value="Masculino" ${emp.genero == "Masculino"? 'selected' : ''}>Masculino</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <div class="form-group">
                                                                <label >Fecha Nacimiento </label>
                                                                <input  type="date"  class="form-control" id="fecha_nacimiento" name="fecha_nacimiento"  value="<c:out value = "${emp.fechaNacimiento}"/>" required=""/>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <br>
                                                        <h5 style="text-decoration: underline;">Datos de correspondencia</h5>

                                                        <div class="row">
                                                            <div class="col-sm-12">
                                                                <div class="form-group">
                                                                    <label >Dirección </label>
                                                                    <input  type="text"  class="form-control" id="direccion" name="direccion"  value="<c:out value = "${emp.direccion}"/>" maxlength="60">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label >Teléfono </label>
                                                                    <input  type="text"  class="form-control" id="telefono" name="telefono"  value="<c:out value = "${emp.telefono}"/>"  maxlength="12"/>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label >Correo </label>
                                                                    <input type="email" class="form-control" id="correo" name="correo"  value="<c:out value = "${emp.correoElectronico}"/>"  maxlength="30" required=""/>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label >Tipo Usuario </label>
                                                                    <select class="form-control" name="tipo_usuario" id="tipo_usuario" onchange="CargarCargos()"  />
                                                                    <c:forEach var="dato" items="${tipos_uuarios}" >
                                                                        <option value="${dato.idTipoUsuario}" ${emp.idTipoUsuario == dato.idTipoUsuario ? 'selected' : ''}>${dato.descTipoUsuario }</option>
                                                                    </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label >Cargo </label>
                                                                    <select class="form-control" name="cargo" id="cargo" >
                                                                    </select>
                                                                </div>
                                                            </div>

                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-6">
                                                                <div class="form-group">
                                                                    <label >Horario </label>
                                                                    <select class="form-control" name="horario" id="horario">
                                                                        <c:forEach var="dato" items="${horarios}" >
                                                                            <option value="${dato.idHorario}"  ${emp.idHorario == dato.idHorario ? 'selected' : ''}>${dato.hora_entrada } - ${dato.hora_salida}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <input type="hidden" name="accion" value="guardar_emp"/>
                                                        <button type="submit" class="btn asistencia-boton">Grabar</button>
                                                        <input type="reset" value="Limpiar" class="btn asistencia-boton" />
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
        function CargarCargos() {
            var cargosAdmin = ["Admin"];
            var cargosDcotor = ["Dermatologia", "Oftalmologia", "Pediatria", "Estamotologia"];
            var cargosEnfermero = ["Auxiliar"];

            var tipo_usuario = $("#tipo_usuario").val();
            var id = $("#cargo").val();
            var cargo = $("#cargo");
            cargo.find("option").remove();

            var data = new Array();

            switch (parseInt(tipo_usuario)) {
                case 1:// ADMIN
                    data = cargosAdmin;
                    break;
                case 2: // DOCTOR
                    data = cargosDcotor;
                    break;
                default :
                    data = cargosEnfermero;
            }

            for (var i = 0; i < data.length; i++) {
                cargo.append("<option value='" + data[i] + "'>" + data[i] + "</option>");
            }
        }
    </script>
</html>
