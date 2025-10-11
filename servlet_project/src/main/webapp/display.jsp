<%@page import="servlet_project.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<%List<Employee> a=(List<Employee>)request.getAttribute("objects");%>
<table border="">
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>gender</th>
<th>password</th>
<th>country</th>
<th>delete</th>
<th>update</th>
</tr>
<%for(Employee u:a){ %>
<tr>
<td><%=u.getId()%></td>
<td><%=u.getName()%></td>
<td><%=u.getEmail()%></td>
<td><%=u.getGender()%></td>
<td><%=u.getPassword()%></td>
<td><%=u.getCountry()%></td>
<td><a href="did?pk=<%=u.getId()%>">remove</a></td>
<td><a href="update.jsp?id=<%=u.getId()%>&&name=<%=u.getName()%>&&email=<%=u.getEmail()%>&&password=<%=u.getPassword()%>">edit</a></td>
<%} %>
</tr>
</table>
</body>
</html>