<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Mensaje</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
    </head>
    
    <body >
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
