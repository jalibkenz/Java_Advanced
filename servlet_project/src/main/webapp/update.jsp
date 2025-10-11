<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>edit details</h1>
<form action="u" method="post">
<input type="hidden" placeholder="enter id" name="eid" value="<%=request.getParameter("id")%>"><br>
<input type="text" placeholder="enter name" name="ename" value="<%=request.getParameter("name")%>"><br>
<input type="email" placeholder="enter email" name="empemail" value="<%=request.getParameter("email")%>"><br>
<input type="number" placeholder="enter password" name="emppassword" value="<%=request.getParameter("password")%>"><br>
male:   <input type="radio" name="gender" value="male"><br>
female: <input type="radio" name="gender" value="female"><br>
country: <select name="coun">
<option>IND</option>
<option>PAK</option>
<option>CHN</option>
</select><br>
<button>update</button>
<button>cancel</button>
</form>
</div>
</body>
</html>