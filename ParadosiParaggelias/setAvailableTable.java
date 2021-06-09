import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class setAvailableTable {

private String tableid;	
private int tableint;
private int tableValue;
	
	public setAvailableTable(String id) {
		
		this.tableid = id;
		
		if(tableid == "Table 1") {
			
			this.tableint = 1;
			
		}else if(tableid == "Table 2") {
			
			this.tableint = 2;
			
		}else if(tableid == "Table 3") {
			
			this.tableint = 3;
			
		}else if(tableid == "Table 4") {
			
			this.tableint = 4;
			
		}else if(tableid == "Table 5") {
			
			this.tableint = 5;
		}
		
		try {
			
			//sundesi me ti vasi dedomenwn + ektelesi query
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
    		Statement stmt = c.createStatement();
    		String sql = "SELECT isOccupied FROM tables WHERE id="+tableint;
    		ResultSet rs = stmt.executeQuery(sql);			
    		
			while(rs.next()) {
	            
				tableValue = rs.getInt("isOccupied"); 
	         }
			
			System.out.print(tableValue);
			if(tableValue == 1) {
				
				String s=Integer.toString(tableValue);
				
				String sql2 = "UPDATE tables SET isOccupied=0 WHERE id="+tableint;
				PreparedStatement stmt2 = c.prepareStatement(sql);
				stmt2.executeUpdate(sql2);
				
				
				
				
				
				JOptionPane.showMessageDialog(null, "Table "+tableint+" is now Available!");
			}else{
				
				JOptionPane.showMessageDialog(null, "Table "+tableint+" is already Available!");
			}
			//apeleutherosi porwn
			c.close();
			stmt.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
	}
}
