<page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Admin Home</title>
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
    <form method=get> 
        <!--Navigation Bar-->
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        	<a class="navbar-brand" href="#"><b> GRE EXAMINATION SYSTEM</b></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            	<span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
            	<ul class="navbar-nav ml-auto">
                	<li class="nav-item">
		        		<a class="nav-link" href="questions.jsp">Edit Paper</a>
		    		</li>
                	<li class="nav-item">
                		<a class="nav-link" href="ChangePasswordA.jsp">Change Password</a>
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
                	<h1 class="display-4">Welcome Admin!</h1>
                	<p>Welcome to GRE ONLINE EXAMINATION!</p>
                </div>
			</div>
            <div class="container">
            	<div class="row">
                	<div class="col-md-4">
                    	<h2>Schedule Exam.</h2>
                      	<p> Check out the students who have registered for the GRE exam and schedule their exam, so that they can attempt it.</p>
                    	<p><a class="btn btn-secondary" href="ScheduleExam.jsp" role="button">Schedule Exam &raquo;</a></p>
                    </div>
                    <div class="col-md-4">
                    	<h2>Check exam pattern?</h2>
                      	<p>Wanna make sure that the categories and question are set properly??</p>
                      	<p><a class="btn btn-secondary" href="ViewCategoryandQues.jsp" role="button">View Category/Ques &raquo;</a></p>
                    </div>
                </div>
                <hr>
            </div>
        </main>

		<footer class="container">
  			<p>&copy; GRE. All Rights Reserved</p>
		</footer>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      	<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="../assets/dist/js/bootstrap.bundle.js"></script>
    </form>
</body>
</html>