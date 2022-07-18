<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Inicio</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
    </head>

    <body>
        <div class="container">
                    <div class="text-right" style="margin-top:20px;">
                        <a href="PagLogin.jsp" class="btn asistencia-boton" title="Iniciar Sesion"><i class="fa fa-user"></i> Iniciar Sesion</a>
                    </div>
            <div class="row main">
                <div class="col-sm-8">
                                <center>
                                    <h1 class="titulo"> <strong> MedCenter+</strong></h1>
                                </center>
                    <div class="padre">

                        <form action="ControlAsistencia" method="post">
                            <div class="hijo">

                                <div class="asistencia-container">
                                <h3 class="text-creado">Registra tu asistencia</h3>
                                <br>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="row">
                                            <div class="col-sm-12">

                                                <div class="form-group">
                                                    <label class="text-left">Ingresa tu DNI</label>
                                                    <input  type="text"  class="form-control" id="documento"  value="<c:out value = "${documento}"/>"
                                                            name="documento" style="width: 100%;border-radius: 15px; font:  bold 20px Georgia, Serif;color: #123c63" required="" maxlength="12">
                                                </div>
                                            </div>
                                        </div>
                                        <center>
                                        <div class="row" style="margin:20px;">
                                            <div>
                                                <div class="form-group">
                                                    <button type="submit" name="accion" value="entrada"  class="btn asistencia-boton  btn-lg">MARCAR ENTRADA</button>
                                                </div>
                                            </div>
                                            <div>
                                                <div class="form-group">
                                                    <button type="submit" name="accion" value="salida"  class="btn asistencia-boton btn-lg">MARCAR SALIDA</button>
                                                </div>
                                            </div>
                                        </div>
                                        </center>
                                    </div>
                                </div>
                                
                               </div>
                                                            
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
                                <br>

                            </div>
                        </form>
                                          <div class="img-container">
                    <br>

                    <img src="img/asistencia-img.webp" class="img-doctor"/>
                </div>                                  
                                                            
                    </div>

                </div>

            </div>
        </div>
               
    </body>
</html>
