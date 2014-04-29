<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>teacher</title>
</head>
<body>
	<h3>Welcome Teacher</h3>


	<h1>
		hi
		<%=session.getAttribute("teacher")%></h1>
	<table align="center">
		<tr>
			<td><a href="dialyAttendance.jsp"><font size="4" color="red">DAILY
						ATTENDANCE</font></a></td>
		</tr>
		<tr>
			<td><a
				href="http://sleepy-island-3750.herokuapp.com/ExtraClassSearchServlet?teacher=<%=session.getAttribute("teacher")%>"><font
					size="4" color="red">ATTENDANCE FOR EXTRA CLASS</font></a></td>
		</tr>

		<tr>
			<td><a href="changepasswordteacher.jsp"><font size="4" color="red">CHANGE
						PASSWORD</font></a></td>
		</tr>
		<tr>
			<td><a href="logout.jsp"><font size="4" color="red">LOGOUT</font></a></td>
		</tr>
	</table>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>