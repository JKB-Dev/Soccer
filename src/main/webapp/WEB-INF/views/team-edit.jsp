<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Team</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container">

	<h1>${item}</h1>
	
	<form method="post">
		<div class="form-group">
			<input class="form-control" type="hidden" id="teamid" name="teamid" value="${team.teamid}" required="required" autocomplete="off">
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<input class="form-control" id="name" name="name" value="${team.teamname}" required="required" autocomplete="off">
		</div>
		<button class="btn btn-secondary" type="submit">Submit</button>
		<br>
		<br>
		<a class="btn btn-secondary" href="/teams">cancel</a>
	</form>

</div>

</body>
</html>