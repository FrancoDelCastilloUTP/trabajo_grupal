package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uml.Empleado;
import uml.Usuarios;
import modelo.OPERACIONESUsuario;

public class SERVLETUsuario extends HttpServlet {

    OPERACIONESUsuario usuarioSQL = new OPERACIONESUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";

        if (accion.equals("login")) {
            IniciarSesion(request, response);
        } else if (accion.equals("logout")) {
            CerrarSesion(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    protected void IniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        Usuarios user = new Usuarios();
        user.setCorreo(request.getParameter("correo"));
        user.setContrasenia(request.getParameter("pass"));

        String pagina = "";

        Empleado e = usuarioSQL.IniciarSesion(user);

        if (e != null) {
            if (!e.getDescripTipoUsuario().equalsIgnoreCase("enfermero")) {
                sesion.setAttribute("usuario", e);
                pagina = "ControlEmpleado?accion=datos";
            } else {
                  request.setAttribute("mensaje_error", "Usted no cuenta con el rol para ingresar al sistema.");
                pagina = "/PagLogin.jsp";
            }

        } else {
            request.setAttribute("mensaje_error", "Usuario y/o incorrecto.");
            pagina = "/PagLogin.jsp";
        }

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void CerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);

        request.setAttribute("mensaje_success", "Sesión Cerrada correctamente..");

        String pagina = "/PagLogin.jsp";

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
