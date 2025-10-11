<%@page import="servlet_project.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f6f8;
        margin: 20px;
    }

    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 30px;
    }

    table {
        border-collapse: collapse;
        width: 90%;
        margin: 0 auto;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        border-radius: 8px;
        overflow: hidden;
    }

    th, td {
        padding: 12px 20px;
        text-align: left;
    }

    th {
        background-color: #4CAF50;
        color: white;
        text-transform: uppercase;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tr:hover {
        background-color: #e0f7fa;
        transition: 0.3s;
    }

    td {
        color: #555;
    }

    @media (max-width: 768px) {
        table, th, td {
            font-size: 14px;
        }
    }
</style>
</head>
<body> 
<h1>Employee List</h1>
<% 
    List<Employee> employees = (List<Employee>) request.getAttribute("objects");
    if(employees != null && !employees.isEmpty()) {
%>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Gender</th>
        <th>Country</th>
        <th>DELETE</th>
        <th>UPDATE</th>
    </tr>
    <% for(Employee u : employees){ %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getPassword() %></td>
        <td><%= u.getGender() %></td>
        <td><%= u.getCountry() %></td>
        <td><a href="did?pk=<%= u.getId() %>">DEL</a></td>
        <td><a href="did?pk=<%= u.getId() %>">UPD</a></td>
    </tr>
    <% } %>
</table>
<% } else { %>
    <p style="text-align:center; color:#777; font-size:18px;">No employees found.</p>
<% } %>
</body>
</html>