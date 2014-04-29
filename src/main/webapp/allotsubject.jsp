<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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






	<form id="myform" action="AllotSubjectServlet" method="POST">
		<table cellpadding="2" cellspacing="2" border="4" align="center">
			<tr>
				<td>COURSE</td>
				<td><select name="course"><option value="ECE">ECE</option>
						<option value="EEE">EEE</option>
						<option value="IT">IT</option>
						<option value="CSE">CSE</option></select></td>
			</tr>





			<tr>
				<td>YEAR</td>
				<td><select name="year">
						<option value="1">I</option>
						<option value="2">II</option>
						<option value="3">III</option>
						<option value="4">IV</option>
				</select></td>
			</tr>





			<tr>
				<td>SEMESTER</td>
				<td><select name="semester" onchange="makeRequest()"><option
							value="1">I</option>
						<option value="2">II</option></select></td>
			</tr>



			<tr>
				<td>TEACHERS</td>
				<td><div id="subject"></div></td>
			</tr>







			<!--  



<tr>
<td>DAY</td><td><input type="text" name="day"></td>

</tr>


<tr>
<td>PERIOD</td><td><input type="text" name="period"></td>

</tr>

<tr>
<td>ALLOTMENTTYPE</td><td><input type="text" name="allotmenttype"></td>

</tr>


-->

			<tr cellpadding="2">
				<td><input type="submit" value="ContinueToAlltsubject"></td>
			</tr>



		</table>
	</form>





	<jsp:include page="foot.jsp"></jsp:include>

</body>
</html>