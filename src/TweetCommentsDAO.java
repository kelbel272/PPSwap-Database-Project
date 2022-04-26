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

public class TweetCommentsDAO {     
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
		statement.executeUpdate("DROP TABLE IF EXISTS TweetComments");
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
		
		String sqlstmt = "CREATE TABLE IF NOT EXISTS TweetComments " +
                "(id INTEGER not NULL AUTO_INCREMENT, " +
                " TweetID INTEGER(50), " + 
                " UserID VARCHAR(200), " + 
                " Comment VARCHAR(50), " + 
                " Created_At DATETIME, " + 
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY ( TweetID ) References Tweets( tweetid ), " +
                " FOREIGN KEY ( UserID ) References Users( Email ))"; 
		statement.executeUpdate(sqlstmt);
		System.out.println("TweetComments Table Created");
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
					.prepareStatement("insert into TweetComments(TweetID, UserID, Comment, "
							+ "Created_At) values (?, ?, ?, ?)");
			
			//Insert Comment to Tweet 
			preparedStatement.setInt(1, "1");
			preparedStatement.setString(2, "kelly@gmail.com");
			preparedStatement.setString(3, "yaaasssss");
			preparedStatement.setString(4, "2020-12-23 09:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "2");
			preparedStatement.setString(2, "kelly@gmail.com");
			preparedStatement.setString(3, "what a mood");
			preparedStatement.setString(4, "2021-05-23 09:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "3");
			preparedStatement.setString(2, "kylie@gmail.com");
			preparedStatement.setString(3, "<3");
			preparedStatement.setString(4, "2022-01-24 08:23:40");
			preparedStatement.executeUpdate();
	
			preparedStatement.setInt(1, "4");
			preparedStatement.setString(2, "jungkook@gmail.com");
			preparedStatement.setString(3, "#love_yourself");
			preparedStatement.setString(4, "2020-10-23 08:24:40");
			preparedStatement.executeUpdate();
		
			preparedStatement.setInt(1, "5");
			preparedStatement.setString(2, "hstyles@gmail.com");
			preparedStatement.setString(3, "whaaaat");
			preparedStatement.setString(4, "2021-09-23 10:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "6");
			preparedStatement.setString(2, "halsey@gmail.com");
			preparedStatement.setString(3, "naur");
			preparedStatement.setString(4, "2020-10-23 08:24:40");
			preparedStatement.executeUpdate();

			preparedStatement.setInt(1, "6");
			preparedStatement.setString(2, "kylie@gmail.com");
			preparedStatement.setString(3, "what the-");
			preparedStatement.setString(4, "2020-10-23 09:30:40");
			preparedStatement.executeUpdate();
		
			preparedStatement.setInt(1, "9");
			preparedStatement.setString(2, "squidgames@gmail.com");
			preparedStatement.setString(3, ":D");
			preparedStatement.setString(4, "2020-04-20 08:23:45");
			preparedStatement.executeUpdate();
		
			preparedStatement.setInt(1, "8");
			preparedStatement.setString(2, "obama@gmail.com");
			preparedStatement.setString(3, "me too");
			preparedStatement.setString(4, "2020-10-23 09:23:40");
			preparedStatement.executeUpdate();
	
			preparedStatement.setInt(1, "9");
			preparedStatement.setString(2, "jlo@gmail.com");
			preparedStatement.setString(3, ":p");
			preparedStatement.setString(4, "2020-10-23 09:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "3");
			preparedStatement.setString(2, "kbates@gmail.com");
			preparedStatement.setString(3, "cool");
			preparedStatement.setString(4, "2021-01-23 09:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "3");
			preparedStatement.setString(2, "houseofcards@gmail.com");
			preparedStatement.setString(3, "omg");
			preparedStatement.setString(4, "2021-01-24 09:23:40");
			preparedStatement.executeUpdate();
			
		
			preparedStatement.setInt(1, "4");
			preparedStatement.setString(2, "kbates@gmail.com");
			preparedStatement.setString(3, "omggggg");
			preparedStatement.setString(4, "2022-01-23 09:23:40");
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, "4");
			preparedStatement.setString(2, "houseofcards@gmail.com");
			preparedStatement.setString(3, "thats pretty weird man");
			preparedStatement.setString(4, "2022-01-24 09:23:40");
			preparedStatement.executeUpdate();
			
			
			System.out.println("Sucessfully Seeded TweetComments Database");
			
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
