<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Inicio</title>
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
            text-shadow: 2px 2px 2px black;
        }
        
        .titulo {
            color: #416CDC;
            font-size: 6rem;
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
    <body style="background-color: white; height: 100vh;">

        <div class="container">
                    <div class="text-right" style="margin-top:20px;">
                        <a href="PagLogin.jsp" class="btn asistencia-boton" title="Iniciar Sesion"><i class="fa fa-user"></i> Iniciar Sesion</a>
                    </div>
            <div class="row main">
                <div class="col-sm-8">
                                <center>
                                    <h1 class="titulo"> <strong> MedCenter +</strong></h1>
                                </center>
                    <br>
                    <div class="padre">

                        <form action="ControlAsistencia" method="post">
                            <div class="hijo">

                                <br>
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
                                          <div class="col-sm-4">
                    <br>

                    <img src="img/asistencia-img.webp" class="img-responsive" height="100%"/>
                </div>                                  
                                                            
                    </div>

                </div>

            </div>
        </div>
                    
    </body>
</html>
