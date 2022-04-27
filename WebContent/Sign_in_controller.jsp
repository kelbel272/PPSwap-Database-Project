<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@ page import="modal.Login_Modal" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj_Login_Bean" class="bean.Login_Bean"></jsp:useBean>
<jsp:setProperty property="*" name="obj_Login_Bean"/>

<%
System.out.println(obj_Login_Bean.getUserID());
System.out.println(obj_Login_Bean.getPassword());


Login_Modal obj_Login_Modal=new Login_Modal();

//Check if Admin 
boolean isRoot = obj_Login_Modal.isRoot(obj_Login_Bean);

//Check if User
boolean isUser = obj_Login_Modal.check_userID(obj_Login_Bean);

if (isRoot){
	
	session.setAttribute("user_session", obj_Login_Bean);
	response.sendRedirect("RootHome.jsp");
} else if (isUser) {
	
	session.setAttribute("user_session", obj_Login_Bean);
	response.sendRedirect("Home2.jsp");
} else {
	
	session.setAttribute("login_message", "Login Failed");
	response.sendRedirect("login.jsp");
}


%>
</body>
</html>