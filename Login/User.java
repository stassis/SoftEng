import java.sql.*;


public class User {
	 private String id, Role, Password;
	 	 
	 public User(String id,String Role,String Password)
	 {this.id=id;
	 this.Role=Role;
	 this.Password=Password;
	 
	 try
	    {
	         		     
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	   
	      String sql = " INSERT INTO `user2` (`Role`, `Password`) VALUES (?, ?);";	               		      
	     
	      PreparedStatement pr = c.prepareStatement(sql);
	      
	      pr.setString (1, Role);
	      pr.setString (2, Password);
	      
	      
	      pr.execute();	               		      
	      c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
	 
	 
	 }
	 
	 
	 
}

