<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllotSubject</title>
<script type="text/javascript" language="javascript"
	src="ajaxforteacher.js"></script>
</head>
<body>



	<h1>
		For Teacher<br> <br>
		<%
			String s = (String) request.getAttribute("teacher");
			out.println(s.toUpperCase());
		%>
	</h1>





	<form id="myform" action="AllotSubjectsecondServlet" method="POST">




		<input type="hidden" name="classid"
			value="<%=request.getAttribute("classid")%>"> <input
			type="hidden" name="teacher" value="<%=s%>">
		<table cellpadding="2" cellspacing="2" border="4" align="center">


			<tr>
				<td>SUBJECT</td>
				<td><select name="subject">
						<%
							ArrayList<String> al = (ArrayList<String>) request
									.getAttribute("subjects");
							for (String t : al) {
						%>

						<option value="<%=t%>"><%=t.toUpperCase()%></option>
						<%
							}
						%>
				</select></td>
			<tr>
				<td>DAY</td>




				<td><select name="day">
						<option value="monday">MONDAY</option>
						<option value="tuesday">TUESDAY</option>
						<option value="wednesday">WEDNESDAY</option>
						<option value="thursday">THURSDAY</option>
						<option value="friday">FRIDAY</option>
						<option value="saturday">SATURDAY</option>
				</select></td>


			</tr>


			<tr>
				<td>PERIOD</td>




				<td><select name="period">
						<option value="1">FIRST</option>
						<option value="2">SECOND</option>
						<option value="3">THIRD</option>
						<option value="4">FOURTH</option>
						<option value="5">FIFTH</option>
						<option value="6">SIXTH</option>
				</select></td>


			</tr>

			<tr>
				<td>ALLOTMENTTYPE</td>



				<td><select name="allotment">
						<option value="permanent">PERMANENT</option>
						<option value="temporary">TEMPORARY</option>

				</select></td>


			</tr>




			<tr>
				<td><input type="submit" value="ALLOT"></td>
			</tr>



		</table>


	</form>






	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>