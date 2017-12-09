package T14DAOs;
import java.sql.*;


public class CreateReviewDAO
{

  public static void newReview(String text, int entreeNum, int userNum, float rating)
  {
    try
    {
      // create a mysql database connection
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "team14");
    
      PreparedStatement oPrStmt = conn
				.prepareStatement("SELECT MAX(ReviewNum) FROM reviews;");// ? represents some parameter to include
																						
		ResultSet rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
		rs.first();
		Integer highestID = rs.getInt(1);	//highestID becomes the integer stored from this first query
		
		//System.out.println("The value returned by rs.getInt(1) = "+ highestID);

      // the mysql insert statement
      //String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
        //+ " values (?, ?, ?, ?, ?)";
      
      String query = "INSERT INTO reviews (ReviewNum, ReviewText, AboutEntreeNumber, Author, Rating) "+
    	          "values (?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      //preparedStmt.setString (1, "Barney");
      //preparedStmt.setString (2, "Rubble");
      //preparedStmt.setDate   (3, startDate);
      //preparedStmt.setBoolean(4, false);
      //preparedStmt.setInt    (5, 5000);
      
      preparedStmt.setInt    (1, highestID+1);	//increments the highestID so that new users always have a unique one
      preparedStmt.setString (2, text);
      preparedStmt.setInt	 (3, entreeNum);
      preparedStmt.setInt    (4, userNum);
      preparedStmt.setFloat  (5, rating);

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