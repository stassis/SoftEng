import java.sql.*;

public class Booking {
	int startHH, startmm, endHH, endmm, table, seats, cust_id;
	String name;
	
	Booking(int startHH, int startmm, int endHH, int endmm, int table_id, int seats, int cust_id, String name) {
		this.startHH = startHH;
		this.startmm = startmm;
		this.endHH = endHH;
		this.endmm = endmm;
		this.table = table_id;
		this.seats = seats;
		this.cust_id = cust_id;
		this.name = name;
		
		try
	    {
	         		     
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	   
	      String sql = " INSERT INTO `booking` (`cust_id`, `seats`, `startHH`, `startmm`, `endHH`, `endmm`, `table_id`, `Name`) VALUES (?,?,?,?,?,?,?,?);";	               		      
	     
	      PreparedStatement pr = c.prepareStatement(sql);
	      
	      pr.setInt (1, cust_id);
	      pr.setInt (2, seats);
	      pr.setInt (3, startHH);
	      pr.setInt (4, startmm);
	      pr.setInt (5, endHH);
	      pr.setInt (6, endmm);
	      pr.setInt (7, table_id);
	      pr.setString(8, name);
	      
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
