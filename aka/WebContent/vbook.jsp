<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
<script>
	function setCookie(cvalue,a) {
		document.cookie = "bookid =" + cvalue + ";";
		//  window.location="vremovebook.jsp";
		console.log(a);
		div_show(cvalue,a);
		console.log(cvalue);
	}
	function check_empty(id,a) {

	    var x = document.getElementById("name"+id+a).value;
		if (x < 0) {
			alert("Fill All Fields !");
		} else {

			document.cookie = "bookstock =" + x + ";";
			console.log(x);
			document.getElementById('form'+id+a).submit();
		}
	}
	//Function To Display Popup
	function div_show(id,a) {
		document.getElementById('pb'+id+a).style.display = "block";
	}
	//Function to Hide Popup
	function div_hide(id,a) {
		document.getElementById('pb'+id+a).style.display = "none";
	}
</script>

<link href="/aka/style/vbook.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
</head>
<body>
	<div class="menu">		
		<ul>
			<li><form action="Logout" method="post"><button type="submit" value="LOGOUT">LOGOUT</button></form></li>
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
				<font><strong>Your books..</strong></font>
		</div>
		
		<div class="parent">
			<TABLE cellspacing=25 > 
				<tr>
					<th>Book Id</th>
					<th>Book</th>
					<th>Author</th>
					<th>Publisher</th>
					<th>Publish year</th>
					<th>Genre</th>
					<th>Price</th>
					<th>Stock</th>
					<th>    </th>
					<th>    </th>
					<th>    </th>
				</tr>
				${empty b8? '' :b8}
		
			</TABLE> 
		</div>
		
		<div class="option">
			<p><strong>Do you want to add more books??</strong></p>
			<button onclick="location.href = 'vaddbook.jsp';" type="submit" value="Add Book" class="button">Add Book</button>
		</div>
		
	</div>
	
	
</body>
</html>