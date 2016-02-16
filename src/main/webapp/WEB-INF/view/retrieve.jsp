<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Record</title>
</head>
<body>
<form action="display">
	<p>Select the table: <select name="table">
	<option value="employee">employee</option>
	<option value="orders">order</option>
	</select></p>
	Enter name : <input type="text" name="name"> <br>
		<input type="submit" value="Retrieve">
	</form> 
</body>
</html>