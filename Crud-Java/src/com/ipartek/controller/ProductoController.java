package com.ipartek.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.dao.ProductoDAO;
import com.ipartek.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/productos" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion=request.getParameter("opcion");
		if (opcion.equals("crear")) {
			System.out.println("presiono crear");
			RequestDispatcher requestDispatcher= request.getRequestDispatcher("views/crear.jsp");
			requestDispatcher.forward(request, response);
		}else if("listar".equals(opcion)) {
			System.out.println("presiono listar");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String opcion=request.getParameter("opcion");
		ProductoDAO productoDAO=new ProductoDAO();
		Producto producto=new Producto();
		producto.setNombre(request.getParameter("nombre"));
		producto.setIdUsuario(1);//TODO cambiar esta id por la del usuario conectado
		
		try {
			productoDAO.guardar(producto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
