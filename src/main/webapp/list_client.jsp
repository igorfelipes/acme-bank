<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Clients</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>List Clients</h1>
		<table class="table">
			<c:if test="${successDelete != null}">
				<script>
					alert("Cliente removido com sucesso");
				</script>
			</c:if>
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">E-mail</th>
					<th scope="col">Phone</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="client" items="${clients}">
					<tr>
						<th class="row"><c:out value="${client.id}" /></th>
						<td><c:out value="${client.name}" /></td>
						<td><c:out value="${client.email}" /></td>
						<td><c:out value="${client.phone}" /></td>
						<td><a
							href="clientServlet?action=edit-client&id=${client.id} }"
							class="btn btn-primary"
							>Edit</a></td>
						<td><a
							href="clientServlet?action=delete-client&id=${client.id}"
							class="btn btn-danger"
							>Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>