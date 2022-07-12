package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uml.Empleado;
import modelo.OPERACIONESEmpleado;
import modelo.OPERACIONESHorarios;
import modelo.OPERACIONESTipoDocumento;
import modelo.OPERACIONESUsuario;

public class SERVLETEmpleado extends HttpServlet {

    OPERACIONESEmpleado empSQL = new OPERACIONESEmpleado();
    OPERACIONESUsuario usuariosSQL = new OPERACIONESUsuario();
    OPERACIONESHorarios horariosSQL = new OPERACIONESHorarios();
    OPERACIONESTipoDocumento tipoDocSQL = new OPERACIONESTipoDocumento();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equals("datos")) {
            MisDatos(request, response);
        } else if (accion.equals("guardar_cambios")) {
            EditarCambios(request, response);
        } else if (accion.equals("consulta_03")) {
            ConsultaEmpleados(request, response);
        } else if (accion.equals("nuevo")) {
            NuevoEmpleado(request, response);
        } else if (accion.equals("guardar_emp")) {
            GuardarEmpleado(request, response);
        }
    }

    protected void GuardarEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pagina = "/PagNuevoEmpleado.jsp";

        Empleado e = new Empleado();
        e.setNroDocumento(request.getParameter("documento").trim());
        e.setNombres(request.getParameter("nombres").trim());
        e.setApellidoPaterno(request.getParameter("paterno").trim());
        e.setApellidoMaterno(request.getParameter("materno").trim());
        e.setGenero(request.getParameter("genero"));
        e.setFechaNacimiento(request.getParameter("fecha_nacimiento"));
        e.setCorreoElectronico(request.getParameter("correo").trim());
        e.setDireccion(request.getParameter("direccion").trim());
        e.setTelefono(request.getParameter("telefono").trim());
        e.setNomCargo(request.getParameter("cargo").trim());
        e.setIdTipoUsuario(Integer.parseInt(request.getParameter("tipo_usuario")));
        e.setIdHorario(Integer.parseInt(request.getParameter("horario")));
        e.setIdTipoDocumento(Integer.parseInt(request.getParameter("tipo_documento")));

        int valDocumento = empSQL.ValidarDocumento(e.getNroDocumento());

        if (valDocumento == 0) {
            int valCorreo = empSQL.ValidarCorreoElectronico(e.getCorreoElectronico());

            if (valCorreo == 0) {
                boolean estado = empSQL.GuardarDatos(e);

                if (estado) {
                    pagina = "/ControlEmpleado?accion=nuevo";
                    request.setAttribute("mensaje_success", "Empleado registrado correctamente!!");
                } else {
                    request.setAttribute("mensaje_error", "No se ha podido guardar datos del empleado.");
                }
            } else {
                request.setAttribute("mensaje_error", "El correo " + e.getCorreoElectronico() + " no se encuentra disponible.");
            }
        } else {
            request.setAttribute("mensaje_error", "El documento N°" + e.getNroDocumento() + " no se encuentra disponible.");
        }

        request.setAttribute("emp", e);
        request.setAttribute("tipos_uuarios", usuariosSQL.ListarTiposUsuarios());
        request.setAttribute("horarios", horariosSQL.ListarHorarios());
        request.setAttribute("tipos_documentos", tipoDocSQL.ListarTiposDocumentos());
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void NuevoEmpleado(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pagina = "/PagNuevoEmpleado.jsp";

        request.setAttribute("emp", new Empleado());
        request.setAttribute("tipos_uuarios", usuariosSQL.ListarTiposUsuarios());
        request.setAttribute("horarios", horariosSQL.ListarHorarios());
        request.setAttribute("tipos_documentos", tipoDocSQL.ListarTiposDocumentos());
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void ConsultaEmpleados(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String documento = request.getParameter("documento").trim();
        String pagina = "/PagBuscarEmpleado.jsp";

        List<Empleado> lista = empSQL.BuscarEmpleados(documento);

        if (lista.size() == 0) {
            request.setAttribute("mensaje_error", "No se encontraron resultados con el documento N°- : " + documento);
        }

        request.setAttribute("documento", documento);
        request.setAttribute("lista", lista);
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void EditarCambios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Empleado e = new Empleado();
        e.setNombres(request.getParameter("nombres"));
        e.setApellidoPaterno(request.getParameter("paterno"));
        e.setApellidoMaterno(request.getParameter("materno"));
        e.setNroDocumento(request.getParameter("documento"));
        e.setDireccion(request.getParameter("direccion"));
        e.setFechaNacimiento(request.getParameter("fecha"));
        e.setCorreoElectronico(request.getParameter("correo"));
        e.setPass(request.getParameter("pass"));
        e.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
        e.setIdEmpleado(Integer.parseInt(request.getParameter("id_emp")));

        boolean estado = empSQL.EditarDatos(e);

        if (estado) {
            request.setAttribute("mensaje_success", "Los datos del usuario se actualizaron correctamente.");
        } else {
            request.setAttribute("mensaje_error", "No se ha podido guardar datos del usuario.");
        }

        String pagina = "ControlEmpleado?accion=datos";

        request.getRequestDispatcher(pagina).forward(request, response);
    }

    protected void MisDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();

        Empleado empLogeado = (Empleado) sesion.getAttribute("usuario");

        Empleado e = empSQL.BuscarEmpleado(empLogeado.getIdUsuario());

        request.setAttribute("emp", e);

        String pagina = "/PagMisDatos.jsp";

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
