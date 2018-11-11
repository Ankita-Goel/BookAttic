<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book</title>
<link href="/aka/style/display.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<script>
function setCookie(cvalue) {
    document.cookie = "bookId =" + cvalue + ";" ;
   // location.href="display.jsp";
    console.log(cvalue);
    //window.stop();
}
function vendorCookie(bvalue) {
    document.cookie = "vendorid =" + bvalue + ";" ;
   	location.href="buyLogin.jsp";
    console.log(cvalue);
    //window.stop();
}
</script>
</head>
<body>
	<div class="main">
		<div class="panel">
		
			<div class="logo">
				<a href="home.jsp">
					<img src="logo.jpg">
					<span><strong>BookAttic<strong></span>
				</a>
			</div>
			
			<div class="nav">
				<li><a href="login.jsp"> <strong>Login</strong> </a></li>
				<li><a href="register.jsp"> <strong>Register</strong> </a></li>
			</div>
			
			<div class="search-container">
				<form action="#">
					<input type="text" placeholder="Search.." name="search">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
			</div>
			
		</div>
		<div class="topbar"></div>
	
		<div class="menubar">
			<li><a href="home.jsp">Home</a></li>
			<li><a href="about.jsp">About</a></li>
			<li><a href="#">Contact Us</a></li>
			<hr width="30%" style="margin-left:10px;">
		</div>
		<div class="parent">
			<div class="child1">
				<img src="image${empty a1 ? 0 :a1}.jpg">
			</div>
			<div class="child2">
			<br><br>
				<TABLE>  
				
					<tr><td class="book" style="font-size:40px; padding-left:20px;">${empty a2 ? '' :a2}</td></tr>
					<tr><td><div class="category">Author:</div><div class="info">${empty a3 ? '' :a3}</div></td></tr>
					<tr><td><div class="category">Publisher:</div><div class="info">${empty a4 ? '' :a4}</div></td></tr>
					<tr><td><div class="category">Publish year:</div><div class="info">${empty a5 ? '' :a5}</div></td></tr>
					<tr><td><div class="category">Genre:</div><div class="info">${empty a6 ? '' :a6}</div></td></tr>
					<br>
					
				</TABLE> 
				
				<hr style="margin:0px 0px; width:50%;">
					
					<br>
					<div class="purchase">${empty b8? '' :b8}</div>			
				
			</div>
		</div>
	</div>

</body>
</html>