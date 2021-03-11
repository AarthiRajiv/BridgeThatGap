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
	  
	  <form action="./updateEmployee" method="post">
		  Employee Details:<br/><br/>
		  	<label>Name:</label>
	  		<input type="text" name="fName" value="${selectedEmployee.name}"><br/><br/>   
	  			
	  		<label>Role:</label>
	  		<input type="text" name="fRole" value="${selectedEmployee.role}"><br/><br/>
			
			<label>Specialization:</label>
			<input type="text" name="fSpecialization" value="${selectedEmployee.specialization}"><br/><br/>
	
			<label>Email:</label>
			<input type="text" name="fEmail" value="${selectedEmployee.email}"><br/><br/>
			
			<input type="submit" name="action"  value="Update">
		</form>
		<form action="./deleteEmployee" method="post">
			<input type="submit" name="action" value="Delete">	  
		</form>
				
	</div>     	

</body>
</html>