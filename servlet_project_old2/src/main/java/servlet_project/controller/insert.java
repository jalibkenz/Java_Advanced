package servlet_project.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_project.dao.EmployeeDao;
import servlet_project.dto.Employee;
@WebServlet("/l")
public class insert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("eid");
	int cid = Integer.parseInt(id);
	String name = req.getParameter("ename");
//	String phonenumber = req.getParameter("phn");
	String password = req.getParameter("pwd");
	String gender = req.getParameter("gender");
	String country = req.getParameter("count");
//	System.out.println(id+" "+name+" "+phonenumber+" "+password+" "+gender+" "+ country);
//	resp.getWriter().print("<h1>Innserted data</h1>");
	
	
	Employee employee = new Employee();
	employee.setId(cid);
	employee.setName(name);
	
	employee.setPassword(password);
	employee.setGender(gender);
	employee.setCountry(country);
	
	System.out.println(employee);
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	String msg = employeeDao.insert(employee);
	resp.getWriter().print(msg);
	}

}
