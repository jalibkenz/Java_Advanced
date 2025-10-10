package servlet_project.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/l")
public class insert extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8983768378373690668L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("eid");
	String name = req.getParameter("ename");
	String phonenumber = req.getParameter("phn");
	String password = req.getParameter("pwd");
	String gender = req.getParameter("gender");
	
	String country = req.getParameter("count");
	System.out.println(id+" "+name+" "+phonenumber+" "+password+" "+gender+" "+ country);
	resp.getWriter().print("<h1>Innserted data</h1>");
	
	}

}
