import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Table {

	int id;
	int isOccupied;
	
	Table(int id) {
		this.id=id;
	}
	
	public static void setTableStatus (int id, int isOccup) {
		
		try
	    {
	         		     
		  Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	   
	      String sql = "UPDATE tables SET isOccupied = ?;";	               		      
	     
	      PreparedStatement pr = c.prepareStatement(sql);
	      pr.setInt (1, isOccup);
	          
	      pr.execute();	               		      
	      c.close();	               		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
		
	}
	
	
	public int[] getTables() {
		int[] flag = {0,0,0,0,0};
		try
	    {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			
			String sql = "SELECT * FROM tables";
			
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int count=0;
			while(rs.next()) {
				flag[count] = rs.getInt("isOccupied");
				count++;}
			          		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
		return flag; 
	}
}
