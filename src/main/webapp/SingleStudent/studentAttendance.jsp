<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" import="com.siva.bean.*"
	import="com.siva.service.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single Student Attendance</title>
</head>
<body>
	<h1>
		Your attendance is
		<%=request.getAttribute("per")%></h1>
	<center>
		<table border="2">
			<tr>
				<th>Subectname</th>
				<th>Total Classes</th>
				<th>AttendedClasses</th>
			</tr>

			<%
String roll=(String)request.getAttribute("roll");
ArrayList<Subjects> al=(ArrayList<Subjects>)request.getAttribute("attendance");


for(int i=0;i<al.size();i++)
{
	Subjects sb=al.get(i);
	%><tr>
				<td>
					<%
	out.println(sb.getSubjectname());
	%>
				</td>
				<td>
					<%
	 out.println(sb.getTotalclasses());%>
				</td>
				<td>
					<% out.println(sb.getAttendentlasses());%>
				</td>
			</tr>
			<% 	
	
}



%>
			<%

%>
		</table>
	</center>
</body>
</html>