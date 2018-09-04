<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>

<div class="container">

	<h1>LIST OF CURRENT MEMBERS</h1>

	<table border="1">
		<tr>
		    <th>Name</th>
		    <th>Role</th>
		    <th>Edit</th>
		    <th>Delete</th>
		</tr>
		<c:forEach var="member" items="${members}"> <!-- members EL tag places results of repository.findAll() in table -->
			<tr>
				<td> ${ member.membername }</td> <!-- it's "member" here because we're accessing the object -->
				<td> ${ member.memberrole }</td>
				<td><a href="/member/${member.memberid}/edit">Edit</a></td> <!-- hrefs tell controller to call actions -->
				<td><a href="/member/${member.memberid}/delete" onclick="return confirm('Are you sure you want to delete this member?');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	
	<a class="btn btn-secondary" href="member/create">Add a new Member</a> <!-- href tells controller to call item-add.jsp -->
	<br>
	<br>
	<a class="btn btn-secondary" href="/">home</a>

</div>

</body>
</html>