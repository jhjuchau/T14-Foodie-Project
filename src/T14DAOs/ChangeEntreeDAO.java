package T14DAOs;
import java.sql.*;


public class ChangeEntreeDAO
{

  public static void clearFlag(int entreeNum)
  {
    try
    {
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
      
      String query = "UPDATE entrees SET AttentionFlag = 0 WHERE EntreeNum = "+entreeNum;

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
  
  public static void deleteEntree(int entreeNum)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
      
      String query = "DELETE FROM entrees where EntreeNum="+entreeNum;

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
  
  public static void deleteAssociatedReviews(int entreeNum)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
      
      String query = "DELETE FROM reviews where AboutEntreeNumber="+entreeNum;

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}