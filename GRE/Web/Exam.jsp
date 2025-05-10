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
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
      	.bd-placeholder-img-lg {
         	font-size: 3.5rem;
        }
      }
    nav {
        font-family: sans-serif;
    }
    .navbar-brand {
        font-size: 20px;
        font-family: Georgia, 'Times New Roman', Times, serif;
    }
    .center{
    	text-align:center;
    }
    .instruction-box{
    	border-style: solid;
    	padding:10px;
    }
    </style>
</head>
        
    <c:set var="selectedexam" value="${param.selectedexam}" scope="session" />
    <body>
    <%
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
    %>
         <header>
            <!--Navigation Bar-->
            <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
                <a class="navbar-brand" href="#"><b>GRE Exam</b></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
                    <ul class="navbar-nav ml-auto">
		    			<li class="nav-item">
							<a class="nav-link"><b><span id="timer" style="color:white;"></span></b></a>
		    			</li>
                    </ul>
                </div>    
            </nav>
        </header><br/>
        <sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/gre online test" user="root" password=""></sql:setDataSource>
        <sql:query dataSource="${db}" var="mcq">
            select * from questiondetails where CategoryID="${catId}";
        </sql:query>
           
        <br/><br/><br/>    
        <form action="Evaluate" method="post">
        <div class="instruction-box">
        <h4>Instruction:</h4>
        <ul>
  			<li>This is a timed test so make sure you finish your exam before the time runs out.</li>
  			<li>Make sure to click the submit button before the time is up otherwise you answers wont be marked for evaluation.</li>
  			<li>Do not press the back button,if you do so you wont be able to give the test again and will be scored 0.</li>
		</ul>
		<h4 style="text-align:center;">All the best!!!!</h4>
        </div>
            <c:set var="questioncnt" value="0" />
            <c:forEach var="mcqexam" items="${mcq.rows}" >
                    <c:set var="questioncnt" value="${questioncnt+1}" scope="page" />
                    <ol id="${questioncnt}">

                        <h3><span>Q<c:out value="${questioncnt}"></c:out>.&nbsp;</span><c:out value="${mcqexam.QuestionDescription}"></c:out></h3>
                        <input type="radio" name="${mcqexam.QuestionNo}" value="${mcqexam.Choice1}" required>&nbsp;<c:out value="${mcqexam.Choice1}"></c:out><br>
                        <input type="radio" name="${mcqexam.QuestionNo}" value="${mcqexam.Choice2}" required>&nbsp;<c:out value="${mcqexam.Choice2}"></c:out><br>
                        <input type="radio" name="${mcqexam.QuestionNo}" value="${mcqexam.Choice3}" required>&nbsp;<c:out value="${mcqexam.Choice3}"></c:out><br>
                        <input type="radio" name="${mcqexam.QuestionNo}" value="${mcqexam.Choice4}" required>&nbsp;<c:out value="${mcqexam.Choice4}"></c:out><br>

                        <br>
                        </ol>
                        <br>

                </c:forEach>
             
             <div class="center">
             	<button>Submit Exam</button>
             </div>
            
            
            <br><br>
        </form>
    </body>
    <script type="text/javascript">
    	const startmin=120;
    	let t=startmin*60;
    	const timer = document.getElementById("timer");
    	
        function countDown(){
        	var min = Math.floor(t/60);
        	let sec=t%60;
            if(t > 0){
                t--;
                sec=sec<10?'0'+sec:sec;
                timer.innerHTML = "Examinations ends in: "+min+":"+sec;
                setTimeout("countDown()", 1000)
            }else{
                window.location.href = "Logout";
            }
        }
        countDown();
    </script>
</html>
