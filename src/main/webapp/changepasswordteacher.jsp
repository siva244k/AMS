<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ChangePassword</title>
</head>
<body>
<h2>Change Password</h2>
<center>
<table border="0" cellpadding="2" cellspacing="2">
<form action="TeacherInterfaceController" method="post">


OLDPASSWORD<input type="text" name="oldpassword"/><br/>
NEWPASSWORD<input type="text" name="newpassword"/><br/>

<input type="hidden" name="method" value="changepassword"/>
<input type="submit" value="changepassword"/>

</form>
</table>
</center>
</body>
</html>