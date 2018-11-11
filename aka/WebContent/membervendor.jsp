<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<html>
<head>
<title>Vendor Profile</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/aka/style/membervendor.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
</head>
<body >		
	<div class="menu">		
		<ul>
			<li><form action="Logout" method="post"><button type="submit" value="LOGOUT">LOG OUT</button></form></li>
			<li><a href="contact.jsp"><strong>CONTACT US</strong></a></li>
			<li><a href="about.jsp"><strong>ABOUT</strong></a></li>
			<li><a href="home.jsp"><strong>HOME</strong></a></li>
		</ul>
		
		<div class="logo">
				<a href="home.jsp">
					<img src="logo.jpg">
					<span><strong>BookAttic</strong></span>
				</a>
		</div>	
	</div>
		
	<div class="outer" >
		
		<div class="slider">
<%-- 	 	<% 
// 		Cookie[] cookies = request.getCookies();
// 		String user_name="";
// 		for(Cookie cookie : cookies)
// 		{
// 			if(cookie.getName().equals("name"))
// 			{
// 				user_name = cookie.getValue();
// 				System.out.println("name in vbook"+user_name);
// 			}
// 		}
	%>    --%>
		
				<h1>Hii ${empty a2 ? '' :a2}!!</h1>
				<p>We are glad to serve you.</p>
				<p>Hope we meet your requirements. </p>
				
		</div>
		
		<div class="parent">
			<div class="lside">
			<ul class="babu">
				
				<li><form action="Vinfo" method="POST">
					<button type="submit" value="My Info" class="btn success">My Info</button>
				</form></li>
			
				<li><form action="Vbook" method="POST">
					<button type="submit" value="Book List" class="btn success">Book List</button>
				</form></li>
			</ul>
			</div>
			<div class="rside">
			<ul class="babu">
			
				<li><form action="Vsales" method="POST">
					<button type="submit" value="My Sales" class="btn success">My Sales</button>
				</form></li>
			
				<li><form action="Vsetting" method="POST">
					<button type="submit" value="Account Settings" class="btn success">Account Settings</button>
				</form></li>
			</ul>
			</div>
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



