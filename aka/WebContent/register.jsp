<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<link href="/aka/style/Register.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">

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
	
	<h1>Create Account</h1>
        <div class="registerstyle">
			<form action="Register" method="POST">
			<div style="font-size:20px;"><strong>${empty error ? '' :error}</strong></div>
				<div class="option" style="margin:0px auto; width:30%;"><h2>Choose User: </h2>
					<select name="category">
						<option value="Customer">I'm a Customer</option>
						<option value="Vendor">I'm a Vendor</option>
					</select><br><br>
				</div>
                <table style="padding:10px;">
				<tr>
					<td><div class="line"><label for="first_name">First name: </label><br><input type="text" name="first_name"><br><br></div></td>
					<td><div class="line"><label for="last_name">Last name: </label><br><input type="text" name="last_name"><br><br></div></td>
                </tr>
				<tr>
					<td><div class="line"><label for="email">Email: </label><br><input type="email" name="email"><br><br></div></td>
					<td><div class="line"><label for="password">Password: </label><br><input type="password" name="password"><br><br></div></td>
                </tr>
				<tr>
					<td><div class="line"><label for="phoneno">Phone: </label><br><input type="string" name="phoneno"> <br><br></div></td>
					<td><div class="line"><label for="address">Address: </label><br><input type="text" name="address"><br><br></div></td>
				</tr>
				<tr>
					<td><div class="line"><label for="state">State: </label><br><input type="text" name="state"><br><br></div></td>
					<td><div class="line"><label for="country">Country: </label><br><input type="text" name="country"><br><br></div></td>
                </tr>
				<tr>
					<td colspan="2" class="registerbtn"><button><strong>Register</strong></button></td>
				</tr>
				</table>
            </form>
        </div><br><br><br>
    </body>
</html>