package com.codoacodo.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codoacodo.daos.OradorDAO;
import com.codoacodo.dto.*;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OradorDAO dao = new OradorDAO();
		List<Orador> listado = dao.selectOradores();
		
		req.setAttribute("listado", listado);
		
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}

