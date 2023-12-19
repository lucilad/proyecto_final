package com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.daos.OradorDAO;
import com.codoacodo.dto.*;


@WebServlet("/CreateController")
public class CreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                
		String nombre = req.getParameter("nombreTextarea");
                String apellido = req.getParameter("apellidoTextarea");
                String mail = req.getParameter("mailTextarea");
                String tema = req.getParameter("temaTextarea");
		
   		OradorDAO dao = new OradorDAO();
                Orador ora= new Orador(nombre, apellido, mail,tema);
		dao.insertarOrador(ora);
		
		int registrosInsertados = dao.insertarOrador(ora);
		
		if (registrosInsertados > 0) {
		    // La inserción fue exitosa, redireccionar al ListadoController
		    resp.sendRedirect(req.getContextPath() + "/api/ListadoController");
		} else {
		    // Muestra un mensaje de error
		    resp.getWriter().println("Error al insertar el orador.");
                    resp.getWriter().println(nombre);
                    resp.getWriter().println(apellido);
                    resp.getWriter().println(mail);
                    resp.getWriter().println(tema);
		}
	}
    }

