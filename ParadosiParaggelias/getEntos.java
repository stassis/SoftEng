import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class getEntos {

	
	public static JTable jt;
	public static ArrayList<String> ids = new ArrayList<String>();
	
	public getEntos() {
		

	
	new getPrices();
	
		try {
	    	
	    	ids.clear();
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT order_id,customer_id,quantity1,quantity2,quantity3,quantity4,orderstable FROM orders WHERE delivery='Entos tou xwrou' AND flag='ready'";
			ResultSet rs = stmt.executeQuery(sql);	
			
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Order ID", "Customer ID", "Rice", "Pizza","Chicken","Beef","Table","Total Cost"}, 0){
	
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       return false;
			    }
			};
			
			
			while (rs.next()) {
	            
	            int orderid = rs.getInt("order_id");
	            int custid = rs.getInt("customer_id");
	            int q1 = rs.getInt("quantity1");
	            int q2 = rs.getInt("quantity2");
	            int q3 = rs.getInt("quantity3");
	            int q4 = rs.getInt("quantity4");
	            int orderstable = rs.getInt("orderstable");
	            int totalcost = q1*getPrices.rice + q2*getPrices.pizza + q3*getPrices.chicken + q4*getPrices.beef;
	            
	            String[] data = { Integer.toString(orderid), Integer.toString(custid), "x"+Integer.toString(q1), "x"+Integer.toString(q2), Integer.toString(q3), "x"+Integer.toString(q4), "No."+Integer.toString(orderstable), Integer.toString(totalcost)+"$"};
	            tableModel.addRow(data);
	            
	            this.ids.add(Integer.toString(orderid));
	         }

			jt = new JTable(tableModel);
			
			rs.close();
			stmt.close();
			c.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}