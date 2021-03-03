<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
<header>Bridge That Gap!</header>

	<div class="sidenav">
	  <a href="${pageContext.request.contextPath}/consultations.jsp">Consultations</a>		
	  <a href="${pageContext.request.contextPath}/clients.jsp">Clients</a>
	  <a href="${pageContext.request.contextPath}/interventions.jsp">Interventions</a>
	  <a href="${pageContext.request.contextPath}/employees.jsp">Employees</a>
	  <a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>	
	
	<div class="main">	  
	  <br/> Hello ${user.name}! <br /> <br/>	
	  
	  Clients:  
	  
	  	<table>
			<tr>
		    	<th>Client Name</th>
		    	<th>Contact Name</th>
		    	<th>Contact Phone</th>
		    	<th>Contact Email</th>
		  	</tr>
		<c:forEach items ="${clientList}" var="c">
		      <tr>
    			<td><a href=""> <c:out value="${c.clientName}"/> </a></td>
			    <td><c:out value="${c.contactName}"/> </td>
			    <td><c:out value="${c.contactPhone}"/> </td>
			    <td><c:out value="${c.contactEmail}"/> </td>
			  </tr>
		</c:forEach>
		</table>
		
	</div>     	

</body>
</html>