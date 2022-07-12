package modelo;

import uml.Empleado;
import uml.Usuarios;
import uml.TipoUsuario;
import modelo.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OPERACIONESUsuario {

    Database cn = new Database();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleado IniciarSesion(Usuarios obj) {
        Empleado e = null;
        try {
            String sql = "select e.id , nombres , apellido_paterno , apellido_materno , t.descripcion , u.id\n"
                    + "from usuarios u\n"
                    + "inner join empleados e\n"
                    + "on u.id_empleado = e.id\n"
                    + "inner join tipos_usuario t\n"
                    + "on t.id = u.id_tipo_usuario\n"
                    + "where e.correo_electronico = ? and u.contrasenia = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getCorreo());
            ps.setString(2, obj.getContrasenia());
            rs = ps.executeQuery();

            if (rs.next()) {
               e = new Empleado();
               e.setIdEmpleado(rs.getInt(1));
               e.setNombres(rs.getString(2));
               e.setApellidoPaterno(rs.getString(3));
               e.setApellidoMaterno(rs.getString(4));
               e.setDescripTipoUsuario(rs.getString(5));
               e.setIdUsuario(rs.getInt(6));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
    
    public List<TipoUsuario> ListarTiposUsuarios() {
        List<TipoUsuario> lista = new ArrayList<>();
        try {
            String sql = "select  * from tipos_usuario order by descripcion asc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoUsuario e = new TipoUsuario();
                e.setIdTipoUsuario(rs.getInt(1));
                e.setDescTipoUsuario(rs.getString(2));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
