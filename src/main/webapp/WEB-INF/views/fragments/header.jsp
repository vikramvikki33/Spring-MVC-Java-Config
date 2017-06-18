<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href='<spring:url value="/"></spring:url>'>Background Verification</a>
		</div>
		
		<ul class="nav navbar-nav">
			<!-- Admin Drop Down -->
			<li class="dropdown">
       			<a href="#" class="dropdown-toggle" 
       				data-toggle="dropdown" role="button" 
       				aria-expanded="false">Admin <span class="caret"></span></a>
       			<ul class="dropdown-menu" role="menu">
         			<li><a href="<spring:url value="/admin_clients/clients"/>">Clients</a></li>
         			<li><a href='<spring:url value="/admin_subclients/subClients"></spring:url>'>Sub Clients</a></li>
         			<li><a href='<spring:url value="/admin_profiles/profiles"></spring:url>'>Profiles</a></li>
       			</ul>
       		</li>
			<!-- End of Admin Drop Down -->
		</ul>
	</div>
</nav>