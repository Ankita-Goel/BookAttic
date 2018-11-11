<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
</head>
<link href="/aka/style/vsalesdetail.css" rel="stylesheet" type="text/css">
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
				<font><strong>Your Sales</strong></font>
		</div>
		
		<div class="parent">
			
			${empty b7? '' :b7}
		</div>
		
		<div id="accordion">${empty b8? '' :b8}</div>
		
	</div>

</body>
</html>