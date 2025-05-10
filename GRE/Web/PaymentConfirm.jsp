<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="PaymentConfirm.css">
	<title>Payment Confirmation</title>
</head>
<body style="background:#c3e8fa">
<div class="container" >
	<img src="images/check.jpeg">
	<div class="head"><h1 style="color: green;">Payment Complete</h1></div>
	<div class="mssg"><p>Thank you, your payment has been successful</p></div>
	<div>
		<h3>Payment Details:</h3>
		<p>Credit Card Number: ${ccnum}<br>
		Amount:${amount}<br>
		Paid to: GRE Portal
		</p>
		<div class="final"><p>Date and Time:${paydatetime}</p></div>
	</div><hr>
	<div class="back">
		<h4><a style="color:black;" href="ExamRegister0.jsp">GO BACK</a></h4>
	</div>
</div>
</body>
</html>