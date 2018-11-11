<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="/aka/style/buyLogin.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<body>
	<div class="menu">
		<ul>
			<li><a href="contact.jsp">CONTACT US</a></li>
			<li><a href="about.jsp">ABOUT</a></li>
			<li><a href="home.jsp">HOME</a></li>
		</ul>
		
		<div class="logo">
				<a href="home.jsp">
					<img src="logo.jpg">
					<span><strong>BookAttic</strong></span>
				</a>
		</div>
	</div>
	
	<header>
	<h1>Confirm your order by login!!</h1>
	<br>
	</header>
	<form action="Buy" method="POST">
		<div class="loginstyle">
			<br>
			<img src="avatar.jpg" class="avatar"><br> <br>
			<div>${empty error ? '' :error}</div>
			<input type="text" name="uid" id="email" placeholder="Enter the user id"><br> <br>
			<input type="password" name="upassword" id="password" placeholder="Enter the password"><br> <br>
			<input type="submit" value="Confirm Order" id="btn">
			<br>
			<br>
		</div>
		<div class="Register">
			<br>
			<h4>-- Not a member yet?? Get yourself Registered here --</h4>
					<a href="register.jsp"> <strong>Register Here</strong></a></div>
	</form>
	<br>
	<br>
	<br>
	<br>

</body>
</html>