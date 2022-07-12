package modelo;

import modelo.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uml.TipoDocumento;
import uml.TipoUsuario;

public class OPERACIONESTipoDocumento {

    Database cn = new Database();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<TipoDocumento> ListarTiposDocumentos() {
        List<TipoDocumento> lista = new ArrayList<>();
        try {
            String sql = "select  * from tipos_documento order by descripcion asc";
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoDocumento e = new TipoDocumento();
                e.setIdTipoDocumento(rs.getInt(1));
                e.setDescDocumento(rs.getString(2));
                lista.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
