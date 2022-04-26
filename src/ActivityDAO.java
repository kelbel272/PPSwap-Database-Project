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
	
	// Create Activity Database 
	public void createDatabase() {
		try {
			connect_func();
			statement = (Statement) connect.createStatement();
		statement = connect.createStatement();
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
		statement.executeUpdate("DROP TABLE IF EXISTS Activity");
		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
	
		String sqlstmt = "CREATE TABLE IF NOT EXISTS Activity " +
                "( transid INTEGER not NULL AUTO_INCREMENT, " +
                " ActivityType VARCHAR(50), " + 
                " createdAt DATETIME, " + 
                " UserFrom VARCHAR(50), " + 
                " UserTo VARCHAR(50), " + 
                " PPSent INTEGER(50), " + 
                " dollarAmt DOUBLE, " +
                " PRIMARY KEY ( transid ), " +
                " FOREIGN KEY ( UserFrom ) REFERENCES Users(Email), " +
                " FOREIGN KEY ( UserTo ) REFERENCES Users(Email))"; 
		statement.executeUpdate(sqlstmt);
		 System.out.println("Activity Table Created");
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
					.prepareStatement("insert into Activity(ActivityType, createdAt, "
							+ "UserFrom, UserTo, PPSent, dollarAmt) values (?, ?, ?, ?, ?, ?)");
			
			//Insert Like of Tweet
			preparedStatement.setString(1, "TRANSFER");
			preparedStatement.setDate(2, "2021-01-01 12:22:32");
			preparedStatement.setString(3, "kelly@gmail.com");
			preparedStatement.setString(4, "kylie@gmail.com");
			preparedStatement.setInt(5, "1");
			preparedStatement.setDouble(6, ".01");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "BUY");
			preparedStatement.setDate(2, "2022-01-23 08:23:29");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "jlo@gmail.com");
			preparedStatement.setInt(5, "12");
			preparedStatement.setDouble(6, ".12");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "SELL");
			preparedStatement.setDate(2, "2020-04-20 11:23:54");
			preparedStatement.setString(3, "kelly@gmail.com");
			preparedStatement.setString(4, "root");
			preparedStatement.setInt(5, "100");
			preparedStatement.setDouble(6, "1");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setDate(2, "2021-02-23 10:23:20");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "obama@gmail.com");
			preparedStatement.setInt(5, "200");
			preparedStatement.setDouble(6, "2");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "TRANSFER");
			preparedStatement.setDate(2, "2020-03-12 04:15:30");
			preparedStatement.setString(3, "steveh@gmail.com");
			preparedStatement.setString(4, "obama@gmail.com");
			preparedStatement.setInt(5, "1900");
			preparedStatement.setDouble(6, "19");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setDate(2, "2021-08-17 05:23:50");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "steveh@gmail.com");
			preparedStatement.setInt(5, "300");
			preparedStatement.setDouble(6, "3");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "SELL");
			preparedStatement.setDate(2, "2021-01-12 01:15:32");
			preparedStatement.setString(3, "kelly@gmail.com");
			preparedStatement.setString(4, "root");
			preparedStatement.setInt(5, "10000");
			preparedStatement.setDouble(6, "100");
			preparedStatement.executeUpdate(); 

			preparedStatement.setString(1, "BUY");
			preparedStatement.setDate(2, "2020-10-23 08:23:40");
			preparedStatement.setString(3, "root");
			preparedStatement.setString(4, "hstyles@gmail.com");
			preparedStatement.setInt(5, "10");
			preparedStatement.setDouble(6, ".1");
			preparedStatement.executeUpdate();
			
			preparedStatement.setString(1, "SELL");
			preparedStatement.setDate(2, "2021-01-12 03:09:43");
			preparedStatement.setString(3, "kylie@gmail.com");
			preparedStatement.setString(4, "root");
			preparedStatement.setInt(5, "700");
			preparedStatement.setDouble(6, "7");
			preparedStatement.executeUpdate(); 
			
			preparedStatement.setString(1, "SELL");
			preparedStatement.setDate(2, "2021-01-12 04:04:04");
			preparedStatement.setString(3, "kylie@gmail.com");
			preparedStatement.setString(4, "root");
			preparedStatement.setInt(5, "500");
			preparedStatement.setDouble(6, "5");
			preparedStatement.executeUpdate(); 
			System.out.println("Sucessfully Seeded Activity Database");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Activity getActivity(String UserID) throws SQLException {
		
    	Activity activity = null;
		
        String sql = "SELECT * FROM Activity WHERE UserFrom or UserTo = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(1, UserID);
         
        
        if (resultSet.next()) {
	    String activityType = resultSet.getString("ActivityType");
            String createdAt = resultSet.getString("createdAt");
            String userFrom = resultSet.getString("UserFrom");
            String userTo = resultSet.getString("UserTo");
	    int ppSent = resultSet.getInt("PPSent");
	    double dollarAmt = resultSet.getDouble("dollarAmt");
	    
             
            activity = new Activity(activityType, createdAt, userFrom, userTo, ppSent, dollarAmt);
        }
         
        resultSet.close();
        statement.close();
         
        return activity;
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
