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

public class ActivityDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ActivityDAO() {
		
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
                " Activity_Type VARCHAR(50), " + 
                " created_at VARVHAR(200), " + 
                " User_From VARCHAR(50), " + 
                " User_To VARCHAR(50), " + 
                " PPSent INTEGER(50), " + 
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
					.prepareStatement("insert into Activity(Activity_Type, created_at, "
							+ "User_From, User_To, PPSent) values (?, ?, ?, ?, ?)");
			
			//Insert Like of Tweet
			preparedStatement.setString(1, "TRANSFER");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "kelly@gmail.com");
			preparedStatement.setString(4, "kylie@gmail.com");
			preparedStatement.setString(5, "1");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "BUY");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "jlo@gmail.com");
			preparedStatement.setString(5, "12");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "SELL");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "kelly@gmail.com");
			preparedStatement.setString(4, "jlo@gmail.com");
			preparedStatement.setString(5, "100");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "obama@gmail.com");
			preparedStatement.setString(5, "200");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "TRANSFER");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "steveh@gmail.com");
			preparedStatement.setString(4, "obama@gmail.com");
			preparedStatement.setString(5, "1900");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "steveh@gmail.com");
			preparedStatement.setString(5, "300");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "SELL");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "jlo@gmail.com");
			preparedStatement.setString(4, "kelly@gmail.com");
			preparedStatement.setString(5, "100");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setString(2, "2021.03.12.12:21:56");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "hstyles@gmail.com");
			preparedStatement.setString(5, "10");
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
