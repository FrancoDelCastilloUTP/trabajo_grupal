<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login</title>
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
            width: 100%;
            height: 100%;
        }

        .text-creado {
            
            
            text-align: center;
            font-weight: 200;
            font: 5rem Georgia, Serif;
            
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
    <body style="background-color: white;">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <br>
                    <div class="padre">
                        <form action="ControlUsuario" method="post">
                            <div class="hijo">
                                <center>
                                    <a href="index.jsp" style="text-decoration:none;">
                                                                        <center>
                                    <h1 class="titulo"> <strong> MedCenter +</strong></h1>
                                </center>
                                    </a>
                                </center>
                                <br>
                                <div class="panel">
                                    <div class="panel-heading">
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
                                            
                                            <div class="row" style="width:800px;">
                                                
                                                <div class="col-sm-6 asistencia-container">
                                                    <h3 class="text-creado">LOGIN</h3>
                                            <br>
                                                    <div class="row">
                                                        <div >
                                                            <br><br>
                                                            <div class="form-group">
                                                                <label class="text-left">Correo </label>
                                                                <input " type="text"  class="form-control" id="correo" name="correo" style="border-radius: 15px; font:  bold 20px Georgia, Serif;color: #123c63" required="">
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="text-left">Contraseña </label>
                                                                <input type="password"  class="form-control" id="pass" name="pass" style="border-radius: 15px; font:  bold 20px Georgia, Serif;color: #123c63" required="">
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="row">
                                                        <center>
                                                            <div class="form-group">
                                                                <input type="hidden" name="accion" value="login">
                                                                <input type="submit" value="Ingresar"  class="btn asistencia-boton btn-lg">
                                                            </div>
                                                        </center>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                <img src="img/login-img.webp" class="img-responsive"  width="100%"/>     
                                            </div>
                                                
                                            </div>
                                           
                                            <br>
                                            
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    
                </div>

            </div>
        </div>

    </body>

</html>
