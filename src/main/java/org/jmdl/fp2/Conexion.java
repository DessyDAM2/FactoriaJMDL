package org.jmdl.fp2;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://fp2.croh1mygfad5.eu-west-3.rds.amazonaws.com";
    private static final String USER = "admin";
    private static final String passwd = "FP2%SanAlberto";



    public static DataSource poolConexiones() {
        BasicDataSource datos = new BasicDataSource();
        datos.setUrl(URL);
        datos.setUsername(USER);
        datos.setPassword(passwd);
        datos.setInitialSize(10);
        return datos;
    }

    public static Connection conectar() throws SQLException {
        return poolConexiones().getConnection();
    }
}
