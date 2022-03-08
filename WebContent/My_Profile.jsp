<%@page import="bean.Login_Bean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Page</title>
</head>
<body>

<%
	Login_Bean obj_Login_Bean = (Login_Bean)session.getAttribute("user_session");
	
	//If you have not logged in, user is taken back to the login screen
	if(obj_Login_Bean == null){	
		session.setAttribute("login_message", "Please login first");
	%>
	<script type="text/javascript">
		window.location.href="http://localhost:8080/database/index.jsp";
	</script>
	<%
	}
	%>
	
<center>
<h1>Profile Page</h1>

<!-- Navigation Bar -->
<table>
<tr>
<td><a href="Home.jsp">Home</a></td>
<td><a href="My_Profile.jsp">Profile</a></td>
<td> Welcome <%=obj_Login_Bean.getUserID() %></td>
<td><a href="Signout_controller.jsp">Log Out</a></td>
</tr>
</table>
</center>
</body>
</html>