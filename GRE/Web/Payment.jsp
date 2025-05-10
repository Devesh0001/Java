<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Form</title>
    <link rel="stylesheet" href="Payment.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
	<%
        response.setHeader("Cache-Control", "no-store, no-cache");
    %> 
    <form action="PaymentConfirm" method="get">
    <div class="container">
        <h1>PAYMENT</h1>
        <div class="first-row">
            <div class="owner">
                <h3>Card Holder's Name</h3>
                <div class="input-field">
                    <input type="text" id="card holder name"required autofocus>
                </div>
            </div>
            <div class="cvv">
                <h3>CVV</h3>
                <div class="input-field">
                    <input type="password" id="cvv" placeholder="000" pattern="[0-9]{3}" minlength="3" maxlength="3" required>
                </div>
            </div>
        </div>
        <div class="second-row">
            <div class="card-number">
                <h3>Card Number</h3>
                <div class="input-field" >
                    <input type="text" id="card number" name="ccnum" placeholder="1234-1234-1234-1234" minlength="16" maxlength="16" pattern="[0-9]{16}"  required>
                </div>
			</div>
            <div class="pay">
            	<h3>Payment</h3>
                <div class="input-field">
                    <input type="text" readonly value=${ef}>
                </div>
            </div>
           </div>
           
        <div class="third-row">
            <h3>Validity Upto</h3>
            <div class="selection">
                <div class="date">
                    <select name="months" id="months">
                        <option value="May">May</option>
                        <option value="Jun">Jun</option>
                        <option value="Jul">Jul</option>
                        <option value="Aug">Aug</option>
                        <option value="Sep">Sep</option>
                        <option value="Oct">Oct</option>
                        <option value="Nov">Nov</option>
                        <option value="Dec">Dec</option>
                      </select>
                      <select name="years" id="years">
                      	<option value="2033">2033</option>
                        <option value="2032">2032</option>
                        <option value="2031">2031</option>
                        <option value="2030">2030</option>
                        <option value="2029">2029</option>
                        <option value="2028">2028</option>
                        <option value="2027">2027</option>
                        <option value="2026">2026</option>
                        <option value="2025">2025</option>
                        <option value="2024">2024</option>
                        <option value="2023">2023</option>
                        <option value="2022">2022</option>
                        
                      </select>
                </div>
                <div class="cards">
                    <img src="images/MasterCard.jpeg" alt="master card logo">
                    <img src="images/visa.jpeg" alt="visa card logo">
                    <img src="images/rupay.jpg" alt="rupay card logo" class="rupay">
                </div>
            </div>    
        </div>
        <input class="button" type="submit" value="Pay" style="color:white;">
    </div>
    </form>
</body>
</html>