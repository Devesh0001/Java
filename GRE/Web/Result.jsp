<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        
        <title>Result</title>
        <style>
		#logreg-forms{
    		width:412px;
    		margin:10vh auto;
    		background-color:#f3f3f3;
    		box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    		transition: all 0.3s cubic-bezier(.25,.8,.25,1);
		}
		#logreg-forms form {
    		width: 100%;
    		max-width: 410px;
    		padding: 15px;
    		margin: auto;
		}
		#logreg-forms .form-control {
    		position: relative;
    		box-sizing: border-box;
    		height: auto;
    		padding: 10px;
    		margin-bottom:15px;
    		font-size: 16px;
		}
		#logreg-forms .form-control:focus { z-index: 2; }
		#logreg-forms .form-signin input[type="text"] {
    		margin-bottom: -1px;
    		border-bottom-right-radius: 0;
    		border-bottom-left-radius: 0;  
		}
		#logreg-forms .form-signin input[type="password"] {
    		border-top-left-radius: 0;
    		border-top-right-radius: 0;
		}
		#logreg-forms a{
    		display: block;
    		padding-top:10px;
    		color:grey;
		}
		#logreg-forms input[type="submit"]{ margin-top:10px;  background-color: #4a4747}

		#logreg-forms .form-reset, #logreg-forms .form-signup{ display: none; }

		#logreg-forms .form-signup input { margin-bottom: 2px;}

		/* Mobile */

		@media screen and (max-width:500px){
    		#logreg-forms{
        		width:300px;
    		}
		}
    	</style>
    </head>
    <body style="background-color:#c3e8fa;">
        <div id="logreg-forms">
        <form class="form-signin">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Result</h1>
            <hr/>
            <h5 style="color:Black; margin-bottom:20px;">Category ID:<p style="display:inline; margin-left:30px;">${cID}</p></h5>
            <h5 style="color:Black; margin-bottom:20px;;">Paper:<p style="display:inline; margin-left:85px;">${pname}</p></h5>
            <h5 style="color:Black; margin-bottom:20px;">Name:<p style="display:inline; margin-left:80px;">${name} ${lname}</p></h5>
            <h5 style="color:Black; margin-bottom:20px;">UserID:<p style="display:inline; margin-left:75px;">${uId}</p></h5>
            <h5 style="color:Black; margin-bottom:20px;">Score:<p style="display:inline; margin-left:87px;">${score}</p></h5>
            <a href="UserHome.jsp" id="forgot_pswd"  style="text-align: center;">Back to profile</a><br/>
            
            <hr/>
        </form>
    </div>
    </body>
</html>