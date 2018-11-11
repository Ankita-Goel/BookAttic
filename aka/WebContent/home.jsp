<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
<link href="/aka/style/home.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
<script>
function setCookie(cvalue) {
    document.cookie = "bookId =" + cvalue + ";" ;
   // location.href="display.jsp";
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
					<span><strong>BookAttic</strong></span>
				</a>
			</div>
			
			<div class="nav">
			<ul>
				<li><a href="login.jsp"> <strong>Login</strong> </a></li>
				<li><a href="register.jsp"> <strong>Register</strong> </a></li>
			</ul>
			</div>
			
			<div class="search-container">
				<form action="Display" method="post">
					<input type="text" placeholder="Search.." name="search">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
			</div>
		</div>
		
		<div class="topbar"></div>
	
		<div class="menubar">
		<ul>
			<li><a href="home.jsp"><strong>Home</strong></a></li>
			<li><a href="about.jsp"><strong>About</strong></a></li>
			<li><a href="contact.jsp"><strong>Contact Us</strong></a></li>
		</ul>
		
		<hr width="30%" style="margin-left:10px;">
		<br>
		
		</div>
				
		<div class="slider">
			<div class="subheader">
				<img class="mySlides" src="book1.jpg" >
				<img class="mySlides" src="book2.jpg" >
				<img class="mySlides" src="book3.jpg" >
				<img class="mySlides" src="book4.jpg" >
				<img class="mySlides" src="book5.jpg" >
				<img class="mySlides" src="book6.jpg" >
			</div>
			
		</div>
		<br>
		<script>
		function hello(){
		location.href="display.html";
		Console.log("HI!");
		}
		</script>
		
		<hr width="70%" align="center" style="margin-left:20px;" >
		
		<div class="adcolumn" style="background-color:none;">
			<p><strong>Advance Booking<br>
				 Click now..</strong>
			</p>
			<div class="slideshow2">
					<a>
						<img class="mySlides2" src="ad1.jpg" >
						<img class="mySlides2" src="ad2.jpg" >
						<img class="mySlides2" src="ad3.jpg" >
					</a>
			</div>
		</div>
		
		<div class="subheader1">
			<strong>Best Sellers of all time</strong>
		</div>
		<div class="block1">
			<div class="column" style="background-color:none;">
				<img src="image3.jpg">
				<form action="Display" method=post>
				 <button onclick="setCookie(3)" >Sherlock Holmes</button>
				 </form>
			</div>
			<div class="column" style="background-color:none;">
				<img src="image2.jpg">
				<form action="Display" method=post>
				 <button onclick="setCookie(2)" >The Perfect Murder</button>
				 </form>
			</div>
			<div class="column" style="background-color:none;">
				<img src="image10.jpg">
				<form action="Display" method=post>
				 <button onclick="setCookie(10)" >Everything, Everything</button>
				 </form>
			</div>
		</div>
		
		<hr width="70%" align="center" style="margin-left:20px;">
		
		<div class="subheader2">
			<strong>Featured</strong>
		</div>
		<div class="block2">
			<div class="column" style="background-color:none;">
				<img src="image8.jpg">
				<form action="Display" method=post>
				 <button onclick="setCookie(8)" >The Alchemist</button>
				 </form>
			</div>
			<div class="column" style="background-color:none;">
				
				<img src="image9.jpg">
				<form action="Display" method=post>
				<button onclick="setCookie(9)" >Harry Potter and the Cursed Child</button>
				 </form>
			</div>
			<div class="column" style="background-color:none;">
				<form action="Display"  method=post>
				<img src="image5.jpg">
				 <button onclick="setCookie(5)" >Fault in our stars</button>
				 </form>
			</div>
		</div>
		
		<div class="block3">
			<footer>
				<p style="font-family:tangerine; font-size:30px;width:auto;margin:0px 0px; color:#32CD32"><strong>BookAttic</strong></p>
				<ul>
					<a href="home.jsp"><li>Terms</li></a>
					<a href="home.jsp"><li>Blog</li></a>
					<a href="home.jsp"><li>About</li></a>
				</ul>
			</footer>
		</div>
		
	</div>
	
	
	<script>
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
			   x[i].style.display = "none";  
			}
			myIndex++;
			if (myIndex > x.length) {myIndex = 1}    
			x[myIndex-1].style.display = "block";  
			setTimeout(carousel, 3000); // Change image every 3 seconds
		}
		
		var myIndex2 = 0;
		carousel2();

		function carousel2() {
			var i;
			var x = document.getElementsByClassName("mySlides2");
			for (i = 0; i < x.length; i++) {
			   x[i].style.display = "none";  
			}
			myIndex2++;
			if (myIndex2 > x.length) {myIndex2 = 1}    
			x[myIndex2-1].style.display = "block";  
			setTimeout(carousel2, 3000); // Change image every 3 seconds
		}
	</script>
</body>

</html>
