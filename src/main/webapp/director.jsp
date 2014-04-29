<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOD PAGE</title>
</head>
<body>
	<h3>WELCOME DIRECTOR</h3>
	<br />
	<br />
	<table align="center">
		<tr>
			<td><a href="classwiseattendance.jsp"><font size="4"
					color="red">ClasswiseAttenanceReport</font></a></td>
		</tr>
		<tr>
			<td><a href="subjectwiseattendancereport.jsp"><font size="4"
					color="red">SubjectWiseAttendanceReport</font></a></td>
		</tr>
		<tr>
			<td><a href="changepassword.jsp"><font size="4" color="red">ChangePassword</font></a></td>
		</tr>
		<tr>
			<td><a href="logout.jsp"><font size="4" color="red">LogOut</font></a></td>
		</tr>
	</table>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>