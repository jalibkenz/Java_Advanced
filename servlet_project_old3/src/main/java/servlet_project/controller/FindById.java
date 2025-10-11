package servlet_project.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_project.dao.EmployeeDao;
import servlet_project.dto.Employee;

@WebServlet("/fid")
public class FindById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("pk");
        int cid = 0;

        String htmlResponse = "<!DOCTYPE html><html><head><title>Employee Details</title>"
                + "<style>"
                + "body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background:#f4f6f8; display:flex; justify-content:center; padding-top:50px; }"
                + ".card { background:white; padding:30px 40px; border-radius:12px; box-shadow:0 8px 20px rgba(0,0,0,0.1); width:400px; text-align:center; }"
                + "h2 { color:#333; margin-bottom:20px; }"
                + "table { width:100%; border-collapse:collapse; }"
                + "td { padding:10px; text-align:left; border-bottom:1px solid #eee; }"
                + ".error { color:red; font-size:16px; }"
                + "</style></head><body><div class='card'>";

        try {
            cid = Integer.parseInt(id);
            EmployeeDao employeeDao = new EmployeeDao();
            Employee emp = (Employee) employeeDao.findById(cid); 

            if (emp != null) {
                htmlResponse += "<h2>Employee Details</h2>"
                        + "<table>"
                        + "<tr><td>ID:</td><td>" + emp.getId() + "</td></tr>"
                        + "<tr><td>Name:</td><td>" + emp.getName() + "</td></tr>"
                        + "<tr><td>Email:</td><td>" + emp.getEmail() + "</td></tr>"
                        + "<tr><td>Gender:</td><td>" + emp.getGender() + "</td></tr>"
                        + "<tr><td>Country:</td><td>" + emp.getCountry() + "</td></tr>"
                        + "</table>";
            } else {
                htmlResponse += "<p class='error'>Employee not found for ID: " + cid + "</p>";
            }
        } catch (NumberFormatException e) {
            htmlResponse += "<p class='error'>Invalid ID format! Please enter a numeric ID.</p>";
        }

        htmlResponse += "</div></body></html>";
        resp.getWriter().print(htmlResponse);
    }
}