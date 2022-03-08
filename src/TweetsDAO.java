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
