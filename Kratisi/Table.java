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
	
	public void setTableStatus (int id, int isOccup) {
		this.isOccupied=isOccup;
		
		try
	    {
	         		     
		  Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
	   
	      String sql = "INSERT INTO `tables` (`isOccupied`) VALUES (?);";	               		      
	     
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
	
	
	public int getTables() {
		int tmp=0, flag=0;
		try
	    {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			
			String sql = "SELECT * FROM `tables` WHERE 1";
			
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int count=0;
			while(rs.next()) {
				tmp = rs.getInt("isOccupied");
				flag = flag + ((10^count) * tmp); 
				count++;}
			          		   
	    }
	    catch (Exception ee)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(ee.getMessage());
	    }
		return flag; //return a 5 digit binary int [table5, table4, table3, table2, table1]. use MOD to choose table
		// example: flag = 00101 -> Tables 3 and 1 are isOccupied = true
	}
}
