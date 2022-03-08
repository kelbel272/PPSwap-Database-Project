<%

//When Log out button is clicked, Remove the user_session 
session.removeAttribute("user_session");

//Display Sign Out Message
session.setAttribute("login_message", "Log Out Successful");


%>

<!-- Navigate to the Login Window after Log Out --> 
<script type="text/javascript">
	window.location.href="http://localhost:8080/database/login.jsp";
</script>
	