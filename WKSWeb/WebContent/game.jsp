<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wendall, Karl, Stephen - Lines and Boxes</title>
</head>
<body>
<h1 style="text-align: center">Lines and Boxes</h1>

<hr>
<h1>${requestScope.instr}</h1>
<hr>
<div id="table">
<form action="${pageContext.request.contextPath }/game" method="post">
<table>
	<c:forEach var='i' begin='0' end='${requestScope.size - 1 }'> 
	<tr>
		<c:forEach var='j' begin='0' end='${requestScope.size - 1 }'>
			<c:if test="${i % 2 == 0 }"> 
				<c:if test="${j % 2 == 0}">
				<!-- Dots -->
	
					<td bgcolor="#000000" style="width:5px;height:5px"></td>
				</c:if>
				<c:if test="${j % 2 == 1 }">
				<!-- Horizontal Button -->
					<c:choose>
						<c:when test="${requestScope.board[i][j] != 'a'}">
						<td bgcolor="#FFFFFF">
							<input name="but" value="${i},${j}" type="submit" style="width:60px;height:20px;color:rgba(0,0,0,0);background-color: rgba(0,0,0,0.001) " />
						</td>
						</c:when>
						<c:otherwise>
							<td bgcolor="#000000" style="width:60px;height:20px">
							</td>
						</c:otherwise>
					</c:choose>
					
				</c:if>
			</c:if>
			<c:if test="${i % 2 == 1 }">
				<c:if test="${j % 2 == 0}">
				<!-- Vertical Button -->
					<c:choose>
						<c:when test="${requestScope.board[i][j] != 'a'}">
						<td bgcolor="#FFFFFF">
							<input name="but" value="${i},${j}" type="submit" style="width:20px;height:60px;color:rgba(0,0,0,0);background-color: rgba(0,0,0,0.001) " />
						</td>
						</c:when>
						<c:otherwise>
							<td bgcolor="#000000" style="width:20px;height: 60px;">
							</td>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${j % 2 == 1 }">
				<!-- Open Space/Contested Space -->
					<c:choose>
						<c:when test="${requestScope.board[i][j] == 'b'}">
							<td bgcolor="#00FF00">&nbsp;</td>
						</c:when>
						<c:when test="${requestScope.board[i][j] == 'c' }">
							<td bgcolor="#FF0000">&nbsp;</td>
						</c:when>
						<c:otherwise>
							<td bgcolor="#FFFFFF">&nbsp;</td>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:if>	
		</c:forEach>
	</tr>
	</c:forEach>
</table>
</form>
</div>
<hr>
<br>
<br>
</body>
</html>