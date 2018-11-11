<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Detail</title>
</head>
<link href="/aka/style/trackorderdetail.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$( function() {
    $( "#accordion" ).accordion({
      collapsible: true,
      heightStyle: "content"
    });
  } );
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
			<font><strong>Order Details</strong></font>
		</div>
			${empty b7? '' :b7}
		<div id="accordion">${empty b8? '' :b8}</div>
		
		
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