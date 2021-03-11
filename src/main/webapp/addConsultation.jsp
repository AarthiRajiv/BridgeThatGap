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
	  
	  <form action="./addConsultation" method="post">
		  Consultation Details:<br/><br/>
		  	<label>Client Name:</label>
	  		<input type="text" name="fClient"><br/><br/>   
	  			
	  		<label>Intervention:</label>
	  		<input type="text" name="fIntervention"><br/><br/>
			
			<label>Consultant:</label>
			<input type="text" name="fEmployee"><br/><br/>
	
			<label>Goal:</label>
			<input type="text" name="fGoal"><br/><br/>

			<label>Status:</label>
			<input type="text" name="fStatus"><br/><br/>

			<label>Start Date:</label>
			<input type="text" name="fStartDate"><br/><br/>						
			<input type="submit" name="action"  value="Add">
		</form>
	</div>     	

</body>
</html>