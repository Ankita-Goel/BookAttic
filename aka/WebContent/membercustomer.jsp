<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>member customer</title>
</head>
 <link href="/aka/style/membercustomer.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<body>
	<div class="menu">		
		<ul>
			<li><form action="Logout" method="post"><button type="submit" value="LOGOUT">LOG OUT</button></form></li>
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
	<div class="outer">
		<div class="slider">
				<font><strong>Hello ${empty a2 ? '' :a2}!! </strong></font>
				<p>We are glad to serve you.</p>
				<p>Hope we meet your requirements.</p>
				
		</div>
		<div class="parent">
			<div class="lside">
				<ul class="babu">
					<li><form action="Cinfo" method="POST">
						<button type="submit" value="My Info" class="btn success">My Info</button>
					</form></li>
					<br><br><br>
					<li><form action="Trackorder" method="POST">
						<button type="submit" value="Track Order" class="btn success">Track Order</button>
					</form></li>
				</ul>
			</div>
			
			<div class="rside">
				<ul class="babu" >
					<li><form action="OrderH" method="POST">
						<button type="submit" value="Order History" class="btn success">Order History</button>
					</form></li>
					<br><br><br>
					<li><form action="Vsetting" method="POST">
						<button type="submit" value="Account Settings" class="btn success">Account Settings</button>
					</form></li>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="footer">
			<p style="font-family:tangerine; font-size:35px;margin:0px auto;color:#32CD32"><strong>BookAttic</strong></p>
				<ul>
					<a href="#"><li>Terms</li></a>
					<a href="#"><li>Blog</li></a>
					<a href="#"><li>About</li></a>
				</ul>
		</div>
</body>
</html>


