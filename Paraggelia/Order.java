import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Order {
	
	int order_id;
	int cust_id;
	int q1;
	int q2;
	int q3;
	int q4;
	
	public Order( int cust_id, int q1, int q2, int q3, int q4 ) {
	   this.cust_id = cust_id;
	   this.q1 = q1;
	   this.q2 = q2;
	   this.q3 = q3;
	   this.q4 = q4;
	   
	   try
	    {
	         		     
		 Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	   
	      String sql = " INSERT INTO `orders` (`customer_id`, `quantity1`, `quantity2`, `quantity3`, `quantity4`, `flag`) VALUES (?, ?, ?, ?, ?, 'submitted');";	               		      
	     
	      PreparedStatement pr = c.prepareStatement(sql);
	      
	      pr.setInt (1, cust_id);
	      pr.setInt (2, q1);
	      pr.setInt (3, q2);
	      pr.setInt (4, q3);
	      pr.setInt (5, q4);
	      
	      pr.execute();	               		      
	      c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
	 
	 
	 }
	 
	 

	
	//public void getPlates() {
	     
	//}
	
	//public void getTable() {
		
	//}

	//public getOrderList() {
		
	//}
}
