<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Delete Question</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>	
        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">

    <style>
        body {
    padding-top: 3.5rem;
    background-color:powderblue;
    
}
nav {
    font-family: sans-serif;
}
.navbar-brand {
    font-size: 20px;
    font-family: Georgia, 'Times New Roman', Times, serif;
}
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
    font-size: 16px;
    color:powderblue;
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
    <body>
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        	<a class="navbar-brand" href="#"><b> GRE EXAMINATION SYSTEM</b></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            	<span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
            	<ul class="navbar-nav ml-auto">
            		<li class="nav-item">
		        		<a class="nav-link" href="AdminHome.jsp">Home</a>
		    		</li>
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
            <h1 style="text-align: center;"><u>Delete Questions</u></h1>
            <h5 style="text-align: center;">Delete Questions to Examination</h5><br/>
                        
            <form class="form-signin" action="deletequestionDB" method="post">
               
                <input type="text" class="form-control" placeholder="Category Id" required readonly name="catid" value=${CategoryId} />
                <input type="text" class="form-control" placeholder="Question" required readonly name="question" value="<%=request.getAttribute("Quesdesc") %>"/>
                <input type="text" class="form-control" placeholder="Choice 1" required readonly name="ans1" value="<%=request.getAttribute("ans1") %>" />
                <input type="text" class="form-control" placeholder="Choice 2" required readonly name="ans2" value="<%=request.getAttribute("ans2") %>"  />
                <input type="text" class="form-control" placeholder="Choice 3" required readonly name="ans3" value="<%=request.getAttribute("ans3") %>"  />
                <input type="text" class="form-control" placeholder="Choice 4" required readonly name="ans4" value="<%=request.getAttribute("ans4") %>"  />
                <input type="text" class="form-control" placeholder="Correct Choice" readonly required name="answer"  value="<%=request.getAttribute("answer") %>" /><br>
                
                <input class="btn btn-success btn-block" type="submit" value="Delete Question" style="color:white;"><br/>
                
            </form>
    </body>
</html>