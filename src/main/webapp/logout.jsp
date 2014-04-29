<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%session.removeAttribute("username"); %>
<center><h2>you are succes fully logged out</h2>
<h3><a href="home.jsp"><font color="red">HOME</font></a></h3>
</center>


</body>
</html>