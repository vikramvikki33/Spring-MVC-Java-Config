<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clients</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<h2 class="text-center"> Sub Client Details	</h2>
		<div class="row">
		<spring:url value="/admin/add_subClient" var="add"></spring:url>
		<spring:url value="/admin/edit_subClient" var="edit_subClient"></spring:url>
		<spring:url value="/" var="back"></spring:url>
			<form action='<spring:url value="/admin_subclients/add_subClient"></spring:url>' method="POST">
				<div class="form-group">
					<table class="table table-bordered table-hover">
						<tr>
							<th width="5%"> Delete </th>
							<th width="5%"> Edit </th>
							<th width="5%">SubClient Id</th>
							<th width="25%">Sub Client Name</th>
							<th width="35%">Address</th>
							<th width="15%">City</th>
							<th width="15%">Country</th>
						</tr>
						<c:forEach items="${subClients}" var="clients">
							<tr>
								<td>
									<a href='<spring:url value="/admin_subclients/remove_subClient/${subClients.clientId}"></spring:url>'>
										<span class="btn btn-danger glyphicon glyphicon-trash"></span>
									</a>
								</td>
								<td>
									<a href='<spring:url value="/admin_subclients/edit_subClient/${subClients.clientId}"></spring:url>'>
										<span class="btn btn-info glyphicon glyphicon-wrench"></span>
									</a>
								</td>
								<td class="text-center">${subClients.clientId }</td>
								<td>${subClients.clientName } </td>
								<td>${subClients.address } </td>
								<td>${subClients.city } </td>
								<td>${subClients.country }</td>
							</tr>
						</c:forEach>
					</table>
					<div class="text-center">
						<input type="submit" class="btn btn-primary" value="Add " />
						<a href='<spring:url value="/"></spring:url>' class="btn btn-primary"> Back </a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<jsp:include page="../views/fragments/footer.jsp" />
</html>