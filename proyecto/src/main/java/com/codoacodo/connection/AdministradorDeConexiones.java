package com.codoacodo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministradorDeConexiones {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/integrador_cac";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PASS);
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    public static void close(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void close(Connection cn) throws SQLException {
        if (cn != null) {
            cn.close();
        }
    }
}
