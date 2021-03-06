
<%@page import="bean.Login_Bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Load the TweetList when page loads -->
<c:choose>
	<c:when test="${!empty listTweets}">
	</c:when>
	<c:otherwise>
	<jsp:forward page="listTweets"></jsp:forward>
	</c:otherwise>
</c:choose>

<html>
<head>
  <meta charset="UTF-8">
<title>Home/PPSwap</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
</head>
<body>

<%
	Login_Bean obj_Login_Bean = (Login_Bean)session.getAttribute("user_session");
	
	//If you have not logged in, user is taken back to the login screen
	if(obj_Login_Bean == null){	
		session.setAttribute("login_message", "Please login first");
	%>
	<script type="text/javascript">
		window.location.href="http://localhost:8080/database/login.jsp";
	</script>
	<%
	}
	
	//String email = obj_Login_Bean.getUserID();
	//System.out.println("Print email: " + email);
	
%>

<!-- Left Navigation Bar -->
<nav class="sidenav">

        <div class="active">
        	<a href="listTweets">
            <img class="icon" src="images/Home.png">
                Dashboard
            <img class="arrow" src="images/Caret-right.png">
        	</a>
        </div>
    
    <a href="listUserTweets" >
        <img class="icon" src="images/User.png">
                Profile
        <img class="arrow" src="images/Caret-right.png">
    </a>
    <a href="listActivity">
        <img class="icon" src="images/Invoice.png">
                Activity
        <img class="arrow" src="images/Caret-right.png">
    </a>
    <a href="#">
        <img class="icon" src="images/Bank.png">
                Buy/Sell
        <img class="arrow" src="images/Caret-right.png">
    </a>
</nav>

<!-- Home Page -->
<div style="margin-left:25%">
    <!-- Search Bar -->
     <input type="text" name="search" placeholder="Search...">

    <div class="balance-div" style="color: black;">
        <img style="height: 84px; width: 84px;" src="images/PPSwap.png">
        
    </div>
    <div class="post-div">
        <div class="post-comment-div">
            <img style="height: 88px; width: 88px;" src="images/User.png">
                <input type="text" name="tweet" placeholder="Whats on your mind?">
            <div class="post-line">  </div> <button>Create Post</button>
        </div>
    </div>
    <div class="tweets">
    	<form action="listTweets" method="get">
    	<c:forEach var="tweets" items="${listTweets}">
        <div class="tweet-container" >
            <img style="height: 88px; width: 88px;" src="images/User.png">
            <div class="tweet-author"><c:out value="${tweets.userID}" /></div>
            <span class="dot"></span>
            <div class="tweet-time">12m</div>
            <div class="user-tweet"><c:out value="${tweets.tweet}" /></div>
            <div class="like-comment-icons">
                <img style="height: 88px; width: 88px;" src="images/Like.png">
                <img style="height: 88px; width: 88px;" src="images/Comment.png">
            </div>
        </div>
        </c:forEach>
        </form>
    </div>
   
    
    </div>
<center>
		
</center>


</body>
</html>
