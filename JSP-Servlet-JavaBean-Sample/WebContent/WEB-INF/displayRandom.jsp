<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Random Poney</title>
</head>
<body>

	<h1>WELCOME TO ${sessionScope.rponey.name} PONEY!</h1>
	<h2>Color: ${sessionScope.rponey.color}</h2>
	<h2>Power: ${sessionScope.rponey.superPower}</h2>
	<img src=${sessionScope.rponey.imgUrl} >

</body>
</html>
