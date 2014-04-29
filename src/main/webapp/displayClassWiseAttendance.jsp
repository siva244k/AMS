<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import=java.util.* pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CLASSWISE</title>


</head>
<body>



	<table border="1" width="50%">
		<tr>

			<th>STUDENTROLL</th>
			<th>ATTENDANCEPERCENTAGE</th>

		</tr>

		<%
			Map<String, Double> m = (Map<String, Double>) request
					.getAttribute("inAtt");
			Iterator<String> itr = m.keySet().iterator();
			while (itr.hasNext()) {
		%><tr>
			<td><%=itr.next()%></td>
			<td><%=m.get(itr.next())%></td>
		</tr>
		<%
			}
		%>

	</table>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>