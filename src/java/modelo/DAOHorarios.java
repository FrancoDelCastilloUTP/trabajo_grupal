package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.Horarios;

public class DAOHorarios {
    
    Database cn = new Database();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Horarios> ListarHorarios() {
        List<Horarios> lista = new ArrayList<>();
        
        try {
            String sql = "select id , hora_entrada , hora_salida from horarios order by hora_entrada asc;";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Horarios h = new Horarios();
                h.setIdHorario(rs.getInt(1));
                h.setHora_entrada(rs.getString(2));
                h.setHora_salida(rs.getString(3));
                lista.add(h);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}
