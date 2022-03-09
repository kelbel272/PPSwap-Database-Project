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

public class TweetLikesDAO {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public TweetLikesDAO() {
		
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
                " PostID INTEGER(50), " + 
                " UserID VARCHAR(200), " + 
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
					.prepareStatement("insert into TweetComments(PostID, UserID, "
							+ "Created_At) values (?, ?, ?)");
			
			//Insert Like of Tweet
			preparedStatement.setString(1, "1");
			preparedStatement.setString(2, "kelly@gmail.com");
			preparedStatement.setString(3, "2022.01.12.01:22:66");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "2");
            preparedStatement.setString(2, "kelly@gmail.com");
            preparedStatement.setString(3, "2022.03.01.02:12:60");
            preparedStatement.executeUpdate();
            
            preparedStatement.setString(1, "3");
            preparedStatement.setString(2, "jungkook@gmail.com");
            preparedStatement.setString(3, "2022.03.08.08:22:66");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "3");
            preparedStatement.setString(2, "squidgames@gmail.com");
            preparedStatement.setString(3, "2022.03.03.12:32:46");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "5");
            preparedStatement.setString(2, "kylie@gmail.com");
            preparedStatement.setString(3, "2022.03.09.01824:26");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "6");
            preparedStatement.setString(2, "steveh@gmail.com");
            preparedStatement.setString(3, "2022.02.28.02:22:66");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "6");
            preparedStatement.setString(2, "hstyles@gmail.com");
            preparedStatement.setString(3, "2022.03.09.03:12:26");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, "jlo@gmail.com");
            preparedStatement.setString(3, "2022.03.01.02:22:66");
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "10");
            preparedStatement.setString(2, "halsey@gmail.com");
            preparedStatement.setString(3, "2022.02.28.03:12:66");
            preparedStatement.executeUpdate(); 

            preparedStatement.setString(1, "10");
            preparedStatement.setString(2, "jungkook@gmail.com");
            preparedStatement.setString(3, "2022.03.07.12:22:16");
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