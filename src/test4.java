
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class test4  {
  private static Connection connect = null;
  private static Statement statement = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;



 public static void main(String[] args) {

	 String sql1 = "DROP TABLE IF EXISTS Users";
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
    String sql3 = "insert into  Student(Name, Address, Status) values (?, ?, ?)";
    String sql4 = "insert into Student(Name, Address, Status) values (\"John Liu\", \"345 Database Road, Troy, MI 48083\", \"Junior\")";
    String sql5 = "UPDATE Student set Address=\"123 New Main Street, Troy, MI 48083\" WHERE Name=\"Shiyong Lu\"";
    String sql6 = "DELETE FROM Student WHERE Name=\"Shiyong Lu\"";

    try {
      System.out.println("Select a table and then print out its content.");
      // This will load the MySQL driver, each DB has its own driver
      //Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/testdb?"
              + "useSSL=false&user=john&password=pass1234");

        

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      statement.executeUpdate(sql1);
      statement.executeUpdate(sqlstmt);

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


      // see the results 
      resultSet = statement.executeQuery("select * from Users");
      writeResultSet(resultSet);

     
      
    } catch (Exception e) {
         System.out.println(e);
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private static void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    System.out.println("print result from a table..");
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      Integer id = resultSet.getInt("id");
      String userID = resultSet.getString("UserID");
      String password = resultSet.getString("Password");
      String fname = resultSet.getString("First_Name");
      String lname = resultSet.getString("Last_Name");
      String bday = resultSet.getString("Birthdate");
      String street = resultSet.getString("Street");
      String unit = resultSet.getString("Unit");
      String city = resultSet.getString("City");
      
      String status = resultSet.getString("Status");
      System.out.println("id " + id);
      System.out.println("name: " + name);
      System.out.println("address: " + address);
      System.out.println("status: " + status);
      System.out.println("");
    }
  }

  // You need to close the resultSet
  private static void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }
} 
