<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Question Portal</title>
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
                padding: 10px;
                margin: auto;
            }
            #logreg-forms .form-control {
                position: relative;
                box-sizing: border-box;
                height: auto;
                padding: 10px;
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
      <script type="text/javascript">
           
           		function populate(s1,s2){
           			var s1=document.getElementById(s1);
           			var s2=document.getElementById(s2);
           			s2.innerHTML="";
           			if(s1.value == "General"){
           				var optionArr=["|----Category Id----","G001|G001-Aptitude"];
           			}
           			else{
           				var optionArr=["|----Category Id----","S001|S001-Maths","S002|S002-Physics","S003|S003-Chemistry","S004|S004-Physcology"
           					,"S005|S005-English"];
           			}
           			for(var option in optionArr){
           				var pair =optionArr[option].split("|");
           				var newoption=document.createElement("option");
           				newoption.value=pair[0];
           				newoption.innerHTML=pair[1];
           				s2.options.add(newoption);
           			}
           			
           		}
       </script>
    </head>
    <body style="background-color:#c3e8fa;">
        <div id="logreg-forms" >
        <form class="form-signin" action="questionportal" method="get">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Edit Paper</h1>
            <hr>
           
            <select class="form-control" required name="Category Name" id="CategoryName" onclick="populate('CategoryName','CategoryId')">
	           <option value="" selected class="form-control">----Category Name----</option>
	           <option value="General">General</option>
	           <option value="Subject">Subject</option>
           </select><br/>
           
           <select class="form-control" required name="Category Id" id="CategoryId">
           </select><br/>
         
			<input class="btn btn-success btn-block" type="submit" value="ADD QUESTIONS" style="color:white;">
			<input class="btn btn-success btn-block" type="submit" value="MODIFY QUESTIONS" style="color:white;" onclick="form.action='questionportal1';">
			<input class="btn btn-success btn-block" type="submit" value="DELETE QUESTIONS" style="color:white;" onclick="form.action='questionportal2';">
		
		</form> 
		
			<a href="AdminHome.jsp" id="forgot_pswd"  style="text-align: center;">Back To Profile</a><br/>
            <hr>
         
        </div>
      
         
    </body>
</html>
