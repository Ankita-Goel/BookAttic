<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="/aka/style/vremovestock.css" rel="stylesheet" type="text/css">
    <body>
	<h1>Add Book</h1>
        <div class="registerstyle">
            <form method="post" action="Vremovestock">
                        <div>${empty error ? '' :error}</div>
            <div class="line"><label for="book_id">Book id : </label><br><input type="text" name="book_id"><br><br></div>
                        <div class="line"><label for="book_name">Book Name : </label><br><input type="text" name="book_name"><br><br></div>
				<div class="line"><label for="stock">Stock : </label><br><input type="number" name="stock"><br><br></div>
                <div class="line"><br><input type="submit" name="submit" value="Remove Book" id="btn"></div>

            </form>
        </div><br><br><br>

</body>
</html>