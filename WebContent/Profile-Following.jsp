
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
            <img class="icon" src="images/Lock.png">
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
    <a href="#">
        <img class="icon" src="images/Lock.png">
                Activity
        <img class="arrow" src="images/Caret-right.png">
    </a>
    <a href="#">
        <img class="icon" src="images/Lock.png">
                Buy/Sell
        <img class="arrow" src="images/Caret-right.png">
    </a>
</div>
<!-- Home Page -->
<div style="margin-left:25%">
    <!-- Search Bar -->
        <input type="text" name="search" placeholder="Search...">

        <div class="balance-div">
            <!-- user Profile Picture -->
            <div style="display: flex">
                <img style="height: 88px; width: 88px;" src="images/User.png">
                <!-- Profile  Name  -->
                <div class="header-txt">Kelly Whitlock</div>
            </div>
            <!-- # of Posts -->
            <!-- # of Followers -->
            <!-- # of Following -->
        </div>
    <div class="tweets">
        <div class="header-txt">
            <div style="display: flex; justify-content: space-evenly; padding-bottom: 22px;">
                <a href="listFollowers"><span>Followers</span></a><a href="listFollowing"><span>Following</span></a>
            </div>
            <div style="padding-left: 33px;" class="post-line"></div>
        </div>
        <form action="listFollowing" method="get">
    		<c:forEach var="following" items="${listFollowers}">
        	<div class="tweet-container" >
        		<img style="height: 88px; width: 88px;" src="images/User.png">
            		<div class="tweet-author"><c:out value="${following.followerID}" /></div>
            		<button>Follow</button>
            		<button>Tip</button>
            </div>
        
        </c:forEach>
        </form>
     </div>
</div>

</body>
</html>
