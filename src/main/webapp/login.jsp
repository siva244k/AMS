<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>


	<form id="loginform" action="AuthenticationServlet" method="POST">
		<center>
			<table border="3" cellpadding="2" cellspacing="2">

				<tr>
					<td>USERNAME</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="login"></td>
				</tr>

			</table>
		</center>

	</form>
	
</body>
</html>