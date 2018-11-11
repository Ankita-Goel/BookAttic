<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Info</title>
</head>
<link href="/aka/style/vinfo.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

<body>

<div class="menu">
		<ul>
			<li><form action="Logout" method="post"><BUTTON type="submit" value="LOGOUT">LOGOUT</BUTTON></form></li>
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
			<font><strong>We have pen it down for you...</strong></font>
		</div>
		
		<div class="papa">
			<TABLE> 
			 
					<tr><td><div class="line"><div class="category">Vendor ID:</div><div class="info">${empty a1 ? '' :a1}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">First Name:</div><div class="info">${empty a2 ? '' :a2}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Last Name:</div><div class="info">${empty a3 ? '' :a3}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Email:</div><div class="info">${empty a4 ? '' :a4}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Password:</div><div class="info">${empty a5 ? '' :a5}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Phone No.:</div><div class="info">${empty a6 ? '' :a6}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Address:</div><div class="info">${empty a7 ? '' :a7}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">State:</div><div class="info">${empty a8 ? '' :a8}</div></div></td></tr>
					<tr><td><div class="line"><div class="category">Country:</div><div class="info">${empty a9 ? '' :a9}</div></div></td></tr>
			
			</TABLE> 
		</div>
	</div>
	
	<div class="footer">
		<p style="font-family:tangerine; font-size:30px;margin:10px auto;color:#32CD32;"><strong>BookAttic</strong></p>
				<ul>
					<a href="#"><li>Terms</li></a>
					<a href="#"><li>Blog</li></a>
					<a href="#"><li>About</li></a>
				</ul>
	</div>
	
</body>
</html>