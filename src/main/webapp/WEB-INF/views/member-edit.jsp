<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Member</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container">

	<h1>Edit ${item}</h1>
	
	<fieldset>
	
	<form method="post">
		<div class="form-group">
			<input class="form-control" type="hidden" id="id" name="id" value="${member.memberid}" required="required" autocomplete="off">
		</div>
		<div class="form-group">
			<label for="name">Name: ${member.membername}</label>
			<input class="form-control" id="name" name="name" value="${member.membername}" required="required" autocomplete="off">
		</div>
		
		<div class="form-group">
			<label for="role">Role: ${member.memberrole}</label>
			<input class="form-control" id="role" name="role" value="${member.memberrole}" required="required" autocomplete="off">
		</div>
		
		<div class = dropdown>
		<label for="teamid">Team: </label>
			<select name = "teamid">
				<c:forEach var="teamid" items="${teams}">
					<option value="${teamid.teamid}">${teamid.teamname}</option>
				</c:forEach>
			</select>
		</div>
		
		<br>
		<br>
		<button class="btn btn-secondary" type="submit">Submit</button>
	</form>
		<br>
		<br>
		<a class="btn btn-secondary" href="/members">cancel</a>
	
	</fieldset>

</div>

</body>
</html>