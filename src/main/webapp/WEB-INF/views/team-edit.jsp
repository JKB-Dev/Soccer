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

	<h1>Edit ${item}</h1>
	
	<form method="post">
		<div class="form-group">
			<label for="name">Name:</label>
			<input class="form-control" id="name" name="name" value="${team.teamname}" required="required" minlength="2" autocomplete="off">
		</div>
		<button type="submit">Submit</button>
	</form>

</div>

</body>
</html>