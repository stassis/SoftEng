import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class getPrices {
	
	static int rice;
	static int pizza;
	static int chicken;
	static int beef;
	
	public getPrices() {
		
		int counter=0;
		
		
		try {
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
				
			String sql = "SELECT price FROM plate";
			ResultSet rs = stmt.executeQuery(sql);	
								
			while (rs.next()) {
		            
		           int price = rs.getInt("price");
		            
		           if(counter == 0) {
		        	   
		        	   this.rice = price;
		        	   counter++;
		        	   
		           }else if(counter == 1) {
		        	   
		        	   this.pizza = price;
		        	   counter++;
		        	   
		           }else if(counter == 2) {
		        	   
		        	   this.chicken = price;
		        	   counter++;
		           }else {
		        	   
		        	   this.beef = price;
		        	   counter++;
		           }
		            
		    }
			
			rs.close();
			stmt.close();
			c.close();
		
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
