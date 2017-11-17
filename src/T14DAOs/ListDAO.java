package T14DAOs;
/*
@author: Divyang Soni
@date : 10/18/2017
@ This class is having database related methods for login application
*/
import java.sql.*;

//This modular method is designed to return a ResultSet
//This ResultSet will contain all values 
//	from a table specified by the String categoryToList
//ie ListDAO.resultList(entrees) will return a ResultSet containing all entries
//	in the 'entrees' table.

//This DAO exists to make grabbing lists of users, entrees and restaurants
//	as simple as possible.
//Parsing through the ResultSet to make the data comprehensible
//	is up to the calling method
public class ListDAO {

	public static ResultSet resultList(String categoryToList) {
		boolean foundVals = false;
		ResultSet rs = null;
		try {
			//defining database driver to use
			Class.forName("com.mysql.jdbc.Driver");
			
			//getting connection from the mysql database
			//jdbc:mysql://localhost:3306 is database url
			//login is database name
			//root : username
			//root: password
			//syntex : databaseurl/databasename, username , password
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/team14?zeroDateTimeBehavior=convertToNull", "root", "team14");
			
			

			//prepared statement is used for secure access
			// ? used for data to put in query
			// actual query to execute is
			// select * from users where username = name and password = pass
			PreparedStatement oPrStmt = con
					.prepareStatement("select * from "+categoryToList);// ? represents some parameter to include
																							
			//oPrStmt.setString(1, name);// parameter index start from 1
			//oPrStmt.setString(2, pass);
			rs = oPrStmt.executeQuery(); // executing the query and getting the resultset from databse
			
			//rs.next() shows that the resultset contains nect value or not
			// for retriving multiple results, you can use while(rs.next)
			
			if (rs.next()) { //checking if the resultset has any value?   
				foundVals = true;	//if a value is found in the result set
			}
			else{	//if no values are found in the result set
				System.out.println("No values were found in the result set.");
				System.out.println("The set will be returned null");
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return rs;
	}
}
