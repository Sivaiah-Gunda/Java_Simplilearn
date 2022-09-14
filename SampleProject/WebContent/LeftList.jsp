<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidenav">
	<h3 id="logo">
		Learners Academy
	</h3>
	<c:url var="classesLink" value="AdminControlServlet">
		<c:param name="command" value="CLASSES" />
	</c:url>

	<c:url var="subjectsLink" value="AdminControlServlet">
		<c:param name="command" value="SUBJECTS" />
	</c:url>

	<c:url var="teachersLink" value="AdminControlServlet">
		<c:param name="command" value="TEACHERS" />
	</c:url>

	<c:url var="studentsLink" value="AdminControlServlet">
		<c:param name="command" value="STUDENTS" />
	</c:url>
	
 
	<a class="bar-item" href="${classesLink}">Classes</a> 
		<a class="bar-item" href="${subjectsLink}">Subjects</a>
		<a class="bar-item" href="${teachersLink}">Teachers</a> 
		<a class="bar-item" href="${studentsLink}">Students</a> 
		<a class="bar-item" href="Login.jsp">Log out</a>

</div>

