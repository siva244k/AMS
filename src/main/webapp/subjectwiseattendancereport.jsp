<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SubjectWiseAttendanceReport</title>
<script type="text/javascript" language="javascript" src="ajax.js"></script>
</head>
<body>





	<center>

		<form id="myform" action="SubjectWiseAttendanceReportServlet"
			method="POST">
			<table cellpadding="2" cellspacing="2" border="4">
				<tr>
					<td>Course</td>
					<td><select name="course"><option value="ECE">ECE</option>
							<option value="EEE">EEE</option>
							<option value="IT">IT</option>
							<option value="CSE">CSE</option></select></td>
				</tr>

				<tr>
					<td>Semester</td>
					<td><select name="semester"><option value="1">I</option>
							<option value="2">II</option></select></td>
				</tr>



				<tr>
					<td>Year</td>
					<td><select name="year" onchange="makeRequest()">
							<option value="1">I</option>
							<option value="2">II</option>
							<option value="3">III</option>
							<option value="4">IV</option>
					</select></td>
				</tr>


				<tr>
					<td>SUBJECT</td>
					<td><div id="subject"></div></td>
				</tr>







				<tr>
					<td>CutOffPercentage</td>
					<td><input type="text" name="cutoff"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="Submit" value="LetterGenerate"></td>
				</tr>



			</table>
		</form>

	</center>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>