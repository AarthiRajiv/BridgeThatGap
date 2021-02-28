<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<div class="main">	  
	  <br/> Hello ${user.name}! <br /> <br/>	  
	   ${employeeList[0].name}
		<c:forEach items ="${employeeList}" var="e">
		      <c:out value="${e}"/> 
		</c:forEach>
	</div>     	

</body>
</html>