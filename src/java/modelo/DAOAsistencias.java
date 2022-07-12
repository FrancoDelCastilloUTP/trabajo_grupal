package modelo;
import modelo.Database;
import java.util.*;
import java.sql.*;
import uml.Asistencias;

public class DAOAsistencias {
    
    Database cn = new Database();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
        public boolean MarcarEntrada(int idUsuario) {
        boolean estado = false;
        try {
            String sql = "insert into asistencias(id_usuario , fecha_entrada , hora_entrada) values(? ,  SYSDATE(), CURTIME())";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);

            if (ps.executeUpdate() > 0) {
                estado = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }
        
    public boolean MarcarSalida(int idUsuario) {
        boolean estado = false;
        try {
            String sql = "update asistencias set fecha_salida = SYSDATE() , hora_salida = CURTIME() "
                    + "where id_usuario = ? and fecha_salida is null and hora_salida is null";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);

            if (ps.executeUpdate() > 0) {
                estado = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }
    
        public int CantAsistenciasDiario(String documento) {
        int res = 0;
        try {
            String sql = "select count(1) from asistencias "
                    + "where fecha_entrada = DATE_FORMAT(now(), '%Y-%m-%d') "
                    + "and id_usuario in (select u.id  "
                    + "from empleados e inner join usuarios u "
                    + "on e.id = u.id_empleado "
                    + " where nro_documento =?)";
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
        
        
    public List<Asistencias> BuscarAsistencia(String documento) {
        List<Asistencias> lista = new ArrayList<>();
        try {
            String sql = "select id , fecha_entrada , hora_entrada, fecha_salida , hora_salida "
                    + " from asistencias "
                    + " where id_usuario in (select u.id "
                    + " from empleados e inner join usuarios u"
                    + " on e.id = u.id_empleado "
                    + " where nro_documento = ?) order by 2 asc , 3 asc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, documento);
            rs = ps.executeQuery();

            while (rs.next()) {
                Asistencias e = new Asistencias();
                e.setIdAsistencia(rs.getInt(1));
                e.setFechaEntrada(rs.getString(2));
                e.setHoraEntrada(rs.getString(3));
                e.setFechaSalida(rs.getString(4));
                e.setHoraSalida(rs.getString(5));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }


    public List<Asistencias> ConsultarMisAsistencias(String inicio, String fin, int idUsuario) {
        List<Asistencias> lista = new ArrayList<>();
        try {
            String sql = "select id , fecha_entrada , hora_entrada, fecha_salida , hora_salida "
                    + "from asistencias "
                    + "where fecha_entrada between ? and ? and id_usuario = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, inicio);
            ps.setString(2, fin);
            ps.setInt(3, idUsuario);
            rs = ps.executeQuery();

            while (rs.next()) {
                Asistencias e = new Asistencias();
                e.setIdAsistencia(rs.getInt(1));
                e.setFechaEntrada(rs.getString(2));
                e.setHoraEntrada(rs.getString(3));
                e.setFechaSalida(rs.getString(4));
                e.setHoraSalida(rs.getString(5));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
    
    public boolean EliminarAsistencia(int idAsistencia) {
        boolean estado = false;

        try {
            String sql = "delete from asistencias where id = ?";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAsistencia);

            if (ps.executeUpdate() > 0) {
                estado = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estado;
    }
    
}
