<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/aka/style/contact.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">


<title>Contact Us</title>
</head>
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
	
	<div class="outer">
		<div class="slider">
			<strong>Contact Us</strong>
		</div>
        
        <div class="parent">
	        <form action="Contact" method="post"><pre><font face="Times new Roman" size="4">
	            <div class="line">Name : </div><input type="text" name="nm" size="35" >
	            
	            <div class="line">E-Mail : </div><input type="text" name="mail" size="35" >
	            
	            <div class="line">Contact : </div><input type="text" name="con" size="35" >
	            
	            <div class="line">Message : </div>
	            
	                      <textarea cols="35" rows="10" name="qu">Write Message Here</textarea>
	                      
	                      <button type="submit" Value ="Contact" name="sub" >Send</button>      
	                 
	            </font></pre>
	        </form>
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