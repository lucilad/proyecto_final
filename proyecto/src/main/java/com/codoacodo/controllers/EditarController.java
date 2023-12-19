package com.codoacodo.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.daos.OradorDAO;
import com.codoacodo.dto.*;
import java.sql.SQLException;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
            try{
		String id = req.getParameter("id");
		OradorDAO dao = new OradorDAO();
		
		Orador oraFromDb = dao.obtenerPorId(Long.parseLong(id));
		
		req.setAttribute("orador", oraFromDb);
		
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	catch(SQLException e){
            e.printStackTrace();
        }}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String tema = req.getParameter("tema");
		
		OradorDAO dao = new OradorDAO();
		Orador ora= new Orador(nombre,apellido,mail,tema);
		
		dao.actualizarOrador(ora);

		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}

