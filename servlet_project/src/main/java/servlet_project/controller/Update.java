package servlet_project.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_project.dao.EmployeeDao;
import servlet_project.dto.Employee;

@WebServlet("/u")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("eid");

		int cid = Integer.parseInt(id);

		String name = req.getParameter("ename");
		String email = req.getParameter("empemail");
		String password = req.getParameter("emppassword");
		String gender = req.getParameter("gender");
		String country = req.getParameter("coun");
		
		Employee employee=new Employee();
		employee.setId(cid);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setGender(gender);
		employee.setCountry(country);
		
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.update(employee);
		
		List<Employee> list=employeeDao.fetchAll();
		//resp.getWriter().print(list);
		
		req.setAttribute("objects", list);
		
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("display.jsp");
		requestDispatcher.forward(req, resp);
	}

}
