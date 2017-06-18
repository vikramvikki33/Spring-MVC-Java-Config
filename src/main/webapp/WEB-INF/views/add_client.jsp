<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clients Details</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<p class="text-center"> Maintain Client Details</p>
		<hr />
		<div class="row">
			<spring:url value="/admin_clients/save_client" var="addClient" />
			<spring:url value="/admin_clients/back_to_client" var="back" />
			<form:form cssClass="form-horizontal" action="${addClient}" method="POST" modelAttribute="clients" >
				<form:hidden path="id" />
				<div class="form-group">
					<label for="cName" class="col-sm-2">Client Name : </label>
					<div class="col-sm-10">
						<form:input path="clientName" id="cName" cssClass="form-control" />
						<form:errors path="clientName" />
					</div>
				</div>
				<div class="form-group">
					<label for="cAddress" class="col-sm-2">Client Address</label>
					<div class="col-sm-10">
						<form:textarea id="cAddress" cssClass="form-control" path="clientDetails.addressDetails.address.addressLine1" rows="2" cols="20"/>
						<form:errors path="clientDetails.addressDetails.address.addressLine1"/>
					</div>
				</div>
				<div class="form-group">
					<label for="cCity" class="col-sm-2"> City</label>
					<div class="col-sm-10">
						<form:input id="cCity" cssClass="form-control" path="clientDetails.addressDetails.address.city"/>
						<form:errors path="clientDetails.addressDetails.address.city" />
					</div>
				</div>
				<div class="form-group">
					<label for="cCountry" class="col-sm-2"> Country</label>
					<div class="col-sm-10">
						<form:input id="cCountry" cssClass="form-control" path="clientDetails.addressDetails.address.country"/>
						<form:errors path="clientDetails.addressDetails.address.country" />
					</div>
				</div>
			  	<div class="form-group">
			    	<div class="col-sm-offset-2 col-sm-10">
			      		<input type="submit" class="btn btn-default" value="Save" />
			      		<a href="${back}" class="btn btn-default"> Back</a>
			    	</div>
			  	</div>

			</form:form>
		</div>
	</div>
</body>
<jsp:include page="../views/fragments/footer.jsp" />
</html>