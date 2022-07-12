package modelo;

import java.sql.Connection;

public class ProbarConexion {

    public static void main(String[] args) {
        Database cn = new Database();
        cn.getConexion();
    }

}
