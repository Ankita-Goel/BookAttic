<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>
</head>
<link href="/aka/style/vaddbook.css" rel="stylesheet" type="text/css">
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
		
	<h1>Add Book</h1>
        <div class="registerstyle">
            <form method="post" action="Vaddbook">
            	
					<div class="line"><label for="book_title"><div class="title" style="float:left; width:150px;">Title: </div></label><input type="text" name="book_title"></div>
					<div class="line"><label for="book_author"><div class="title" style="float:left; width:150px;">Author: </div></label><input type="text" name="book_author"></div>
					<div class="line"><label for="book_publisher"><div class="title" style="float:left; width:150px;">Publisher: </div></label><input type="text" name="book_publisher"></div>
					<div class="line"><label for="book_publishyr"><div class="title" style="float:left; width:150px;">Publish year: </div></label><input type="number" name="book_publishyr"></div>
					<div class="line"><label for="book_genre"><div class="title" style="float:left; width:150px;">Genre: </div></label><input type="text" name="book_genre"></div>
					<div class="line"><label for="book_rate"><div class="title" style="float:left; width:150px;">Price: </div></label><input type="number" name="book_rate"></div>
					<div class="line"><label class="category" for="stock"><div class="title" style="float:left; width:150px;">Stock: </div></label><input type="number" name="stock"></div>
						
					<button type="submit">Add</button>
            </form>
        </div><br><br><br>
</body>
</html>

