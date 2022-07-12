<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mi Asistencia</title>
        <%@include file="includes/MisRecursos.jsp" %>
    </head>
           <style>
        .main {
            
            display: flex;
            justify-content: center;
            align-items: center;
        }
        
        .padre {
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
            padding-top: 60px;
        }

        
        
        .hijo {
            width: 430px;
            height: 100%;
        }

        .text-creado {
            
            
            margin-bottom: 20px;
            text-align: center;
            font-weight: 200;
            font: 3.5rem Georgia, Serif;
            
        }

        .text-usuario {
            color: #0075b0;
            margin: 0 auto;
            text-align: center;
            font-weight: 200;
            font: italic bold 30px Georgia, Serif;
            
        }
        
        .titulo {
            color: #416CDC;
            font-size: 6rem;
            background-color: #41DCD3;
            margin-top: 0;
            padding: 20px;
        }
        
        .asistencia-container {
            background-color: #41DCD3;
            padding: 40px;
        }
        
        .asistencia-boton{
            background-color: #416CDC;
            color: white;
            border-radius: 15px;
            font-size: 1.2rem;
        }
        
        .asistencia-boton:hover{
                background-color: white;
            }
    </style>
    <body style="background-color: white;">
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
                                    Mi Asitencia
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
                                                    <div class="col-sm-3">
                                                        <div class="form-group">
                                                            <label >Fecha Inicio </label>
                                                            <input  type="date"  class="form-control" id="inicio" name="inicio" required="" value="<c:out value = "${inicio}"/>">
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <div class="form-group">
                                                            <label >Fecha Fin </label>
                                                            <input  type="date"  class="form-control" id="fin" name="fin" required="" value="<c:out value = "${fin}"/>">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-sm-6">
                                                        <div class="form-group">
                                                            <input type="hidden" name="accion" value="consulta_02" />
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
                                                                <th class="text-center">#</th>
                                                                <th class="text-center">Fecha Entrada</th>
                                                                <th  class="text-center">Hora Entrada</th>
                                                                <th class="text-center">Fecha Salida</th>
                                                                <th class="text-center">Hora Salida</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="dato" items="${lista}"  varStatus="loop">
                                                                <tr>
                                                                    <td>${loop.index + 1}</td>
                                                                    <td>${dato.fechaEntrada }</td>
                                                                    <td>${dato.horaEntrada }</td>
                                                                    <td>${dato.fechaSalida }</td>
                                                                    <td>${dato.horaSalida }</td>
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
