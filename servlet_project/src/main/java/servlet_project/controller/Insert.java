package servlet_project.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_project.dao.EmployeeDao;
import servlet_project.dto.Employee;

@WebServlet("/i")
public class Insert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eid");

		int cid = Integer.parseInt(id);

		String name = req.getParameter("ename");
		String email = req.getParameter("empemail");
		String password = req.getParameter("emppassword");
		String gender = req.getParameter("gender");
		String country = req.getParameter("coun");
//		System.out.println(id + " " + name + " " + " " + email + " " + password + " " + gender + " " + country);
//		resp.getWriter().print("<h1>data inserted<h1>");

		Employee employee = new Employee();
		employee.setId(cid);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setGender(gender);
		employee.setCountry(country);

		System.out.println(employee);

		EmployeeDao employeeDao = new EmployeeDao();
		String msg = employeeDao.insert(employee);
		resp.getWriter().print(msg);
	}

}
