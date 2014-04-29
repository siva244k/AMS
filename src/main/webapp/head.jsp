<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<center>
		<div">

			<h1>
				<p style="color: green">
					<%
				out.print("AMS   " + new java.util.Date().toLocaleString());
					
			%>
			<h3><font size="2" align="left"><%
			if(session.getAttribute("username")!=null)
			out.println("welcome "+session.getAttribute("username")); %></font></h3>
				</p>
			</h1>
			
			</table>
		</div>


	</center>


</body>
</html>