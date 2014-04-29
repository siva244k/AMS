<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is very Sample One</title>
</head>
<body bgcolor="cyan">
	<h1>The Class Wise ATTendance</h1>
	<%
		Object m = request.getAttribute("inAtt");

		Map<String, Double> s = (Map<String, Double>) m;

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
	<h2>The ClassWise attendance percentage is</h2>
	<h1>
		<%
			out.println(Math.ceil(d / j));
		%>
	</h1>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>