 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
<title>Home/PPSwap</title>
<link rel="stylesheet" type="text/css" href="css/Home.css">
</head>
<body>
<!-- Left Navigation Bar -->
<div class="sidenav">
        <a href="listTweets">
            <img class="icon" src="images/Home.png">
                Dashboard
            <img class="arrow" src="images/Caret-right.png">
        </a>
    <div class="active">
        <a href="listUserTweets">
            <img class="icon" src="images/User.png">
                    Profile
            <img class="arrow" src="images/Caret-right.png">
        </a>
    </div>
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
</div>
<!-- Home Page -->
<div style="margin-left:25%">
    <!-- Search Bar -->
        <input type="text" name="search" placeholder="Search...">
    <!-- Profile Name and Stats Bar -->
    <div class="balance-div">
        <!-- user Profile Picture -->
        <div style="display: flex; justify-content: space-between;">
            <img style="height: 88px; width: 88px;" src="images/User.png">
            <!-- Profile  Name  -->
            <div class="header-txt">Kelly Whitlock</div>
            <br>
            
            <a href="listFollowing"><div class="header-txt">Following</div></a>
            <br>
            <a href="listUserFollowers"><div class="header-txt">Followers</div></a>
        </div>
        <!-- # of Posts -->
        <!-- # of Followers -->
        <!-- # of Following -->
    </div>
     <!-- Users Posts -->
    <div class="tweets">
         <!-- Label for Posts -->
        <div class="header-txt">
            <div style="padding-left: 40px; padding-bottom: 22px;">
                Tweets
            </div>
            <div style="padding-left: 33px;"class="post-line"></div>
        </div>
    	<form action="listTweets" method="get">
    	<c:forEach var="tweets" items="${listUserTweets}">
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
</body>
</html>
