 /*The purpose of exercise 3 is to learn how to execute a CREATE/INSERT/SELECT/UPDATE/DELETE statement in Java over a table located at a local MySQL database server. 
     1) Execute each SQL statement from ch2's slides in Java. You will need to understand how method writeResultSet() works and modify it to display your results correctly. 
     2) Understand the difference between dynamic SQLs and static SQLs. 
 *
 * */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Date;

public class login  {
  private static Connection connect = null;
  private static Statement statement = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;



 public static void main(String[] args) {

    String sql1 = "DROP TABLE IF EXISTS Users";
    String sql2 = "CREATE TABLE IF NOT EXISTS Users " +
                   "(id INTEGER NOT NULL AUTO_INCREMENT,  " +
                   " userID VARCHAR(50), " + 
                   " password VARCHAR(50), " + 
                   " created_at DATETIME DEFAULT CURRENT_TIMESTAMP, "
                   " PRIMARY KEY ( userID ))"; 

    String sql3 = "insert into  Student(id, userID, password) values (?, ?, ?)";
    String sql4 = "insert into  Student(id, userID, password) values (\"2\", \"John Liu\", \"345 Database Road, Troy, MI 48083\", \"junior\")";
    String sql5 = "update Student set Address= ? where Name = ?";
    String sql6 = "DELETE FROM Student WHERE Name=\"Shiyong Lu\"";
    String sql7 = "SELECT id, Name FROM Student";
    String sql8 = "SELECT Name FROM Student WHERE id > 4999";
    String sql3 = "insert into  Login(userID, password) values (?, ?)";

  System.out.println("LOGIN TEST");
  
    try {
      System.out.println("");
      System.out.println("");
      System.out.println(""); 
      System.out.println("Select a table and then print out its content.");
      // This will load the MySQL driver, each DB has its own driver
      // Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost:3306/testdb?"
              + "useSSL=false&user=john&password=pass1234");

        

      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();

      //Create Student Table
      statement.executeUpdate(sql1);
      statement.executeUpdate(sql2);

      //Insert into table 
      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "1");
      preparedStatement.setString(2, "root");
      preparedStatement.setString(3, "pass1234");
      preparedStatement.executeUpdate();

      //Insert John Liu into Student 
      statement.executeUpdate(sql4);

      // see the results 
     resultSet = statement.executeQuery("select * from Student");
     writeResultSet(resultSet);

     System.out.println(""); 
      System.out.println("After the insert statements are executed.");

      //Insert john info 
      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "1111");    
      preparedStatement.setString(2, "John");
      preparedStatement.setString(3, "123 Main");
      preparedStatement.setString(4, "fresh");
      preparedStatement.executeUpdate();

      //Insert Mary info 
      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "2222");    
      preparedStatement.setString(2, "Mary");
      preparedStatement.setString(3, "321 Oak");
      preparedStatement.setString(4, "soph");
      preparedStatement.executeUpdate();

      //Insert Joan info 
      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "1234");        
      preparedStatement.setString(2, "Joan");
      preparedStatement.setString(3, "777 Grand");
      preparedStatement.setString(4, "soph");
      preparedStatement.executeUpdate();

      //Insert Joan info 
      preparedStatement = connect
          .prepareStatement(sql3);
      preparedStatement.setString(1, "999999999");    
      preparedStatement.setString(2, "Bill");
      preparedStatement.setString(3, "432 Pine");
      preparedStatement.setString(4, "senior");
      preparedStatement.executeUpdate();

     resultSet = statement.executeQuery("select * from Student");
     writeResultSet(resultSet);
    


       //SEE RESULTS OF select Name from Student where id > 4999
      System.out.println(""); 
      System.out.println("After SELECT Name from Student WHERE id > 4999 is executed");
      System.out.println("print result from a table..");
      System.out.println("");
      System.out.println("--------------------------");
      resultSet = statement.executeQuery(sql8);

        while(resultSet.next()) {
          System.out.println("");
          String name = resultSet.getString("Name");
          System.out.println("name: " + name);
          
      }
      System.out.println(""); 
      System.out.println("--------------------------");
      
      
     

       // SEE RESULTS OF select id, Name FROM Student 
      System.out.println(""); 
      System.out.println("After SELECT id, Name FROM Student is executed");
      System.out.println("print result from a table..");
      System.out.println(""); 
      System.out.println("--------------------------");
      System.out.println(""); 
      resultSet = statement.executeQuery("SELECT id, Name FROM Student");
      
        while (resultSet.next()) {
          Integer id = resultSet.getInt("id");
          String name = resultSet.getString("Name");
          System.out.println("id " + id);
          System.out.println("name: " + name);
          System.out.println("");
        }

        System.out.println("--------------------------");

      // SEE RESULTS OF select Id, Name FROM Student WHERE Status = 'senior'
      System.out.println(""); 
      System.out.println("After SELECT id, Name FROM Student WHERE Status = 'senior' is executed");
      System.out.println("print result from a table..");
      System.out.println(""); 
      System.out.println("--------------------------");
      System.out.println(""); 
      resultSet = statement.executeQuery("SELECT id, Name FROM Student WHERE Status = 'senior'");

        while (resultSet.next()) {
          Integer id = resultSet.getInt("Id");
          String name = resultSet.getString("Name");
          System.out.println("id " + id);
          System.out.println("name: " + name);
          System.out.println("");
        }

      System.out.println("--------------------------");
      

      // SEE RESULTS OF SELECT * FROM Student WHERE Status = 'senior‘
      System.out.println("After SELECT * FROM Student WHERE Status = 'senior' is executed");
      resultSet = statement.executeQuery("SELECT * FROM Student WHERE Status = 'senior'");
      writeResultSet(resultSet);

       // SEE RESULTS OF SELECT COUNT(*) FROM Student WHERE Status = 'senior'
      System.out.println(""); 
      System.out.println("After SELECT COUNT(*) FROM Student WHERE Status = 'senior' is executed");
      System.out.println("print result from a table..");
      System.out.println("");
      resultSet = statement.executeQuery("SELECT COUNT(*) FROM Student WHERE Status = 'senior'");
      Integer count = 1;

      while (resultSet.next()) {
        count++;
      }

      System.out.println("Total Count of Students with Senior status: " + count);

      System.out.println("");
      System.out.println("--------------------------");
      System.out.println("");
      System.out.println("After the delete statement is executed.");
      //delete shiyong data 
      statement.executeUpdate(sql6);
   
      // see the results 
      resultSet = statement.executeQuery("select * from Student");
      writeResultSet(resultSet);


      //UPDATE Student SET Status = 'soph' WHERE Id = 111111111;
      System.out.println("");
      System.out.println("After UPDATE Student SET Status = 'soph' WHERE Id = 111111111 is executed");
      String query1 = "update Student set Status = ? where id = ?";
      preparedStatement = connect.prepareStatement(query1);
      preparedStatement.setString(1, "soph");
      preparedStatement.setString(2, "111111111");
      preparedStatement.executeUpdate();
      resultSet = statement.executeQuery("select * from Student");
      writeResultSet(resultSet);


      // DELETE FROM Student WHERE Id = 111111111 
       System.out.println("");
      System.out.println("After DELETE FROM Student WHERE Id = 111111111 is executed");

      // Delete
      String query2 = "DELETE FROM Student WHERE id = ?";
      preparedStatement = connect.prepareStatement(query2);
      preparedStatement.setString(1, "111111111");
      preparedStatement.executeUpdate();
      resultSet = statement.executeQuery("select * from Student");
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
    System.out.println("");
     System.out.println("--------------------------");

        while(resultSet.next()) {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("Name");
        String address = resultSet.getString("Address");
        String status = resultSet.getString("Status");
        System.out.println("");
        System.out.println("id " + id);
        System.out.println("name: " + name);
        System.out.println("address: " + address);
        System.out.println("status: " + status);
        }
        System.out.println("");
        System.out.println("--------------------------");
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