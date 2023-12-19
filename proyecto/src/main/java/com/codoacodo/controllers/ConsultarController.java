package com.codoacodo.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.connection.AdministradorDeConexiones;
import com.codoacodo.dto.*;
import java.sql.Timestamp;

@WebServlet("/api/ConsultarController")
public class ConsultarController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String sql = "SELECT * FROM oradores WHERE ID = " + id;

        try {
            Connection con = AdministradorDeConexiones.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                int idOrador = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String mail = rs.getString(4);
                String tema = rs.getString(5);
                Timestamp fechaAlta = rs.getTimestamp(6);

                Orador oraFromDb = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                req.setAttribute("orador", oraFromDb);
            }
            getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
           } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
