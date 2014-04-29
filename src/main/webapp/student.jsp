<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>StudentPage</title>
</head>
<body>
	<center>
		<form id="studentroll" method="post" action="StudentServlet">
			<table border="2" cellpadding="2" cellspacing="2">
				<tr>
					<td>ROLLNO</td>
					<td><input type="text" name="roll" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="GET ATTENDANCE"></td>
				</tr>
			</table>
		</form>
	</center>
	
</body>
</html>