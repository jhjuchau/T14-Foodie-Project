package T14DAOs;

import importedMethods.ResultsDecoratorHTML;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



public class PullEntreeReviewsDAO
{
  public static ResultSet listReviews(int entreeNum)
  {
	try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";

      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
    
      PreparedStatement oPrStmt = conn
				.prepareStatement("SELECT * FROM reviews WHERE AboutEntreeNumber='"+entreeNum+"';");// ? represents some parameter to include
  
		ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
		return rs;
		
    }catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    return null;
  }
  
  public static String singleEntreeInfo(int entreeNum)
  {
	  
	try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";

      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
    
      PreparedStatement oPrStmt = conn
				.prepareStatement("SELECT * FROM entrees WHERE EntreeNum='"+entreeNum+"';");// ? represents some parameter to include
      																			
		ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
		String entreeName = rs.getString("EntreeName");
		return entreeName;
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    return "blah";
  }
  
}