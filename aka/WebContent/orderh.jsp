<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="/aka/style/orderh.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

<script>
function orderCookie(ovalue) {
    document.cookie = "orderid =" + ovalue + ";" ;
   	//location.href="buyLogin.jsp";
    console.log(cvalue);
    //window.stop();
}
</script>
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
			<font><strong>Your Order History</strong></font>
		</div>
		
		<div>${empty error ? '' :error}</div>
		
		<div class="parent">
			<TABLE cellspacing="20"> 
				<th>ORDER ID</th>
				<th>BOOK</th>
				<th>   </th>
			
				${empty b8? '' :b8}
		
			</TABLE> 
		</div>
	</div>

	<div class="footer">
		<p style="font-family:tangerine; font-size:30px;margin:0px auto;color:#32CD32"><strong>BookAttic</strong></p>
				<ul>
					<a href="#"><li>Terms</li></a>
					<a href="#"><li>Blog</li></a>
					<a href="about.jsp"><li>About</li></a>
				</ul>
	</div>
</body>
</html>