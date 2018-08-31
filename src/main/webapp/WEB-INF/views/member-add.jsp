<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Member</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container">

	<form method="post">
		<div class="form-group">
			<label for="membername">Member Name:</label>
			<input class="form-control" id="membername" name="membername" value="${ member.membername }" required="required" minlength="2" autocomplete="off">
			<br>
			<label for="memberrole">Member Role:</label>
			<input class="form-control" id="memberrole" name="memberrole" value="${ member.memberrole }" required="required" minlength="2" autocomplete="off">
			<br>
			<label for="teamid">Member Team:</label>
			<input class="form-control" id="teamid" name="teamid" value="${ member.teamid }" required="required" autocomplete="off">
			<br>
		</div>
		<button type="submit">Submit</button>	
	</form>		
	
</div>

</body>
</html>