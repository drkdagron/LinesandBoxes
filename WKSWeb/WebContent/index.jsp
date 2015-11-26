<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wendall, Karl, Stephen - Lines and Boxes</title>
</head>
<body>
<h1 style="text-align: center">Lines and Boxes - Setup</h1>
<p>Please enter names for each player. If you only enter one name, you will face a computer player.</p>
<p style="color: red">${requestScope.error}</p>
<strong>Player Setup:</strong><br>
<form action="${pageContext.request.contextPath }/index" method="post">
<table>
<tr style="padding-top:10px">
<td>Player 1 Name:</td>
<td><input type="text" name="player1"></td>
</tr>
<tr style="padding-top:10px">
<td>Player 2 Name:</td>
<td><input type="text" name="player2"></td>
</tr>
<tr style="padding-top:10px">
<td>Board Size:</td>
<td><select name="boardSize">
	<option value="0">Small</option>
	<option value="1">Medium</option>
	<option value="2">Large</option>
</select></td>
</tr>
</table>
<br>

<input type="submit" value="Start Game" />
</form>
</body>
</html>