 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>PPSwap - Login</title>
      <link rel="stylesheet" type="text/css" href="css/StyleSheet.css">
</head>

<body>
  <div class="container">
  <div class="ppswap">
            <img alt="logo" style="width: 150px; height: 150px;" src="<c:url value="images/PPSwap.png" />"/>
        </div>
        
  <div class="form">
  <form class="login-form" action="Sign_in_controller.jsp" method="post">
     
      <input type="text" style="background-image: url('images/Envelope.png');" placeholder="USERNAME" name="userID"/>
      <input type="password" style="background-image: url('images/Lock.png'); " placeholder="PASSWORD" name="password"/>
         <%
		String message=(String)session.getAttribute("login_message");
		
		if(message!=null){
			out.println(message);
			session.removeAttribute("login_message");
		}
		%>
      <button>LOGIN</button>
 
    </form>
  </div>
  <div style="font-size: 16px;">New User? <u><a href="register.jsp" style="color:white;">Register Here</u></a></div>
</div>


</body>
</html>
