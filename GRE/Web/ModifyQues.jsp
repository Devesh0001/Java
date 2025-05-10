<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Select Question</title>
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
    </head>
    <body style="background-color:#c3e8fa;">
        <div id="logreg-forms" >
        <form class="form-signin" action="selectques" method="get">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Select Question to modify</h1>
            <hr>
            <input type="text" class="form-control" placeholder="Category Id" readonly name="questno" value=${CategoryId} >
                <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/gre online test" user="root" password=""></sql:setDataSource>
        		<sql:query dataSource="${db}" var="userIds">
            		select * from questiondetails where CategoryID="${CategoryId}";
        		</sql:query>
                <select class="form-control" name="QuesName">
        			<option value="">---select Question---</option>
        			<c:forEach var="uid" items="${userIds.rows}" >
                    	<option value="${uid.QuestionDescription}">${uid.QuestionDescription}</option>
                	</c:forEach>
             	</select> <br>
        
			<input class="btn btn-success btn-block" type="submit" value="Next" style="color:white;">
			
		</form> 
		
			<a href="AdminHome.jsp" id="forgot_pswd"  style="text-align: center;">Back To Profile</a><br/>
			<h5 style="color:red; text-align: center;">${modcon}</h5>
            <hr>
         
        </div>
      
         
    </body>
</html>
