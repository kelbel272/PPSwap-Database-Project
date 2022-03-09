import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class Connect
 */

public class TweetsDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public TweetsDAO() {
		
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
	
	// Create Tweet Database 
	public void createDatabase() {
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
			
		statement = connect.createStatement();
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
		statement.executeUpdate("DROP TABLE IF EXISTS Tweets");
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
		
		String sqlstmt = "CREATE TABLE IF NOT EXISTS Users " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " UserID VARCHAR(50), " + 
                " Tweet VARCHAR(200), " + 
                " Created_At VARCHAR(50), " + 
                " total_likes INTEGER(50), " + 
                " total_comments INTEGER(50), " + 
                " PRIMARY KEY ( id ))"; 
		statement.executeUpdate(sqlstmt);
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
					.prepareStatement("insert into Tweets(UserID, Tweet, Created_At, "
							+ "total_likes, total_comments) values (?, ?, ?, ?, ?)");
			
			//Insert Tweet
			preparedStatement.setString(1, "kelly@gmail.com");
			preparedStatement.setString(2, "I hate mondays.");
			preparedStatement.setString(3, "2022.01.12.01:22:66");
			preparedStatement.setString(4, "0");
			preparedStatement.setString(5, "0");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "halsey@gmail.com");
            preparedStatement.setString(2, "Excited for the new Master Chef Junior season!");
            preparedStatement.setString(3, "2021.03.12.12:21:56");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "jungkook@gmail.com");
            preparedStatement.setString(2, "Excited for our concert in Las Vegas!");
            preparedStatement.setString(3, "2022.03.11.10:12:45");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "squidgames@gmail.com");
            preparedStatement.setString(2, "Seasaon Two????");
            preparedStatement.setString(3, "2022.02.28.09:12:38");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "jlo@gmail.com");
            preparedStatement.setString(2, "How far away is Christmas?");
            preparedStatement.setString(3, "2022.01.18.04:21:46");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "hstyles@gmail.com");
            preparedStatement.setString(2, "Why is my internet connection rubbish");
            preparedStatement.setString(3, "2020.01.22.03:22:56");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "steveh@gmail.com");
            preparedStatement.setString(2, "FAMILY FEUDDDD");
            preparedStatement.setString(3, "2021.12.12.03:12:46");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            
            preparedStatement.setString(1, "obama@gmail.com");
            preparedStatement.setString(2, "I love meatloaf");
            preparedStatement.setString(3, "2021.08.13.12:12:46");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "kelly@gmail.com");
            preparedStatement.setString(2, "I love databases");
            preparedStatement.setString(3, "2022.01.22.09:02:26");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "kylie@gmail.com");
            preparedStatement.setString(2, "Why are weekends so far away");
            preparedStatement.setString(3, "2021.09.12.11:42:36");
            preparedStatement.setString(4, "0");
            preparedStatement.setString(5, "0");
            preparedStatement.executeUpdate();
            
			//Add 9 more 
			
		} catch (Exception e) {
			System.out.println(e);
		}
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
