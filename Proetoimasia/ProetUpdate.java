import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class ProetUpdate {

	public ProetUpdate(DefaultTableModel tm1, DefaultTableModel tm2, DefaultTableModel tm3,
			DefaultTableModel tm4) {
	try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pdinera","root","");
    	String sql = "SELECT COUNT(*) AS total FROM food";
    	Statement stmt = c.createStatement();
    	ResultSet rs = stmt.executeQuery(sql);
    				
    	rs.next();
    	int rows = rs.getInt("total");
    	System.out.println(rows);
    						
    	for(int a=0; a<rows; a++) {
    		if((String)tm1.getValueAt(a, 2) == null) { }
    		else {
    			int tmp = Integer.parseInt((String)tm1.getValueAt(a,2));
    			String fagito = (String)tm1.getValueAt(a,0);
    			sql = "UPDATE `food` SET `Posotita` = `Posotita` - '"+tmp+"' WHERE `fagito` = '"+fagito+"'";
    			System.out.println(tmp+"  "+fagito);
    			stmt.executeUpdate(sql);	}
    			}
    	
    	for(int a=0; a<rows; a++) {
    		if((String)tm2.getValueAt(a, 2) == null) { }
    		else {
    			int tmp = Integer.parseInt((String)tm2.getValueAt(a,2));
    			String fagito = (String)tm2.getValueAt(a,0);
    			sql = "UPDATE `food` SET `Posotita` = `Posotita` - '"+tmp+"' WHERE `fagito` = '"+fagito+"'";
    			System.out.println(tmp+"  "+fagito);
    			stmt.executeUpdate(sql);	}
    			}
    	
    	for(int a=0; a<rows; a++) {
    		if((String)tm3.getValueAt(a, 2) == null) { }
    		else {
    			int tmp = Integer.parseInt((String)tm3.getValueAt(a,2));
    			String fagito = (String)tm3.getValueAt(a,0);
    			sql = "UPDATE `food` SET `Posotita` = `Posotita` - '"+tmp+"' WHERE `fagito` = '"+fagito+"'";
    			System.out.println(tmp+"  "+fagito);
    			stmt.executeUpdate(sql);	}
    			}
    	
    	for(int a=0; a<rows; a++) {
    		if((String)tm4.getValueAt(a, 2) == null) { }
    		else {
    			int tmp = Integer.parseInt((String)tm4.getValueAt(a,2));
    			String fagito = (String)tm4.getValueAt(a,0);
    			sql = "UPDATE `food` SET `Posotita` = `Posotita` - '"+tmp+"' WHERE `fagito` = '"+fagito+"'";
    			System.out.println(tmp+"  "+fagito);
    			stmt.executeUpdate(sql);	}
    			}
    	
    	
    		c.close();stmt.close();rs.close();
    				
    		}catch (Exception ee) {ee.printStackTrace();}
	}
}