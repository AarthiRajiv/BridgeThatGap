<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
<header>Bridge That Gap!</header>

	<div class="sidenav">
	  <a href="${pageContext.request.contextPath}/employees.jsp">Consultations</a>
	  <a href="${pageContext.request.contextPath}/clients.jsp">Clients</a>
	  <a href="${pageContext.request.contextPath}/interventions.jsp">Interventions</a>
	  <a href="${pageContext.request.contextPath}/employees.jsp">Employees</a>
	  <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
	</div>
	
	<div class="main">	  
	  <br/> Hello ${user.name}! <br /> <br/>
	  Choose an option from the left menu.
	  <br/>
	   <img src="diversityStockPhoto.jpg">	   
	   
	</div>     	

</body>
</html>