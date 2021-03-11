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
	  
	  Interventions:  
	  
	  	<table>
			<tr>
		    	<th>#</th>
		    	<th>Intervention Option</th>
		  	</tr>
		<c:forEach items ="${interventionList}" var="i">
		      <tr>
    			<td><a href=""> <c:out value="${i.interventionId}"/> </a></td>
			    <td><c:out value="${i.option}"/> </td>
			  </tr>
		</c:forEach>
		</table>
		
	</div>     	

</body>
</html>