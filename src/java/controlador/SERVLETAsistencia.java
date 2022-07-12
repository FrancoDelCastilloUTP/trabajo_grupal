package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uml.Asistencias;
import uml.Empleado;

import modelo.OPERACIONESEmpleado;
import modelo.DAOAsistencias;

public class SERVLETAsistencia extends HttpServlet {

    DAOAsistencias obj=new DAOAsistencias();
    OPERACIONESEmpleado empSQL = new OPERACIONESEmpleado();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion") != null ? request.getParameter("accion") : "";

        if (accion.equals("entrada")) {
            MarcarEntrada(request, response);
        } else if (accion.equals("salida")) {
            MarcarSalida(request, response);
        } else if (accion.equals("consulta_01")) {
            ConsultaAsistenciasPorDocumento(request, response);
        } else if (accion.equals("consulta_02")) {
            ConsultaAsistenciasPorFechas(request, response);
        } else if (accion.equals("eliminar")) {
            EliminarAsistencia(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void EliminarAsistencia(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();

        String documento = request.getParameter("documento").trim();
        int idAsistencia = Integer.parseInt(request.getParameter("id"));

        boolean estadp = obj.EliminarAsistencia(idAsistencia);

        if (estadp) {
            request.setAttribute("mensaje_success", "Se eliminó correctamente la asistencia con el nro " + idAsistencia);
        }

        String pagina = "ControlAsistencia?accion=consulta_01&documento=" + documento;

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void ConsultaAsistenciasPorFechas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession();
        Empleado empLogeado = (Empleado) sesion.getAttribute("usuario");

        String inicio = request.getParameter("inicio");
        String fin = request.getParameter("fin");
        String pagina = "/PagMiAsistencia.jsp";

        List<Asistencias> lista = obj.ConsultarMisAsistencias(inicio, fin, empLogeado.getIdUsuario());

        if (lista.size() == 0) {
            request.setAttribute("mensaje_error", "No se encontraron asistencias en el rango de fechas: " + inicio + " - " + fin);
        }

        request.setAttribute("inicio", inicio);
        request.setAttribute("fin", fin);
        request.setAttribute("lista", lista);

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void ConsultaAsistenciasPorDocumento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String documento = request.getParameter("documento").trim();
        String pagina = "/PagAsistencias.jsp";

        List<Asistencias> lista = obj.BuscarAsistencia(documento);
        Empleado e = empSQL.BuscarEmpleado(documento);

        if (lista.size() == 0) {
            if (e != null) {
                request.setAttribute("mensaje_error", "No se encontraron marcaciones para el empleado: " + e.nomCompletos());
            } else {
                request.setAttribute("mensaje_error", "No se encontro el documento N°-" + documento + " registrado.");
            }
        }

        request.setAttribute("emp", e);
        request.setAttribute("documento", documento);
        request.setAttribute("lista", lista);

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void MarcarSalida(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String documento = request.getParameter("documento").trim();
        String pagina = "";

        Empleado e = empSQL.BuscarEmpleado(documento);

        if (e != null) {
            int existenciaMarcacion = obj.CantAsistenciasDiario(documento);

            if (existenciaMarcacion != 0) {
                boolean marcacion = obj.MarcarSalida(e.getIdUsuario());

                if (marcacion) {
                    request.setAttribute("emp", e);
                    request.setAttribute("mensaje", "GRACIAS POR INGRESAR TU SALIDA");
                    pagina = "/PagMensaje.jsp";
                } else {
                    request.setAttribute("documento", documento);
                    request.setAttribute("mensaje_error", "No se ha podido marcar la salida mas de 1 vez.");
                    pagina = "/index.jsp";
                }

            } else {
                request.setAttribute("documento", documento);
                request.setAttribute("mensaje_error", "El documento N°-" + documento + " no cuenta con una hora de entrada.");
                pagina = "/index.jsp";
            }
        } else {
            request.setAttribute("documento", documento);
            request.setAttribute("mensaje_error", "No se encontro el documento N°-" + documento + " registrado.");
            pagina = "/index.jsp";
        }

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void MarcarEntrada(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String documento = request.getParameter("documento").trim();
        String pagina = "";

        Empleado e = empSQL.BuscarEmpleado(documento);

        if (e != null) {
            int existenciaMarcacion = obj.CantAsistenciasDiario(documento);

            if (existenciaMarcacion == 0) {
                boolean marcacion = obj.MarcarEntrada(e.getIdUsuario());

                if (marcacion) {
                    request.setAttribute("emp", e);
                    request.setAttribute("mensaje", "GRACIAS POR INGRESAR TU ENTRADA");
                    pagina = "/PagMensaje.jsp";
                } else {
                    request.setAttribute("documento", documento);
                    request.setAttribute("mensaje_error", "No se ha podido marcar la asistencia.");
                    pagina = "/index.jsp";
                }

            } else {
                request.setAttribute("documento", documento);
                request.setAttribute("mensaje_error", "No se puede marcar asistencia mas 1 vez.");
                pagina = "/index.jsp";
            }
        } else {
            request.setAttribute("documento", documento);
            request.setAttribute("mensaje_error", "No se encontro el documento N°-" + documento + " registrado.");
            pagina = "/index.jsp";
        }

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
