<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sub Clients</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
</head>
<body>
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<div class="container">
		<p class="text-center"> Maintain Sub Client Details</p>
		<hr />
		<div class="row">
			<spring:url value="/admin_subclients/save_subClient" var="addSubClient" />
			<spring:url value="/admin_subclients/back_to_subClient" var="back" />
			<form:form cssClass="form-horizontal" action="${addSubClient}" method="POST" modelAttribute="subClients" >
				<form:hidden path="clientId"/>
				<div class="form-group">
					<label for="sName" class="col-sm-2">Sub Client Name : </label>
					<div class="col-sm-10">
						<form:input path="subClientName" id="sName" cssClass="form-control" />
						<form:errors path="subClientName" />
					</div>
				</div>
				<div class="form-group">
					<label for="sAddress" class="col-sm-2">Sub Client Address</label>
					<div class="col-sm-10">
						<form:textarea id="sAddress" cssClass="form-control" path="address" rows="2" cols="20"/>
						<form:errors path="address"/>
					</div>
				</div>
				<div class="form-group">
					<label for="sCity" class="col-sm-2"> City</label>
					<div class="col-sm-10">
						<form:input id="sCity" cssClass="form-control" path="city"/>
						<form:errors path="sity" />
					</div>
				</div>
				<div class="form-group">
					<label for="sCountry" class="col-sm-2"> City</label>
					<div class="col-sm-10">
						<form:input id="sCountry" cssClass="form-control" path="country"/>
						<form:errors path="city" />
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