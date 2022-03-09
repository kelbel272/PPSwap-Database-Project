import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Login_Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

import modal.Login_Modal;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */


public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
    private UserDAO userDAO;
    private TweetsDAO tweetsDAO;
    private TweetCommentsDAO tweetCommentsDAO;
    private UserFeedsDAO userFeedsDAO;
    private UserFollowersDAO userFollowersDAO;
    private TweetLikesDAO tweetLikesDAO;
    private AccountDAO accountDAO;
    private ActivityDAO activityDAO;
    
    private Login_Modal loginModal;
    private Login_Bean loginBean;
    
 
    public void init() {
    	peopleDAO = new PeopleDAO();
        userDAO = new UserDAO();
        tweetsDAO = new TweetsDAO();
        tweetCommentsDAO = new TweetCommentsDAO();
        userFeedsDAO = new UserFeedsDAO();
        userFollowersDAO = new UserFollowersDAO();
        tweetLikesDAO = new TweetLikesDAO();
        accountDAO = new AccountDAO();
        activityDAO = new ActivityDAO();
        loginModal = new Login_Modal();
        loginBean = new Login_Bean();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doPost started: 000000000000000000000000000");
        doGet(request, response);
        System.out.println("doPost finished: 11111111111111111111111111");
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("doGet started: 000000000000000000000000000"); 
     
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/initialize":
            	initializeDatabase(request, response);
            	break;
            case "/login": 
                System.out.println("The action is: login");
                login(request, response);           	
                break;
            case "/register":
            	System.out.println("The action is: register");
                register(request, response);           	
                break;
            case "/new":
                System.out.println("The action is: new");
                showNewForm(request, response);
                break;
            case "/insert":
                System.out.println("The action is: insert");
            	   insertPeople(request, response);
                break;
            case "/delete":
                System.out.println("The action is: delete");
            	   deletePeople(request, response);
                break;
            case "/edit":
                System.out.println("The action is: edit");
                showEditForm(request, response);
                break;
            case "/update":
                System.out.println("The action is: update");
            	   updatePeople(request, response);
                break;
            default:
                System.out.println("Not sure which action, we will treat it as the list action");
                listPeople(request, response);           	
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        System.out.println("doGet finished: 111111111111111111111111111111111111");
    }
    
    public void initializeDatabase(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	userDAO.createDatabase();
    	tweetsDAO.createDatabase();
    	tweetCommentsDAO.createDatabase();
    	userFeedsDAO.createDatabase();
    	userFollowersDAO.createDatabase();
    	tweetLikesDAO.createDatabase();
    	accountDAO.createDatabase();
    	activityDAO.createDatabase();
    	
    	//Add DAOs for each table of database 
    	userDAO.seedDatabase();
    	tweetsDAO.seedDatabase();
    	tweetCommentsDAO.seedDatabase();
       	userFeedsDAO.seedDatabase();
       	userFollowersDAO.seedDatabase();
       	tweetLikesDAO.createDatabase();
    	accountDAO.seedDatabase();
    	activityDAO.seedDatabase();
    	
    }
    
    public void login(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	
    	String username = request.getParameter("userID");
    	String password = request.getParameter("password");
    	if (userDAO.isRoot(username,password))
    		response.sendRedirect("NewRootPage.jsp");
    	else if (userDAO.isValid(username,password))
    		response.sendRedirect("Home1.jsp");
    	else
    		response.sendRedirect(password);
    }
    
    public void register(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, IOException, ServletException {
    	//REGISTER USER HERE (INSERT)
    	System.out.println("register started: 000000000000000000000000000");
    	
    	String username = request.getParameter("userID");
    	String password = request.getParameter("password");
    	String fname = request.getParameter("First_Name");
    	String lname = request.getParameter("Last_Name");
    	String birthdate = request.getParameter("birthdate");
    	String street = request.getParameter("street");
    	String unit = request.getParameter("unit");
    	String city = request.getParameter("city");
    	String state = request.getParameter("state");
    	String zip = request.getParameter("zipcode");
    	
    	
        System.out.println("userID: " + username + ", password: "+ password + ", "
        		+ "fname: " + fname + ", lname: " + lname + ", birth: " + birthdate 
        		+ ", street: " + street + ", unit: " + unit + ", city: " + city 
        		+ ", state: " + ", zip: " + zip);

        User newUser = new User(username, password, fname, lname, birthdate, street, unit, city, state, zip);
        userDAO.insert(newUser);
     
        System.out.println("Ask the browser to call the list action next automatically");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("Home1.jsp");
        dispatcher.forward(request, response);
     
        System.out.println("insertPeople finished: 11111111111111111111111111");   
        
    }
    
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("listPeople started: 00000000000000000000000000000000000");

     
        List<People> listPeople = peopleDAO.listAllPeople();
        request.setAttribute("listPeople", listPeople);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
     
        System.out.println("listPeople finished: 111111111111111111111111111111111111");
    }
 
    // to insert a people
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showNewForm started: 000000000000000000000000000");
     
        RequestDispatcher dispatcher = request.getRequestDispatcher("InsertPeopleForm.jsp");
        dispatcher.forward(request, response);
        System.out.println("The user sees the InsertPeopleForm page now.");
     
        System.out.println("showNewForm finished: 1111111111111111111111111111111");
    }
 
    // to present an update form to update an  existing Student
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        System.out.println("showEditForm started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        People existingPeople = peopleDAO.getPeople(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditPeopleForm.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response); // The forward() method works at server side, and It sends the same request and response objects to another servlet.
        System.out.println("Now you see the EditPeopleForm page in your browser.");
     
        System.out.println("showEditForm finished: 1111111111111111111111111111");
    }
 
    // after the data of a people are inserted, this method will be called to insert the new people into the DB
    // 
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("insertPeople started: 000000000000000000000000000");
     
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        System.out.println("name:" + name + ", address: "+address + ", status:" + status);
     
        People newPeople = new People(name, address, status);
        peopleDAO.insert(newPeople);
     
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list");  //
     
        System.out.println("insertPeople finished: 11111111111111111111111111");   
    }
 
    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("updatePeople started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        System.out.println("name:" + name + ", address: "+address + ", status:" + status);
        
        People people = new People(id,name, address, status);
        peopleDAO.update(people);
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list");
     
        System.out.println("updatePeople finished: 1111111111111111111111111111111");
    }
 
    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        System.out.println("deletePeople started: 000000000000000000000000000");
     
        int id = Integer.parseInt(request.getParameter("id"));
        //People people = new People(id);
        peopleDAO.delete(id);
        System.out.println("Ask the browser to call the list action next automatically");
        response.sendRedirect("list"); 
     
        System.out.println("deletePeople finished: 1111111111111111111111111111111");
    }

}
