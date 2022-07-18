
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        
        <title>Principal</title>
        <link href="./css/estilos-version-1.css" rel="stylesheet" />
        <%@include file="includes/MisRecursos.jsp" %>
        
    </head>
      
      
    <body >
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
