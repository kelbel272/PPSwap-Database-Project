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

public class AccountDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public AccountDAO() {
		
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
                " UserID VARCHAR(50), " + 
                " Balance DOUBLE(200), " + 
                " PPSwap_Total DOUBLE(50), " + 
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
					.prepareStatement("insert into Account(UserID, Balance, "
							+ "PPSwap_Total) values (?, ?, ?)");
		
			//Insert Like of Tweet
			preparedStatement.setString(1, "root");
			preparedStatement.setString(2, "1000");
			preparedStatement.setString(3, "1,000,000,000");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "kelly@gmail.com");
			preparedStatement.setString(2, "2002");
			preparedStatement.setString(3, "200");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "obama@gmail.com");
			preparedStatement.setString(2, "198341");
			preparedStatement.setString(3, "2500");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "steveh@gmail.com");
			preparedStatement.setString(2, "53421");
			preparedStatement.setString(3, "500");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "hstyles@gmail.com");
			preparedStatement.setString(2, "100");
			preparedStatement.setString(3, "10");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "jlo@gmail.com");
			preparedStatement.setString(2, "9000");
			preparedStatement.setString(3, "200");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "squidgames@gmail.com");
			preparedStatement.setString(2, "11000");
			preparedStatement.setString(3, "100");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "jungkook@gmail.com");
			preparedStatement.setString(2, "800000");
			preparedStatement.setString(3, "0");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "halsey@gmail.com");
			preparedStatement.setString(2, "293847");
			preparedStatement.setString(3, "400");
			preparedStatement.executeUpdate();

			preparedStatement.setString(1, "kylie@gmail.com");
			preparedStatement.setString(2, "0");
			preparedStatement.setString(3, "0");
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