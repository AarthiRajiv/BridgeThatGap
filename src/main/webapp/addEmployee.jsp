<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
<header>Bridge That Gap!</header>

	<div class="sidenav">
	  <a href="${pageContext.request.contextPath}/employees.jsp">Consultations</a>
	  <a href="${pageContext.request.contextPath}/clients.jsp">Clients</a>
	  <a href="${pageContext.request.contextPath}/interventions.jsp">Interventions</a>
	  <a href="${pageContext.request.contextPath}/employees.jsp">Employees</a>
	  <a href="${pageContext.request.contextPath}/login.jsp">Logout</a>
	</div>	
	
	<div class="main">	  
	  <br/> Hello ${user.name}! <br /> <br/>		  
	  
	  <form action="./addEmployee" method="post">
		  Employee Details:<br/><br/>
		  	<label>Name:</label>
	  		<input type="text" name="fName"><br/><br/>   
	  			
	  		<label>Role:</label>
	  		<input type="text" name="fRole"><br/><br/>
			
			<label>Specialization:</label>
			<input type="text" name="fSpecialization"><br/><br/>
	
			<label>Email:</label>
			<input type="text" name="fEmail"><br/><br/>
			
			<input type="submit" name="action"  value="Add">
		</form>
	</div>     	

</body>
</html>