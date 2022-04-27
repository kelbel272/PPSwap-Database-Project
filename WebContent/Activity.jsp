 
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
        <a href="Home2.jsp">
            <img class="icon" src="images/Home.png">
                Dashboard
            <img class="arrow" src="images/Caret-right.png">
        </a>
        <a href="Profile.jsp">
            <img class="icon" src="images/User.png">
                    Profile
            <img class="arrow" src="images/Caret-right.png">
        </a>
    <div class="active">
    <a href="#">
        <img class="icon" src="images/Invoice.png">
                Activity
        <img class="arrow" src="images/Caret-right.png">
    </a>
    </div>
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
        <div style="display: flex">
            <img style="height: 88px; width: 88px;" src="images/User.png">
            <!-- Profile  Name  -->
            <div class="header-txt">Kelly Whitlock</div>
        </div>
    </div>
     <!-- Users Activities -->
    <div class="tweets">
         <!-- Label for Posts -->
        <div class="header-txt">
            <div style="padding-left: 40px; padding-bottom: 22px;">
                Activity
            </div>
            <div style="padding-left: 33px;"class="post-line"></div>
        </div>
        <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Activities</h2></caption>
            <tr>
                <th>Activity Type</th>
                <th>Created At</th>
                <th>userFrom</th>
                <th>userTo</th>
                <th>PPSent</th>
                <th>dollarAmt</th>
            </tr>
          
            <c:forEach var="activity" items="${listActivity}">
                <tr>
                    <td><c:out value="${activity.activityType}" /></td>
                    <td><c:out value="${activity.createdAt}" /></td>
                    <td><c:out value="${activity.userFROM}" /></td>
                    <td><c:out value="${activity.userTO}" /></td>
                    <td><c:out value="${activity.ppSent}" /></td>
                    <td><c:out value="${activity.dollarAmt}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    </div>
        
  
</div>
</body>
</html>
