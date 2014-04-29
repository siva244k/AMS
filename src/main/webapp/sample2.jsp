<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SubjectWiseAttendancereport</title>
</head>
<body bgcolor="cyan">
	<%
		Object m = request.getAttribute("subjectwiaseatt");
		Object subject = request.getAttribute("subjectname");

		Map<String, Double> s = (Map<String, Double>) m;
		String subjectname = (String) subject;
	%>
	<h1>
		Subject Name is
		<%
		out.println(subjectname);
	%>
	</h1>

	<%
		Set t = s.keySet();
		double d = 0;
		double j = t.size();
		Iterator itr = t.iterator();
		while (itr.hasNext()) {
			String ar = (String) itr.next();

			out.println(ar + "has attendance Percentage is " + s.get(ar));
			d = d + s.get(ar);
	%>
	<br />
	<br />
	<%
		}
	%>
	<h2>The Total Class avg Subject wise attendance percentage is</h2>
	<h1>
		<%
			out.println(Math.ceil(d / j));
		%>
	</h1>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>