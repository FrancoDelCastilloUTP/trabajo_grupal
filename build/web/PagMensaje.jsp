<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mensaje</title>
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
    <center>
        <br>
        <div class="padre">
            <div class="hijo">
                
                <h3 class="text-creado"><c:out value = "${mensaje}"/></h3>
                <h4 class="text-usuario"><c:out value = "${emp.nomCompletos()}"/></h4>
                <br>
                <img src="img/mensaje-img.jpg" class="img-responsive"  width="50%"/>
                <a href="index.jsp" class="btn asistencia-boton">Retornar</a>
            </div>
        </div>
    </center>

</body>

</html>
