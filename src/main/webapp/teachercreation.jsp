<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function password() {
		var password = document.forms["myform"]["password"].value;
		var confirmpassword = document.forms["myform"]["confirmpassword"].value;

		if (password == '') {
			alert('here password is empty');
		}

	}
</script>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TeacherCreation</title>
</head>
<body>






	<form id="myform" action="TeacherCreationServlet" method="POST"
		onsubmit="password()">
		<table cellpadding="2" cellspacing="2" border="4" align="center">
			<tr>
				<td>DepartMent</td>
				<td><select name="department"><option value="ECE">ECE</option>
						<option value="EEE">EEE</option>
						<option value="IT">IT</option>
						<option value="CSE">CSE</option></select></td>
			</tr>

			<tr>
				<td>Designation</td>
				<td><select name="designation"><option value="btech">BTECH</option>
						<option value="mtech">MTECH</option>
						<option value="mca">MCA</option>

						<option value="degree">DEGREE</option>

				</select></td>
			</tr>



			<tr>
				<td>TEACHERNAME</td>
				<td><input type="text" name="teachername"></td>

			</tr>


			<tr>
				<td>USERNAME</td>
				<td><input type="text" name="username"></td>

			</tr>



			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password"></td>

			</tr>



			<tr>
				<td>CONFIRM PASSWORD</td>
				<td><input type="password" name="confirmpassword"></td>

			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="SUBMIT" onclick="password()"></td>
			</tr>



		</table>
	</form>






	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>