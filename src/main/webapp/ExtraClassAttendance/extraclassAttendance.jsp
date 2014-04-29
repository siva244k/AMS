<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" import="com.siva.bean.*"
	import="com.siva.service.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ExtraClassAttendance</title>
</head>
<body>

	<h1>
		hi
		<%=session.getAttribute("teacher") %>
		your extra classes are scheduled here
	</h1>
	<%ArrayList l=(ArrayList)request.getAttribute("classes");
%>
	<center>
		<table border=2>
			<tr>
				<th>DATEOFCLASS</th>
				<th>PERIOD</th>
				<th>CLASSDETAILS</th>

			</tr>

			<% 
ClassMapper cm=new ClassMapper();
for(int i=0;i<l.size();i++)
{
	ExtraClassBean ab=(ExtraClassBean)l.get(i);
	%><tr>
				<td>
					<% out.println(ab.getDateofextraclass());%>
				</td>


				<td>
					<% out.println(ab.getPeriod());%>
				</td>
				<td><a
					href="http://localhost:8081/AMS/StudentCheckBoxServlet?classid=<%=ab.getClassid()%>&subject=<%=ab.getSubject()%>">
						<% out.println(cm.mapper(ab.getClassid()));
	%>
				</a><br />
				<br />
					<%
	out.println(ab.getSubject());
	%></td>
				<%
}

%>
			</tr>
		</table>
	</center>

</body>
</html>