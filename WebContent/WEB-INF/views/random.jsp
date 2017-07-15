<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Random Word Generator</title>
</head>
<body>
	<form action="/RandomWord/counter" name="counter" method="get">
		<h2><c:out value="${word}"/></h2>
		<input type="submit" value="Generate"></input>
	</form>
	<h2>You have clicked this button <c:out value = "${counter}"/> times.</h2>
	<p><c:out value = "${current}"/></p>
</body>
</html>