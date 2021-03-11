<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
<header>Bridge That Gap!</header>

	<div class="sidenav">
	  <a href="${pageContext.request.contextPath}/consultations.jsp">Consultations</a>		
	  <a href="${pageContext.request.contextPath}/clients.jsp">Clients</a>
	  <a href="${pageContext.request.contextPath}/interventions.jsp">Interventions</a>	    
	  <c:if test = "${user.role == 'admin'}">
	  	<a href="${pageContext.request.contextPath}/employees.jsp">Employees</a>	
	  </c:if>
	  <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>
	
	<div class="main">	  
	  <br/> Hello ${user.name}! <br /> <br/>
	  Together We can help Tech, Bridge that gap!
	  
	  Choose an option from the left menu.
	  <br/>
	
	  	<img src="diversityStockPhoto.jpg">
	   
	  	   
	</div>     	

</body>
</html>