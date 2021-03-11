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
	  
	  Consultations:  
	  
	  	<table>
			<tr>
		    	<th>Consultant</th>
		    	<th>Client Name</th>
		    	<th>Intervention Requested</th>
		    	<th>Goal</th>
		    	<th>Status</th>
		    	<th>Start Date</th>
		  	</tr>
		<c:forEach items ="${consultationList}" var="c">
		      <tr>
    			<td><a href=""> <c:out value="${c.employee.name}"/> </a></td>
			    <td><c:out value="${c.client.clientName}"/> </td>
			    <td><c:out value="${c.intervention.option}"/> </td>
			    <td><c:out value="${c.goal}"/> </td>
			    <td><c:out value="${c.status}"/> </td>
			    <td><c:out value="${c.startDate}"/> </td>
			  </tr>
		</c:forEach>
		</table>
		
		<br/><br/>
		<a href="${pageContext.request.contextPath}/addConsultation.jsp">Add New Consultation</a>
		
	</div>     	

</body>
</html>