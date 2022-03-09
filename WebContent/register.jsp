

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>PPSwap - Login</title>
      <link rel="stylesheet" type="text/css" href="assets/css/StyleSheet-Registration.css">
</head>

<body>
  <div class="ppswap">
            <img alt="logo" style="width: 150px; height: 150px;" src="assets/images/PPSwap.png"/>
        </div>
        
  <div class="form">
  <!--  Need to add REGISTER to ControlServlet -->
  <form class="ControlServlet registration" action="register" method="post">
      <!--- First Name Field  -->
      <input type="text" style="background-image: url('assets/images/Envelope.png');" placeholder="FIRST NAME" name="First_Name"/>
      <!--- Last Name Field  -->
      <input type="text" style="background-image: url('assets/images/Lock.png'); " placeholder="LAST NAME" name="Last_Name"/>

            <!--- Email Field  -->
            <input type="email" style="background-image: url('assets/images/Envelope.png');" id="userID" name="userID" placeholder="EMAIL">

            <!--- JS Email Field  -->
            <input type="text" style="background-image: url('assets/images/Info-circle.png'); border: none; font-family: Montserrat-Medium; "   placeholder="an account with this email already exists" readonly>

            <!--- Password Field -->
            <input type="password" style="background-image: url('assets/images/Lock.png'); " id="password" name="password" placeholder="PASSWORD">
            <div></div>

            <!--- Confirm Password Field -->
            <input type="password" style="background-image: url('assets/images/Lock.png'); " id="passwordConfirm" name="passwordConfirm" placeholder="CONFIRM PASSWORD">

            <!--- Confirm Password Field -->
            <input type="text" style="background-image: url('assets/images/Info-circle.png'); border: none; font-family: Montserrat-Medium; "   placeholder="passwords do not match">

            <!--- Birthdate Field  -->
            <input type="date" style="background-image: url('assets/images/Present.png'); " id="birthdate" name="birthdate" placeholder="BIRTHDAY">
            <div></div>

            <!--- Address Line 1 Field  -->
            <input type="text" style="background-image: url('assets/images/Location.png');" id="street" name="street" placeholder="ADDRESS LINE 1">

             <!--- Address Line 2 Field  -->
             <input type="text" style="background-image: url('assets/images/Location.png');" id="unit" name="unit" placeholder="ADDRESS LINE 2">

             <!--- City Field  -->
             <input type="text" style="background-image: url('assets/images/Location.png');" id="city" name="city" placeholder="CITY">

             <!--- State Field  -->
             <input type="text" style="background-image: url('assets/images/Location.png');" id="state" name="state" placeholder="STATE">

             <!--- Zipcode Field  -->
             <input type="text" style="background-image: url('assets/images/Location.png');" id="zipcode" name="zipcode" placeholder="ZIPCODE">
<div></div>
     <button onclick="register">REGISTER</button>
     
    </form>
  </div>
  <div style="display: flex; justify-content: center; margin-top: 63px; font-size: 16px;">Already have an account? <u><a href="login.jsp" style="color:white;">Login Here</u></a></div>


</body>
</html>
