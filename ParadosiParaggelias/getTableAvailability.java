import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class getTableAvailability {

private String availability;
public static JTable tabav;

	public getTableAvailability() {
		
		try {
	    	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
			Statement stmt = c.createStatement();
			String sql = "SELECT id,isOccupied FROM tables";			
			ResultSet rs = stmt.executeQuery(sql);
			
			DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Table", "Availability"}, 0){
	
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //ola ta kelia mh epexergasima
			       return false;
			    }
			};
			
			
			while (rs.next()) {
	            
				int table = rs.getInt("id");
	            int avail = rs.getInt("isOccupied");
	            
	            if(avail == 0) {
	            	
	            	this.availability = "Available";
	            	
	            }else {
	            	
	            	this.availability = "Not Available";
	            	
	            }
	            
	            String[] data = { "Table "+Integer.toString(table), availability};
	            tableModel.addRow(data);

	         }

			tabav = new JTable(tableModel);
			
			rs.close();
			stmt.close();
			c.close();
			
		}catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
