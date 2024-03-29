<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Teachers</title>
<link type="text/css" rel="stylesheet" href="style.css">
</head>
<body style="background-image: url('paper.gif');">
	<div id="page">
		<jsp:include page="LeftList.jsp" />

		<div id="wrapper">

			<div id="header">
				<h3>Teachers</h3>
			</div>
		</div>

		<div id="container">

			<div id="content">

				<table>

					<tr>

						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>

					</tr>

					<c:forEach var="tempStudent" items="${TEACHERS_LIST }">
						<tr>

							<td>${tempStudent.fname}</td>
							<td>${tempStudent.lname}</td>
							<td>${tempStudent.age}</td>

						</tr>

					</c:forEach>

				</table>
			</div>
		</div>
	</div>

</body>
</html>