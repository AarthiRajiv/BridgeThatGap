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
	  Employees:  
	  
	  	<table>
			<tr>
		    	<th>Name</th>
		    	<th>Role</th>
		    	<th>Specialization</th>
		    	<th>Email</th>
		  	</tr>
		<c:forEach items ="${employeeList}" var="e">
		      <tr>
    			<td><a href="${pageContext.request.contextPath}/getEmployee?employeeToEdit=${e.empId}"> <c:out value="${e.name}"/> </a></td>
			    <td><c:out value="${e.role}"/> </td>
			    <td><c:out value="${e.specialization}"/> </td>
			    <td><c:out value="${e.email}"/> </td>
			  </tr>
		</c:forEach>
		</table>
		
		<br/><br/>
		<a href="${pageContext.request.contextPath}/addEmployee.jsp">Add New Employee</a>
	</div>     	

</body>
</html>