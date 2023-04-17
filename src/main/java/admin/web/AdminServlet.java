package admin.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import admin.bean.Admin;
import admin.dao.AdminBase;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminBase adminBase;
	    
	public AdminServlet() {
	   this.adminBase = new AdminBase();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertAdmin(request, response);
			break;
		case "/delete":
			deleteAdmin(request, response);
			break;
		default:
			listAdmin(request, response);
			break;
		}
	}
	// form ajout
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-form.jsp");
		dispatcher.forward(request, response);
	}
	//
	// delete admin
	private void deleteAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			adminBase.deleteAdmin(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listadmin");
	}
	
	// insert admin
	private void insertAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		
		Admin newAdmin = new Admin(nom, email, telephone, password);
		try {
			adminBase.insertAdmin(newAdmin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listadmin");
	}
	
	// liste
	private void listAdmin(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		List<Admin> listAdmin = adminBase.selectallAdmin();
		request.setAttribute("listAdmin", listAdmin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-list.jsp");
		dispatcher.forward(request, response);
	}

}
