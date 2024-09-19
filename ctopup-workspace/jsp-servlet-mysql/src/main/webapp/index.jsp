<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style type="text/css">
.card {
	padding: 5%;
	height: 400px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

form {
	box-shadow: rgb(201 11 75/ 30%) 0px 1px 2px 0px, rgb(35 123 188/ 15%)
		0px 1px 6px 6px;
	padding: 5%;
}
</style>


</head>
<body>
	<div class="card">


		<form action="register" method="post">
			<h3>User Registration</h3>
			Name : <input type="text" name="name" placeholder="Enter the Name"
				required="name" /> <br> <br> Age : <input type="number"
				name="age" required="age" /> <br> <br> Gender : <input
				type="radio" name="gender" value="male" required="gender" />Male <input
				type="radio" name="gender" value="female" required="gender" />
			Female <br> <br> Msisdn : <input type="tel" name="msisdn"
				placeholder="Enter the Msisdn" required="msisdn" /> <br> <br>
			Email : <input type="email" name="email"
				placeholder="Enter the Email" required="email" /> <br> <br>
			Password : <input type="password" name="password"
				placeholder="Enter the Password" required="password"> <br>
			<br> <input type="submit" value="signup">


		</form>

	</div>
</body>
</html>