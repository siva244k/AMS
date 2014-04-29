<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student checkbox attd</title>
</head>
<body>
	<center>
		<form action="AttendanceInsertServlet" method="post">
			<h1>Tick Who are Abscent</h1>
			<br> <br> Students:
			<%
				ArrayList l = (ArrayList) request.getAttribute("students");
				for (Object s : l) {
			%>
			<br /> <input type="checkbox" name="student" check="true"
				value="<%=(String) s%>"><%=(String) s%>
			<%
				}
			%>
			<input type="hidden" name="subject"
				value="<%=request.getParameter("subject")%>"> <input
				type="hidden" name="classid"
				value="<%=request.getAttribute("classid")%>"> <br /> <input
				type="submit" value="submit">

		</form>
	</center>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>