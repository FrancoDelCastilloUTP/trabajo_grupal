
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Principal</title>
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
            <div id="page-wrapper" style="background-color: white">
                <div class="header" style="opacity: 0; height: 5px"> 
                    <h4 class="page-header">
                        Módulo  <small><i class="fa fa-angle-double-right"></i> Principal</small>
                    </h4>
                </div>

                <div id="page-inner"> 
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Menu Principal
                                </div>
                                <div class="panel-body">
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
