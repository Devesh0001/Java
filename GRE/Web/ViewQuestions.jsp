<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Exam Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
		.center {
  			margin-left: auto;
  			margin-right: auto;
		}
		table {
  			width: 95%;
		}
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
		.container{
 			width: 100%;
  			text-align: center;
		}
		.container a{
			color:grey;
			margin-bottom:20px;
			padding-bottom:20px;
		}
		
    </style>
</head>
        
    <c:set var="selectedexam" value="${param.selectedexam}" scope="session" />
    <body>
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
		        		<a class="nav-link" href="">Edit Paper</a>
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
        <h1 style="text-align: center;">${catId} Exam Set</h1><br/>
        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/gre online test" user="root" password=""/>
        <sql:query dataSource="${db}" var="res">
            SELECT * FROM questiondetails WHERE CategoryID="${catId}";
        </sql:query>
        
        <sql:query dataSource="${db}" var="ci">
            SELECT * FROM categorydetails WHERE CategoryID="${catId}";
        </sql:query>
        
         <table border="1" class="center">
            <tr>
                <th>Category Id</th>
                <th>Category Name</th>
                <th>Paper Name</th>
                <th>No of Questions</th>
                <th>Duration of Exam</th>
                <th>Exam Fee</th>
            </tr>
            <c:forEach var="tb" items="${ci.rows}">
                <tr>
                    <td><c:out value="${tb.CategoryID}"/></td>
                    <td><c:out value="${tb.CategoryName}"/></td>
                    <td><c:out value="${tb.PaperName}"/></td>
                    <td><c:out value="${tb.NoOfQuestions}"/></td>
                    <td><c:out value="${tb.DurationOfExam}"/></td>
                    <td><c:out value="${tb.ExamFare}"/></td>
                </tr>
            </c:forEach>
        </table><br>
        
        <table border="1" class="center">
            <tr>
                <th>Question Description</th>
                <th>Choice 1</th>
                <th>Choice 2</th>
                <th>Choice 3</th>
                <th>Choice 4</th>
                <th>Answer</th>
            </tr>
            <c:forEach var="tbl" items="${res.rows}">
                <tr>
                    <td><c:out value="${tbl.QuestionDescription}"/></td>
                    <td><c:out value="${tbl.Choice1}"/></td>
                    <td><c:out value="${tbl.Choice2}"/></td>
                    <td><c:out value="${tbl.Choice3}"/></td>
                    <td><c:out value="${tbl.Choice4}"/></td>
                    <td><c:out value="${tbl.Answer}"/></td>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <div class="container">
        	<a href="ViewCategoryandQues.jsp" id="forgot_pswd">Back</a><br/>
        </div>
        
    </body>
    
</html>
