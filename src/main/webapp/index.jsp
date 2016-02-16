<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcomeses</title>
	</head> 
	<body>
	<h2>insert records in tables</h2>
	<form action="tables">
	<input type="submit" value="Insert Records">
	</form> <br>
		<h2>Retrieve records from tables</h2>
	<form action="querythem">
	<input type="submit" value="Retrieve the Records">
	</form> 
	
	</body>
</html>
