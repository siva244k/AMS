<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" import="com.siva.bean.DialyAttBean"
	import="com.siva.service.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DialyAttendance</title>
</head>
<body>
	<center>
		<h1>
			Welcome
			<%=session.getAttribute("teacher")%>
			your Time Table is
		</h1>
		<h3>
			<%
				Map<String, DialyAttBean> m = (Map<String, DialyAttBean>) session
						.getAttribute("timetable");
			%>
		</h3>
		<table border="2">
			<tr>
				<th>DAY</th>
				<th>PERIOD1</th>
				<th>PERIOD2</th>
				<th>PERIOD3</th>
				<th>PERIOD4</th>
				<th>PERIOD5</th>
				<th>PERIOD6</th>
			</tr>


			<%
				String a[] = { "monday", "tuesday", "wednesday", "thursday",
						"friday", "saturday" };
				ClassMapper cm = new ClassMapper();
				for (int k = 0; k < a.length; k++)

				{
			%><td>
				<%
					out.println(a[k].toUpperCase());
				%>
			</td>
			<%
				for (int i = 1; i < 7; i++) {
			%><td>
				<%
					DialyAttBean db = m.get(a[k] + "" + i);
							if (db != null) {
								out.println(db.getSubjectname());
				%><a
				href="http://sleepy-island-3750.herokuapp.com/StudentCheckBoxServlet?classid=<%=db.getClassid()%>&subject=<%=db.getSubjectname()%>">
					<%
						out.println(cm.mapper(db.getClassid()));

								}
					%>
			
			</td>
			<%
	}

%>

			</tr>
			<%
}
%>



		</table>
	</center>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>