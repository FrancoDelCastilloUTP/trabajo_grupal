package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.Empleado;

public class DAOEmpleado {
    Database cn = new Database();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Empleado BuscarEmpleado(String documento) {
        Empleado e = null;
        try {
            String sql = "select  nombres , apellido_paterno , apellido_materno ,u.id ,telefono ,"
                    + " correo_electronico , fecha_nacimiento , nom_cargo ,e.id "
                    + "from empleados e inner join tipos_documento t on t.id = e.id_tipo_documento "
                    + "inner join usuarios u "
                    + "on u.id_empleado = e.id "
                    + "where nro_documento = ? ";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();

            if (rs.next()) {
                e = new Empleado();
                e.setNombres(rs.getString(1));
                e.setApellidoPaterno(rs.getString(2));
                e.setApellidoMaterno(rs.getString(3));
                e.setIdUsuario(rs.getInt(4));
                e.setTelefono(rs.getString(5));
                e.setCorreoElectronico(rs.getString(6));
                e.setFechaNacimiento(rs.getString(7));
                e.setNomCargo(rs.getString(8));
                e.setIdEmpleado(rs.getInt(9));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }
    
    public Empleado BuscarEmpleado(int idUsuario) {
        Empleado e = null;
        try {
            String sql = "select nombres , apellido_paterno , apellido_materno , fecha_nacimiento , "
                    + " direccion , correo_electronico , contrasenia , nro_documento , e.id , u.id "
                    + "from empleados e inner join usuarios u "
                    + "on u.id_empleado = e.id "
                    + "where u.id = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                e = new Empleado();
                e.setNombres(rs.getString(1));
                e.setApellidoPaterno(rs.getString(2));
                e.setApellidoMaterno(rs.getString(3));
                e.setFechaNacimiento(rs.getString(4));
                e.setDireccion(rs.getString(5));
                e.setCorreoElectronico(rs.getString(6));
                e.setPass(rs.getString(7));
                e.setNroDocumento(rs.getString(8));
                e.setIdEmpleado(rs.getInt(9));
                e.setIdUsuario(rs.getInt(10));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return e;
    }

    public List<Empleado> BuscarEmpleados(String documento) {
        List<Empleado> lista = new ArrayList<>();
        try {
            String sql = "select  nombres , apellido_paterno , apellido_materno ,u.id ,telefono , correo_electronico , "
                    + " fecha_nacimiento , nom_cargo ,e.id , t.descripcion "
                    + "from empleados e inner join tipos_documento t on t.id = e.id_tipo_documento "
                    + "inner join usuarios u "
                    + "on u.id_empleado = e.id "
                    + "where ? = '' or nro_documento = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            ps.setString(2, documento);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setNombres(rs.getString(1));
                e.setApellidoPaterno(rs.getString(2));
                e.setApellidoMaterno(rs.getString(3));
                e.setIdUsuario(rs.getInt(4));
                e.setTelefono(rs.getString(5));
                e.setCorreoElectronico(rs.getString(6));
                e.setFechaNacimiento(rs.getString(7));
                e.setNomCargo(rs.getString(8));
                e.setIdEmpleado(rs.getInt(9));
                e.setNroDocumento(rs.getString(10));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public boolean EditarDatos(Empleado e) {
        boolean estado = false;
        try {
            String sql = " update empleados set nombres = ?, apellido_paterno = ? , "
                    + "apellido_materno =?, fecha_nacimiento = ? , direccion = ? , "
                    + "correo_electronico =? , nro_documento = ? where id = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getApellidoPaterno());
            ps.setString(3, e.getApellidoMaterno());
            ps.setString(4, e.getFechaNacimiento());
            ps.setString(5, e.getDireccion());
            ps.setString(6, e.getCorreoElectronico());
            ps.setString(7, e.getNroDocumento());
            ps.setInt(8, e.getIdEmpleado());

            if (ps.executeUpdate() > 0) {
                estado = true;

                sql = "update usuarios set contrasenia= ? where id_empleado = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, e.getPass());
                ps.setInt(2, e.getIdEmpleado());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    public boolean GuardarDatos(Empleado e) {
        boolean estado = false;
        int idEmp = MaximoIdEmpleado();
        int idUsuario = MaximoIdUsuario();
        try {
            String sql = "insert into usuarios(id , id_empleado , id_tipo_usuario , contrasenia) values(? , ? , ? , ?)";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setInt(2, idEmp);
            ps.setInt(3, e.getIdTipoUsuario());
            ps.setString(4, e.getNroDocumento());

            if (ps.executeUpdate() > 0) {
                sql = "insert into empleados(id , id_tipo_documento , id_horario,nom_cargo , genero , nro_documento , nombres , apellido_paterno , apellido_materno , fecha_nacimiento , direccion , telefono , correo_electronico , fecha_entrada) values(?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE())";
                ps = con.prepareStatement(sql);
                ps.setInt(1, idEmp);
                ps.setInt(2, e.getIdTipoDocumento());
                ps.setInt(3, e.getIdHorario());
                ps.setString(4, e.getNomCargo());
                ps.setString(5, e.getGenero());
                ps.setString(6, e.getNroDocumento());
                ps.setString(7, e.getNombres());
                ps.setString(8, e.getApellidoPaterno());
                ps.setString(9, e.getApellidoMaterno());
                ps.setString(10, e.getFechaNacimiento());
                ps.setString(11, e.getDireccion());
                ps.setString(12, e.getTelefono());
                ps.setString(13, e.getCorreoElectronico());

                if (ps.executeUpdate() > 0) {
                    estado = true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }

    public int MaximoIdEmpleado() {
        int id = 0;
        try {
            String sql = "select ifnull(max(id) , 0) + 1 from empleados";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public int MaximoIdUsuario() {
        int id = 0;
        try {
            String sql = "select ifnull(max(id) , 0) + 1 from usuarios";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public int ValidarCorreoElectronico(String correo) {
        int res = 0;
        try {
            String sql = "select count(1) from empleados where correo_electronico = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                res = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public int ValidarDocumento(String documento) {
        int res = 0;
        try {
            String sql = "select count(1) from empleados where nro_documento = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();

            if (rs.next()) {
                res = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    
    
}
