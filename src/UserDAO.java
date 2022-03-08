import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
/**
 * Servlet implementation class Connect
 */

@WebServlet("/UserDAO")
public class UserDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	UserDAO() {
		
	}

	protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=john&password=pass1234");
            System.out.println(connect);
        }
    }
	
	// Create User Database 
	public void createDatabase() {
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
			
		statement = connect.createStatement();
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
		statement.executeUpdate("DROP TABLE IF EXISTS Users");
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
		
		String sqlstmt = "CREATE TABLE IF NOT EXISTS Users " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " UserID VARCHAR(50), " + 
                " Password VARCHAR(50), " + 
                " First_Name VARCHAR(50), " + 
                " Last_Name VARCHAR(50), " + 
                " Birthdate VARCHAR(50), " + 
                " Street VARCHAR(50), " + 
                " Unit VARCHAR(50), " + 
                " City VARCHAR(50), " + 
                " State VARCHAR(50), " + 
                " Zipcode VARCHAR(50), " + 
                " PRIMARY KEY ( id ))"; 
		statement.executeUpdate(sqlstmt);
		statement.close();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				//Need to make this function at the bottom
			}
	}
	
	public void seedDatabase() {
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
			
			statement = connect.createStatement();
			
			preparedStatement = connect
					.prepareStatement("insert into Users(UserID, Password, First_Name, "
							+ "Last_Name, Birthdate, Street, Unit, City, State, "
							+ "Zipcode) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//Insert Root User
			preparedStatement.setString(1, "root");
			preparedStatement.setString(2, "pass1234");
			preparedStatement.setString(3, "Root");
			preparedStatement.setString(4, "");
			preparedStatement.setString(5, "");
			preparedStatement.setString(6, "");
			preparedStatement.setString(7, "");
			preparedStatement.setString(8, "");
			preparedStatement.setString(9, "");
			preparedStatement.setString(10, "");
			preparedStatement.executeUpdate();
			
			//Insert User: Kelly
			preparedStatement.setString(1, "kelly@gmail.com");
			preparedStatement.setString(2, "kelbel272");
			preparedStatement.setString(3, "Kelly");
			preparedStatement.setString(4, "W");
			preparedStatement.setString(5, "08/17/1993");
			preparedStatement.setString(6, "123 Detroit Ave");
			preparedStatement.setString(7, "Unit 202");
			preparedStatement.setString(8, "Detroit");
			preparedStatement.setString(9, "MI");
			preparedStatement.setString(10, "48208");
			preparedStatement.executeUpdate();
			
			//Insert User: Kylie
			preparedStatement.setString(1, "kylie@gmail.com");
			preparedStatement.setString(2, "kylielee");
			preparedStatement.setString(3, "Kylie");
			preparedStatement.setString(4, "Lee");
			preparedStatement.setString(5, "02/17/2000");
			preparedStatement.setString(6, "222 Anthony Wayne Drive");
			preparedStatement.setString(7, "");
			preparedStatement.setString(8, "Detroit");
			preparedStatement.setString(9, "MI");
			preparedStatement.setString(10, "48208");
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	 
	public boolean isValid(String username, String password) {
		boolean flag = false;
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
			
		String sqlstmt = "Select * from Users where UserID='" + username + "' and password= '" + password;
		ResultSet rs = statement.executeQuery(sqlstmt);
			if (rs.next()) 
				flag = true;
			} catch (Exception e) {
				System.out.println(e);
			} finally {
			}
		
			return flag;
		}
	
	public boolean isRoot(String username, String password) {
		boolean flag = false;
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
			
		String sqlstmt = "Select * from Admin where UserID='" + username + "' and password= '" + password;
		ResultSet rs = statement.executeQuery(sqlstmt);
			if (rs.next()) 
				flag = true;
			} catch (Exception e) {
				System.out.println(e);
			} finally {
			}
		
			return flag;
		}
	
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    
    
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
     
}
