<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
<header>Bridge That Gap!</header>

	<div class="sidenav">
	  <a href="${pageContext.request.contextPath}/employees.jsp">Consultations</a>
	  <a href="#services">Clients</a>
	  <a href="#clients">Interventions</a>
	  <a href="${pageContext.request.contextPath}/employees.jsp">Employees</a>
	</div>
	
	<div class="main">	  
	  <br/> Hello ${user.name}! Your role: ${user.role} <br /> <br/>
	   ${consultationList[0].consultationId}
	</div>     	

</body>
</html>