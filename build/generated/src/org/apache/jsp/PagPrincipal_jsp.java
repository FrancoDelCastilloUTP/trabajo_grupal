package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PagPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/includes/MisRecursos.jsp");
    _jspx_dependants.add("/includes/Navbar.jsp");
    _jspx_dependants.add("/includes/Footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_redirect_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_redirect_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_redirect_url_nobody.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <title>Principal</title>\n");
      out.write("        ");
      out.write("<link href=\"./css/bootstrap.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"./css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<link href=\"./css/custom-styles.css\" rel=\"stylesheet\" />\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("<script src=\"./js/jquery-1.10.2.js\"></script>\n");
      out.write("<script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"./js/jquery.metisMenu.js\"></script>\n");
      out.write("<script src=\"./js/custom-scripts.js\"></script>\n");
      out.write("<script src=\"./js/misFunciones/Funciones.js\"></script>");
      out.write("\n");
      out.write("    </head>\n");
      out.write("                <style>\n");
      out.write("        .main {\n");
      out.write("            \n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .padre {\n");
      out.write("            height: 100%;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            padding-top: 60px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        .hijo {\n");
      out.write("            width: 430px;\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .text-creado {\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            margin-bottom: 20px;\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: 200;\n");
      out.write("            font: 3.5rem Georgia, Serif;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .text-usuario {\n");
      out.write("            color: #0075b0;\n");
      out.write("            margin: 0 auto;\n");
      out.write("            text-align: center;\n");
      out.write("            font-weight: 200;\n");
      out.write("            font: italic bold 30px Georgia, Serif;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .titulo {\n");
      out.write("            color: #416CDC;\n");
      out.write("            font-size: 6rem;\n");
      out.write("            background-color: #41DCD3;\n");
      out.write("            margin-top: 0;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .asistencia-container {\n");
      out.write("            background-color: #41DCD3;\n");
      out.write("            padding: 40px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .asistencia-boton{\n");
      out.write("            background-color: #416CDC;\n");
      out.write("            color: white;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            font-size: 1.2rem;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .asistencia-boton:hover{\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("    </style>\n");
      out.write("    <body style=\"background-color: white;\">\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            ");


    String URL = request.getRequestURL().toString();

      out.write("\n");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-default top-navbar\" role=\"navigation\" >\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".sidebar-collapse\" >\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <a href=\"ControlEmpleado?accion=datos\" >\n");
      out.write("            <h1 class=\"titulo\" style=\"font-size: 2rem;\"> <strong> MedCenter +</strong></h1>\n");
      out.write("        </a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <ul class=\"nav navbar-top-links navbar-right\" >\n");
      out.write("        <li>\n");
      out.write("            <b style=\"color: white;\">\n");
      out.write("                <span style=\"font-size: 15px;\">\n");
      out.write("                    Bienvenido: \n");
      out.write("                </span>\n");
      out.write("                <span style=\"font-size: 19px;\">\n");
      out.write("                    ");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write(" &nbsp;&nbsp;\n");
      out.write("                </span>\n");
      out.write("            </b>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("\n");
      out.write("            <form action=\"ControlUsuario\">\n");
      out.write("                <input type=\"hidden\" name=\"accion\" value=\"logout\">\n");
      out.write("                <button type=\"submit\" class=\"btn asistencia-boton\" style=\"  border-radius: 10%;\">Cerrar Sesión\n");
      out.write("                </button>\n");
      out.write("            </form>\n");
      out.write("        </li>\n");
      out.write("        <!-- /.dropdown -->\n");
      out.write("        <li class=\"dropdown\">\n");
      out.write("            <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" aria-expanded=\"false\">\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("</nav>\n");
      out.write("<!--/. NAV TOP  -->\n");
      out.write("<nav class=\"navbar-default navbar-side\" role=\"navigation\" style=\"background-color: #41DCD3\" >\n");
      out.write("    <div class=\"sidebar-collapse\">\n");
      out.write("        <ul class=\"nav\" id=\"main-menu\">\n");
      out.write("            <li class=\"divider\"></li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"ControlEmpleado?accion=datos\" class=");
      out.print( URL.contains("PagMisDatos") ? "active-menu" : "");
      out.write("><i class=\"fa fa-dashboard\"></i> Mis datos</a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"PagMiAsistencia.jsp\" class=");
      out.print( URL.contains("PagMiAsistencia") ? "active-menu" : "");
      out.write("><i class=\"fa fa-desktop\"></i>Mi asistencia</a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"PagBuscarEmpleado.jsp\" class=");
      out.print( URL.contains("PagBuscarEmpleado") ? "active-menu" : "");
      out.write("><i class=\"fa fa-bar-chart-o\"></i>Empleados</a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.descripTipoUsuario =='Administrador'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <li>\n");
          out.write("                    <a href=\"PagAsistencias.jsp\" class=");
          out.print( URL.contains("PagAsistencias") ? "active-menu" : "");
          out.write("><i class=\"fa fa-qrcode\"></i> Asistencia</a>\n");
          out.write("                </li>\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("            <div id=\"page-wrapper\" style=\"background-color: white\">\n");
      out.write("                <div class=\"header\" style=\"opacity: 0; height: 5px\"> \n");
      out.write("                    <h4 class=\"page-header\">\n");
      out.write("                        Módulo  <small><i class=\"fa fa-angle-double-right\"></i> Principal</small>\n");
      out.write("                    </h4>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"page-inner\"> \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-12\">\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    Menu Principal\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
      out.write("<footer>\n");
      out.write(" <p> TRABAJO GRUPAL DEL CURSO INTEGRADOR I: SISTEMAS - SOFTWARE </p>\n");
      out.write(" <span>Lima - Peru</span>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_redirect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_redirect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:redirect
    org.apache.taglibs.standard.tag.rt.core.RedirectTag _jspx_th_c_redirect_0 = (org.apache.taglibs.standard.tag.rt.core.RedirectTag) _jspx_tagPool_c_redirect_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.RedirectTag.class);
    _jspx_th_c_redirect_0.setPageContext(_jspx_page_context);
    _jspx_th_c_redirect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_redirect_0.setUrl("index.jsp");
    int _jspx_eval_c_redirect_0 = _jspx_th_c_redirect_0.doStartTag();
    if (_jspx_th_c_redirect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
      return true;
    }
    _jspx_tagPool_c_redirect_url_nobody.reuse(_jspx_th_c_redirect_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.nomCompletos()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
