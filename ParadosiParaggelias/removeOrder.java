import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class removeOrder {

	
	public removeOrder(String orderid) {
		
		try {
	    	
			int oid=Integer.parseInt(orderid);
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
				
			String sql = "UPDATE orders SET flag='canceled'  WHERE order_id="+oid;
			stmt.executeUpdate(sql);	
			
			stmt.close();
			c.close();
			
			}catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	}
}