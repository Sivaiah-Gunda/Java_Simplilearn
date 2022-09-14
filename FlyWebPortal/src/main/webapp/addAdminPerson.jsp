<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="PersonServlet" method="post">
		Name : <input type="text" name="name"/><br/>
		Address  : <input type="text" name="address"/><br/>
		Email  : <input type="text" name="email"/><br/>
		Phone   : <input type="text" name="phone"/><br/>
		User Id : <input type="text" name="accId"><br/>
		Password : <input type="password" name="password"><br/>
		<select name="account_type" id="account_type">
			<option value="Admin">Admin</option>
			<option value="Crew">Crew</option>
			<option value="Customer">Customer</option>
			<option value="Pilot">Pilot</option>
		</select>
		
		<br/>
		<button type="submit">Add</button>
	</form>

</body>
</html>