# PPSwap Database Project 

Kelly Whitlock (fr6097)
Kylie Lee (gw2217)

Hours worked together: 20hours 

Contributions 
- Kelly 
--- Designed UI on Figma https://www.figma.com/file/GQTEI8oTlMEMKeAWFRIJQV/PPSwap
--Implemented login.jsp, register.jsp, Home1.jsp, and MyRootPage.jsp 
-- Created action functions to connect to the database

- Kylie 
--Made the database java files for each table and each of their their 10 realistic tuples 
--Fixed formatting on the CSS 
-- implemented SQL calls
-- worked on all jsp files to be compatible with project

SRC Folder 
- Account.java and AccountDAO.java
- Activity.java and ActivityDAO.java
- People.java & PeopleDAO.java
- TweetComments.java & TweetCommentsDAO.java
- TweetLikes.java & TweetLikesDAO.java
- Tweets.java & TweetsDAO.java
- User.java & UserDAO.java
- UserFeeds.java & UserFeedsDAO.java
    -TBD if using for rest of project
- UserFollowers.java & UserFollowersDAO.java
    -All of these implement their respective databases and their functions 
-Login_Bean.java and Login_Modal.java 
    -Checks info from the login page to see if admin or user 
-DB_Connection.java 
    -Used to connect to Sign_in_controller.jsp & Signout_controller.jsp

WebContent 
- Home1.jsp
- login.jsp
- My_Profile.jsp
- NewRootHome.jsp 
- register.jsp
- Sign_in_controller.jsp 
- Sign_out_controller.jsp 

WebContent/assets/css
- StyleSheet.css
    -Style Sheet for login.jsp & NewRootHome.jsp 
- StyleSheet-Registration.css 
    -Style sheet for register.jsp 


WebContent/assets/font
- Montserrat-Light.tff 
- Montserrat-Medium.tff 
- Montserrat-SemiBold.tff 
    -All fonts imported into the StyleSheets 

WebContent/assets/images
- Envelope.png
    -Used for UserID/Email form image 
- Info-Circle.png 
- Info-Triangle.png
    -Used for message when registering and email exists and passwords dont match 
- Location.png
    -Used for Address1, Address2, City, State, Zipcode form image 
- PPSwap.png 
    -PPSwap Logo 
- Present.png 
    -Used for Birthdate form image 
-User.png 
    -Used for first name and last name form image 

