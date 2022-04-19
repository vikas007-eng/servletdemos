package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbctest {
      public static void main(String[] args) { 
		System.out.println("JDBC test"); //creat a lib folder and download and stored the mysql connector also build path select classpath and add lib sql connctor path

          try (// automaticallly closeable
        		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","Vikas@123"); // now its localhost n in production it might be any ip address
        		Statement statement  = connection.createStatement();
        		ResultSet rs = statement.executeQuery("select * from account"); 
          )
          {			//insert (C)
			int result = statement.executeUpdate("Insert into account values (1,'dwivedi','vkk',0099)"); // return int , how many rows are affected by update
			System.out.println("number of rows inserted" + result);
			
			//Update (U)
//			int result = statement.executeUpdate("update account set balance = 13000 where accno=2"); // return int , how many rows are affected by update
//			System.out.println("number of rows inserted" + result);
			
			//delete (D)
//			int result = statement.executeUpdate("delete from account where accno=1"); 
//			System.out.println("number of rows inserted" + result);
//			
			
			// read (R)
		
			while(rs.next()) {
				 System.out.println(rs.getInt(1)+"."+ rs.getString(2)+","+rs.getString(3)+": Balance= "+rs.getInt(4));
			}		
			
 		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			
		}
      }

