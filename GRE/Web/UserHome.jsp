<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>User Home Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>	
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">
    <style>
        body {
    		padding-top: 3.5rem;
		}

		nav {
    		font-family: sans-serif;
		}
		.navbar-brand {
    		font-size: 20px;
    		font-family: Georgia, 'Times New Roman', Times, serif;
		}
    </style>
</head>
<body>
		<%
        	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    	%>
	<form method="get">
            <!--Navigation Bar-->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <a class="navbar-brand" href="#"><b>GRE ONLINE EXAMINATION </b></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                	<span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
						<a class="nav-link" href="ViewResult.jsp">View Result</a>
		    		</li>
		    		<li class="nav-item">
						<a class="nav-link" href="ChangePasswordU.jsp">Change Password</a>
		    		</li>
		    		<li class="nav-item">
						<a class="nav-link" href="Logout">Logout</a>
		    		</li>
                    </ul>
                </div>
            </nav>
        <main role="main">
            <div class="jumbotron">
            	<div class="container">
                	<h1 class="display-4">Welcome ${name}</h1>
                	<h2>User Id: ${uId}</h2>
                	<p>Welcome to GRE Online Exam!</p>
                	<p>Test your knowledge by taking GRE Test!!</p>
                	<p>Register for a test or if already registered take the exam.</p>
                	
            	</div>
			</div>
			<div class="container">
                  <div class="row">
                    <div class="col-md-4">
                      <h2>Register For GRE Test</h2>
                      <p>If you have'nt already registered for GRE test, register now.</p>
                      <p><a class="btn btn-secondary" href="ExamRegister0.jsp" role="button">Register &raquo;</a></p>
                    </div>
                    <div class="col-md-4">
                      <h2>Take Test</h2>
                      <p>If you have already registered for the exam then start the test.</p>
                      <p><a class="btn btn-secondary" href="Confirmation.jsp" role="button">Start Test &raquo;</a></p>
                    </div>
                </div>
                <hr>
            </div>
        </main>

		<footer class="container">
			<p>&copy; gre. All Rights Reserved</p> 
		</footer>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    	<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.js"></script>
    </form>
</body>
</html>