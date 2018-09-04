<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team View</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/minty/bootstrap.min.css" />
</head>
<body>


<div class="container">

	<h1>${teamname}</h1>
	
	<table border="1">
		<tr>
			<th>Member Name</th>
			<th>Member Role</th>
		</tr>
		<c:forEach var="member" items="${teamMembers}">
			<tr>
				<td> ${member.membername} </td>
				<td> ${member.memberrole }</td>
			</tr>
		</c:forEach>	
	</table>

</div>


</body>
</html>