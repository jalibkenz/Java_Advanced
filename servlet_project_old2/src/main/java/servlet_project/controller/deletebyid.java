package servlet_project.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_project.dao.EmployeeDao;

@WebServlet("/did")
public class deletebyid extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		
		String id = req.getParameter("pk");
		int cid = Integer.parseInt(id);
		
		
		
		EmployeeDao employeeDao = new EmployeeDao();
		Object msg = employeeDao.deletebyid(cid);
		resp.getWriter().print(msg);
		
	}

}
