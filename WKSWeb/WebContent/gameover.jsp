<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lines and Boxes - Game Over</title>
</head>
<body>

<h1>Game Finished!</h1>
<hr>
<h1 style="color: green;">Winner!!! ${requestScope.winName } with a score of ${requestScope.winScore }</h1>
<h3 style="color:red;">Loser!!! ${requestScope.loseName } with a score of ${requestScope.loseScore }</h3>
<br>
<hr>
<form method="post" action="${pageContext.request.contextPath }/gameover">
<input type="submit" name="playBtn" value="Play Again">
<input type="submit" name="backBtn" value="Back to Menu">
</form>
</body>
</html>