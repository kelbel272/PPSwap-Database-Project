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

public class UserFollowersDAO {     
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
	
	// Create Tweet Comment Database 
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
                " UserID VARCHAR(200), " + 
                " FollowerID VARCHAR(50), " + 
                " Created_At VARCHAR(50), " + 
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
					.prepareStatement("insert into UserFollowers(UserID, FollowerID, "
							+ "Created_At) values (?, ?, ?)");
			
			//Insert Comment to Tweet 
			preparedStatement.setString(1, "kelly@gmail.com");
			preparedStatement.setString(2, "kylie@gmail.com");
			preparedStatement.setString(4, "2022.01.12.01:22:66");
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
