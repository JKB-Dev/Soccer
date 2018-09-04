<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container">

	<h1>LIST OF CURRENT TEAMS</h1>

	<table border="1">
		<tr>
		    <th>Name</th>
		    <th>View</th>
		    <th>Edit</th>
		    <th>Delete</th>
		</tr>
		<c:forEach var="team" items="${teams}"> <!-- teams EL tag places results of repository.findAll() in table -->
			<tr>
				<td> ${team.teamname} </td> <!-- it's "member" here because we're accessing the object -->
				<td><a href="/team/${team.teamid}/view">View</a></td> <!-- view team -->
				<td><a href="/team/${team.teamid}/edit">Edit</a></td> <!-- hrefs tell controller to call actions -->
				<td><a href="/team/${team.teamid}/delete" onclick="return confirm('Are you sure you want to delete this team?');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<a class="btn btn-secondary" href="team/create">Add a new Team</a> <!-- href tells controller to call team-add.jsp -->
	<br>
	<br>
	<a class="btn btn-secondary" href="/">home</a>
</div>

</body>
</html>