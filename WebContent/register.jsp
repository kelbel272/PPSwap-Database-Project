

<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>PPSwap - Login</title>
      <link rel="stylesheet" type="text/css" href="css/StyleSheet-Registration.css">
</head>

<body>
  <div class="ppswap">
            <img alt="logo" style="width: 150px; height: 150px;" src="images/PPSwap.png"/>
        </div>
        
  <div class="form">
  <!--  Need to add REGISTER to ControlServlet -->
  <form class="registration" action="register" method="post">
      <!--- First Name Field  -->
      <input type="text" style="background-image: url('images/Envelope.png');" placeholder="FIRST NAME" name="First_Name"/>
      <!--- Last Name Field  -->
      <input type="text" style="background-image: url('images/Lock.png'); " placeholder="LAST NAME" name="Last_Name"/>

            <!--- Email Field  -->
            <input type="email" style="background-image: url('images/Envelope.png');"  id="userID" name="userID" placeholder="EMAIL">

            <!--- JS Email Field  -->
            <input type="text" style="background-image: url('images/Info-circle.png'); border: none; font-family: Montserrat-Medium; "   placeholder="an account with this email already exists" disabled>

            <!--- Password Field -->
            <input type="password" style="background-image: url('images/Lock.png'); " id="password" name="password" placeholder="PASSWORD">
            <div></div>

            <!--- Confirm Password Field -->
            <input type="password" style="background-image: url('images/Lock.png');" id="passwordConfirm" name="passwordConfirm" placeholder="CONFIRM PASSWORD">
			
            <!--- Confirm Password Message -->
            <input type="text" style="background-image: none; border: none; font-family: Montserrat-Medium; " id="passMessage" placeholder=" " disabled>

            <!--- Birthdate Field  -->
            <input type="date" style="background-image: url('images/Present.png');" id="birthdate" name="birthdate" placeholder="BIRTHDAY">
            <div></div>

            <!--- Address Line 1 Field  -->
            <input type="text" style="background-image: url('images/Location.png');" id="street" name="street" placeholder="ADDRESS LINE 1">

             <!--- Address Line 2 Field  -->
             <input type="text" style="background-image: url('images/Location.png');" id="unit" name="unit" placeholder="ADDRESS LINE 2">

             <!--- City Field  -->
             <input type="text" style="background-image: url('images/Location.png');" id="city" name="city" placeholder="CITY">

             <!--- State Field  -->
             <input type="text" style="background-image: url('images/Location.png');" id="state" name="state" placeholder="STATE">

             <!--- Zipcode Field  -->
             <input type="text" style="background-image: url('images/Location.png');" id="zipcode" name="zipcode" placeholder="ZIPCODE">
<div></div>
     <button>REGISTER</button>
     
    </form>
  </div>
  <div style="display: flex; justify-content: center; margin-top: 63px; font-size: 16px;">Already have an account? <u><a href="login.jsp" style="color: white;">Login Here</u></a></div>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js">
    </script>
<script type="text/javascript">
//Check if passwords match 
$(document).ready(function(){
    $("#passwordConfirm").keyup(function(){
         if ($("#password").val() != $("#passwordConfirm").val()) {
             $("#passMessage").attr("placeholder", "passwords do not match");
             $("#passMessage").css("background-image", "url('images/Info-circle.png')");
         }else{
        	  $("#passMessage").css("background-image", "");
        	  $("#passMessage").attr("placeholder", "");
        }
  });
  
    
});

</script>

</body>
</html>
